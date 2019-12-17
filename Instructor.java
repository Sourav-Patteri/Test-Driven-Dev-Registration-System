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
public class Instructor {
    
    private String fName,lName, streetAdd, city, postlCode;
    private int id;
    private LocalDate enrollmentDate, dob;
    private final ArrayList<String> certified_subjects =new ArrayList<>();//Creating arraylist to store the subjects an instructor is certified to teach.
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param id
     * @param streetAdd
     * @param city
     * @param postlCode
     * @param enrollmentDate
     * @param dob
     */
    public Instructor(String firstName, String lastName, int id, String streetAdd, String city, String postlCode, LocalDate enrollmentDate, LocalDate dob) {
        
        fName = firstName;
        lName = lastName;
        this.streetAdd = streetAdd;
        this.city = city;
        this.postlCode = postlCode;
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        this.dob = dob;
        
        /**
         * Throws an exception if the instructor age is more than 100 as its probably a mistake
         */
        if(getAgeInYears() > 100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        /**
         * Throws an exception if the instructor has been in college for more than 80 years
         */
        if(NoOfYearsAtCollege() > 80){
            throw new IllegalArgumentException(getjoinDate()+" as a hire date would mean "+getfName()+" started working over "+NoOfYearsAtCollege()+" years ago");
        }
        
    }

    /**
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
     *
     * @return
     */
    public String getInstructorAddress(){
        
       String fullAdd = streetAdd+", "+city+", "+postlCode;
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
    public int getinstructorid() {
        return id;
    }
    
    /**
     *
     * @return
     */
    public LocalDate getjoinDate(){
        return enrollmentDate;
    }

    /**
     *
     * @return
     */
    public LocalDate getdob(){
        return dob;
    }
    
    /**
     *
     * @return
     */
    public int getAgeInYears(){
       Period period = Period.between(dob,  LocalDate.now()); 
       return period.getYears();
   }
   
    /**
     *
     * @return
     */
    public int NoOfYearsAtCollege(){
       Period period = Period.between(enrollmentDate,  LocalDate.now()); 
       return period.getYears();
   }
   
    /**
     * returns a string of the courses the instructor is certified to teach
     * @return
     */
    public String listOfSubjectsCertifiedToTeach () {
        if(certified_subjects.isEmpty()) {
            return "not qualified to teach courses yet.";  
        } 
        else {
          return certified_subjects.toString();
        }
    }

    /**
     * returns true if instructor is qualified to teach the given subject
     * @param subject
     * @return
     */
    public boolean InstructorcanTeach(String subject) {
        return certified_subjects.contains(subject);   
    }
    
    //utility method will check if the string contains only letters.
    private boolean ifLettersOnly(String str){
        return str.chars().allMatch(Character::isLetter);
    }
//    end of getter methods
    
//    setter methods are void methods

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
     * @param id
     */
    public void setid(int id) {
        this.id = id;    
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
    public void setdob(LocalDate dob) {
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
     *
     * @param subject
     */
    public void addCourseToInstructorAbilities(String subject) {
       if(!certified_subjects.contains(subject)) 
       certified_subjects.add(subject);
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return (getfName()+" "+getlName());
    }
}

