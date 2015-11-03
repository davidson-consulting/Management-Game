/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.facade;

import com.davidson.dev.qcm.dao.QuestionDAO;
import com.davidson.dev.qcm.entity.Question;
import java.util.List;

/**
 *
 * @author nebrass
 */
public class QuestionFacade {

    private static final long serialVersionUID = 1L;

    private final QuestionDAO questionDAO = new QuestionDAO();
    
    /**
     * create question
     * @param question Question 
     */
    public void createQuestion(Question question) {
        questionDAO.beginTransaction();
        questionDAO.save(question);
        questionDAO.commitAndCloseTransaction();
    }

    /**
     * update question
     * @param question Question 
     */
    public void updateQuestion(Question question) {
        questionDAO.beginTransaction();
        Question persistedQuestion = questionDAO.find(question.getId());

        persistedQuestion.setOptions(question.getOptions());
        persistedQuestion.setText(question.getText());
        persistedQuestion.setType(question.getType());
        persistedQuestion.setRecommandation(question.getRecommandation());

        questionDAO.update(persistedQuestion);
        questionDAO.commitAndCloseTransaction();
    }
    
    /**
     * Query find by question
     * @param questionId Long
     * @return question Question
     */
    public Question findQuestion(Long questionId) {
        questionDAO.beginTransaction();
        Question question = questionDAO.find(questionId);
        questionDAO.closeTransaction();
        return question;
    }
    
    /**
     * Query list question
     * @return List<Question> List<Question> 
     */
    public List<Question> listAll() {
        questionDAO.beginTransaction();
        List<Question> result = questionDAO.findAll();
        questionDAO.closeTransaction();
        return result;
    }
    
    /**
     * Query delete question
     * @param question Question 
     */
    public void deleteQuestion(Question question) {
        questionDAO.beginTransaction();
        Question persistedQuestion = questionDAO.findReferenceOnly(question.getId());
        questionDAO.delete(persistedQuestion);
        questionDAO.commitAndCloseTransaction();
    }
}
