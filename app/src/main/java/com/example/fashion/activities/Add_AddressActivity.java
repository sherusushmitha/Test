package com.example.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fashion.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

public class Add_AddressActivity extends AppCompatActivity {
    ImageView image;
    SharedPreferences sharedPreferences;
    Button add_address;
    EditText name,email,mobile,address,landmark,city,district,pincode;
    String id,Token;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_address );
        image=findViewById( R.id.image );
        name=findViewById( R.id.name );
        mobile=findViewById( R.id.mobile );
        email=findViewById( R.id.email );
        address=findViewById( R.id.address );
        landmark=findViewById( R.id.landmark );
        city=findViewById( R.id.city );
        district=findViewById( R.id.district );
        pincode=findViewById( R.id.pincode );
        add_address=findViewById( R.id.button_address );

        sharedPreferences = getSharedPreferences( "Agribiz", Context.MODE_PRIVATE );
        Token = sharedPreferences.getString( "Token", null );
        id = sharedPreferences.getString( "id", null );




        add_address.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateData()) {
                    Toast.makeText( Add_AddressActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                    servicesaddress(id,Token,name.getText().toString(),mobile.getText().toString(),
                            email.getText().toString(),address.getText().toString(),
                            landmark.getText().toString(),city.getText().toString(),district.getText().toString(),
                            pincode.getText().toString());
                }

            }
        } );



        Toolbar toolbar = findViewById(R.id.delivery_tool3);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Address ");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    private void servicesaddress(String user_masterid,String Token,String name,String mobile,String email,
                                 String address,String landmark,String city,String district,String pincode) {
        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.addnewaddress( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String statuscode = (model.getMessage()).trim();
                        String successcode = "1", failurecode = "0";

                        if (statuscode.equals(failurecode)) {

                            Toast.makeText(Add_AddressActivity.this, model.getMessage(), Toast.LENGTH_SHORT).show();

                        } else if (statuscode.equals(successcode)) {
                            //database edit

                            if(model.getMessage()!=null) {
                                Intent intent=new Intent(Add_AddressActivity.this,Delivery_AddressActivity.class);
                                startActivity( intent );


                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_masterid,Token,name,mobile,email,address,landmark,city,district,pincode );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean validateData() {
        if (name.getText().length() == 0) {
            name.setError( "required" );
            name.requestFocus();
        } else if (mobile.getText().length() == 0) {
            mobile.requestFocus();
            mobile.setError( "required" );
        } else if (mobile.getText().length() < 10) {
            mobile.requestFocus();
            mobile.setError( "required" );
        } else if (email.getText().length() == 0) {
            email.requestFocus();
            email.setError( "required" );
        }else if (pincode.getText().length() == 0) {
            pincode.requestFocus();
            pincode.setError( "required" );
        }else if (address.getText().length() == 0) {
            address.requestFocus();
            address.setError( "required" );
        } else if (landmark.getText().length() == 0) {
            landmark.requestFocus();
            landmark.setError( "required" );
        }else if (city.getText().length() == 0) {
            city.requestFocus();
            city.setError( "required" );
        }else if (district.getText().length() == 0) {
            district.requestFocus();
            district.setError( "required" );
        }else {
            return true;
        }
        return false;
    }
}