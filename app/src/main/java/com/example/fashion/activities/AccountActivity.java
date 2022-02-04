package com.example.fashion.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fashion.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

public class AccountActivity extends AppCompatActivity {
    private static final Object CAMERA_PIC_REQUEST = 100;
    private static final int CAMERA_REQUEST = 100;
    ImageView open_camera,profile;
    Button update;
    EditText name_one,email_Address;
    String user_masterid,Token,image,imagename;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_account );

        open_camera = findViewById( R.id.camera );
        profile=findViewById( R.id.profile );
        update=findViewById( R.id.update );
        name_one=findViewById( R.id.name_one );
        email_Address=findViewById( R.id.email_Address );



        sharedPreferences=getSharedPreferences( "Agribiz" , Context.MODE_PRIVATE);
        user_masterid=sharedPreferences.getString( "id",null );
        Token=sharedPreferences.getString( "Token",null );

//        image=sharedPreferences.getString( "image",null );
//        image_name=sharedPreferences.getString( "imagename",null );



        Toolbar toolbar = findViewById(R.id.delivery_tool_one);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Edit Profile");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }



        update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateData()) {

                    System.out.println("user_masterid"+user_masterid+","+"name_one"+name_one.getText().toString()+","+
                            "email_Address"+email_Address.getText().toString()+","+"imagename"+imagename+","+"Token"+Token);
                    System.out.println("image"+image  );


//                    servicechangeprofile( user_masterid,Token,name_one.getText().toString(),
//                       email_Address.getText().toString(),imagename,image);
                }
            }
        } );


        open_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryPick();
            }
        });


    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == AccountActivity.RESULT_OK) {
                if (data != null) {
                    Uri selectedImage = data.getData();
                    InputStream imageStream = null;
                    try {
                        if (AccountActivity.this != null) {
                            imageStream = AccountActivity.this.getContentResolver().openInputStream(selectedImage);

                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                        if (bitmap != null) {
                            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                            String hjkl = currentDateTimeString.replaceAll(" ", "_");
                            String hiop = hjkl.replaceAll(":", "-");

                            image = encodeTobase64(bitmap);
                            imagename = hiop + ".jpeg";
                            profile.setImageBitmap(bitmap);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private String encodeTobase64(Bitmap image) {
        Bitmap immagex = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    private boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getApplication().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }


    private void galleryPick() {
        if (isStoragePermissionGranted()) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
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


    private void servicechangeprofile(String user_masterid,String Token,String name,String email,String imagename,String image) {
        try {
            DataManager dataManager = DataManager.getDataManager();
            dataManager.updateprofile( new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    Model model = response.body();
                    if (model != null) {
                        String statuscode = (model.getStatus()).trim();
                        String successcode = "200", failurecode = "400";

                        if (statuscode.equals(failurecode))
                            Toast.makeText( AccountActivity.this, model.getMessage(), Toast.LENGTH_SHORT ).show();
                        else if (statuscode.equals(successcode)) {
                            //database edit

//                            if(model.getStatus()!=null) {
//                                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
//
//                                startActivity(intent);
//                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    Toast.makeText( getApplicationContext(), "Check Internet Connection!. Please Try Again", Toast.LENGTH_SHORT ).show();
                }
            }, user_masterid, Token, name, email, imagename, image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean validateData() {
        if (name_one.getText().length() == 0) {
            name_one.setError( "required" );
            name_one.requestFocus();
        }
        else if (email_Address.getText().length() == 0) {
            email_Address.requestFocus();
            email_Address.setError( "required" );
        }else {
            return true;
        }
        return false;
    }

}
