package com.example.pw17.Services;

import com.example.pw17.Tables.Departure;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

    @PostConstruct
    public void init() {
        session = sessionFactory.openSession();
    }

    @Override
    public void createEntity(Departure departure) {
        Transaction transaction = session.beginTransaction();
        session.save(departure);
        transaction.commit();
    }

    @Override
    public List<Departure> readAllEntity() {
        List<Departure> departures = session.createQuery("select i from Departure i", Departure.class).getResultList();
        return departures;
    }

    @Override
    public Departure readOneEntity(Integer id) {
        Departure departure = session.createQuery("from Departure where id = :id", Departure.class)
                .setParameter("id", id)
                .getSingleResult();
//        System.out.println(departure);
        return departure;
    }

    @Override
    public boolean updateEntity(Departure departure, Integer id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Departure set departureType=:type, " +
                        "departureDate=:date where id = :id")
                .setParameter("id", id)
                .setParameter("type", departure.getDepartureType())
                .setParameter("date", departure.getDepartureDate());
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return status == 1;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Departure where id = :id")
                .setParameter("id", id);
        int status = query.executeUpdate();
        System.out.println(status);
        transaction.commit();

        return status == 1;
    }

    public List<Departure> filterByDepartureType(String departureType) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> criteriaQuery = criteriaBuilder.createQuery(Departure.class);
        Root<Departure> root = criteriaQuery.from(Departure.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("departureType"), departureType));
        Query<Departure> query = session.createQuery(criteriaQuery);
        final List<Departure> departures = query.getResultList();
        return departures;
    }

    public List<Departure> readSortedByType() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Departure> criteriaQuery = criteriaBuilder.createQuery(Departure.class);
        Root<Departure> root = criteriaQuery.from(Departure.class);
        criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("departureType")));
        Query<Departure> query = session.createQuery(criteriaQuery);
        final List<Departure> departures = query.getResultList();
        return departures;
    }

    @PreDestroy
    public void quit() {
        session.close();
    }
}
