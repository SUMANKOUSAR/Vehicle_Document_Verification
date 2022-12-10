package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 14-09-2022.
 */
public class UserAccountArray {

    private String name;
    private String email;
    private String mobileno;
    private String city;
    private String postaladdress;
    private String 	password;


    public UserAccountArray(String name, String email, String mobileno, String city, String postaladdress, String password) {
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
        this.city = city;
        this.postaladdress = postaladdress;
        this.password = password;

    }

    public String getname() {
        return name;
    }
    public String getemail() {
        return email;
    }
    public String getmobileno() {

        return mobileno;
    }
    public String getcity() {
        return city;
    }
    public String getpostaladdress() {
        return postaladdress;
    }
    public String getpassword() {
        return password;
    }
}


