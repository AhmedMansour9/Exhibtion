package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.model.AboutUsData;
import com.example.alshimaa.exhibtion.presenter.AboutUsPresenter;
import com.example.alshimaa.exhibtion.view.AboutUsView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment implements AboutUsView,SwipeRefreshLayout.OnRefreshListener{
    ImageView imageView;
    TextView description;
    AboutUsPresenter aboutUsPresenter;
    NetworkConnection networkConnection;

    SwipeRefreshLayout swipeRefreshLayout;
    public AboutUsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_about_us, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        swipeRefresh();
        AboutUs();


        return view;
    }

    private void swipeRefresh() {
        swipeRefreshLayout.setColorSchemeResources( android.R.color.holo_blue_dark );
        swipeRefreshLayout.setEnabled( true );
        swipeRefreshLayout.setOnRefreshListener( this );
        swipeRefreshLayout.post( new Runnable() {
            @Override
            public void run() {
                if(networkConnection.isNetworkAvailable( getContext() ))
                {
                    if (Language.isRTL()) {
                        aboutUsPresenter.getAboutUsResult("ar");
                    }else
                    {
                        aboutUsPresenter.getAboutUsResult("en");
                    }
                }else
                {
                    Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }

    private void AboutUs() {
        aboutUsPresenter=new AboutUsPresenter(getContext(),this);
        if (Language.isRTL()) {
            aboutUsPresenter.getAboutUsResult("ar");
        }else
        {
            aboutUsPresenter.getAboutUsResult("en");
        }
    }

    private void init() {
            imageView=view.findViewById(R.id.about_us_img);
            description=view.findViewById(R.id.about_us_description);
            swipeRefreshLayout=view.findViewById(R.id.about_us_swip_refresh);


    }

    @Override
    public void showAboutUsResult(List<AboutUsData> aboutUsDataList) {
        Glide.with(getContext()).load("http://yallahshare.com"+aboutUsDataList.get(0).getImg())
                .into(imageView);
        description.setText(aboutUsDataList.get(0).getDescription());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if(networkConnection.isNetworkAvailable( getContext() ))
        {
            swipeRefreshLayout.setRefreshing( true );
            if (Language.isRTL()) {
                aboutUsPresenter.getAboutUsResult("ar");
            }else
            {
                aboutUsPresenter.getAboutUsResult("en");
            }
        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }

    }
}
