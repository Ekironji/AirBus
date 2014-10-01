
package com.aidilab.airbus.fragment;

import java.util.ArrayList;
import java.util.Arrays;
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
import android.widget.GridView;
import android.widget.ListView;

import com.aidilab.airbus.R;
import com.aidilab.airbus.gridview.GridObject;
import com.aidilab.airbus.gridview.GridViewCustomAdapter;

public class ShoppingFragment extends Fragment {

	final String DEBUG = "Shopping Fragment";
	View rootView;
	GridView itemsGridView;
	ArrayList<String> categories;
	HashMap<String, ArrayList<GridObject>> globalMap;
	
    public static ShoppingFragment newInstance() {
    	ShoppingFragment fragment = new ShoppingFragment();
        return fragment;
    }

    public ShoppingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shopping, container, false);
        
        ListView categoryListview = (ListView) rootView.findViewById(R.id.categoriesListview);
        itemsGridView = (GridView) rootView.findViewById(R.id.gridViewCustom);
        
        categories = new ArrayList<String>();
        categories.add("Perfumes");
        categories.add("Watches");
        categories.add("Bags");
        
        globalMap = new HashMap<String, ArrayList<GridObject>>();
        globalMap.put("Perfumes", new ArrayList<GridObject>(Arrays.asList(new GridObject("CK One", "€ 60", R.drawable.ckone),
        		new GridObject("Egoiste", "€ 80", R.drawable.egoist),
        		new GridObject("Light Blue", "€ 75", R.drawable.dglblue),
        		new GridObject("Only The Brave", "€ 70", R.drawable.onlybrave))));
        
        globalMap.put("Watches", new ArrayList<GridObject>(Arrays.asList(new GridObject("Swatch", "€ 40", R.drawable.swatch),
        		new GridObject("Chronotech", "€ 70", R.drawable.chronotech),
        		new GridObject("Moto 360", "€ 249", R.drawable.moto360))));
        
        globalMap.put("Bags", new ArrayList<GridObject>(Arrays.asList(new GridObject("Gucci", "€ 350", R.drawable.gucci_bag),
        		new GridObject("Alviero Martini", "€ 290", R.drawable.alviero_martini),
        		new GridObject("Liu Jo", "€ 249", R.drawable.luijo))));
        
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
        
        itemsGridView.setAdapter(new GridViewCustomAdapter(rootView.getContext(), globalMap.get("Perfumes")));
        
        return rootView;
    }
    
    private void updateGridView(String category){

        itemsGridView.setAdapter(new GridViewCustomAdapter(rootView.getContext(), globalMap.get(category)));
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
