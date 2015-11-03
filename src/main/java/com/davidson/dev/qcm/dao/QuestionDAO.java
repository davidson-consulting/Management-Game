/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.dao;

import com.davidson.dev.qcm.entity.Question;

/**
 *
 * @author nebrass
 */
public class QuestionDAO extends GenericDAO<Question> {

    private static final long serialVersionUID = 1L;
    
    /**
     * Question class DAO
     */
    public QuestionDAO() {
        super(Question.class);
    }

    /**
     * delete Question class
     * @param question Question 
     */
    public void delete(Question question) {
        super.delete(question.getId(), Question.class);
    }
}
