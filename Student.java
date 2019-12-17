/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registrationsystem;
import java.time.LocalDate;
import java.time.Period; 
import java.util.ArrayList;
/**
 *
 * @author soura
 * Sourav Patteri 200428729
 */
public class Student {
    private String fName,lName, streetAdd, city, postlCode, program;
    private int studentNumber;
    private LocalDate enrollmentDate, dob;
    private boolean studentGoodStanding = true;   
    private final ArrayList<String> completed_courses = new ArrayList<>();//Creating arraylist to store only the completed course codes  
    private final ArrayList<String> completed_Course_Grade = new ArrayList<>();//Creating arraylist to store course code, description and grades   

    /**
     *
     * @param firstName
     * @param lastName
     * @param streetAdd
     * @param city
     * @param postlCode
     * @param program
     * @param studentNum
     * @param enrollmentDate
     * @param dob
     */
    public Student(String firstName, String lastName, String streetAdd, String city, String postlCode,  String program, int studentNum, LocalDate enrollmentDate, LocalDate dob) {
        
        fName = firstName;
        lName = lastName;
        this.streetAdd = streetAdd;
        this.city = city;
        this.postlCode = postlCode;
        this.program = program;
        studentNumber = studentNum;
        this.enrollmentDate = enrollmentDate;
        this.dob = dob;
        /**
         * Throws an exception if the student age is more than 100
         */
        if(getStudentAge() > 100){
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
            
    }
    /***
     * 
     * @return 
     */
    public  String getfName(){
        return fName;
    }

    /**
     *
     * @return
     */
    public String getlName(){
        return lName;
    }

    /**
     *
     * @return
     */
    public String getstreetAdd(){
        return streetAdd;
    }

    /**
     *  returns full address i.e., the combination of street address, city and Postal Code
     * @return
     */
    public String getStudentAddress(){
       String fullAdd = streetAdd+" "+city+" "+postlCode;
        return fullAdd;
    }
   
    /**
     *
     * @return
     */
    public String getcity(){
        return city;
    }

    /**
     *
     * @return
     */
    public String getpostcode(){
        return postlCode;
    }
    
    /**
     *
     * @return
     */
    public String getprog(){
        return program;
    }
    
    /**
     *
     * @return
     */
    public int getStudentNumber() {
        return studentNumber;
    }
    
    /**
     *
     * @return
     */
    public LocalDate getenrollDate(){
        return enrollmentDate;
    }

    /**
     *
     * @return
     */
    public LocalDate getStudentBirthday(){
        return dob;
    }

    /**
     * Uses the period function between to find the period between student DOB and now,
     * then using the function getYears() we get the student age 
     * @return
     */
    public int getStudentAge(){
      Period age = Period.between(getStudentBirthday(), LocalDate.now());
      int years = age.getYears();
      return years;
    }

    /**
     *using the function getYears() we get the number of years student was enrolled in the college 
     * @return
     */
    public int getNoOfYearEnrolled(){
       int enrollYear = enrollmentDate.getYear();
       return enrollYear;
    }
    /***
     * 
     * @return 
     */
     public boolean StudentInGoodStanding(){
         return studentGoodStanding;
     }

    /**
     *
     * @return
     */
    public String getCoursesCompleted(){
         return completed_Course_Grade.toString();
     }
    
    /**
     *
     * @return
     */
    public String getCoursesCompletedOnly(){
         return completed_courses.toString();
     }
     /**
     * Checks if the student has completed the Course
     * @param courseCode
     * @return
     */
    public boolean hasCompleted(String courseCode){
        return completed_courses.contains(courseCode);
     }
    
    //utility method will check if the string contains only letters.
    private boolean ifLettersOnly(String str){
        return str.chars().allMatch(Character::isLetter);
    }
//    end of getter methods
    
//    start of setter methods

    /**
     * uses utility method to validate first name before setting it
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if(ifLettersOnly(fName)) fName = firstName;
        else System.out.println("Please enter a valid first name");
    }

    /**
     * uses utility method to validate last name before setting it
     * @param lastName
     */
    public void setLastName(String lastName) {
        if(ifLettersOnly(lName)) lName = lastName;
        else System.out.println("Please enter a valid last name");
    }
    
    /**
     *
     * @param add
     */
    public void setStrtAdd(String add) {
        streetAdd = add;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @param postlCode
     */
    public void setPostCode(String postlCode) {
        this.postlCode = postlCode;
    }    

    /**
     *
     * @param program
     */
    public void setprog(String program) {
        this.program = program;
    }
    
    /**
     *
     * @param studentNumber
     */
    public void setStudentNum(int studentNumber) {
        this.studentNumber = studentNumber;    
    }
    
    /**
     *
     * @param enrollDate
     */
    public void setEnrollDate(LocalDate enrollDate) {
        enrollmentDate = enrollDate;
    }

    /**
     *
     * @param dob
     */
    public void setBirthday(LocalDate dob) {
        this.dob = dob;  
    }
    
    /**
     * sets the new address entered using setter methods of each part of the address
     * @param newStrtAdd
     * @param newCity
     * @param newPostlCode
     */
    public void changeAddress(String newStrtAdd, String newCity, String newPostlCode) {
       setStrtAdd(newStrtAdd);
       setCity(newCity);
       setPostCode(newPostlCode);
    }

    /**
     * sets boolean good student standing to false
     */
    public void suspendStudent(){
        setStudentStanding(false);
     }
     
    /**
     * sets boolean good student standing to true
     */
    public void reinstateStudent(){
        setStudentStanding(true);
     }
     
    /**
     *
     * @param goodStanding
     */
    public void setStudentStanding(boolean goodStanding){
         studentGoodStanding = goodStanding;
     }
   
    
    /**
     * Throws an exception if the student grade is less than 0 or more than 100
     * If grade is a valid passing grade adds the course and grade to array list completed_Course_Grade
     * and also adds just the course code to a different array list completed_courses
     * @param completedCourse
     * @param grade
     */
    public void addCompletedCourse(Course completedCourse, int grade){
         if(grade < 0 || grade > 100){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
         if(grade > 50){
         completed_Course_Grade.add(completedCourse.toString()+ " grade="+String.valueOf(grade));
         completed_courses.add(completedCourse.getCourseCode());
         } 
     }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return (getfName()+" "+getlName()+", student number: "+getStudentNumber());
    }
}
