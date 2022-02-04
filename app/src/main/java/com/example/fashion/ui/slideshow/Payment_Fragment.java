package com.example.fashion.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fashion.R;
import com.example.fashion.ui.gallery.ALLFragment;
import com.example.fashion.ui.gallery.ComingFragment;
import com.example.fashion.ui.home.HomeFragment;


public class Payment_Fragment extends Fragment {
    FragmentTransaction fragmentTransaction;
    CardView card1,card2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_payment, container, false );
        card1=root.findViewById( R.id.card1 );
        card2=root.findViewById( R.id.card2 );

        CardFragment cardFragment = new CardFragment();
        fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.fragment_container, cardFragment );
        fragmentTransaction.addToBackStack( null );
        fragmentTransaction.commit();

        card1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardFragment cardFragment = new CardFragment();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.fragment_container, cardFragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();

            }
        } );

        card2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CashFragment cashFragment = new CashFragment();
                fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.fragment_container, cashFragment );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();

            }
        } );


        return root;
    }



}