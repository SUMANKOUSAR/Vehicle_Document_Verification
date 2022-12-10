package com.example.hp.vehicle_document_verification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Missing_info extends AppCompatActivity {
    TextView missname,missno,complaint,station,citiy,address,date;
    SharedPrefHandler shr;
    String str_val;
    String[] product;

    List<MissingArray> missingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.missing_info);

        missname = (TextView) findViewById(R.id.tv_missingname);
        missno = (TextView) findViewById(R.id.tv_missingno);
        complaint = (TextView) findViewById(R.id.tv_missingcomplaint);
        station = (TextView) findViewById(R.id.tv_missingstation);
        citiy = (TextView) findViewById(R.id.tv_missingcity);
        address = (TextView) findViewById(R.id.tv_missingaddress);
        date = (TextView) findViewById(R.id.tv_missingdate);


        shr = new SharedPrefHandler(this);
        str_val = shr.getSharedPreferences("key");

        Toast.makeText(Missing_info.this, "" + str_val, Toast.LENGTH_SHORT).show();

        getVehicleMissing(str_val);
    }

    private void getVehicleMissing(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<MissingArray>> call = api.getmissing(str_val);

        call.enqueue(new Callback<List< MissingArray>>() {
            @Override
            public void onResponse(Call<List<MissingArray>> call, Response<List<MissingArray>> response) {
                missingList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {

                    missno.setText(missingList.get(0).getVehicleno());
                    missname.setText(missingList.get(0).getVehiclename());
                    complaint.setText(missingList.get(0).getComplaintdetails());
                    station.setText(missingList.get(0).getStationname());
                    citiy.setText(missingList.get(0).getCity());
                    address.setText(missingList.get(0).getAddress());
                    date.setText(missingList.get(0).getDate_d());



                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<MissingArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}




