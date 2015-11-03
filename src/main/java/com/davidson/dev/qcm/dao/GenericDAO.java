/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Method DAO 
 * @author nebrass
 */
abstract class GenericDAO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger("DAOLogger");

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("davidsonPU");
    private EntityManager em;

    private Class<T> entityClass;
    
    /**
     * Begin Transaction query
     */
    public void beginTransaction() {
        em = emf.createEntityManager();

        em.getTransaction().begin();
    }
    
    /**
     * 
     * @return Entity manager 
     */
    public EntityManager geEntityManager() {
        return em;
    }
    
    /**
     * commit query
     */
    public void commit() {
        em.getTransaction().commit();
    }
    
    /**
     * cancel transaction
     */
    public void rollback() {
        em.getTransaction().rollback();
    }

    /**
     * close transaction
     */
    public void closeTransaction() {
        em.close();
    }
    
    /**
     * send data and close transaction
     */
    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }
    
    /**
     * insert in data base 
     */
    public void flush() {
        em.flush();
    }
    
    
    public void joinTransaction() {
        em = emf.createEntityManager();
        em.joinTransaction();
    }

    /**
     * 
     * @param entityClass Class entity 
     */
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * save data
     * @param entity 
     */
    public void save(T entity) {
        em.persist(entity);
    }

    protected void delete(Object id, Class<T> classe) {
        T entityToBeRemoved = em.getReference(classe, id);

        em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
        return em.merge(entity);
    }

    public T find(Long entityID) {
        return em.find(entityClass, entityID);
    }

    public T findReferenceOnly(Long entityID) {
        return em.getReference(entityClass, entityID);
    }

    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    // Using the unchecked because JPA does not have a
    // query.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;

        try {
            Query query = em.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();

        } catch (NoResultException e) {
            System.out.println("No result found for named query: " + namedQuery);
        } catch (Exception e) {
            System.out.println("Error while running query: " + e.getMessage());
            logger.log(Level.WARNING, e.getMessage());
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
