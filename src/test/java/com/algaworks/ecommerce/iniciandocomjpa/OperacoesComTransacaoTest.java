package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaoComBancoDeDados() {

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.detach(produto);

        entityManager.getTransaction().begin();
        produto.setNome("PlaysTation 5 de ouro Plus");
        entityManager.getTransaction().commit();
    }

    @Test
    public void mostrarDiferencaPersistMerge() {

        Produto produtoPersist = new Produto();

        produtoPersist.setId(5);
        produtoPersist.setNome("Teclado Gamer Razer");
        produtoPersist.setDescricao("O RGB deixa seu PC mais rapido.");
        produtoPersist.setPreco(new BigDecimal(8000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        entityManager.getTransaction().commit();
    }

    @Test
    public void inserirObjetoComMerge() {

        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Microfone BM 800");
        produto.setDescricao("Um bom microfone custo beneficio para iniciantes.");
        produto.setPreco(new BigDecimal(80));

        entityManager.getTransaction().begin();

        entityManager.merge(produto);

        entityManager.getTransaction().commit();
    }

    @Test
    public void atualizarObjetoGertenciado() {

        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("PlaysTation 5 de ouro Plus");
        entityManager.getTransaction().commit();
    }

    @Test
    public void atualizarObjeto() {

        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("PlaysTation 5 de ouro");
        produto.setDescricao("Tenha algo que todo mundo tem so que 500X mais caro");
        produto.setPreco(new BigDecimal(1000000.0));

        entityManager.getTransaction().begin();

        entityManager.merge(produto);

        entityManager.getTransaction().commit();
    }

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
