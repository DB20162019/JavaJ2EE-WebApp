/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author dainahb
 */
@Entity
@Table(name="COURSE",  uniqueConstraints = {@UniqueConstraint(columnNames={"CODE"})})
public class Course implements Serializable{
    private String code;
    private String title;

    public Course() {
    }

    public Course(String code) {
        this.code = code;
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    @Basic
    @Id
    @Column(name="CODE",nullable=false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name="TITLE",nullable=false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + '}';
    }
    
}
