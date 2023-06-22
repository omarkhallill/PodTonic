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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public class SelectingActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double backn = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear3;
	private ListView listview1;
	private Button continueButton;
	
	private Intent in = new Intent();
	private TimerTask backt;
	private Intent intent = new Intent();
	private SharedPreferences myPrefs;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.selecting);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear4 = findViewById(R.id.linear4);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		listview1 = findViewById(R.id.listview1);
		continueButton = findViewById(R.id.continueButton);
		myPrefs = getSharedPreferences("myPrefs", Activity.MODE_PRIVATE);
	}
	
	private void initializeLogic() {
		vscroll1.setVerticalScrollBarEnabled(false);
		
		
		
		
		
		
		
		
		
		
		
		// done
		vscroll1.setVerticalScrollBarEnabled(false);
		
		continueButton.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)5, 0xFF616161, Color.TRANSPARENT));
		
		
		
		String[] podcastCategories = {"English", "Arabic", "German", "Portugese", "Chiniese"};
		
		        // Get the reference to the continue button in the activity's onCreate() method
		Button continueButton = findViewById(R.id.continueButton);
		continueButton.setVisibility(View.GONE);
		
		listview1.setAdapter(new ArrayAdapter<String>(this, R.layout.custom_list_item_layout, podcastCategories) {
			    // Maintain a list of checked items
			    List<Boolean> checkedItems = new ArrayList<>(Collections.nCopies(podcastCategories.length, false));
			
			    @Override
			    public View getView(int position, View convertView, ViewGroup parent) {
				        // Inflate the custom item view
				        View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item_layout, parent, false);
				
				        // Find the TextView and CheckBox views
				        TextView tv = view.findViewById(R.id.text);
				        CheckBox checkBox = view.findViewById(R.id.checkbox);
				
				        // Set the text and checkbox values
				        tv.setText(getItem(position));
				        checkBox.setChecked(checkedItems.get(position));
				        checkBox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(android.R.color.darker_gray)));
				
				        // Set the click listener for the RelativeLayout
				        RelativeLayout layout = view.findViewById(R.id.layout);
				        layout.setOnClickListener(new OnClickListener() {
					            @Override
					            public void onClick(View v) {
						                // Toggle the state of the checkbox for the clicked item
						                checkedItems.set(position, !checkedItems.get(position));
						                checkBox.setChecked(checkedItems.get(position));
						
						                // Update the visibility of the continue button
						                if (checkedItems.contains(true)) {
							                    // Set the continue button to visible
							                    continueButton.setVisibility(View.VISIBLE);
							                } else {
							                    // Set the continue button to invisible
							                    continueButton.setVisibility(View.INVISIBLE);
							                }
						            }
					        });
				
				        // Set the click listener for the CheckBox
				        checkBox.setOnClickListener(new OnClickListener() {
					            @Override
					            public void onClick(View v) {
						                // Update the state of the checkbox for the clicked item
						                checkedItems.set(position, checkBox.isChecked());
						
						                // Update the visibility of the continue button
						                if (checkedItems.contains(true)) {
							                    // Set the continue button to visible
							                    continueButton.setVisibility(View.VISIBLE);
							                } else {
							                    // Set the continue button to invisible
							                    continueButton.setVisibility(View.INVISIBLE);
							                }
						            }
					        });
				
				        return view;
				    }
		});
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		continueButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				myPrefs.edit().putString("key1", "value1").commit();
				intent.setClass(getApplicationContext(), CategoriesActivity.class);
				startActivity(intent);
			}
		});
		if (myPrefs.getString("key1", "").equals("value1")) {
			intent.setClass(getApplicationContext(), CategoriesActivity.class);
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
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom_list_item_layout, null);
			}
			
			return _view;
		}
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
