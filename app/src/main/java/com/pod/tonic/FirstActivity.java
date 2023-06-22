package com.pod.tonic;

import android.animation.*;
import android.app.*;
import com.pod.tonic.R;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.shimmer.*;
import com.google.firebase.FirebaseApp;
import id.zelory.compressor.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class FirstActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String LoggedIn = "";
	private double backn = 0;
	
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private LinearLayout linear18;
	private LinearLayout linear2;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private Button button8;
	private LinearLayout linear16;
	private TextView textview1;
	private Button button10;
	private Button button11;
	private ImageView imageview2;
	private ImageView imageview3;
	
	private Intent in = new Intent();
	private SharedPreferences loginPrefs;
	private TimerTask backt;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.first);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll2 = findViewById(R.id.vscroll2);
		linear1 = findViewById(R.id.linear1);
		linear18 = findViewById(R.id.linear18);
		linear2 = findViewById(R.id.linear2);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		linear17 = findViewById(R.id.linear17);
		button8 = findViewById(R.id.button8);
		linear16 = findViewById(R.id.linear16);
		textview1 = findViewById(R.id.textview1);
		button10 = findViewById(R.id.button10);
		button11 = findViewById(R.id.button11);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		loginPrefs = getSharedPreferences("loginPrefs", Activity.MODE_PRIVATE);
		
		button8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), Main1Activity.class);
				startActivity(in);
				finish();
			}
		});
		
		button11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), MainActivity.class);
				startActivity(in);
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		
		button10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFF757575, Color.TRANSPARENT));
		button11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFF757575, Color.TRANSPARENT));
		vscroll2.setVerticalScrollBarEnabled(false);
		Window window = this.getWindow();window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.setNavigationBarColor(Color.parseColor("#101010"));
		BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
			
			    @Override
			    public void onReceive(Context arg0, Intent intent) {
				        String action = intent.getAction();
				        if (action.equals("finish_activity")) {
					            
					            
					            in.setClass(getApplicationContext(), MainactivActivity.class);
						startActivity(in);
					            
					            finish();
					            // DO WHATEVER YOU WANT.
					loginPrefs.edit().putString("skip", "skip").commit();
					        }
				        
				        
				        
				          if (action.equals("finish_activity1")) {
					            
					            
					            in.setClass(getApplicationContext(), SelectingActivity.class);
						startActivity(in);
					            
					            finish();
					            // DO WHATEVER YOU WANT.
					          loginPrefs.edit().putString("signup", "skip").commit();
					          }
				      
				    }
		};
		registerReceiver(broadcastReceiver, new IntentFilter("finish_activity"));
		
		registerReceiver(broadcastReceiver, new IntentFilter("finish_activity1"));
		if (loginPrefs.getString("login", "").equals("skip")) {
				intent.setClass(getApplicationContext(), MainactivActivity.class);
				startActivity(intent);
				finish();
		}
		if (loginPrefs.getString("signup", "").equals("skip")) {
				intent.setClass(getApplicationContext(), SelectingActivity.class);
				startActivity(intent);
				finish();
		}
	}
	
	@Override
	public void onBackPressed() {
		backn++;
		backt = new TimerTask() {
				@Override
				public void run() {
						runOnUiThread(new Runnable() {
								@Override
								public void run() {
										if (backn == 1) {
												backn = 0;
												SketchwareUtil.showMessage(getApplicationContext(), "Double press to exit");
										}
										else {
												if (backn > 1) {
														finishAffinity();
												}
										}
								}
						});
				}
		};
		_timer.schedule(backt, (int)(500));
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
