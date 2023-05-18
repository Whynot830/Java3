package com.example.pw16.Services;

import com.example.pw16.Tables.Departure;
import com.example.pw16.Tables.PostOffice;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostOfficeService implements TableService<PostOffice> {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }
    public PostOfficeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(PostOffice postOffice) {
        Transaction transaction = session.beginTransaction();
        session.save(postOffice);
        transaction.commit();
    }

    @Override
    public List<PostOffice> readAllEntity() {
        List<PostOffice> departures = session.createQuery("select i from PostOffice i", PostOffice.class).getResultList();
        return departures;
    }

    @Override
    public PostOffice readOneEntity(Integer id) {
        PostOffice postOffice = session.createQuery("from PostOffice where id = :id", PostOffice.class)
                .setParameter("id", id)
                .getSingleResult();
//        System.out.println(postOffice);
        return postOffice;
    }

    @Override
    public boolean updateEntity(PostOffice postOffice, Integer id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update PostOffice set officeName=:name, " +
                        "cityName=:cityName where id = :id")
                .setParameter("id", id)
                .setParameter("name", postOffice.getOfficeName())
                .setParameter("cityName", postOffice.getCityName());
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return status == 1;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from PostOffice where id = :id")
                .setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return status == 1;
    }
    @PreDestroy
    public void quit() {
        session.close();
    }
}
