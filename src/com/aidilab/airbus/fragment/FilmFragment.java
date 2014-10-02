package com.aidilab.airbus.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.aidilab.airbus.R;
import com.aidilab.airbus.gridview.GridObject;
import com.aidilab.airbus.gridview.GridViewCustomAdapter;

public class FilmFragment extends Fragment{

	final String DEBUG = "Film Fragment";
	View rootView;
	GridView itemsGridView;
	ArrayList<String> categories;
	HashMap<String, ArrayList<GridObject>> globalMap;
	
    public static FilmFragment newInstance() {
    	FilmFragment fragment = new FilmFragment();
        return fragment;
    }

    public FilmFragment() {
    }
   
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_film, container, false);
        
        ListView categoryListview = (ListView) rootView.findViewById(R.id.categoriesListviewFilm);
        itemsGridView = (GridView) rootView.findViewById(R.id.gridViewCustomFilm);
        
        categories = new ArrayList<String>();
        categories.add("Action");
        categories.add("Cartoon");
        categories.add("Commedy");
        
        globalMap = new HashMap<String, ArrayList<GridObject>>();
        globalMap.put("Action", new ArrayList<GridObject>(Arrays.asList(new GridObject("Superman Returns", "(2006) dir. Bryan Singer", R.drawable.superman),
        		new GridObject("Indiana Jones", "(1981) dir. Steven Spielberg", R.drawable.indianaj))));
        
        globalMap.put("Cartoon", new ArrayList<GridObject>(Arrays.asList(new GridObject("Aladdin", "(1992) dir. Ron Clements e John Musker", R.drawable.aladdin),
        		new GridObject("The Lion King", "(1994) dir. Rob Minkoff e Roger Allers", R.drawable.lionking))));
        
        globalMap.put("Commedy", new ArrayList<GridObject>(Arrays.asList(new GridObject("The Hangover", "(2009) dir. Todd Phillips", R.drawable.hangover))));

        categoryListview.setAdapter(new StableArrayAdapter(rootView.getContext(), 
        		R.layout.simple_list_view_layout, categories));
        
        categoryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                int position, long id) {
              final String item = (String) parent.getItemAtPosition(position);
//              Log.i(DEBUG, "item: " + item);
              updateGridView(item);
            }

        });
        
        itemsGridView.setAdapter(new GridViewCustomAdapter(rootView.getContext(), globalMap.get("Action")));
        
        itemsGridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
            	GridObject selected = (GridObject)itemsGridView.getAdapter().getItem(position);
                Log.i(DEBUG, "pos: " + position + " - name: " + selected.getTitle());
           		File moviePath = new File(Environment.getExternalStoragePublicDirectory(
                   Environment.DIRECTORY_MOVIES).getAbsolutePath()+ "/" + selected.getTitle().replace(" ", "").toLowerCase() + ".mp4");
	    	   	Log.i(DEBUG, "uri: " + moviePath.getAbsolutePath());
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setDataAndType(Uri.fromFile(moviePath), "video/mp4");
				startActivity(intent);
            }
           });
        
        return rootView;
    }    
    
    private void updateGridView(String category){
    	 itemsGridView.setAdapter(new GridViewCustomAdapter(rootView.getContext(), globalMap.get(category)));
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
