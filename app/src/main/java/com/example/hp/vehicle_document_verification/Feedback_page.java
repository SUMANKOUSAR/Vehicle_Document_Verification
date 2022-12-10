package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HP on 14-09-2022.
 */
public class Feedback_page extends AppCompatActivity {
    EditText sub,msg,mob;
    Button send;
    String str_sub,str_mno,str_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);
        sub=(EditText)findViewById(R.id.et_feedback_subject);
        msg=(EditText)findViewById(R.id.et_feedback_message);
        mob=(EditText)findViewById(R.id.et_feedback_mno);
        send=(Button)findViewById(R.id.btn_feedback);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_sub = sub.getText().toString();
                str_mno = mob.getText().toString();
                str_msg = msg.getText().toString();
                if (str_sub.isEmpty() || str_mno.length() < 10 || str_msg.isEmpty()) {
                    Toast.makeText(Feedback_page.this, "Enter feedback details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"samanarahubballi@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, str_sub);
                    email.putExtra(Intent.EXTRA_TEXT, str_msg + str_mno);

                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                    Toast.makeText(Feedback_page.this, " sent sucessfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

