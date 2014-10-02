package com.aidilab.airbus.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.aidilab.airbus.MainActivity;
import com.aidilab.airbus.R;
import com.aidilab.airbus.utils.Effect;

public class ComfortFragment extends Fragment implements OnClickListener{
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
	
	final String DEBUG = "Comfort Fragment";
	
	public static ComfortFragment newInstance() {
    	ComfortFragment fragment = new ComfortFragment();
        return fragment;
    }

    public ComfortFragment() {}
    
    int temp = 20;
    String degSymbol = "°";
    
    TextView tempTextView      	= null;
    TextView tempAttuale      	= null;
    ImageButton tempMinus      	= null;
    ImageButton tempPlus       	= null;
    ImageButton callAssistance 	= null;
    ImageButton lightOFF		= null;
    ImageButton lightON			= null;
    TextView autoBrightnessTV	= null;
    boolean autoBrightness 		= false;
    int lastBrightness			= 0;
    SeekBar lightIntensity     	= null; 
    GradientDrawable gd 		= null;
    
	private AdkReadTempTask mAdkReadTempTask;
	Effect assistanceEffect;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comfort, container, false);
        
        tempTextView = (TextView) rootView.findViewById(R.id.tempTextview);
        tempAttuale = (TextView) rootView.findViewById(R.id.textViewTemp);
        tempMinus = (ImageButton) rootView.findViewById(R.id.temMinus);
        tempPlus = (ImageButton) rootView.findViewById(R.id.tempPlus);
        lightOFF = (ImageButton) rootView.findViewById(R.id.lightOFFbutton);
        lightON = (ImageButton) rootView.findViewById(R.id.lightONbutton);
        autoBrightnessTV = (TextView) rootView.findViewById(R.id.autoBrightnessTextView);
        callAssistance  = (ImageButton) rootView.findViewById(R.id.assistanceButton);
        lightIntensity = (SeekBar) rootView.findViewById(R.id.seekBarLight);
        lightIntensity.setIndeterminate(false);
        lightIntensity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {		
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				Log.i(DEBUG, "progress: " + progress);
				MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)progress});
			}
		});
        
        tempMinus.setOnClickListener(this);
        tempPlus.setOnClickListener(this);
        callAssistance.setOnClickListener(this);
        lightOFF.setOnClickListener(this);
        lightON.setOnClickListener(this);
        autoBrightnessTV.setOnClickListener(this);
        
        tempTextView.setText(temp + degSymbol);
        

        mAdkReadTempTask = new AdkReadTempTask();
		mAdkReadTempTask.execute();
               
		gd = new GradientDrawable();
        gd.setColor(getResources().getColor(android.R.color.white)); // Changes this drawbale to use a single color instead of a gradient
        gd.setCornerRadius(1);
        gd.setStroke(1, getResources().getColor(R.color.apptheme_color));
        autoBrightnessTV.setBackgroundDrawable(gd);
        
        assistanceEffect = new Effect(getActivity().getBaseContext(), R.raw.airplanebeep); 
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    
	@Override
	public void onPause() {
		super.onPause();	
		mAdkReadTempTask.pause();
		mAdkReadTempTask = null;

		assistanceEffect.release(); 
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.temMinus:
			temp--;
	        tempTextView.setText(temp + degSymbol);
			break;
		case R.id.tempPlus:
			temp++;
	        tempTextView.setText(temp + degSymbol);
			break;
		case R.id.assistanceButton:
			assistanceEffect.play();		 
			break;		
		case R.id.lightOFFbutton:
			lightIntensity.setProgress(0);
			MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)0});
			break;
		case R.id.lightONbutton:
			lightIntensity.setProgress(lightIntensity.getMax());
			MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)127});
			break;
		case R.id.autoBrightnessTextView:
			if(autoBrightness){
				autoBrightness = false;
				MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)-1});
				autoBrightnessTV.setBackgroundColor(getResources().getColor(android.R.color.white));
				autoBrightnessTV.setTextColor(getResources().getColor(R.color.apptheme_color));
				autoBrightnessTV.setBackgroundDrawable(gd);
				lightIntensity.setProgress(lastBrightness);
				MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)lastBrightness});
			} else {
				lastBrightness = lightIntensity.getProgress();
				lightIntensity.setProgress(0);
				autoBrightness = true;
				MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)-2});
				autoBrightnessTV.setBackgroundColor(getResources().getColor(R.color.apptheme_color));
				autoBrightnessTV.setTextColor(getResources().getColor(android.R.color.white));
				lightIntensity.setProgress(0);
			}
			break;
		}
		
	}
	
	ArrayList<Integer> tempMean = new ArrayList<Integer>();
	int WINDOW_SIZE = 55;
	
	/* 
	 * We put the readSerial() method in an AsyncTask to run the 
	 * continuous read task out of the UI main thread
	 */
	private class AdkReadTempTask extends AsyncTask<Void, String, Void> {

		private boolean running = true;
			
		public void pause(){
			running = false;
		}
		 
	    protected Void doInBackground(Void... params) {
//	    	Log.i("ADK demo bi", "start adkreadtask");
	    	while(running) {
	    		publishProgress(MainActivity.mAdkManager.readSerial()) ;
	     	}
	    	return null;
	    }

	    protected void onProgressUpdate(String... progress) {
	    	if(tempMean.size() > WINDOW_SIZE)
	    		tempMean.remove(0);
	    		
		    tempMean.add((int)progress[0].charAt(0));
	    	
	    	int meanSum = 0;
	    	for(int i=0; i<tempMean.size(); i++){
	    		meanSum += tempMean.get(i);
	    	}
	    	
	    	meanSum /= tempMean.size();
	    	
	    	tempAttuale.setText(meanSum + degSymbol);
	    }  
	}
}
