/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.time.DayOfWeek;

/**
 *
 * @author soura
 * Sourav Patteri 200428729
 */
public class Course {

    protected Instructor fName;
    protected String courseCode, courseDesc, room, preReqstCourse;
    protected DayOfWeek courseDay;
    protected LocalTime courseTime;
    protected ArrayList<Student> studentList = new ArrayList<>();//Creating arraylist   
    protected int capacity;
   
    /**
     *
     * @param fName
     * @param courseCode
     * @param courseDesc
     * @param room
     * @param courseDay
     * @param courseTime
     * @param capacity
     */
    public Course(Instructor fName, String courseCode, String courseDesc, String room, DayOfWeek courseDay, LocalTime courseTime, int capacity) {
        this.fName = fName;
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
        this.room = room;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.capacity = capacity;
       
        /**
         * Throws an exception if the course time is not between 8 a.m and 6 p.m.
         */
        if(getCourseTime().isBefore(LocalTime.parse("08:00")) || getCourseTime().isAfter(LocalTime.parse("18:00"))){
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        //Throws an exception if the instructor is not certified to teach the course
        if(!getfName().listOfSubjectsCertifiedToTeach().contains(getCourseCode())){
            throw new IllegalArgumentException("Professor "+getfName().getfName()+" "+getfName().getlName()+" is not qualified to teach "+getCourseCode());
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
     */
    public Course(Instructor fName, String courseCode, String courseDesc, String room, DayOfWeek courseDay, LocalTime courseTime, int capacity, String preReqstCourse) {
        this.fName = fName;
        this.courseCode = courseCode;
        this.courseDesc = courseDesc;
        this.room = room;
        this.courseDay = courseDay;
        this.courseTime = courseTime;
        this.capacity = capacity;
        this.preReqstCourse = preReqstCourse;       
    }

    /**
     * Here fName does not just signify the first name of the instructor but is a variable of the datatype class Instructor and has all methods and properties of the class
     * @return
     */
    public Instructor getfName() {
        return fName;
    }

    /**
     *
     * @param fName
     */
    public void setfName(Instructor fName) {
        this.fName = fName;
    }

    /**
     *
     * @return
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     *
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     *
     * @return
     */
    public String getCourseDesc() {
        return courseDesc;
    }

    /**
     *
     * @param courseDesc
     */
    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    /**
     *
     * @return
     */
    public String getClassRoom() {
        return room;
    }

    /**
     *
     * @param room
     */
    public void setClassRoom(String room) {
        this.room = room;
    }

    /**
     *
     * @return
     */
    public DayOfWeek getCourseDay() {
        return courseDay;
    }

    /**
     *
     * @param courseDay
     */
    public void setCourseDay(DayOfWeek courseDay) {
        this.courseDay = courseDay;
    }

    /**
     *
     * @return
     */
    public LocalTime getCourseTime() {
        return courseTime;
    }

    /**
     *
     * @param courseTime
     */
    public void setCourseTime(LocalTime courseTime) {
        this.courseTime = courseTime;
    }

    /**
     *
     * @return
     */
    public int getClassSize() {
        return capacity;
    }

    /**
     * Maximum capacity for all course = 40 hence sets class size to 40 if they try to set it to more than 40 else sets the entered capacity 
     * @param capacity
     * @return
     */
    public String setClassSize(int capacity) {
        if(capacity < 40){
        this.capacity = capacity;
        }
        this.capacity = 40;
         return("Max class size = 40, it has been set to 40");
        }
        
    /**
     * returns String of course day and time
     * @return
     */
    public String getCourseDayAndTime(){
        String dayAndTime = getCourseDay().toString()+"'s, starting at "+getCourseTime().toString();
        return dayAndTime;
    }

    /**
     *
     * @return
     */
    public Instructor getInstructorToTeach(){
        return fName;
    }
    
    /**
     * if student is in good standing and the class is not full and prerequisites are met adds student to course.
     * The default return is an empty String but it wont come to that
     * @param stdntNum
     * @return
     */
    public String addStudent(Student stdntNum){
        if (stdntNum.StudentInGoodStanding() == false) {
            return "The Student is not in good standing and cannot join the course.";
        }
        if(studentList.size() > getClassSize() || studentList.size() == getClassSize()){
            return "Student was not added because the course is full";
        }
        if ( (checkPrerequisite() != null) && (!(stdntNum.getCoursesCompleted().contains(checkPrerequisite()))) ) { 
            return "Student has not completed the prerequisite course: "+checkPrerequisite();
        }
        else{
        studentList.add(stdntNum);
        }
        return "";
    }
    /**
     *
     * @return
     */
    public String displayTheClassList(){
           return ((studentList.toString()).replace("[","")).replace("]", "");
    }

    /**
     * uses an enhanced for loop to iterate through the student list and calculate the average of the class
     * returns true if average is greater than 25
     * @return
     */
    
    public boolean matureClass(){
        int avg;
        int sum = 0;
        for(Student x : studentList){
            sum += x.getStudentAge();   
        }
        avg = sum / studentList.size();   
        return avg > 25;
    }

    /**
     *
     * @return
     */
    public String checkPrerequisite(){
        return preReqstCourse;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return (getCourseCode()+"-"+getCourseDesc());
    }
}
