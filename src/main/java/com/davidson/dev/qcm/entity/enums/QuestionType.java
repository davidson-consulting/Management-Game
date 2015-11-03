/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.entity.enums;

/**
 *
 * @author nebrass
 */
public enum QuestionType {

    RADIO("Radio"),
    CHECKBOX("Checkbox");

    private String value;

    private QuestionType(String value) {
    }

    public String getValue() {
        return value;
    }

}
