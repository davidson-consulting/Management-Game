/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author nebrass
 */
@Entity
@Table(name = "PERSONS")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByID", query = "SELECT p FROM Person p WHERE p.id = :id"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByInvitationID", query = "SELECT p FROM Person p WHERE p.invitation = :invitation"),
    @NamedQuery(name = "Person.findByReferralID", query = "SELECT p FROM Person p WHERE p.referral_id = :referral_id")
})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String familyName;

    private String email;

    private String companyName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Answer answer;
    private String referral_id;
    @Column(name = "invitation")
    private String invitation;

    public Person() {
        this("", "", "", "", "");
    }

    public Person(String name, String familyName, String companyName, String invitation) {
        this(name, familyName,"", companyName, invitation);
    }

    public Person(String name, String familyName, String email, String companyName, String invitation) {
        this(name, familyName, email, companyName, null, UUID.randomUUID().toString().replace("-", "").substring(16), invitation);
    }

    public Person(String name, String familyName, String email, String companyName, Answer answer, String referral_id, String invitation) {
        this.name = name;
        this.familyName = familyName;
        this.email = email;
        this.companyName = companyName;
        this.answer = answer;
        this.referral_id = referral_id;
        this.invitation = invitation;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the answer
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    /**
     * @return the referral_id
     */
    public String getReferral_id() {
        return referral_id;
    }

    /**
     * @param referral_id the referral_id to set
     */
    public void setReferral_id(String referral_id) {
        this.referral_id = referral_id;
    }

    /**
     * @return the invitation
     */
    public String getInvitation() {
        return invitation;
    }

    /**
     * @param invitation the invitation to set
     */
    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFamilyName(), getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.getName() == null) ? (other.getName() != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.getFamilyName() == null) ? (other.getFamilyName() != null) : !this.familyName.equals(other.familyName)) {
            return false;
        }
        if ((this.getEmail() == null) ? (other.getEmail() != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.getCompanyName() == null) ? (other.getCompanyName() != null) : !this.companyName.equals(other.companyName)) {
            return false;
        }
        return true;
    }

}
