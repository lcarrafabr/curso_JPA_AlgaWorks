package com.algaworks.ecommerce.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Integer produtoId;
}
