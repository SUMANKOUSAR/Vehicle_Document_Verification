package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 17-09-2022.
 */
public class MissingArray {
    private String vehicleno;
    private String vehiclename;
    private String complaintdetails;
    private String stationname;
    private String 	city;
    private String 	address;
    private String date_d;




    public MissingArray(String vehicleno, String vehiclename, String complaintdetails, String stationname, String city,String address,String date_d) {
        this.vehicleno = vehicleno;
        this.vehiclename = vehiclename;
        this.complaintdetails = complaintdetails;
        this.stationname = stationname;
        this.city = city;
        this.address = address;
        this.date_d = date_d;



    }

    public String getVehicleno() {
        return vehicleno;
    }
    public String getVehiclename()
    {
        return vehiclename;
    }
    public String getComplaintdetails() {

        return complaintdetails;
    }
    public String getStationname()
    {
        return stationname;

    }
    public String getCity()
    {
        return city;
    }
    public String getAddress() {
        return address;


    }
    public String getDate_d() {
        return date_d;


    }
}

