package com.aidilab.airbus.fragment.shopping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.aidilab.airbus.R;

/**
 * A list fragment representing a list of Products. This fragment also supports
 * tablet devices by allowing list items to be given an 'activated' state upon
 * selection. This helps indicate which item is currently being viewed in a
 * {@link ProductDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ProductListFragment extends Fragment {

	ArrayList<String> listDataHeader = null;
	HashMap<String, List<String>> listDataChild = null;

	public ProductListFragment() {
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate the layout that contains the ExpandableListView
        View view =  inflater.inflate(R.layout.fragment_shopping_list, container, false);

        // get a reference to ExpandableListView
        ExpandableListView list = (ExpandableListView)view.findViewById(R.id.exp_list_view);
        
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        
        listDataHeader.add("Perfumes");
        listDataHeader.add("Watches");
        listDataHeader.add("Bags");
        
        listDataChild.put("Perfumes", Arrays.asList("CK One", "Egoiste", "Light Blue", "Only the Brave"));
        listDataChild.put("Watches", Arrays.asList("Swatch", "Chronotech", "Moto360"));
        listDataChild.put("Bags", Arrays.asList("Gucci", "Alviero Martini", "Liu Jo"));
        
        // set the adapter
        list.setAdapter(new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild));
        // set listeners
        list.setOnChildClickListener(new OnChildClickListener() {
        	 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
						
            	String categoria = listDataHeader.get(groupPosition);
            	String prodotto = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
            	
            	Fragment fragment = new ProductDetailFragment();
            	Bundle args = new Bundle();
	            args.putString("categoria", categoria);
	            args.putString("prodotto", prodotto);
	            fragment.setArguments(args);
            	
	            ShoppingFragment fr = (ShoppingFragment) getParentFragment();
	            fr.changeDetail(fragment);
	            
            	return false;         
            }
        });   
        
        Fragment fragment = new ProductDetailFragment();
    	Bundle args = new Bundle();
        args.putString("categoria", "Perfumes");
        args.putString("prodotto", "CK One");
        fragment.setArguments(args);
    	
        ShoppingFragment fr = (ShoppingFragment) getParentFragment();
        fr.changeDetail(fragment);

        return view;
    }
    
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

}
