package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsCurrentExhibtionFragment extends Fragment /*implements YouTubePlayer.OnInitializedListener*/ {

    public static final int RECOVERY_DIALOG_REQUEST=1;


    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    String Link;
    public DetailsCurrentExhibtionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_current_exhibtion, container, false);
       /* youTubePlayerSupportFragment = (YouTubePlayerSupportFragment)
                getChildFragmentManager()
                        .findFragmentById(R.id.youtube_player_support_fragment);

        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {

            Link = bundle.getString( "video_link" );

        }*/
        return view;
    }

   /* @Override
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
    }*/
}
