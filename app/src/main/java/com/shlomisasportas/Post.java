package com.shlomisasportas;

public class Post {

    private String firstName;
    private String lastName;
    private String age;
    private String dateOfBirth;
    private String dadName;
    private String deathLocation;
    private String dateOfDeath;
    private String momName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDadName(String dadName){
        this.dadName = dadName;
    }
    public String getDadName(){
        return dadName;
    }

    public void setDeathLocation(String deathLocation){
        this.deathLocation = deathLocation;
    }

    public String getDeathLocation(){
        return deathLocation;
    }

    public String getDateOfDeath(){
        return dateOfDeath;
    }
    public void setDateOfDeath(String dateOfDeath){
        this.dateOfDeath = dateOfDeath;
    }

    public String getMomName(){
        return momName;
    }
    public void setMomName(String momName){
        this.momName = momName;
    }

}