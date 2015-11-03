/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.PrivateOwned;

/**
 *
 * @author nebrass
 */
@Entity
@Table(name = "ANSWERS")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseDate;
    private int score;
    @OneToOne(mappedBy = "answer", cascade = CascadeType.ALL)
    private Person person;
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL)
    @PrivateOwned
    private List<Reponse> reponses;

    private String lang;
    
    /**
     * constructor 
     */
    public Answer() {
        this(new Date());
    }
    
    /**
     * Constructor
     * @param date Date 
     */
    public Answer(Date date) {
        this.responseDate = date;
        this.reponses = new ArrayList<Reponse>();
    }
    /**
     * Constructor
     * @param responseDate Date
     * @param score int
     */
    public Answer(Date responseDate, int score) {
        this(responseDate);
        this.score = score;
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
     * @return the responseDate
     */
    public Date getResponseDate() {
        return responseDate;
    }

    /**
     * @param responseDate the responseDate to set
     */
    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    /**
     * @return the reponses
     */
    public List<Reponse> getReponses() {
        return reponses;
    }

    /**
     * @param reponses the reponses to set
     */
    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResponseDate(), getReponses(), getScore(), getPerson());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.getResponseDate() != other.getResponseDate() && (this.getResponseDate() == null || !this.responseDate.equals(other.responseDate))) {
            return false;
        }
        if (this.getReponses() != other.getReponses() && (this.getReponses() == null || !this.reponses.equals(other.reponses))) {
            return false;
        }
        if (this.getScore() != other.getScore()) {
            return false;
        }
        return true;
    }

}
