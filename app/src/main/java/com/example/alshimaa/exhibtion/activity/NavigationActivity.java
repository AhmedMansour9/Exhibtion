package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.fragment.AboutUsFragment;
import com.example.alshimaa.exhibtion.fragment.CallUsFragment;
import com.example.alshimaa.exhibtion.fragment.CurrentExhibitionFragment;
import com.example.alshimaa.exhibtion.fragment.ExhibtionOwnerFragment;
import com.example.alshimaa.exhibtion.fragment.HomeContactUsFragment;
import com.example.alshimaa.exhibtion.fragment.HomeFragment;
import com.example.alshimaa.exhibtion.fragment.NavItemServiceProviderFragment;
import com.example.alshimaa.exhibtion.fragment.NewsFragment;
import com.example.alshimaa.exhibtion.fragment.PreviousExhibitionFragment;
import com.example.alshimaa.exhibtion.fragment.ServiceProviderFragment;
import com.example.alshimaa.exhibtion.fragment.SettingsFragment;
import com.example.alshimaa.exhibtion.model.HomeSiteOptionData;
import com.example.alshimaa.exhibtion.presenter.AboutUsPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeSiteOptionPresenter;
import com.example.alshimaa.exhibtion.view.HomeSiteOptionView;

import java.util.List;
import java.util.Locale;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,HomeSiteOptionView {
    Fragment fragment;
    private int currentSelectedPosition=0;
    NavigationView navigationView;
    public static Toolbar toolbar;
    public static ActionBarDrawerToggle toggle;
    public  static DrawerLayout drawer;

    Button exhibtionOwnerBtn;
    View header;

    Button serviceProviderBtn;

    /*ImageView imageView;
    TextView titleTxt,emailTxt;
    HomeSiteOptionPresenter homeSiteOptionPresenter;*/
    NetworkConnection networkConnection;

    SharedPreferences shared;
    String Lan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        networkConnection=new NetworkConnection(this);

        shared=getSharedPreferences("Language",MODE_PRIVATE);
        Lan=shared.getString("Lann",null);


        navigationView=findViewById( R.id.nav_view );
        onNavigationItemSelected( navigationView.getMenu().getItem( 0 ) );

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        exhibtionOwnerBtn=header.findViewById( R.id.nav_header_btn_exhibtion_owner );
        exhibtionOwnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExhibtionOwnerPage();
            }
        });

       /* header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        imageView=header.findViewById(R.id.nav_header_image);
        titleTxt=header.findViewById(R.id.nav_header_text_name);
        emailTxt=header.findViewById(R.id.nav_header_text_email);*/
        serviceProviderBtn=header.findViewById( R.id.nav_header_btn_service_provider );
        serviceProviderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToServiceProviderPage();
            }
        });

        if(Lan!=null) {
            Locale locale = new Locale(Lan);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }

       /* HomeSiteOption();*/

    }

  /*  private void HomeSiteOption() {
        homeSiteOptionPresenter=new HomeSiteOptionPresenter(this,this);
        homeSiteOptionPresenter.getHomeSiteOptionResult();
    }*/




    private void goToServiceProviderPage() {
        drawer.closeDrawer(GravityCompat.START);
        FragmentManager fragmentManager=  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.content_navigation,new ServiceProviderFragment() ).addToBackStack( null )
                .commit();
    }

    private void goToExhibtionOwnerPage() {
        drawer.closeDrawer(GravityCompat.START);
        FragmentManager fragmentManager=  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.content_navigation,new ExhibtionOwnerFragment() ).addToBackStack( null )
                .commit();
        /*Intent intent=new Intent(NavigationActivity.this,VisitorActivity.class);
        startActivity(intent);*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        switch (item.getItemId()){
           case  R.id.nav_Home:
                currentSelectedPosition=0;
                fragment=new HomeFragment();
                break;

            case  R.id.nav_CurrentExhibitions:
                currentSelectedPosition=1;
                fragment=new CurrentExhibitionFragment();
                break;

            case  R.id.nav_PreviousExhibitions:
                currentSelectedPosition=2;
                fragment=new PreviousExhibitionFragment();
                break;
           /* case R.id.nav_news:
                currentSelectedPosition=3;
                fragment=new NewsFragment();
                break;*/
            case R.id.nav_service_provider:
                currentSelectedPosition=4;
                fragment=new NavItemServiceProviderFragment();
                break;
            case R.id.nav_about_us:
                currentSelectedPosition=5;
                fragment=new AboutUsFragment();
                break;
        case R.id.nav_contact_us:
                currentSelectedPosition=6;
                fragment=new CallUsFragment();
                break;

            case R.id.nav_change_language:
                currentSelectedPosition=7;
                startActivity(new Intent(this, ChangeLanguageActivity.class));

                break;
           /* case R.id.nav_exhibtion_owner:
                currentSelectedPosition=5;
                fragment=new ExhibtionOwnerFragment();
                break;*/
           /* case R.id.nav_settings:
                currentSelectedPosition=5;
                fragment=new SettingsFragment();
                break;*/

            default:
                currentSelectedPosition=0;
                break;
        }

        if (item.isChecked())
        {
            item.setChecked( false );
        }else
        {
            item.setChecked( true );
        }
        FragmentManager fragmentManager=  getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.content_navigation,fragment ).addToBackStack( null )
                .commit();
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
        /*int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
*/

    }

   /* @Override
    public void showHomeSiteOptionResult(List<HomeSiteOptionData> homeSiteOptionDataList) {
        Glide.with(this).load("http://eelectronicexpo.com"+homeSiteOptionDataList.get(0).getLogo())
                .into(imageView);
        titleTxt.setText(homeSiteOptionDataList.get(0).getTilte());
        emailTxt.setText(homeSiteOptionDataList.get(0).getEmail());
    }

    @Override
    public void showError() {

    }*/
}
