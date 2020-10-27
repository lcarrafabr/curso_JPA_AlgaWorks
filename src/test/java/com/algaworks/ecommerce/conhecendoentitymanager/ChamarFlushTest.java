package com.algaworks.ecommerce.conhecendoentitymanager;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Pedido;
import com.algaworks.ecommerce.model.StatusPedido;
import org.junit.Test;

public class ChamarFlushTest extends EntityManagerTest {

        @Test(expected = Exception.class)
        public void chamarFlush() {

            try {
                entityManager.getTransaction().begin();
                Pedido pedido = entityManager.find(Pedido.class, 1);
                pedido.setStatus(StatusPedido.PAGO);

                entityManager.flush();

                if (pedido.getPagamento() == null) {
                    throw new RuntimeException("O pedido ainda não foi pago.");
                }


                entityManager.getTransaction().commit();
            }catch (Exception e) {
                entityManager.getTransaction().rollback(); //Cancelar Transação
                throw e;
            }
        }


}
