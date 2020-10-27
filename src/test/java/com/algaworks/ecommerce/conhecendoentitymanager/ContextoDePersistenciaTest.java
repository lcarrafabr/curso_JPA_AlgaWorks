package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistenciaTest extends EntityManagerTest {

        @Test
        public void usarContextoPersistencia() {

            entityManager.getTransaction().begin();

            Produto produto = entityManager.find(Produto.class, 1);
            produto.setPreco(new BigDecimal("895.15"));

            Produto produto1 = new Produto();
            produto1.setNome("Café Extra big fucking forte");
            produto1.setDescricao("Café produzido em chernobyl");
            produto1.setPreco(new BigDecimal("15000.99"));
            entityManager.persist(produto1);

            Produto produto2 = new Produto();
            produto2.setNome("Caneca de Adamantium para aguentar o café");
            produto2.setPreco(new BigDecimal("10000.99"));
            produto2.setDescricao("Não tinha descrição");
            produto2 = entityManager.merge(produto2);
            produto2.setDescricao("Produto raro");

            entityManager.getTransaction().commit();
        }


}
