package com.aidilab.airbus.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.aidilab.airbus.R;

public class GamesFragment extends Fragment {
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static GamesFragment newInstance() {
    	GamesFragment fragment = new GamesFragment();
        return fragment;
    }

    public GamesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);
        
        ImageButton game1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
        game1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.halfbrick.fruitninjafree");
		        startActivity(LaunchIntent);
			}
		});
        ImageButton game2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        game2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.halfbrick.jetpackjoyride");
		        startActivity(LaunchIntent);
			}
		});
        ImageButton game3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
        game3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.rovio.angrybirds");
		        startActivity(LaunchIntent);
			}
		});
        ImageButton game4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        game4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.king.candycrushsaga");
		        startActivity(LaunchIntent);
			}
		});
        ImageButton game5 = (ImageButton) rootView.findViewById(R.id.imageButton5);
        game5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.creativemobile.DragRacing");
		        startActivity(LaunchIntent);
			}
		});
        ImageButton game6 = (ImageButton) rootView.findViewById(R.id.imageButton6);
        game6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.brainium.solitairefree");
		        startActivity(LaunchIntent);
			}
		});
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
