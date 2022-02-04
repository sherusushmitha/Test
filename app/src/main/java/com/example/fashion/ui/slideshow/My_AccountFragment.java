package com.example.fashion.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.fashion.activities.AccountActivity;
import com.example.fashion.activities.ContactActivity;
import com.example.fashion.R;
import com.example.fashion.activities.LoginActivity;
import com.example.fashion.activities.Reset_PasswordActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utilities.DataManager;
import utilities.Model;

public class My_AccountFragment extends Fragment {
    ImageView account_image,image3,image5,image9,image11,password_image,image_con1;
    FragmentTransaction fragmentTransaction;

    TextView text2,text3,text5,password,text6,text_con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_myaccount, container, false );

        account_image = root.findViewById( R.id.account_image );
        image3 = root.findViewById( R.id.image3 );
        image5=root.findViewById( R.id.image5 );
        image9=root.findViewById( R.id.image9 );
        image11=root.findViewById( R.id.image11 );
        password=root.findViewById( R.id.password );
        image_con1=root.findViewById( R.id.image_con1 );

        text2=root.findViewById( R.id.text2 );
        text3=root.findViewById( R.id.text3 );
        text5=root.findViewById( R.id.text5 );
        password_image=root.findViewById( R.id.password_image );
        text6=root.findViewById( R.id.text6 );
        text_con=root.findViewById( R.id.text_con );

        account_image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), AccountActivity.class );
                startActivity( intent );
            }
        } );
//
        image3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationFragment notificationFragment = new NotificationFragment();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, notificationFragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();


            }
        } );

        text2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationFragment notificationFragment = new NotificationFragment();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, notificationFragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();


            }
        } );
//
        image5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Payment_Fragment payment_fragment=new Payment_Fragment();
                fragmentTransaction=getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation,payment_fragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();

            }
        } );

        text3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Payment_Fragment payment_fragment=new Payment_Fragment();
                fragmentTransaction=getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation,payment_fragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();

            }
        } );
//
        image9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),My_PromoActivity.class);
                startActivity( intent );

            }
        } );

        text5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),My_PromoActivity.class);
                startActivity( intent );


            }
        } );
        //
        image11.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SettingActivity.class);
                startActivity( intent );
            }
        } );

        text6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SettingActivity.class);
                startActivity( intent );

            }
        } );
//
        password_image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Reset_PasswordActivity.class );
                startActivity( intent );
            }
        } );
        password.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Reset_PasswordActivity.class );
                startActivity( intent );




            }
        } );
        //

        text_con.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ContactActivity.class );
                startActivity( intent );
            }
        } );

        image_con1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ContactActivity.class );
                startActivity( intent );

            }
        } );


        return root;


    }

}
