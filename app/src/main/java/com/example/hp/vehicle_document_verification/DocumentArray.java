package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 17-09-2022.
 */
public class DocumentArray {

        private String vehicleno;
        private String vehiclename;
        private String vehicletype;
        private String username;
        private String city;
        private String 	address;
        private String 	fueltype;
        private String 	model;
        private String 	manufacturedate;
        private String 	chasiseno;




        public DocumentArray(String vehicleno, String vehiclename, String vehicletype, String username, String city, String address,String fueltype,String model,String manufacturedate,String chasiseno) {
            this.vehicleno = vehicleno;
            this.vehiclename = vehiclename;
            this.vehicletype = vehicletype;
            this.username = username;
            this.city = city;
            this.address = address;
            this.fueltype = fueltype;
            this.model = model;
            this.manufacturedate = manufacturedate;
            this.chasiseno = chasiseno;


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
        public String getCity()
        {
            return city;
        }
        public String getAddress()
        {
            return address;
        }
        public String getFueltype() {
            return fueltype;
        }
        public String getModel() {
            return model;
        }
        public String getManufacturedate() {
            return manufacturedate;
        }
        public String getChasiseno() {
            return chasiseno;
        }


    }
