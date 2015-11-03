 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.facade;

import com.davidson.dev.qcm.dao.PersonDAO;
import com.davidson.dev.qcm.entity.Person;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author nebrass
 */
public class PersonFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    private final PersonDAO personDAO = new PersonDAO();
    
    /**
     * Create person 
     * @param person Person 
     */
    public void createPerson(Person person) {
        personDAO.beginTransaction();
        personDAO.save(person);
        personDAO.commitAndCloseTransaction();
    }

    /**
     * Update person
     * @param person Person 
     */
    public void updatePerson(Person person) {
        personDAO.beginTransaction();
        Person persistedPerson = personDAO.find(person.getId());
        personDAO.delete(persistedPerson);
        personDAO.commit();
        personDAO.save(person);
        personDAO.commitAndCloseTransaction();
    }
    
    /**
     * Delete person
     * @param person Person 
     */
    public void deletePerson(Person person) {
        personDAO.beginTransaction();
        Person persistedPersonWithIdOnly = personDAO.findReferenceOnly(person.getId());
        personDAO.delete(persistedPersonWithIdOnly);
        personDAO.commitAndCloseTransaction();
    }
    
    /**
     * Find person 
     * @param personId Long
     * @return person Person 
     */
    public Person findPerson(Long personId) {
        personDAO.beginTransaction();
        Person person = personDAO.find(personId);
        personDAO.closeTransaction();
        return person;
    }
    
    /**
     * Query find person by invitation ID
     * @param invitationID String
     * @return person Person 
     */
    public Person findPersonByInvitationID(String invitationID) {
        personDAO.beginTransaction();
        Person person = personDAO.findByInvitationID(invitationID);
        personDAO.closeTransaction();
        return person;
    }
    
    /**
     * Query find person by Referral ID
     * @param referralID String
     * @return person Person
     */
    public Person findPersonByReferralID(String referralID) {
        personDAO.beginTransaction();
        Person person = personDAO.findByReferralID(referralID);
        personDAO.closeTransaction();
        return person;
    }
    
    /**
     * Query list person
     * @return List<person> List<Person> 
     */
    public List<Person> listAll() {
        personDAO.beginTransaction();
        List<Person> result = personDAO.findAll();
        personDAO.closeTransaction();

        return result;
    }

}
