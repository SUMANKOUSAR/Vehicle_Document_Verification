package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HP on 12-09-2022.
 */
public class Home_page extends AppCompatActivity {
    SharedPrefHandler shr;
    TextView vehicle,missing,feed,about;
    ImageView veh,miss,fee,abo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        shr=new SharedPrefHandler(this);
        vehicle=(TextView)findViewById(R.id.tv_vehicle);
        missing=(TextView)findViewById(R.id.tv_missing);
        feed=(TextView)findViewById(R.id.tv_feedback);
        about=(TextView)findViewById(R.id.tv_about);
        veh=(ImageView)findViewById(R.id.img_image);
        miss=(ImageView)findViewById(R.id.img_cartoon);
        fee=(ImageView)findViewById(R.id.img_lo);
        abo=(ImageView)findViewById(R.id.img_call);

        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Vehicle_verification.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome here", Toast.LENGTH_SHORT).show();
            }
        });

        missing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Missing_vehicle.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "Missing me", Toast.LENGTH_SHORT).show();
            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Feedback_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "Like me", Toast.LENGTH_SHORT).show();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),About_app.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "About mee", Toast.LENGTH_SHORT).show();
            }
        });

        veh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Vehicle_verification.class);
                startActivity(i);

            }
        });

        miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Missing_vehicle.class);
                startActivity(i);
            }
        });

        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),Feedback_page.class);
                startActivity(i);
            }
        });

        abo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(),About_app.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {

            shr.setSharedPreferences("login","false");
            Intent i = new Intent(getApplication(), Login_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_Profile) {

            shr.setSharedPreferences("login","false");
            Intent i = new Intent(getApplication(), Profile_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_ContactUs) {

            shr.setSharedPreferences("login","false");
            Intent i = new Intent(getApplication(), Contact_us.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_HelpCenter) {

            shr.setSharedPreferences("login","false");
            Intent i = new Intent(getApplication(), Help_center.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
