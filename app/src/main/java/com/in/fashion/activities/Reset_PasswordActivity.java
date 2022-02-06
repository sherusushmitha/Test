package com.in.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fashion.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

@SuppressWarnings("SingleStatementInBlock")
public class Reset_PasswordActivity extends AppCompatActivity {
    Button password_button;
    EditText current_password,new_password,confirm_password;
    String user_masterid,Token;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reset_password );
        password_button = findViewById( R.id.password_button );
        current_password=findViewById( R.id.current_password );
        new_password=findViewById( R.id.new_password );
        confirm_password=findViewById( R.id.confirm_password );
        sharedPreferences=getSharedPreferences( "Agribiz" ,MODE_PRIVATE);
        user_masterid=sharedPreferences.getString( "id",null );
        Token=sharedPreferences.getString( "Token",null );


        Toolbar toolbar = findViewById(R.id.delivery_tool_10);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        System.out.println("user_masterid"+user_masterid+","+"current_password"+current_password.getText().toString()+","+
                "new_password"+new_password.getText().toString()+"Token"+Token);

        password_button.setOnClickListener( new View.OnClickListener() {
            private SharedPreferences prefs;

            public void onClick(View v) {

                if (validateData()) {
                    Toast.makeText( Reset_PasswordActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                    servicechangepassword( user_masterid,Token,current_password.getText().toString(),new_password.getText().toString());
                }
            }

        });


//        password_button.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialogBox();
//
//            }
//
//            private void showDialogBox() {
//                ViewGroup viewGroup = findViewById( android.R.id.content );
////
//                View view = LayoutInflater.from( getApplication() ).inflate( R.layout.row_reset_paswword_design, viewGroup, false );
//                Button submit1 = view.findViewById( R.id.reset_button );
//
//
//                AlertDialog.Builder builder = new AlertDialog.Builder( Reset_PasswordActivity.this );
//                builder.setView( view );//setting view to  dialog
//                //Creating dialog box
//                final AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//
//                submit1.setOnClickListener( new View.OnClickListener() {
//                    public void onClick(View v) {
//                       alertDialog.dismiss();
//
//
//
//                    }
//                } );
//            }
//
//        } );



}
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void servicechangepassword(String user_masterid,String Token,String oldpassword,String password) {
        try {
            Toast.makeText( getApplicationContext(), "check", Toast.LENGTH_SHORT ).show();
            DataManager dataManager = DataManager.getDataManager();
            dataManager.changepassword( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals(failurecode))
                            Toast.makeText( Reset_PasswordActivity.this, model.getMessage(), Toast.LENGTH_SHORT ).show();
                        else if (statuscode.equals(successcode)) {
                            //database edit

//                            if(model.getStatus()!=null) {
//                                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
//                                startActivity(intent);
//                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_masterid,Token,oldpassword,password );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean validateData() {
        if (current_password.getText().length() == 0) {
            current_password.setError( "required" );
            current_password.requestFocus();
        }else if (new_password.getText().length() == 0) {
            new_password.requestFocus();
            new_password.setError( "required" );
        }else if (confirm_password.getText().length() == 0) {
            confirm_password.requestFocus();
            confirm_password.setError( "required" );
        }else if (!new_password.getText().toString().equals( confirm_password.getText().toString() )) {
            confirm_password.requestFocus();
            confirm_password.setError( "Password does not match" );
        }else return true;
        return false;
    }

}


