package com.in.fashion.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fashion.R;
import com.in.fashion.SideNavigation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

public class OTPActivity extends AppCompatActivity {
    Button otp_button;
    TextView resend_otp;
    TextView edit;
    TextView edit1;
    TextView edit2;
    TextView edit3;
    String otp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_otp );

        otp_button = findViewById( R.id.otp_button );
        resend_otp = findViewById( R.id.resend_otp );
        edit = findViewById( R.id.edit );
        edit1 = findViewById( R.id.edit1 );
        edit2 = findViewById( R.id.edit2 );
        edit3 = findViewById( R.id.edit3 );


        edit.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit.getText().toString().length() == 1) {
                    edit1.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        edit1.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (edit1.getText().length() == 0) {
                    edit2.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit1.getText().toString().length() == 1) {
                    edit2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edit1.getText().length() == 0) {
                    edit.requestFocus();
                }
            }
        } );

        edit2.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (edit2.getText().length() == 0) {
                    edit1.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit2.getText().toString().length() == 1) {
                    edit3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edit2.getText().length() == 0) {
                    edit1.requestFocus();
                }
            }
        } );

        edit3.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (edit3.getText().length() == 0) {
                    edit2.requestFocus();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (edit3.getText().toString().length() == 1) {
                    getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    InputMethodManager inputManager = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE);
                    if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edit3.getText().length() == 0) {
                    edit2.requestFocus();
                }
            }

   } );

        otp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit.getText().toString().length() == 0 || edit1.getText().toString().length() == 0 || edit2.getText().toString().length() == 0 || edit3.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter Valid OTP", Toast.LENGTH_SHORT).show();

                } else {
                    otp = edit.getText().toString() + edit1.getText().toString() +
                            edit2.getText().toString() + edit3.getText().toString();

                    serviceVerifyOtp(otp);
                }
            }

        });


    }


    private void serviceVerifyOtp(String otp) {
        try {
            Toast.makeText( getApplicationContext(), "check", Toast.LENGTH_SHORT ).show();
            DataManager dataManager = DataManager.getDataManager();
            dataManager.verifyotp( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String successcode = "200", failurecode = "400";
                        String statuscode = (model.getStatus()).trim();

                        if (statuscode.equals( failurecode )) {

                            Toast.makeText( getApplicationContext(), model.getMessage(), Toast.LENGTH_SHORT ).show();

                        } else if (statuscode.equals( successcode )) {
                            //database edit
                            Intent intent = new Intent( OTPActivity.this, SideNavigation.class );
                            startActivity( intent );
                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "hello", Toast.LENGTH_SHORT ).show();
                }
            },otp );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    private boolean validateData() {
//        if (edit.getText().length() == 0) {
//            edit.setError( "required" );
//            edit.requestFocus();
//        } else if (edit1.getText().length() == 0) {
//            edit1.setError( "required" );
//            edit1.requestFocus();
//        } else if (edit2.getText().length() == 0) {
//            edit2.requestFocus();
//            edit2.setError( "required" );
//        } else if (edit3.getText().length() == 0) {
//            edit3.requestFocus();
//            edit3.setError( "required" );
//        }  else {
//            return true;
//        }
//        return false;
//    }

}