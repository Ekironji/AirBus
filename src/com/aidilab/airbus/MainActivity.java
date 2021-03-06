package com.aidilab.airbus;

import org.udoo.adktoolkit.AdkManager;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.aidilab.airbus.fragment.ComfortFragment;
import com.aidilab.airbus.fragment.FilmFragment;
import com.aidilab.airbus.fragment.GamesFragment;
import com.aidilab.airbus.fragment.MusicFragment;
import com.aidilab.airbus.fragment.NewsFragment;
import com.aidilab.airbus.fragment.FlightInfoFragment;
import com.aidilab.airbus.fragment.ShoppingFragment;
import com.aidilab.airbus.fragment.UserSocialsFragment;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
	public static AdkManager mAdkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        
        mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));
        
        registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());
    }
    
	@Override
	public void onResume() {
		super.onResume(); 
		mAdkManager.open();
	}
 
	@Override
	public void onPause() {
		super.onPause();
		mAdkManager.close();
	}
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mAdkManager.getUsbReceiver());
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments   	
    	//TODO: switch su position per inserire il giusto fragment
    	FragmentManager fragmentManager = getFragmentManager();
    	
    	switch(position){
	        
    	case 0:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new FilmFragment())
	                .commit();
	        break;
    	case 1:
    		fragmentManager.beginTransaction()
		            .replace(R.id.container, new MusicFragment())
		            .commit();
    		break;
    	case 2:
    		fragmentManager.beginTransaction()
		            .replace(R.id.container, new ComfortFragment())
		            .commit();
    		break;
    	case 3:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new GamesFragment())
	                .commit();
	        break;
    	case 4:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new FlightInfoFragment())
	                .commit();
	        break;
    	case 5:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new NewsFragment())
	                .commit();
	        break;
    	case 6:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new ShoppingFragment())
	                .commit();
	        break;
    	case 7:
	        fragmentManager.beginTransaction()
	                .replace(R.id.container, new UserSocialsFragment())
	                .commit();
	        break;
    	default:
    		break;
    		
    	}
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_film_section);
                break;
            case 2:
                mTitle = getString(R.string.title_music_section);
                break;
            case 3:
                mTitle = getString(R.string.title_comfort_section);
                break;
            case 4:
                mTitle = getString(R.string.title_games_section);
                break;
            case 5:
                mTitle = getString(R.string.title_flightinfo_section);
                break;
            case 6:
                mTitle = getString(R.string.title_news_section);
                break;
            case 7:
                mTitle = getString(R.string.title_shopping_section);
                break;
            case 8:
                mTitle = getString(R.string.title_usersocial_section);
                break;
            default:
            	mTitle = getString(R.string.app_name);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        actionBar.setIcon(R.drawable.logo_single);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
  

}
