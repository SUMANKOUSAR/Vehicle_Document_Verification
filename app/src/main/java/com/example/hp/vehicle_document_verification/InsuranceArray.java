package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 17-09-2022.
 */
public class InsuranceArray {

    private String vehicleno;
    private String vehiclename;
    private String ownername;
    private String vehicleamount;
    private String insuranceamount;
    private String 	expirydate;
    private String 	city;
    private String 	postaladdress;




    public InsuranceArray(String vehicleno, String vehiclename, String ownername, String vehicleamount, String insuranceamount, String expirydate,String city,String postaladdress) {
        this.vehicleno = vehicleno;
        this.vehiclename = vehiclename;
        this.ownername = ownername;
        this.vehicleamount = vehicleamount;
        this.insuranceamount = insuranceamount;
        this.expirydate = expirydate;
        this.city = city;
        this.postaladdress = postaladdress;



    }

    public String getVehicleno() {
        return vehicleno;
    }
    public String getVehiclename()
    {
        return vehiclename;
    }
    public String getOwnername() {

        return ownername;
    }
    public String getVehicleamount()
    {
        return vehicleamount;
    }
    public String getInsuranceamount()
    {
        return insuranceamount;
    }
    public String getExpirydate()
    {
        return expirydate;
    }
    public String getCity() {
        return city;
    }
    public String getPostaladdress() {
        return postaladdress;

    }


}