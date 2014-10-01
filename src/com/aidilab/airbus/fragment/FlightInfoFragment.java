package com.aidilab.airbus.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.aidilab.airbus.R;

public class FlightInfoFragment extends Fragment  {
	
	final private String DEBUG = "AirBus FlightInfo";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FlightInfoFragment newInstance() {
    	FlightInfoFragment fragment = new FlightInfoFragment();
        return fragment;
    }

    public FlightInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_flightinfo, container, false);
        
        VideoView video1 = (VideoView) rootView.findViewById(R.id.videoView1);        
        VideoView video2 = (VideoView) rootView.findViewById(R.id.videoView2);        
//        VideoView video3 = (VideoView) rootView.findViewById(R.id.videoView3);
        
        video1.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
                + R.raw.fly1);

        video1.setVideoURI(uri);
        video1.requestFocus();    
        video1.start();
        
        video2.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        Uri uri2 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
                + R.raw.fly3);

        video2.setVideoURI(uri2);
        video2.requestFocus();    
        video2.start();
//        
//        video3.setOnPreparedListener(new OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
//
//        Uri uri3 = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +
//                + R.raw.fly3);
//
//        video3.setVideoURI(uri2);
//        video3.requestFocus();    
//        video3.start();
//        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

}
