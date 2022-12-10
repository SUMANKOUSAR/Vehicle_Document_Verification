package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 17-09-2022.
 */
public class EmmissionArray {
    private String vehicleno;
    private String vehiclename;
    private String vehicletype;
    private String vehiclecondition;
    private String 	carbonvalue;
    private String 	expirydate;





    public EmmissionArray(String vehicleno, String vehiclename, String vehicletype, String vehiclecondition, String carbonvalue,String expirydate) {
        this.vehicleno = vehicleno;
        this.vehiclename = vehiclename;
        this.vehicletype = vehicletype;
        this.vehiclecondition = vehiclecondition;
        this.carbonvalue = carbonvalue;
        this.expirydate = expirydate;




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
    public String getVehiclecondition()
    {
        return vehiclecondition;

    }
    public String getCarbonvalue()
    {
        return carbonvalue;
    }
    public String getExpirydate() {
        return expirydate;


    }
}
