package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentExhibitionFragment extends Fragment implements CurrentExhibtionView
,DetailsExhibtionView {

    Toolbar toolbar;
    NetworkConnection networkConnection;



    RecyclerView recyclerViewCurrentExhibtion;
    CurrentExhibtionAdapter currentExhibtionAdapter;
    CurrentExhibtionPresenter currentExhibtionPresenter;

    EditText searchCurrentExhibtionEtext;
    ImageView iconSearch;
    public CurrentExhibitionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_current_exhibition, container, false);

        init();


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
        networkConnection=new NetworkConnection( getContext() );


        CurrentExhibtion();
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return view;
    }

    private void performSearch() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            currentExhibtionPresenter = new CurrentExhibtionPresenter(getContext(), this);
            if( TextUtils.isEmpty(searchCurrentExhibtionEtext.getText())){
                /**
                 *   You can Toast a message here that the Username is Empty
                 **/

                searchCurrentExhibtionEtext.setError(getResources().getString(R.string.Key_search_is_required) );

            } else {
                        if (Language.isRTL()) {
                            currentExhibtionPresenter.getSearchCurrentExhibtionResult("ar", searchCurrentExhibtionEtext.getText().toString());
                        } else {
                            currentExhibtionPresenter.getSearchCurrentExhibtionResult("en", searchCurrentExhibtionEtext.getText().toString());
                        }
                }

        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }

    }

    private void CurrentExhibtion() {
        currentExhibtionPresenter=new CurrentExhibtionPresenter(getContext(),this);
        if (Language.isRTL()) {
            currentExhibtionPresenter.getCurrentExhibtionResult("ar");
        }else
        {
            currentExhibtionPresenter.getCurrentExhibtionResult("en");
        }

    }

    private void init() {
        toolbar=view.findViewById(R.id.current_exhibtion_toolbar);
        recyclerViewCurrentExhibtion=view.findViewById(R.id.current_exhibtion_recycler);
        searchCurrentExhibtionEtext=view.findViewById(R.id.current_exhibtion_edit_text_search);
        iconSearch=view.findViewById(R.id.current_exhibtion_icon_search);
    }

    @Override
    public void showCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        recyclerViewCurrentExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSearchCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        recyclerViewCurrentExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }

    @Override
    public void showErrorSearch(String Msg) {
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showExhibtionDetails(CurrentExhibtionData currentExhibtionData) {

            DetailsExhibtionFragment detailsExhibtionFragment=new DetailsExhibtionFragment();
            Bundle bundle=new Bundle(  );
            bundle.putString( "video_link",currentExhibtionData.getYoutube());
            bundle.putString("title",currentExhibtionData.getTitle());
            bundle.putString("description",currentExhibtionData.getDescription());
            bundle.putString("address",currentExhibtionData.getAddress());
            bundle.putString("id",String.valueOf(currentExhibtionData.getId()));
            bundle.putString("user_id",currentExhibtionData.getIdUser());
            bundle.putString("logo",currentExhibtionData.getLogo());
            bundle.putString("visibilty","yes");

            detailsExhibtionFragment.setArguments(bundle);

            getFragmentManager().beginTransaction().add( R.id.content_navigation,
                    detailsExhibtionFragment )
                    .addToBackStack( null ).commit();



    }
}
