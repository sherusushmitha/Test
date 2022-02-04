package com.example.fashion.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.fashion.R;
import com.google.android.material.tabs.TabLayout;

public class My_Orders extends Fragment {
    TabLayout tabLayout;

    ViewPager viewPager;
    FragmentTransaction fragmentTransaction;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_my_order, container, false );

        tabLayout = root.findViewById( R.id.tab );
        viewPager = root.findViewById( R.id.viewpager );





//        MainActivityAdapter adapter = new MainActivityAdapter( getParentFragmentManager() );
//        adapter.addFrag( new ALLFragment(), "All" );
//        adapter.addFrag( new ComingFragment(), "Coming" );
//        adapter.addFrag( new HistoryFragment(), "History" );
//        adapter.addFrag( new DraftFragment(), "Draft" );
//        viewPager.setAdapter( adapter );

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("Coming"));
        tabLayout.addTab(tabLayout.newTab().setText("History"));
        tabLayout.addTab( tabLayout.newTab().setText( "Draft" ) );

//        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);

       // viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        ALLFragment allFragment = new ALLFragment();
        fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.container, allFragment );
        fragmentTransaction.addToBackStack( null );
        fragmentTransaction.commit();

        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    if (tab.getPosition() == 0) {
                        ALLFragment allFragment = new ALLFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.container, allFragment );
                        fragmentTransaction.addToBackStack( null );
                        fragmentTransaction.commit();
                    }else if(tab.getPosition()==1){
                        ComingFragment comingFragment = new ComingFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.container, comingFragment );
                        fragmentTransaction.addToBackStack( null );
                        fragmentTransaction.commit();


                    }else if(tab.getPosition()==2){
                        HistoryFragment historyFragment = new HistoryFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.container, historyFragment );
                        fragmentTransaction.addToBackStack( null );
                        fragmentTransaction.commit();


                    }else if(tab.getPosition()==3){
                        DraftFragment draftFragment = new DraftFragment();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace( R.id.container, draftFragment );
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

//
//    class MainActivityAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmentList = new ArrayList<>();
//        private final List<String> mFragmentTitleList = new ArrayList<>();
//
//        public MainActivityAdapter(FragmentManager manager) {
//            super( manager );
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmentList.get( position );
//        }
//
//        //to count how many Fragments there are to display
//        @Override
//        public int getCount() {
//            return mFragmentList.size();
//        }
//
//        public void addFrag(Fragment fragment, String title) {
//            // add fragments to list
//            mFragmentList.add( fragment );
//            //adding title to list
//            mFragmentTitleList.add( title );
//        }
//
//        //returning each title of fragment
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get( position );
//
//        }
//
//    }
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                ALLFragment allFragment = new ALLFragment();
//                return allFragment;
//            case 1:
//                ComingFragment comingFragment = new ComingFragment();
//                return comingFragment;
//            case 2:
//                HistoryFragment historyFragment = new HistoryFragment();
//                return historyFragment;
//            case 3:
//                DraftFragment draftFragment = new DraftFragment();
//                return draftFragment;
//            default:
//                return null;
//        }
//    }
}