/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * The class courseWithLab extends class Course and can access all its methods and properties.
 * @author soura
 * Sourav Patteri 200428729
 */
public class CourseWithLab extends Course{
    private Instructor labInstructor;
    private String labRoom;
    private DayOfWeek labDay;
    private LocalTime labTime;
    
    /**
     *
     * @param fName
     * @param courseCode
     * @param courseDesc
     * @param room
     * @param courseDay
     * @param courseTime
     * @param capacity
     * @param labInstructor
     * @param labRoom
     * @param labDay
     * @param labTime
     */
    public CourseWithLab(Instructor fName, String courseCode, String courseDesc, String room, DayOfWeek courseDay, LocalTime courseTime, int capacity,  Instructor labInstructor, String labRoom, DayOfWeek labDay, LocalTime labTime) {
        super(fName, courseCode, courseDesc, room, courseDay, courseTime, capacity);
        this.labInstructor = labInstructor;
        this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTime = labTime;
         
        /**
         * Throws an exception if the lab time is not between 8 a.m and 6 p.m.
         */
        if(getLabTime().isBefore(LocalTime.parse("08:00")) || getLabTime().isAfter(LocalTime.parse("18:00"))){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        //Throws an exception if the lab technician is not certified to teach the course
        if(!getLabTech().listOfSubjectsCertifiedToTeach().contains(getCourseCode())){
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        }
    }
    
    /**
     *
     * @param fName
     * @param courseCode
     * @param courseDesc
     * @param room
     * @param courseDay
     * @param courseTime
     * @param capacity
     * @param preReqstCourse
     * @param labInstructor
     * @param labRoom
     * @param labDay
     * @param labTime
     */
    public CourseWithLab(Instructor fName, String courseCode, String courseDesc, String room, DayOfWeek courseDay, LocalTime courseTime, int capacity, String preReqstCourse, Instructor labInstructor, String labRoom, DayOfWeek labDay, LocalTime labTime) {
          super(fName, courseCode, courseDesc, room, courseDay, courseTime, capacity, preReqstCourse);
        this.labInstructor = labInstructor;
        this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTime = labTime;
    }
   
    /**
     *
     * @return
     */
    public Instructor getLabTech() {
        return labInstructor;
    }

    /**
     *
     * @param labInstructor
     */
    public void setLabInstructor(Instructor labInstructor) {
        this.labInstructor = labInstructor;
    }
    /**
     *
     * @return
     */
    public String getLabRoom() {
        return labRoom;
    }

    /**
     *
     * @param labRoom
     */
    public void setLabRoom(String labRoom) {
        this.labRoom = labRoom;
    }
    /**
     *
     * @return
     */
    public DayOfWeek getLabDay() {
        return labDay;
    }

    /**
     *
     * @param labDay
     */
    public void setLabDay(DayOfWeek labDay) {
        this.labDay = labDay;
    }
    /**
     *
     * @return
     */
    public LocalTime getLabTime() {
        return labTime;
    }

    /**
     *
     * @param labTime
     */
    public void setLabTime(LocalTime labTime) {
        this.labTime = labTime;
    }
    /**
     * returns String of lab room, day and time
     * @return
     */
    public String getLabClassAndTime(){
        return("room: "+getLabRoom()+", "+getLabDay()+" starting at "+getLabTime());
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return (getCourseCode()+"-"+getCourseDesc()+" with lab");
    }
}