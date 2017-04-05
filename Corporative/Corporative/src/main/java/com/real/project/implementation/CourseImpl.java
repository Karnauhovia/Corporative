package com.real.project.implementation;


import com.real.project.entity.Course;
import com.real.project.util.Utility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseImpl {

    Session session;

    public void create(Course course) {
        try {
            session = Utility.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.save(course);

            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public Long getCousre(Long id) {

        session = Utility.getSessionFactory().openSession();
        String hql = "FROM \"Exchange_Rates\"" ;
        try {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            List list =  query.list();
            tx.commit();
            String a = list.toString();
            return Long.parseLong(a);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


}
