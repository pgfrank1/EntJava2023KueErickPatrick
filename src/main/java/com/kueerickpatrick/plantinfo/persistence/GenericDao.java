package com.kueerickpatrick.plantinfo.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    private Session session;
    private CriteriaQuery<T> query;
    private Root<T> root;
    private CriteriaBuilder builder;

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities.
     *
     * @return the all entities
     */
    public List<T> getAll() {
        openSession();
        buildQuery();
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets an entity by id.
     *
     * @param id entity id to search by
     * @return an entity
     */
    public <T>T getById(int id) {
        openSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Update an entity.
     *
     * @param entity entity to be inserted or updated.
     */
    public void saveOrUpdate(T entity) {
        openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Insert new entity.
     *
     * @param entity entity to be inserted
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete an entity.
     *
     * @param entity entity to be deleted.
     */
    public void delete(T entity) {
        openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Get user by property (like)
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {

        openSession();

        buildQuery();
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

    /**
     * Open a session
     */
    private void openSession() {
        session = sessionFactory.openSession();
    }

    /**
     * Instantiates CriteriaBuilder and directs query to User class.
     */
    private void buildQuery() {
        builder = session.getCriteriaBuilder();
        query = builder.createQuery(type);
        root = query.from(type);
    }
}
