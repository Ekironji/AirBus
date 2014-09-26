package com.aidilab.airbus.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aidilab.airbus.R;

public class FilmFragment extends Fragment {
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

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_film, container, false);
        
        final ListView listview = (ListView) rootView.findViewById(R.id.categoriesListview);
        String[] values = new String[] { "Adventure", "Action", "Commedy", "Series", "Thriller"};
        
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
          list.add(values[i]);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(rootView.getContext(),
            android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
              final String item = (String) parent.getItemAtPosition(position);
              view.animate().setDuration(2000).alpha(0)
                  .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                      list.remove(item);
                      adapter.notifyDataSetChanged();
                      view.setAlpha(1);
                    }
                  });
            }

          });
        
        return rootView;
    }

    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
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
      
}
