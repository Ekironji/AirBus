package com.aidilab.airbus.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.aidilab.airbus.MainActivity;
import com.aidilab.airbus.R;

public class ConfortFragment extends Fragment implements OnClickListener{
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ConfortFragment newInstance() {
    	ConfortFragment fragment = new ConfortFragment();
        return fragment;
    }

    public ConfortFragment() {}
    
    int temp = 20;
    String degSymbol = "�";
    
    TextView tempTextView      = null;
    Button tempMinus           = null;
    Button tempPlus            = null;
    ImageButton callAssistance = null;
    SeekBar lightIntensity     = null; 
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_confort, container, false);
        
        tempTextView = (TextView) rootView.findViewById(R.id.tempTextview);
        tempMinus = (Button) rootView.findViewById(R.id.temMinus);
        tempPlus = (Button) rootView.findViewById(R.id.tempPlus);
        callAssistance  = (ImageButton) rootView.findViewById(R.id.assistanceButton);
        lightIntensity = (SeekBar) rootView.findViewById(R.id.seekBar1);  
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
				MainActivity.mAdkManager.writeByteArray(new byte[]{(byte)progress});
			}
		});
        
        tempMinus.setOnClickListener(this);
        tempPlus.setOnClickListener(this);
        callAssistance.setOnClickListener(this);
        
        tempTextView.setText(temp + degSymbol);
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
			SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

			/** soundId for Later handling of sound pool **/
			int soundId = sp.load(getActivity().getBaseContext(), R.raw.airplanebeep, 1); 
			// in 2nd param u have to pass your desire ringtone

			sp.play(soundId, 1, 1, 1, 1, 1);		 
			break;			
		}
		
	}
}
