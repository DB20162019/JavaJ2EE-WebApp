/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="COURSE_SESSION",  uniqueConstraints = {@UniqueConstraint(columnNames={"ID"})})
public class CourseSession implements Serializable {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Integer max;
    private Course courseCode;
    private Location locationID;

    public CourseSession() {
    }

    public CourseSession(Integer id) {
        this.id = id;
    }

    public CourseSession(Date startDate, Date endDate, Integer max, Course courseCode, Location locationID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.courseCode = courseCode;
        this.locationID = locationID;
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
    @Column(name="START_DATE",nullable=false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name="END_DATE",nullable=false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name="MAXCS",nullable=false)
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Basic(fetch= FetchType.EAGER)
    @JoinColumn(name="COURSE_CODE")
    @ManyToOne( cascade = CascadeType.ALL, targetEntity= Course.class)
    public Course getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }

    @Basic(fetch= FetchType.LAZY)
    @JoinColumn(name="LOCATION_ID")
    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + ", courseCode=" + courseCode + ", locationID=" + locationID + '}';
    }
}
