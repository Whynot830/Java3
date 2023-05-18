package com.example.pw15.Services;

import com.example.pw15.Tables.PostOffice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService implements TableService<PostOffice> {
    private final SessionFactory sessionFactory;
    private Session session;

    public PostOfficeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(PostOffice postOffice) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(postOffice);
        transaction.commit();
        session.close();
    }

    @Override
    public List<PostOffice> readAllEntity() {
        session = sessionFactory.openSession();
        List<PostOffice> departures = session.createQuery("select i from PostOffice i", PostOffice.class).getResultList();
        session.close();
        return departures;
    }

    @Override
    public PostOffice readOneEntity(Integer id) {
        session = sessionFactory.openSession();
        PostOffice postOffice = session.createQuery("from PostOffice where id = :id", PostOffice.class)
                .setParameter("id", id)
                .getSingleResult();
        session.close();
//        System.out.println(postOffice);
        return postOffice;
    }

    @Override
    public boolean updateEntity(PostOffice postOffice, Integer id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update PostOffice set officeName=:name, " +
                        "cityName=:cityName where id = :id")
                .setParameter("id", id)
                .setParameter("name", postOffice.getOfficeName())
                .setParameter("cityName", postOffice.getCityName());
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return status == 1;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from PostOffice where id = :id")
                .setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return status == 1;
    }
}
