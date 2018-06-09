package com.example.torch;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton tbutton;
	Camera cam;
	Parameters p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tbutton = (ToggleButton) findViewById(R.id.toggleButton1);
		tbutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (tbutton.isChecked()) {
					cam = Camera.open();
					p = cam.getParameters();
					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
					cam.setParameters(p);
					cam.startPreview();
					Toast.makeText(MainActivity.this, "FlashLight is on", Toast.LENGTH_LONG).show();
				} else {
					cam.stopPreview();
					cam.release();
//					status = false;
					Toast.makeText(MainActivity.this, "FlashLight is Off", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}


//import android.app.Activity;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.hardware.Camera;
//import android.hardware.Camera.Parameters;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//
//public class MainActivity extends Activity {
//
//	// flag to detect flash is on or off
//	private boolean isLighOn = false;
//
//	private Camera camera;
//
//	private Button button;
//
//	@Override
//	protected void onStop() {
//		super.onStop();
//
//		if (camera != null) {
//			camera.release();
//		}
//	}
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//
//		button = (Button) findViewById(R.id.toggleButton1);
//
//		Context context = this;
//		PackageManager pm = context.getPackageManager();
//
//		// if device support camera?
//		if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
//			Log.e("err", "Device has no camera!");
//			return;
//		}
//
//		camera = Camera.open();
//		final Parameters p = camera.getParameters();
//
//		button.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//
//				if (isLighOn) {
//					Log.i("info", "torch is turn off!");
//					p.setFlashMode(Parameters.FLASH_MODE_OFF);
//					camera.setParameters(p);
//					camera.stopPreview();
//					isLighOn = false;
//
//				} else {
//					Log.i("info", "torch is turn on!");
//					p.setFlashMode(Parameters.FLASH_MODE_TORCH);
//					camera.setParameters(p);
//					camera.startPreview();
//					isLighOn = true;
//				}
//			}
//		});
//	}
//}
