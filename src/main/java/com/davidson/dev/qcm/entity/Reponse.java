/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author nebrass
 */
@Entity
@Table(name = "REPONSES")
public class Reponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idQuestion;
    private String response;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Answer answer;
    
    /**
     * constructor default
     */
    public Reponse() {
        this(null, null, "");
    }
    
    /**
     * constructor
     * @param idQuestion Long
     * @param response String 
     */
    public Reponse(Long idQuestion, String response) {
        this(null, idQuestion, response);
    }

    /**
     * constructor
     * @param answer Answer
     * @param idQuestion Long
     * @param response String 
     */
    public Reponse(Answer answer, Long idQuestion, String response) {
        this.answer = answer;
        this.idQuestion = idQuestion;
        this.response = response;
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
     * @return the idQuestion
     */
    public Long getIdQuestion() {
        return idQuestion;
    }

    /**
     * @param idQuestion the idQuestion to set
     */
    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
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
}
