package com.example.fashion.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.fashion.R;

public class GridViewFragment extends Fragment {
        ImageView image;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.grid_view_design, container, false );

        image=root.findViewById( R.id.image );

        image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FragmentManager fragmentManager=getFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentTransaction.add( R.id.imageView,new CartFragment() );
//                fragmentTransaction.addToBackStack( null );
//                fragmentTransaction.commit();
            }
        } );



        return root;
    }

}