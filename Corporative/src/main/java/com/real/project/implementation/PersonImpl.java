package com.real.project.implementation;

import com.real.project.entity.Person;
import com.real.project.util.Utility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;


public class PersonImpl {

    Session session;


    public void create(Person person) {
        try {
            session = Utility.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public List<Person> getAllByHQL() throws SQLException {
        List list;
        session = Utility.getSessionFactory().openSession();
        String hql = "FROM Person";
        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            list = query.list();
            tx.commit();
            return list;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public void delete(Long id) {
        try {
            Person person = new Person();
            person.setId(id);
            if(!session.isOpen()) {
                session = Utility.getSessionFactory().openSession();
            }
            Transaction tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(Person person) {
        try {
            session= Utility.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.update(person);

            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public String getRate(Long id) {

        session = Utility.getSessionFactory().openSession();
        String hql = "FROM Person WHERE id = :pId";
        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("pId",id);
            List list =  query.list();
            tx.commit();
            return list.toString();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
