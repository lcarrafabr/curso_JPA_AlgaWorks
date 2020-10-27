package com.algaworks.ecommerce.mapeamentobasico;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import com.algaworks.ecommerce.model.EnderecoEntregaPedido;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutido extends EntityManagerTest {

    @Test
    public void analisarMapeamentoObjetoEmbutido() {

        EnderecoEntregaPedido endereco = new EnderecoEntregaPedido();

        endereco.setCep("29980000");
        endereco.setCep("Rua das latinhas");
        endereco.setNumero("558");
        endereco.setBairro("Caquis");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");


        Pedido pedido = new Pedido();
        Cliente cliente = entityManager.find(Cliente.class, 1);

        //pedido.setId(1);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(5000));
        pedido.setEnderecoEntrega(endereco);
        pedido.setCliente(cliente);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assert.assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
    }
}
