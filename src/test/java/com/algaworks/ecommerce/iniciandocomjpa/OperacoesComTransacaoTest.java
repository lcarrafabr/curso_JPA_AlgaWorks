package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void removerObjeto() {

        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();

        entityManager.remove(produto);

        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

    @Test
    public void inserirOPrimeiroObjeto() {

        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Camera Cannon");
        produto.setDescricao("Camera Tekpix modificada para parecer original.");
        produto.setPreco(new BigDecimal(7500));

        entityManager.getTransaction().begin();

        entityManager.persist(produto);

        entityManager.getTransaction().commit();
    }

    @Test
    public void abrirEFecharATransacao() {

        //Produto produto = new Produto(); //Somente para parar o Erro

        entityManager.getTransaction().begin();

        //entityManager.persist(produto);
       //entityManager.merge(produto);
        //entityManager.remove(produto);

        entityManager.getTransaction().commit();
    }
}
