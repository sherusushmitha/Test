package com.in.fashion.ui.slideshow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fashion.R;
import com.google.android.material.tabs.TabLayout;


public class NotificationFragment extends Fragment {
    TabLayout tabLayout;
    FragmentTransaction fragmentTransaction;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate( R.layout.fragment_notification, container, false );

        tabLayout=root.findViewById( R.id.tab1 );

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab1);
        tabLayout.addTab(tabLayout.newTab().setText("My Order"));
        tabLayout.addTab(tabLayout.newTab().setText("News"));

        Order_NotificationFragment order_notificationFragment = new Order_NotificationFragment();
        fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.container, order_notificationFragment );
        fragmentTransaction.addToBackStack( null );
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    Order_NotificationFragment order_notificationFragment=new Order_NotificationFragment();
                    FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                    fragmentTransaction.replace( R.id.container,order_notificationFragment );
                    fragmentTransaction.addToBackStack( null );
                    fragmentTransaction.commit();
                }else if (tab.getPosition()==1){
                    NewsFragment newsFragment=new NewsFragment();
                    FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
                    fragmentTransaction.replace( R.id.container,newsFragment );
                    fragmentTransaction.addToBackStack( null );
                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );



        return root;
    }
}