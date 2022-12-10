package com.example.hp.vehicle_document_verification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HP on 17-09-2022.
 */
public class Penalty_page extends AppCompatActivity {
    EditText umno,uname,penamt,pendetails;
    String usr_mno,usr_name,usr_amt,usr_details;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penalty_page);
        umno=(EditText)findViewById(R.id.et_penalty_mno);
        uname=(EditText)findViewById(R.id.et_penalty_name);
        penamt=(EditText)findViewById(R.id.et_penalty_amt);
        pendetails=(EditText)findViewById(R.id.et_penalty_details);
        submit=(Button)findViewById(R.id.btn_penalty_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_mno=umno.getText().toString();
                usr_name=uname.getText().toString();
                usr_amt=penamt.getText().toString();
                usr_details=pendetails.getText().toString();
                if (usr_mno.length()<10||usr_name.isEmpty()||usr_amt.isEmpty()||usr_details.isEmpty()){
                    Toast.makeText(Penalty_page.this, "fill details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i = new Intent(getApplication(),Pdf_page.class);
                    startActivity(i);
                    Toast.makeText(Penalty_page.this, "pay the penalty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
