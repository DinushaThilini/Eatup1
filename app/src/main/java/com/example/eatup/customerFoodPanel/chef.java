package com.example.eatup.customerFoodPanel;

public class chef {

    private String Area,City,CnfirmPassworde,Emailid,Fname,House,Lname,Mobile,Password,Postcode,State;


    public chef(String area, String city, String cnfirmPassworde, String emailid, String fname, String house, String lname, String mobile, String password, String postcode, String state) {

       this.Area=area
        City = city;
        CnfirmPassworde = cnfirmPassworde;
        Emailid = emailid;
        Fname = fname;
        House = house;
        Lname = lname;
        Mobile = mobile;
        Password = password;
        Postcode = postcode;
        State = state;
    }
     public chef(){

     }

    public String getArea() {
        return Area;
    }

    public String getCity() {
        return City;
    }

    public String getCnfirmPassworde() {
        return CnfirmPassworde;
    }

    public String getEmailid() {
        return Emailid;
    }

    public String getFname() {
        return Fname;
    }

    public String getHouse() {
        return House;
    }

    public String getLname() {
        return Lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getPassword() {
        return Password;
    }

    public String getPostcode() {
        return Postcode;
    }

    public String getState() {
        return State;
    }
}
