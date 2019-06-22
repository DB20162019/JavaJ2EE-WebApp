/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author dainahb
 */

@Entity
@Table(name="CLIENT",  uniqueConstraints = {@UniqueConstraint(columnNames={"ID"})})
public class Client implements Serializable{
    private Integer id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    private CourseSession courseSessionID;
    
    public Client() {
    }

    public Client(String lastName, String firstName, String address, String phone, String email, CourseSession courseSessionID) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSessionID = courseSessionID;
    }

    @Basic
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID",nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name="LASTNAME",nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name="FIRSTNAME",nullable=false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name="ADDRESS",nullable=false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name="PHONE",nullable=false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name="EMAIL",nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic(fetch= FetchType.LAZY)
    @JoinColumn(name="COURSE_SESSION_ID")
    @ManyToOne( cascade =CascadeType.ALL )
    public CourseSession getCourseSessionID() {
        return courseSessionID;
    }

    public void setCourseSessionID(CourseSession courseSessionID) {
        this.courseSessionID = courseSessionID;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", courseSessionID=" + courseSessionID + '}';
    }


    
}
