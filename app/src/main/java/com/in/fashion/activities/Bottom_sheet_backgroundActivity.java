package com.in.fashion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.fashion.R;

public class Bottom_sheet_backgroundActivity extends AppCompatActivity {
    Button add_address;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bottom_sheet_background );
        add_address = findViewById( R.id.add_address );

//        add_address.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent=new Intent(getApplicationContext(),Add_AddressActivity.class);
//                startActivity( intent );
//
//            }
//        } );

//        add_address.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent( Bottom_sheet_backgroundActivity.this, Add_AddressActivity.class );
//                startActivity( intent );
//            }
//        } );


    }
}