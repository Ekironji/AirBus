package com.aidilab.airbus.gridview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aidilab.airbus.R;

public class GridViewCustomAdapter extends ArrayAdapter<GridObject> {
    Context context;
    ArrayList<GridObject> objects;
    
     public GridViewCustomAdapter(Context context, ArrayList<GridObject> objects) {
             super(context, 0);
             this.context=context;
             this.objects=objects;
             
     }
    
     public int getCount() {
             return objects.size();
     }

     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
            
    	 	View view = null;
             
            if (convertView == null) {
                 LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                 view = inflater.inflate(R.layout.grid_item, parent, false);
   
             } else {
            	 view = convertView;
             }

            TextView textViewTitle = (TextView) view.findViewById(R.id.title);
            textViewTitle.setText(objects.get(position).getTitle());
            TextView textViewDescr = (TextView) view.findViewById(R.id.descr);
            textViewDescr.setText(objects.get(position).getDescription());
            ImageView imageViewItem = (ImageView) view.findViewById(R.id.image);
            imageViewItem.setImageResource(objects.get(position).getImageResource());
            
      
      return view;

     }

}