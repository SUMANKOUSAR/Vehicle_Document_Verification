package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 17-09-2022.
 */
public class VehicleArray {

    private String vehicleno;
    private String vehiclename;
    private String vehicletype;
    private String username;
    private String usermno;
    private String 	city;
    private String 	address;
    private String 	dateofbirth;
    private String 	licenseno;
    private String 	age;
    private String 	issuedate;
    private String 	expiredate;



    public VehicleArray(String vehicleno, String vehiclename, String vehicletype, String username, String usermno, String city,String address,String dateofbirth,String licenseno,String age,String issuedate,String expiredate) {
        this.vehicleno = vehicleno;
        this.vehiclename = vehiclename;
        this.vehicletype = vehicletype;
        this.username = username;
        this.usermno = usermno;
        this.city = city;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.licenseno = licenseno;
        this.age = age;
        this.issuedate = issuedate;
        this.expiredate = expiredate;

    }

    public String getVehicleno() {
        return vehicleno;
    }
    public String getVehiclename()
    {
        return vehiclename;
    }
    public String getVehicletype() {

        return vehicletype;
    }
    public String getUsername()
    {
        return username;
    }
    public String getUsermno()
    {
        return usermno;
    }
    public String getCity()
    {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public String getDateofbirth() {
        return dateofbirth;
    }
    public String getLicenseno() {
        return licenseno;
    }
    public String getAge() {
        return age;
    }
    public String getIssuedate() {
        return issuedate;
    }
    public String getExpiredate() {
        return expiredate;
    }
}

