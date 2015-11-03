/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.dao;

import com.davidson.dev.qcm.entity.Person;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author nebrass
 */
public class PersonDAO extends GenericDAO<Person> {

    private static final long serialVersionUID = 1L;

    /**
     * Person DAO
     */
    public PersonDAO() {
        super(Person.class);
    }

    /**
     * Query delete person
     *
     * @param person Person
     */
    public void delete(Person person) {
        super.delete(person.getId(), Person.class);
    }

    /**
     * Query find by email
     *
     * @param email String
     * @return
     */
    public Person findByEmail(String email) {
        try {
            Query findByEmailQuery = this.geEntityManager().createNamedQuery("Person.findByEmail", Person.class);
            findByEmailQuery.setParameter("email", email);
            findByEmailQuery.setMaxResults(1);
            Person person = (Person) findByEmailQuery.getSingleResult();
            return person;
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Query find invitation by id
     *
     * @param invitationID String
     * @return person Person
     */
    public Person findByInvitationID(String invitationID) {
        try {
            Query findByInvitationIdQuery = this.geEntityManager()
                    .createNamedQuery("Person.findByInvitationID", Person.class);

            findByInvitationIdQuery.setParameter("invitation", invitationID);
            findByInvitationIdQuery.setMaxResults(1);
            Person person = (Person) findByInvitationIdQuery.getSingleResult();
            return person;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    /**
     * Query fin person by referral ID 
     * @param referral_id
     * @return person Person
     */
    public Person findByReferralID(String referral_id) {
        try {
            Query findByInvitationIdQuery = this.geEntityManager()
                    .createNamedQuery("Person.findByReferralID", Person.class);

            findByInvitationIdQuery.setParameter("referral_id", referral_id);
            findByInvitationIdQuery.setMaxResults(1);
            Person person = (Person) findByInvitationIdQuery.getSingleResult();
            return person;
        } catch (NoResultException e) {
            return null;
        }
    }
}
