package com.zhanarys.hiberdemo;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zhanarys.hiberdemo.model.Account;
import com.zhanarys.hiberdemo.model.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpa.internal.util.ConfigurationHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author zh.turemuratov on 1/17/20
 */


public class OrmTesting {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(OrmTesting.class);

        logger.error("hello");

        Card card = new Card();
        card.setDateTime(new Date());

        Account account = new Account();
        account.setAccountNumber("655 32");

        card.setAccountSet(Collections.singleton(account));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        account.setCard(card);

        session.save(card);

        session.getTransaction().commit();
        



    }
}
