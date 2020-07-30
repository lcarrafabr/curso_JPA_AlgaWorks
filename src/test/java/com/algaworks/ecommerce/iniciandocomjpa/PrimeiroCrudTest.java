package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Cliente;
import org.junit.Test;

public class PrimeiroCrudTest  extends EntityManagerTest {

    @Test
    public void buscarRegistros() {

        Cliente cliente = entityManager.find(Cliente.class, 2);

        System.out.println(cliente.getNome());
    }

    @Test
    public void inserirRegistro() {

        Cliente cliente = new Cliente();

        cliente.setId(4);
        cliente.setNome("Joaquim da silva");

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();
    }

    @Test
    public void atualizar() {

        Cliente cliente = new Cliente();

        cliente.setId(2);
        cliente.setNome("Debora Carrafa da Costa dos Santos Carrafa benfica");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Test
    public void removerUsuario() {

        Cliente cliente = entityManager.find(Cliente.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }


}
