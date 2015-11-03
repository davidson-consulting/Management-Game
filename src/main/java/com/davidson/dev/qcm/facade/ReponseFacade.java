/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.facade;

import com.davidson.dev.qcm.dao.ReponseDAO;
import com.davidson.dev.qcm.entity.Reponse;
import java.util.List;

/**
 *
 * @author nebrass
 */
public class ReponseFacade {

    private static final long serialVersionUID = 1L;

    private final ReponseDAO reponseDAO = new ReponseDAO();
    
    /**
     * create Reponse
     * @param reponse Reponse 
     */
    public void createReponse(Reponse reponse) {
        reponseDAO.beginTransaction();
        reponseDAO.save(reponse);
        reponseDAO.commitAndCloseTransaction();
    }
    
    /**
     * Update Reponse
     * @param reponse Reponse 
     */
    public void updateReponse(Reponse reponse) {
        reponseDAO.beginTransaction();
        Reponse persistedReponse = reponseDAO.find(reponse.getId());

        persistedReponse.setIdQuestion(reponse.getIdQuestion());
        persistedReponse.setResponse(reponse.getResponse());

        reponseDAO.update(persistedReponse);
        reponseDAO.commitAndCloseTransaction();
    }
    
    /**
     * Query find reponse
     * @param reponseId Long
     * @return reponse Reponse
     */
    public Reponse findReponse(Long reponseId) {
        reponseDAO.beginTransaction();
        Reponse reponse = reponseDAO.find(reponseId);
        reponseDAO.closeTransaction();
        return reponse;
    }
    
    /**
     * Query list<Reponse>
     * @return List<Reponse> List<Reponse>
     */
    public List<Reponse> listAll() {
        reponseDAO.beginTransaction();
        List<Reponse> result = reponseDAO.findAll();
        reponseDAO.closeTransaction();
        return result;
    }
    
    /**
     * Query delete reponse
     * @param reponse Reponse 
     */
    public void deleteReponse(Reponse reponse) {
        reponseDAO.beginTransaction();
        Reponse persistedReponse = reponseDAO.findReferenceOnly(reponse.getId());
        reponseDAO.delete(persistedReponse);
        reponseDAO.commitAndCloseTransaction();
    }
}
