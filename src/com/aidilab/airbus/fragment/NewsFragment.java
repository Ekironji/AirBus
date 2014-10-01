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
import android.widget.ImageView;

import com.aidilab.airbus.R;

public class NewsFragment extends Fragment implements OnClickListener{
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsFragment newInstance() {
    	NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    public NewsFragment() {
    }

    private ImageButton mImageButton1 = null;
    private ImageButton mImageButton2 = null;
    private ImageButton mImageButton3 = null;
    private ImageButton mImageButton4 = null;
    private ImageButton mImageButton5 = null;
    private ImageButton mImageButton6 = null;
    private ImageButton mImageButton7 = null;
    
    private ImageView mImageView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
     
        mImageButton1 = (ImageButton) rootView.findViewById(R.id.imageButton1);
        mImageButton2 = (ImageButton) rootView.findViewById(R.id.imageButton2);
        mImageButton3 = (ImageButton) rootView.findViewById(R.id.imageButton3);
        mImageButton4 = (ImageButton) rootView.findViewById(R.id.imageButton4);
        mImageButton5 = (ImageButton) rootView.findViewById(R.id.imageButton5);
        mImageButton6 = (ImageButton) rootView.findViewById(R.id.imageButton6);
        mImageButton7 = (ImageButton) rootView.findViewById(R.id.imageButton7);
        
        mImageButton1.setOnClickListener(this);
        mImageButton2.setOnClickListener(this);
        mImageButton3.setOnClickListener(this);
        mImageButton4.setOnClickListener(this);
        mImageButton5.setOnClickListener(this);
        mImageButton6.setOnClickListener(this);
        mImageButton7.setOnClickListener(this);
        
        mImageView = (ImageView) rootView.findViewById(R.id.imageView1);     	
		mImageView.setBackgroundResource(R.drawable.cnn_news);
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

	@Override
	public void onClick(View v) {
		Intent LaunchIntent = null;
		switch(v.getId()){
		case R.id.imageButton1:
			LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("flipboard.app");
		    startActivity(LaunchIntent);
			break;
		case R.id.imageButton2:
			LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.magazines");
		    startActivity(LaunchIntent);
			break;
		case R.id.imageButton3:
			LaunchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.genie.geniewidget");
		    startActivity(LaunchIntent);
						break;
		case R.id.imageButton4:
			mImageView.setBackgroundResource(R.drawable.cnn_news);
			break;
		case R.id.imageButton5:
			mImageView.setBackgroundResource(R.drawable.eurosport_news);
			break;
		case R.id.imageButton6:
			mImageView.setBackgroundResource(R.drawable.ft_news);
			break;
		case R.id.imageButton7:
			mImageView.setBackgroundResource(R.drawable.bbc_news);
			break;
		default:
			break;
		}
		
		
	}
    


}
