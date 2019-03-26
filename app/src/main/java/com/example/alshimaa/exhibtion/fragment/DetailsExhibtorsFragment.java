package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.adapter.EShopAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeUnderConstructAdapter;
import com.example.alshimaa.exhibtion.adapter.ServicesProvidedAdapter;
import com.example.alshimaa.exhibtion.model.EShopData;
import com.example.alshimaa.exhibtion.model.ServicesProvidedData;
import com.example.alshimaa.exhibtion.presenter.EShopPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeUnderConstructPresenter;
import com.example.alshimaa.exhibtion.presenter.ServicesProvidedPresenter;
import com.example.alshimaa.exhibtion.view.EShopView;
import com.example.alshimaa.exhibtion.view.ServicesProvidedView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtorsFragment extends Fragment implements YouTubePlayer.OnInitializedListener
    ,ServicesProvidedView,EShopView
{

    public static String Link,Title,Address,ID,Phone,Email,WebsiteLink;
    TextView title,address,phone,email,websiteLink;

    NetworkConnection networkConnection;

    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    TextView textToolbar;
    Button vacantJopsBtn;

    RecyclerView recyclerViewservicesProvided;
    ServicesProvidedAdapter servicesProvidedAdapter;
    ServicesProvidedPresenter servicesProvidedPresenter;

    RecyclerView recyclerViewEShop;
    EShopAdapter eShopAdapter;
    EShopPresenter eShopPresenter;
    Button contactUsBtn;
    public DetailsExhibtorsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_exhibtors, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            Link = bundle.getString( "video_link_exhibtor" );
            Title=bundle.getString("title_exhibtor");
            Address=bundle.getString("address_exhibtor");
            ID=bundle.getString("id_exhibtor");
            Phone=bundle.getString("phone_exhibtor");
            Email=bundle.getString("email_exhibtor");
            WebsiteLink=bundle.getString("website_link");

            title.setText(Title);
            address.setText(Address);
            phone.setText(Phone);
            email.setText(Email);
            websiteLink.setText(WebsiteLink);

            textToolbar.setText(Title);
            // Toast.makeText(getContext(), "id_user" +ID+"  fair"+DetailsExhibtionFragment.ID, Toast.LENGTH_SHORT).show();
        }
        vacantJopsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToJopsPage();
            }
        });
        ServicesProvided();
        EShop();

        contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCallUsPage();
            }
        });
        return view;
    }

    private void goToCallUsPage() {
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,new CallUsFragment())
                .addToBackStack(null).commit();
    }

    private void EShop() {
        eShopPresenter=new EShopPresenter(getContext(),this);
        if(Language.isRTL()) {
            eShopPresenter.getEShopResult("ar",DetailsExhibtionFragment.ID,ID);// user id ,fair id
        }else {
            eShopPresenter.getEShopResult("en",DetailsExhibtionFragment.ID,ID);
        }
    }

    private void ServicesProvided() {
        servicesProvidedPresenter=new ServicesProvidedPresenter(getContext(),this);
        if(Language.isRTL()) {
            servicesProvidedPresenter.getServicesProvidedResult("ar",DetailsExhibtionFragment.ID,ID);// user id ,fair id
        }else {
            servicesProvidedPresenter.getServicesProvidedResult("en",DetailsExhibtionFragment.ID,ID);
        }
    }

    private void goToJopsPage() {
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,new JopsFragment())
                .addToBackStack(null).commit();
    }

    private void init() {
        title=view.findViewById(R.id.details_exhibtors_title);
        address=view.findViewById(R.id.details_exhibtors_address);
        textToolbar=view.findViewById(R.id.details_exhibtors_text_toolbar);
        youTubePlayerSupportFragment = (YouTubePlayerSupportFragment)
                getChildFragmentManager()
                        .findFragmentById(R.id.details_exhibtors_youtube_player_support_fragment);
    phone=view.findViewById(R.id.details_exhibtors_text_phone);
    email=view.findViewById(R.id.details_exhibtors_text_email);
    websiteLink=view.findViewById(R.id.details_exhibtors_text_website);
    vacantJopsBtn=view.findViewById(R.id.details_exhibtors_btn_jops);
    recyclerViewservicesProvided=view.findViewById(R.id.details_exhibtors_recycler_services);
    recyclerViewEShop=view.findViewById(R.id.details_exhibtors_recycler_E_shop);
    contactUsBtn=view.findViewById(R.id.details_exhibtors_btn_contact_us);
    }
    @Override
    public void onStart() {
        super.onStart();
        getActivity(). getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
           //  String url=Link.substring( Link.lastIndexOf( "=")+1  );
            youTubePlayer.loadVideo(Link);


        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
        } else {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getYouTubePlayerProvider().initialize(YoutubeConfig.DEVELOPER_KEY, this);
    }
    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerSupportFragment)getActivity()
                .getSupportFragmentManager(). findFragmentById(R.id.details_exhibtors_youtube_player_support_fragment);
    }

    @Override
    public void showServicesProvidedList(List<ServicesProvidedData> servicesProvidedDataList) {
        servicesProvidedAdapter=new ServicesProvidedAdapter( getContext(),servicesProvidedDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewservicesProvided.setLayoutManager(linearLayoutManager);
        recyclerViewservicesProvided.setAdapter( servicesProvidedAdapter );
      //  swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showEshopDataList(List<EShopData> eShopDataList) {
        eShopAdapter=new EShopAdapter( getContext(),eShopDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewEShop.setLayoutManager(linearLayoutManager);
        recyclerViewEShop.setAdapter( eShopAdapter );

    }

    @Override
    public void showError() {

    }
}

