package com.example.fashion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;

import com.example.fashion.activities.ActivitySideNavigationBinding;
import com.example.fashion.ui.Private_PolicyActivity;
import com.example.fashion.ui.Terms_ConditionsActivity;
import com.example.fashion.ui.gallery.My_Orders;
import com.example.fashion.ui.home.HomeFragment;
import com.example.fashion.ui.slideshow.My_AccountFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

public class SideNavigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentTransaction fragmentTransaction;
    SharedPreferences sharedPreferences;


    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySideNavigationBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_side_navigation );




        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        NavigationView navigationView = findViewById( R.id.nav_view );

        navigationView.setNavigationItemSelectedListener( this );

        final DrawerLayout drawer = findViewById( R.id.drawer_layout );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );

        toggle.syncState();

        HomeFragment home = new HomeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, home );
        fragmentTransaction.addToBackStack( null );
        fragmentTransaction.commit();

//
//        binding = ActivitySideNavigationBinding.inflate( getLayoutInflater() );
//        setContentView( binding.getRoot() );
//
//        setSupportActionBar( binding.appBarSideNavigation.toolbar );
//        binding.appBarSideNavigation.fab.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
//                        .setAction( "Action", null ).show();
//            }
//        } );
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
////         Passing each menu ID as a set of Ids because each
////         menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow )
//                .setDrawerLayout( drawer )
//                .build();
//        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_content_side_navigation );
//        NavigationUI.setupActionBarWithNavController( this, navController, mAppBarConfiguration );
//        NavigationUI.setupWithNavController( navigationView, navController );
    }

    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController( this, R.id.nav_host_fragment_content_side_navigation );
        return NavigationUI.navigateUp( navController, mAppBarConfiguration )
                || super.onSupportNavigateUp();
    }


    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
               switch (item.getItemId()) {
            case R.id.nav_home:

                HomeFragment home = new HomeFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, home );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();
                break;

                   case R.id.My_Orders:

                My_Orders gallery = new My_Orders();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, gallery );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();
                break;

            case R.id.nav_slideshow:
                My_AccountFragment slideshow = new My_AccountFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace( R.id.nav_host_fragment_content_side_navigation, slideshow );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();
                break;

         case R.id.Privacy:
             Intent intent=new Intent(getApplication(),Private_PolicyActivity.class);
             startActivity( intent );
             break;

         case R.id.Terms:

             Intent intent1=new Intent(getApplication(),Terms_ConditionsActivity.class);
             startActivity( intent1 );
             break;


        }


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.side_navigation, menu);
        return true;
    }


}