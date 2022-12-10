package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 16-09-2022.
 */
public class Vehicle_information extends AppCompatActivity {
    SharedPrefHandler shr;
    String str_shr;
    String str_val;
    String[] product;
    Button penalty;

    List<VehicleArray> vehicleList;
    List<DocumentArray> documentList;
    List<InsuranceArray> insuranceList;
    List<EmmissionArray> emmissionList;

    TextView vehname,vehno,vehtype,uname,umno,city,add,dob,licno,age,issuedate,expiredate;

    //String s_vehname,s_vehno,s_vehtype,s_uname,s_umno,s_city,s_add,s_dob,s_licno,s_age,s_issuedate,s_expiredate;

    TextView vno,vname,vtype,username,citi,addres,fueltype,model,manufacdate,chesisno;

    //String s_vno,s_vname,s_vtype,s_username,s_citi,s_addres,s_fueltype,s_model,s_manufacdate,s_chesisno;

    TextView insuno,insuname,ownername,vehamt,insuamt,exprydate,cit,postal;

   // String s_insuno,s_insuname,s_ownername,s_vehamt,s_insuamt,s_exprydate,s_cit,s_postal;

    TextView emmno,emmname,emmtype,vehcondition,carbon,expidate;

    //String s_emmno,s_emmname,s_emmtype,s_vehcondition,s_carbon,s_expidate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_information);

        vehno=(TextView)findViewById(R.id.tv_vno);
        vehname=(TextView)findViewById(R.id.tv_vname);
        vehtype=(TextView)findViewById(R.id.tv_type);
        uname=(TextView)findViewById(R.id.tv_uname);
        umno=(TextView)findViewById(R.id.tv_umno);
        city=(TextView)findViewById(R.id.tv_city);
        add=(TextView)findViewById(R.id.tv_add);
        dob=(TextView)findViewById(R.id.tv_dob);
        licno=(TextView)findViewById(R.id.tv_licno);
        age=(TextView)findViewById(R.id.tv_age);
        issuedate=(TextView)findViewById(R.id.tv_issuedate);
        expiredate=(TextView)findViewById(R.id.tv_expirydate);


        vno=(TextView)findViewById(R.id.tv_docno);
        vname=(TextView)findViewById(R.id.tv_docname);
        vtype=(TextView)findViewById(R.id.tv_doctype);
        username=(TextView)findViewById(R.id.tv_docuname);
        citi=(TextView)findViewById(R.id.tv_doccity);
        addres=(TextView)findViewById(R.id.tv_docaddress);
        fueltype=(TextView)findViewById(R.id.tv_docfuel);
        model=(TextView)findViewById(R.id.tv_docmodel);
        manufacdate=(TextView)findViewById(R.id.tv_docmanufacture);
        chesisno=(TextView)findViewById(R.id.tv_docchesis);

        insuno=(TextView)findViewById(R.id.tv_insuranceno);
        insuname=(TextView)findViewById(R.id.tv_insurancename);
        ownername=(TextView)findViewById(R.id.tv_insuranceowner);
        vehamt=(TextView)findViewById(R.id.tv_insurancevehicle);
        insuamt=(TextView)findViewById(R.id.tv_insuranceamt);
        exprydate=(TextView)findViewById(R.id.tv_insuranceexpiry);
        cit=(TextView)findViewById(R.id.tv_insurancecity);
        postal=(TextView)findViewById(R.id.tv_insurancepostal);

        emmno=(TextView)findViewById(R.id.tv_emissionno);
        emmname=(TextView)findViewById(R.id.tv_emissionname);
        emmtype=(TextView)findViewById(R.id.tv_emissiontype);
        vehcondition=(TextView)findViewById(R.id.tv_emissioncondition);
        carbon=(TextView)findViewById(R.id.tv_emmissioncarbon);
        expidate=(TextView)findViewById(R.id.tv_emissionexpiry);


        shr=new SharedPrefHandler(this);
        str_val=shr.getSharedPreferences("qrcode");

