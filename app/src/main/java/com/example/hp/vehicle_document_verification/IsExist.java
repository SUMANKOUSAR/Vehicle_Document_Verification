package com.example.hp.vehicle_document_verification;

/**
 * Created by HP on 12-09-2022.
 */
public class IsExist {

    private Boolean success;

    public IsExist(Boolean success){
        this.success = success;
    }

    public Boolean getSuccess(){
        return success;
    }

    public void setSuccess(Boolean success){
        this.success = success;
    }
}
