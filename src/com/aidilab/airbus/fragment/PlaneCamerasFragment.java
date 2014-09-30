package com.aidilab.airbus.fragment;

import java.io.IOException;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aidilab.airbus.R;

public class PlaneCamerasFragment extends Fragment implements TextureView.SurfaceTextureListener {
	
	final private String DEBUG = "AirBus PlaneCamera";
	private Camera mCamera;
    private Camera.CameraInfo info;
    private TextureView mTextureView;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaneCamerasFragment newInstance() {
    	PlaneCamerasFragment fragment = new PlaneCamerasFragment();
        return fragment;
    }

    public PlaneCamerasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_planecameras, container, false);
        
        mTextureView = (TextureView) rootView.findViewById(R.id.camera_texture);
        mTextureView.setSurfaceTextureListener(this);
        
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

	@Override
	public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
		Log.i(DEBUG, "onSurfaceTextureAvailable");
		info = new Camera.CameraInfo();
//		Log.i(DEBUG, "num_camera: "+Camera.getNumberOfCameras());
//		for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
//            Camera.getCameraInfo(i, info);
//            Log.i(DEBUG, "id: " + i + "info: " + info.facing);    
//        }
		
		try {
			mCamera = Camera.open(0);
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		
        if (null == mCamera) {
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "No camera", Toast.LENGTH_LONG);
            toast.show();
        }
        
        //make portrait
//        mCamera.setDisplayOrientation(90);
        
        try {
			/* Tell the camera to write onto our textureView mTextureView */
			mCamera.setPreviewTexture(surface);
			mCamera.startPreview();
			mCamera.autoFocus(null);
		} catch (IOException ioe) {
			Log.e(DEBUG, ioe.getMessage());
		}
	}

	@Override
	public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width,
			int height) {
		
	}

	@Override
	public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
		Log.i(DEBUG, "onSurfaceTextureDestroyed");
        if (null != mCamera) {
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
        return true;
	}

	@Override
	public void onSurfaceTextureUpdated(SurfaceTexture surface) {
		
	}
	
	public void onPause() {
        super.onPause();
		Log.i(DEBUG, "onPause");
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
        }
    }
}
