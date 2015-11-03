/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davidson.dev.qcm.entity;

import com.davidson.dev.qcm.entity.enums.QuestionType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author nebrass
 */
@Entity
@Table(name = "QUESTIONS")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Enumerated(EnumType.STRING)
    private QuestionType type;
    @ElementCollection
    private Map<Integer, String> options;
    @ElementCollection
    @Lob
    private List<String> recommandation;

    private int priority;
    
    /**
     * constructor
     */
    public Question() {
        this("", QuestionType.RADIO, new HashMap<Integer, String>(), new ArrayList<String>(), new ArrayList<String>());
    }
    
    /**
     * constructor
     * @param text String
     * @param type QuestionType
     * @param options Map<integer, string>
     * @param seuilFailed List<String>
     * @param recommandation List<String> 
     */
    public Question(String text, QuestionType type, Map<Integer, String> options, List<String> seuilFailed, List<String> recommandation) {
        this(text, type, options, recommandation, 0);
    }
    
    /**
     * constructor
     * @param text String
     * @param type QuestionType
     * @param options Map<Integer, String>
     * @param recommandation List<String>
     * @param priority int 
     */
    public Question(String text, QuestionType type, Map<Integer, String> options, List<String> recommandation, int priority) {
        this.text = text;
        this.type = type;
        this.options = options;
        this.recommandation = recommandation;
        this.priority = priority;
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
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the type
     */
    public QuestionType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(QuestionType type) {
        this.type = type;
    }

    /**
     * @return the options
     */
    public Map<Integer, String> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(Map<Integer, String> options) {
        this.options = options;
    }

    /**
     * @return the recommandation
     */
    public List<String> getRecommandation() {
        return recommandation;
    }

    /**
     * @param recommandation the recommandation to set
     */
    public void setRecommandation(List<String> recommandation) {
        this.recommandation = recommandation;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, type, options, recommandation);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
