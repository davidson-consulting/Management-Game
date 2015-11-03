/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.dao;

import com.davidson.dev.qcm.entity.Answer;

/**
 *
 * @author nebrass
 */
public class AnswerDAO extends GenericDAO<Answer> {

    private static final long serialVersionUID = 1L;
    
    /**
     * Entity Answer
     */
    public AnswerDAO() {
        super(Answer.class);
    }
    
    /**
     * Method delete Answer
     * @param answer Answer
     */
    public void delete(Answer answer) {
        super.delete(answer.getId(), Answer.class);
    }
}
