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

public class UserSocialsFragment extends Fragment implements OnClickListener {
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UserSocialsFragment newInstance() {
    	UserSocialsFragment fragment = new UserSocialsFragment();
        return fragment;
    }

    public UserSocialsFragment() {
    }

    
    ImageButton facebookButton;
    ImageButton twitterButton;
    ImageButton googlePlusButton;
    ImageButton instagramButton;
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usersocials, container, false);
        

        facebookButton = (ImageButton) rootView.findViewById(R.id.facebookButton);
        twitterButton = (ImageButton) rootView.findViewById(R.id.twitterButton);
        googlePlusButton = (ImageButton) rootView.findViewById(R.id.googlePlusButton);
        instagramButton = (ImageButton) rootView.findViewById(R.id.instagramButton);
        
        facebookButton.setOnClickListener(this);
        twitterButton.setOnClickListener(this);
        googlePlusButton.setOnClickListener(this);
        instagramButton.setOnClickListener(this);
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

	@Override
	public void onClick(View v) {

		Intent launchIntent = null;
		switch(v.getId()){
		case R.id.facebookButton:
			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
		    startActivity(launchIntent);
			break;
		case R.id.twitterButton:
			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.twitter.android");
		    startActivity(launchIntent);
			break;
		case R.id.googlePlusButton:
			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.plus");
		    startActivity(launchIntent);
			break;
		case R.id.instagramButton:
			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.instagram.android");
		    startActivity(launchIntent);
			break;
			
			
		}
	}
    
    
}
