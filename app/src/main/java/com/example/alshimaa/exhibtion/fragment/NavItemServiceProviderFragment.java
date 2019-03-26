package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeUnderConstructAdapter;
import com.example.alshimaa.exhibtion.adapter.NavItemServiceProvAdapter;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeNewsPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeUnderConstructPresenter;
import com.example.alshimaa.exhibtion.presenter.NavItemServiceProviderPresenter;
import com.example.alshimaa.exhibtion.view.NavItemServiceProvView;
import com.example.alshimaa.exhibtion.view.OnClickNavItemServiceProvView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavItemServiceProviderFragment extends Fragment implements NavItemServiceProvView
,SwipeRefreshLayout.OnRefreshListener
,OnClickNavItemServiceProvView{
    Toolbar toolbar;
    NetworkConnection networkConnection;

    RecyclerView recyclerViewProvider;
    NavItemServiceProvAdapter navItemServiceProvAdapter;
    NavItemServiceProviderPresenter navItemServiceProviderPresenter;

    ImageView iconSearch;
    EditText searchServiceProvEtext;

    SwipeRefreshLayout swipeRefreshLayout;
    public NavItemServiceProviderFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_nav_item_service, container, false);
         init();
        swipRefresh();
        networkConnection=new NetworkConnection( getContext() );

        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);



        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();

        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav  );

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();
        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
       serviceProvider();
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
        return view;
    }

    private void swipRefresh() {
        swipeRefreshLayout.setColorSchemeResources( android.R.color.holo_blue_dark );
        swipeRefreshLayout.setEnabled( true );
        swipeRefreshLayout.setOnRefreshListener( this );
        swipeRefreshLayout.post( new Runnable() {
            @Override
            public void run() {
                if(networkConnection.isNetworkAvailable( getContext() ))
                {
                    swipeRefreshLayout.setRefreshing( true );
                    if (Language.isRTL())
                    {
                        navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");
                    }else
                    {
                        navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");
                    }



                }else
                {
                    Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }

    private void performSearch() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            navItemServiceProviderPresenter = new NavItemServiceProviderPresenter(getContext(), this);
            if( TextUtils.isEmpty(searchServiceProvEtext.getText())){
                /**
                 *   You can Toast a message here that the Username is Empty
                 **/

                searchServiceProvEtext.setError(getResources().getString(R.string.Key_search_is_required) );

            } else {
                if (Language.isRTL()) {
                    navItemServiceProviderPresenter.getSearchNavItemServiceProvResult("ar", searchServiceProvEtext.getText().toString());
                } else {
                    navItemServiceProviderPresenter.getSearchNavItemServiceProvResult("en", searchServiceProvEtext.getText().toString());
                }
            }

        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }
    }

    private void serviceProvider() {
        navItemServiceProviderPresenter=new NavItemServiceProviderPresenter(getContext(),this);
        if (Language.isRTL())
        {
            navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");
        }else
        {
            navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");
        }
    }

    private void init() {

        toolbar=view.findViewById(R.id.nav_item_service_provider_toolbar);
        recyclerViewProvider=view.findViewById(R.id.nav_item_service_provider_recycler);
        iconSearch=view.findViewById(R.id.nav_item_service_provider_icon_search);
        searchServiceProvEtext=view.findViewById(R.id.nav_item_service_provider_edit_text_search);
        swipeRefreshLayout=view.findViewById(R.id.nav_item_service_prov_swip);

    }

    @Override
    public void showNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderDataList) {
        navItemServiceProvAdapter=new NavItemServiceProvAdapter( getContext(),navItemServiceProviderDataList );
        navItemServiceProvAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewProvider.setLayoutManager(linearLayoutManager);
        recyclerViewProvider.setAdapter( navItemServiceProvAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing( false );
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSearchNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderData) {
        navItemServiceProvAdapter=new NavItemServiceProvAdapter( getContext(),navItemServiceProviderData );
        navItemServiceProvAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerViewProvider.setLayoutManager(linearLayoutManager);
        recyclerViewProvider.setAdapter( navItemServiceProvAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showErrorSearch(String Msg) {
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void showOnClickNavItemServiceProvData(NavItemServiceProviderData navItemServiceProviderData) {
        DetailsNavItemServiceProviderFragment detailsNavItemServiceProviderFragment=new DetailsNavItemServiceProviderFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("ServiceProviderItem",navItemServiceProviderData);
        detailsNavItemServiceProviderFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,detailsNavItemServiceProviderFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onRefresh() {
        if(networkConnection.isNetworkAvailable( getContext() ))
        {
            swipeRefreshLayout.setRefreshing( true );
            navItemServiceProviderPresenter=new NavItemServiceProviderPresenter(getContext(),this);
            if (Language.isRTL())
            {
                navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");
            }else
            {
                navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");
            }


        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }


    }
}
