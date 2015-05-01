package org.cashmashine.mkalachyov;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("John Doe");
        BigDecimal card1Balance = new BigDecimal("100000.00");
        short pinCode = 1234;
        Card card1 = new Card(pinCode, card1Balance);

        Date currentDate = new Date();
        BigDecimal transaction1Amount = new BigDecimal("500.00");
        BigDecimal transaction2Amount = new BigDecimal("1000.00");

        /*TODO create Enum with transaction codes*/
        CardTransaction cardTransaction1 = new CardTransaction("ADD", currentDate, transaction1Amount);
        CardTransaction cardTransaction2 = new CardTransaction("ADD", currentDate, transaction2Amount);
        List<CardTransaction> cardTransactionsList = new ArrayList<>();
        cardTransactionsList.add(cardTransaction1);
        cardTransactionsList.add(cardTransaction2);

        card1.setTrasactions(cardTransactionsList);
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        customer.setCards(cards);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(customer);
        em.persist(card1);
        em.persist(cardTransaction1);
        em.persist(cardTransaction2);
        tx.commit();

        /*TODO implement some queries */
        em.close();
        emf.close();
    }
}
