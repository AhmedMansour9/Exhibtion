package com.example.alshimaa.exhibtion.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.activity.RegisterActivity;
import com.example.alshimaa.exhibtion.activity.RegisterInExhibtionActivity;
import com.example.alshimaa.exhibtion.activity.RegisterNowActivity;
import com.example.alshimaa.exhibtion.adapter.ExhibtorsAdapter;
import com.example.alshimaa.exhibtion.adapter.OrganizersAndServiceProvidersAdapter;
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.model.SponsorData;
import com.example.alshimaa.exhibtion.presenter.ExhibtorsPresenter;
import com.example.alshimaa.exhibtion.presenter.OrganizersAndServiceProvidersPresenter;
import com.example.alshimaa.exhibtion.view.DetailsExhibtorsView;
import com.example.alshimaa.exhibtion.view.ExhibtorsView;
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtionFragment extends Fragment implements
        YouTubePlayer.OnInitializedListener,OrganizersAndServiceProvidersView
        ,ExhibtorsView,DetailsExhibtorsView
{
    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
   public static String Link,Title,Description,Address,ID,UserId,Logo,Visiblity;
    TextView title,description,address;
    ImageView logo;

    RecyclerView recyclerViewOrganizers;
    OrganizersAndServiceProvidersAdapter organizersAndServiceProvidersAdapter;
    OrganizersAndServiceProvidersPresenter organizersAndServiceProvidersPresenter;

    RecyclerView recyclerViewSponsor;


    NetworkConnection networkConnection;

    TextView textToolbar;

    RecyclerView recyclerViewExhibtors;
    ExhibtorsAdapter exhibtorsAdapter;
    ExhibtorsPresenter exhibtorsPresenter;

   public static Button registerNowBtn;

    public static Button registerAsExhibtor;
    Intent intent;
    public DetailsExhibtionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_exhibtion, container, false);
        init();



           networkConnection=new NetworkConnection(getContext());
        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            Link = bundle.getString( "video_link" );
            Title=bundle.getString("title");
            Description=bundle.getString("description");
            Address=bundle.getString("address");
            ID=bundle.getString("id");
            UserId=bundle.getString("user_id");
            Logo=bundle.getString("logo");
            Visiblity=bundle.getString("visibilty");

            title.setText(Title);
            description.setText(Description);
            address.setText(Address);
          // Toast.makeText(getContext(), UserId, Toast.LENGTH_SHORT).show();
            textToolbar.setText(Title);
            Glide.with(getContext()).load("http://eelectronicexpo.com"+Logo).into(logo);

            if(Visiblity.equals("yes"))
            {
                registerNowBtn.setVisibility(View.VISIBLE);
                registerAsExhibtor.setVisibility(View.VISIBLE);
            }else
            {
                registerNowBtn.setVisibility(View.GONE);
                registerAsExhibtor.setVisibility(View.GONE);
            }

        }
        OrganizersAndServiceProviders();
        Sponsors();
        Exhibtors();
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View v) {

        //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();


        Intent i = new Intent(getActivity(), RegisterActivity.class);
        i.putExtra("registerFromCurExhib","yes");
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }
});
        registerAsExhibtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getActivity(), RegisterInExhibtionActivity.class);
                i.putExtra("registerFromCurExhib","yes");
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }



    private void Exhibtors() {
        exhibtorsPresenter=new ExhibtorsPresenter(getContext(),this);
        if(Language.isRTL()) {
            exhibtorsPresenter.getExhibtorsResult("ar", UserId); //id user
        }else {
            exhibtorsPresenter.getExhibtorsResult("en", UserId);
        }
    }

    private void Sponsors() {
        organizersAndServiceProvidersPresenter=new OrganizersAndServiceProvidersPresenter(getContext(),this);
        if(Language.isRTL()) {
            organizersAndServiceProvidersPresenter.getSponsorList("ar",ID);
        }else
        {
            organizersAndServiceProvidersPresenter.getSponsorList("en",ID);
        }
    }

    private void OrganizersAndServiceProviders() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            organizersAndServiceProvidersPresenter = new OrganizersAndServiceProvidersPresenter(getContext(), this);
            if (Language.isRTL()) {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("ar", ID);
            } else {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("en", ID);
            }
        }
    }

    private void init() {
        youTubePlayerSupportFragment = (YouTubePlayerSupportFragment)
                getChildFragmentManager()
                        .findFragmentById(R.id.youtube_player_support_fragment);
        title=view.findViewById(R.id.details_exhibtion_title);
        description=view.findViewById(R.id.details_exhibtion_description);
        address=view.findViewById(R.id.details_exhibtion_address);
        recyclerViewOrganizers=view.findViewById(R.id.details_exhibtion_recycler_organizers);

        recyclerViewSponsor=view.findViewById(R.id.details_exhibtion_recycler_sponsors);
        textToolbar=view.findViewById(R.id.details_exhibtion_text_toolbar);

        recyclerViewExhibtors=view.findViewById(R.id.details_exhibtion_recycler_exhibtors);
        logo=view.findViewById(R.id.details_exhibtion_logo);
        registerNowBtn=view.findViewById(R.id.details_exhibtion_btn_register);
        registerAsExhibtor=view.findViewById(R.id.details_exhibtion_btn_exhibtor);


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
            // String Url=Link.substring( Link.lastIndexOf( "=")+1  );
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
                .getSupportFragmentManager(). findFragmentById(R.id.youtube_player_support_fragment);
    }

    @Override
    public void showOrganizersAndServiceProvidersList(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList) {

        organizersAndServiceProvidersAdapter=new OrganizersAndServiceProvidersAdapter( getContext(),organizersAndServiceProvidersDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewOrganizers.setLayoutManager(linearLayoutManager);
        recyclerViewOrganizers.setAdapter( organizersAndServiceProvidersAdapter );
    }

    @Override
    public void showSponsorData(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList) {
        organizersAndServiceProvidersAdapter=new OrganizersAndServiceProvidersAdapter( getContext(),organizersAndServiceProvidersDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSponsor.setLayoutManager(linearLayoutManager);
        recyclerViewSponsor.setAdapter( organizersAndServiceProvidersAdapter );
    }


    @Override
    public void showExhibtorsList(List<ExhibtorsData> exhibtorsDataList) {
        exhibtorsAdapter=new ExhibtorsAdapter(getContext(),exhibtorsDataList);
        exhibtorsAdapter.onClick(this);
        recyclerViewExhibtors.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewExhibtors.setAdapter(exhibtorsAdapter);

    }

    @Override
    public void showDetailsExhibtorsData(ExhibtorsData exhibtorsData) {
        DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
        Bundle bundle=new Bundle();
        bundle.putString("video_link_exhibtor",exhibtorsData.getYoutubeLink());
        bundle.putString("title_exhibtor",exhibtorsData.getName());
        bundle.putString("address_exhibtor",exhibtorsData.getAddress());
        bundle.putString("id_exhibtor",String.valueOf(exhibtorsData.getIdExhibitor()));
        bundle.putString("phone_exhibtor",exhibtorsData.getPhone());
        bundle.putString("email_exhibtor",exhibtorsData.getEmail());
        bundle.putString("website_link",exhibtorsData.getWebsiteLink());
        detailsExhibtorsFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add(R.id.content_navigation,detailsExhibtorsFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void showError() {

    }
}
