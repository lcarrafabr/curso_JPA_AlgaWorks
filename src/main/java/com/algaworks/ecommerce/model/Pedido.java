package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItemPedido> itens;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;

    @OneToOne(mappedBy = "pedido")
    private NotaFiscal notaFiscal;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Embedded
    private EnderecoEntregaPedido enderecoEntrega;

    @OneToOne(mappedBy = "pedido")
    private PagamentoCartao pagamento;

    @PrePersist //ao persistir
    public void aoPersistir() {
        dataCriacao = LocalDateTime.now();
        calcularTotal();
    }

    @PreUpdate // ao atualziar
    public void aoAtualziar() {
        dataUltimaAtualizacao = LocalDateTime.now();
        calcularTotal();
    }

    //Somente pode existir UMA anotação de cada tipo em uma classe, se usar 2 tipos iguais vai dar erro:
    //You can only annotate one callback method with javax.persistence.PreUpdate

    //@PrePersist
    //@PreUpdate
    public void calcularTotal() {

        if(itens != null) {
            total = itens.stream().map(ItemPedido::getPrecoProduto)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    @PostPersist
    public void aposPeristir() {
        System.out.println("Após persistir o pedido");
    }

    @PostUpdate
    public void aposAtualizar() {
        System.out.println("Após atualizar o pedido");
    }

    @PreRemove
    public void aoRemover() {
        System.out.println("Antes de remover o pedido");
    }

    @PostRemove
    public void aposRemover() {
        System.out.println("após remover pedido");
    }

    @PostLoad
    public void aoCarregar() {
        System.out.println("Após carregar pedido ");
    }
}
