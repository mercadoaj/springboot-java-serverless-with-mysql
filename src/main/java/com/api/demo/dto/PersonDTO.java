package com.api.demo.dto;

import java.time.LocalDate;


public class PersonDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    //private LocalDate birthDate;
   
    public Long getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getMiddleName(){
        return this.middleName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /*public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }*/

}