        Toast.makeText(Vehicle_information.this, ""+str_val, Toast.LENGTH_SHORT).show();
        getVehicleDriving(str_val);
        getVehicleDocument(str_val);
        getVehicleInsurance(str_val);
        getVehicleEmmission(str_val);

        penalty=(Button)findViewById(R.id.btn_penalty);
        penalty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplication(),Penalty_page.class);
                startActivity(i);
                Toast.makeText(Vehicle_information.this, "Penalty page", Toast.LENGTH_SHORT).show();
            }
        });
   }

    private void getVehicleDriving(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<VehicleArray>> call = api.getvehicle(str_val);

        call.enqueue(new Callback<List< VehicleArray>>() {
            @Override
            public void onResponse(Call<List<VehicleArray>> call, Response<List<VehicleArray>> response) {
                vehicleList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {

                    vehname.setText(vehicleList.get(0).getVehicleno());
                    vehno.setText(vehicleList.get(0).getVehiclename());
                    vehtype.setText(vehicleList.get(0).getVehicletype());
                    uname.setText(vehicleList.get(0).getUsername());
                    umno.setText(vehicleList.get(0).getUsermno());
                    city.setText(vehicleList.get(0).getCity());
                    add.setText(vehicleList.get(0).getAddress());
                    dob.setText(vehicleList.get(0).getDateofbirth());
                    licno.setText(vehicleList.get(0).getLicenseno());
                    age.setText(vehicleList.get(0).getAge());
                    issuedate.setText(vehicleList.get(0).getIssuedate());
                    expiredate.setText(vehicleList.get(0).getExpiredate());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<VehicleArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }




        private void getVehicleDocument(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<DocumentArray>> call = api.getdocument(str_val);

        call.enqueue(new Callback<List< DocumentArray>>() {
            @Override
            public void onResponse(Call<List<DocumentArray>> call, Response<List<DocumentArray>> response) {
                documentList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {


                    vno.setText(documentList.get(0).getVehicleno());
                    vname.setText(documentList.get(0).getVehiclename());
                    vtype.setText(documentList.get(0).getVehicletype());
                    username.setText(documentList.get(0).getUsername());
                    citi.setText(documentList.get(0).getCity());
                    addres.setText(documentList.get(0).getAddress());
                    fueltype.setText(documentList.get(0).getFueltype());
                    model.setText(documentList.get(0).getModel());
                    manufacdate.setText(documentList.get(0).getManufacturedate());
                    chesisno.setText(documentList.get(0).getChasiseno());



                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<DocumentArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getVehicleInsurance(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<InsuranceArray>> call = api.getinsurance(str_val);

        call.enqueue(new Callback<List< InsuranceArray>>() {
            @Override
            public void onResponse(Call<List<InsuranceArray>> call, Response<List<InsuranceArray>> response) {
                insuranceList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {


                    insuno.setText(insuranceList.get(0).getVehicleno());
                    insuname.setText(insuranceList.get(0).getVehiclename());
                    ownername.setText(insuranceList.get(0).getOwnername());
                    vehamt.setText(insuranceList.get(0).getVehicleamount());
                    insuamt.setText(insuranceList.get(0).getInsuranceamount());
                    exprydate.setText(insuranceList.get(0).getExpirydate());
                    cit.setText(insuranceList.get(0).getCity());
                    postal.setText(insuranceList.get(0).getPostaladdress());




                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<InsuranceArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getVehicleEmmission(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<EmmissionArray>> call = api.getemmission(str_val);

        call.enqueue(new Callback<List< EmmissionArray>>() {
            @Override
            public void onResponse(Call<List<EmmissionArray>> call, Response<List<EmmissionArray>> response) {
                emmissionList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {


                    emmno.setText(emmissionList.get(0).getVehicleno());
                    emmname.setText(emmissionList.get(0).getVehiclename());
                    emmtype.setText(emmissionList.get(0).getVehicletype());
                    vehcondition.setText(emmissionList.get(0).getVehiclecondition());
                    carbon.setText(emmissionList.get(0).getCarbonvalue());
                    expidate.setText(emmissionList.get(0).getExpirydate());





                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<EmmissionArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
