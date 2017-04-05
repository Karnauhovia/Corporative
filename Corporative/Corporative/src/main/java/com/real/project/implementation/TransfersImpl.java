package com.real.project.implementation;

import com.real.project.entity.Transfers;
import com.real.project.util.Utility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;


public class TransfersImpl  {

    Session session;

    public void create(Transfers transfers) {
        try {
            session = Utility.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.save(transfers);

            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public List<Transfers> getAllByHQL() throws SQLException {
        List list;
        session = Utility.getSessionFactory().openSession();
        String hql = "FROM Transfers";
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

}


