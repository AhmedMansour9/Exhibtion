package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeSearchResultAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.SearchHomePresenter;
import com.example.alshimaa.exhibtion.view.SearchHomeView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSearchResultFragment extends Fragment implements SearchHomeView {

    NetworkConnection networkConnection;



    RecyclerView recyclerViewsearch;
    HomeSearchResultAdapter homeSearchResultAdapter;
   public static SearchHomePresenter searchHomePresenter;

   String Key;


    public HomeSearchResultFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home_search_result, container, false);
        init();
        networkConnection=new NetworkConnection( getContext() );
        searchHomePresenter = new SearchHomePresenter(getContext(), this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            Key = bundle.getString( "key" );

        }

        performSearch();
        return view;
    }

    private void performSearch() {
        if(networkConnection.isNetworkAvailable(getContext())) {

                    if (Language.isRTL()) {
                        searchHomePresenter.getSearchHomeExhibtionResult("ar", Key);
                    } else {
                        searchHomePresenter.getSearchHomeExhibtionResult("en", Key);
                    }

        }else
        {
            Toast.makeText(getContext(), "check Network Connection!", Toast.LENGTH_SHORT).show();
        }
    }


    private void init() {
        recyclerViewsearch=view.findViewById(R.id.home_search_result_recycler);

    }

    @Override
    public void showSearchHomeExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {
        homeSearchResultAdapter=new HomeSearchResultAdapter( getContext(),currentExhibtionDataList );
        //currentExhibtionAdapter.onClick(this);
        recyclerViewsearch.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewsearch.setAdapter( homeSearchResultAdapter );
    }

    @Override
    public void showErrorHomeSearch(String Msg) {
        Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();

    }
}
