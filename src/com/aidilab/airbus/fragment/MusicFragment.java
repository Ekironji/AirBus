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

public class MusicFragment extends Fragment implements OnClickListener {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MusicFragment newInstance() {
    	MusicFragment fragment = new MusicFragment();
        return fragment;
    }

    public MusicFragment() {
    }

    ImageButton airbusmusicButton = null;
    ImageButton usbmusicButton = null;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_music, container, false);
        
        airbusmusicButton = (ImageButton) rootView.findViewById(R.id.airbusmusicButton);
        usbmusicButton = (ImageButton) rootView.findViewById(R.id.usbmusicButton);
        
        airbusmusicButton.setOnClickListener(this);
        usbmusicButton.setOnClickListener(this);
        
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
    	case R.id.airbusmusicButton:
			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.mxtech.videoplayer.ad");
		    startActivity(launchIntent);
    		break;
    	case R.id.usbmusicButton:

			launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.mxtech.videoplayer.ad");
		    startActivity(launchIntent);
    		break;
    		
    	}
    	
    }
}
