/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.facade;

import com.davidson.dev.qcm.dao.AnswerDAO;
import com.davidson.dev.qcm.entity.Answer;
import java.util.List;

/**
 *
 * @author nebrass
 */
public class AnswerFacade {

    private static final long serialVersionUID = 1L;

    private final AnswerDAO answerDAO = new AnswerDAO();
    
    /**
     * Create answer
     * @param answer Answer 
     */
    public void createAnswer(Answer answer) {
        answerDAO.beginTransaction();
        answerDAO.save(answer);
        answerDAO.commitAndCloseTransaction();
    }
    
    /**
     * Update answer
     * @param answer Answer 
     */
    public void updateAnswer(Answer answer) {
        answerDAO.beginTransaction();
        Answer persistedAnswer = answerDAO.find(answer.getId());

        persistedAnswer.setResponseDate(answer.getResponseDate());
        persistedAnswer.setReponses(answer.getReponses());
        persistedAnswer.setScore(answer.getScore());

        answerDAO.update(persistedAnswer);
        answerDAO.commitAndCloseTransaction();
    }
    
    /**
     * Find Answer
     * @param answerId Long
     * @return answer Answer
     */
    public Answer findAnswer(Long answerId) {
        answerDAO.beginTransaction();
        Answer answer = answerDAO.find(answerId);
        answerDAO.closeTransaction();
        return answer;
    }
    
    /**
     * list answer
     * @return List<Answer>
     */
    public List<Answer> listAll() {
        answerDAO.beginTransaction();
        List<Answer> result = answerDAO.findAll();
        answerDAO.closeTransaction();
        return result;
    }
    
    /**
     * Delete answer
     * @param answer Answer 
     */
    public void deleteAnswer(Answer answer) {
        answerDAO.beginTransaction();
        Answer persistedAnswer = answerDAO.findReferenceOnly(answer.getId());
        answerDAO.delete(persistedAnswer);
        answerDAO.commitAndCloseTransaction();
    }
}
