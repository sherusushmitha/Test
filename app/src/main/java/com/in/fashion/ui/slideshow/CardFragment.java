package com.in.fashion.ui.slideshow;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fashion.R;

public class CardFragment extends Fragment {
    FragmentTransaction fragmentTransaction;
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_card, container, false );

        button = root.findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialogBox();


            }

            private void showDialogBox() {
                ViewGroup viewGroup = getView().findViewById( android.R.id.content );

        View view = LayoutInflater.from( getContext() ).inflate( R.layout.continu, viewGroup, false );
        Button submit1 = view.findViewById( R.id.button1 );


        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );
        builder.setView( view );//setting view to  dialog
        //Creating dialog box
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        submit1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        } );

            }
        } );
        return root;


    }


}