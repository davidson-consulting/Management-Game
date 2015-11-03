/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.dao;

import com.davidson.dev.qcm.entity.Reponse;

/**
 *
 * @author nebrass
 */
public class ReponseDAO extends GenericDAO<Reponse> {

    private static final long serialVersionUID = 1L;
    /**
     * Reponse class DAO
     */
    public ReponseDAO() {
        super(Reponse.class);
    }
    
    /**
     * delete Reponse class
     * @param reponse Reponse 
     */
    public void delete(Reponse reponse) {
        super.delete(reponse.getId(), Reponse.class);
    }
}
