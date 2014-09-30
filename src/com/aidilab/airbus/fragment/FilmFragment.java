package com.aidilab.airbus.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.aidilab.airbus.R;

public class FilmFragment extends Fragment implements OnClickListener{
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FilmFragment newInstance() {
    	FilmFragment fragment = new FilmFragment();
        return fragment;
    }

    public FilmFragment() {
    }

    
    private ListView titleListview = null;
    View rootView;
    ImageView previewImage = null;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_film, container, false);
        
        final ListView categoryListview = (ListView) rootView.findViewById(R.id.categoriesListview);
        titleListview    = (ListView) rootView.findViewById(R.id.titleListview);
        previewImage     = (ImageView) rootView.findViewById(R.id.previewView);
        
        
        String[] values = new String[] { "Action", "Cartoon", "Commedy", "Series", "Thriller"};
         
        String[] action    = new String[] {"Superman Returns", "Indiana Jones"};
        String[] cartoon   = new String[] {"Aladdin", "The Lion King"};
        String[] commedy   = new String[] {"The Hangover"};
        String[] series    = new String[] {};
        String[] thriller  = new String[] {};
        
        final int[] copertine = {R.drawable.movie1,
        		R.drawable.movie2,
        		R.drawable.movie3,
        		R.drawable.movie4,
        		R.drawable.movie5 };
        
        final ArrayList<String[]> titoli = new ArrayList<String[]>();
        titoli.add(action);
        titoli.add(cartoon);
        titoli.add(commedy);
        titoli.add(series);
        titoli.add(thriller);
        
        if (rootView != null) {
            ImageButton mButton = (ImageButton) rootView.findViewById(R.id.playButton);
            Log.d("", "View is not null");

            if (mButton != null) {
            	mButton.setOnClickListener(this);
                Log.d("", "mButton is not null");
            }
        }
        
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
        	list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(rootView.getContext(),
            android.R.layout.simple_list_item_1, list);
        categoryListview.setAdapter(adapter);
        
        categoryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
              final String item = (String) parent.getItemAtPosition(position);
              updateTitleList(titoli.get(position));
            }

          });
        
        titleListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
              final String item = (String) parent.getItemAtPosition(position);
              previewImage.setImageResource(copertine[position]);
            }

          });
        
        return rootView;
    }

    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    
    
    
    private void updateTitleList(String[] values){
    	final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
        	list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(rootView.getContext(),
            android.R.layout.simple_list_item_1, list);
        titleListview.setAdapter(adapter);
    }
    
    
    private class StableArrayAdapter extends ArrayAdapter<String> {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
            List<String> objects) {
        	super(context, textViewResourceId, objects);
        	for (int i = 0; i < objects.size(); ++i) {
        		mIdMap.put(objects.get(i), i);
        	}
        }

        @Override
        public long getItemId(int position) {
          String item = getItem(position);
          return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
          return true;
        }
    }


	@Override
	public void onClick(View v) {
		Log.i("filmFragment","onClick");
		if(v.getId() == (R.id.playButton)){
			//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movieurl));
			String uri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.aladdin;
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			getActivity().startActivity(intent);
		}
	}
      
}
