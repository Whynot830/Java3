package com.example.pw15.Services;

import com.example.pw15.Tables.Departure;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService implements TableService<Departure> {
    private final SessionFactory sessionFactory;
    private Session session;

    public DepartureService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createEntity(Departure departure) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(departure);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Departure> readAllEntity() {
        session = sessionFactory.openSession();
        List<Departure> departures = session.createQuery("select i from Departure i", Departure.class).getResultList();
        session.close();
        return departures;
    }

    @Override
    public Departure readOneEntity(Integer id) {
        session = sessionFactory.openSession();
        Departure departure = session.createQuery("from Departure where id = :id", Departure.class)
                .setParameter("id", id)
                .getSingleResult();
        session.close();
//        System.out.println(departure);
        return departure;
    }

    @Override
    public boolean updateEntity(Departure departure, Integer id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Departure set departureType=:type, " +
                "departureDate=:date where id = :id")
                .setParameter("id", id)
                .setParameter("type", departure.getDepartureType())
                .setParameter("date", departure.getDepartureDate());
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
        Query query = session.createQuery("delete from Departure where id = :id")
                .setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return status == 1;
    }
}
