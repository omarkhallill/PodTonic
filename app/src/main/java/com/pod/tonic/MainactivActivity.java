package com.pod.tonic;

import android.animation.*;
import android.app.*;
import com.pod.tonic.R;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.facebook.shimmer.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.FirebaseApp;
import id.zelory.compressor.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import com.pod.tonic.FileUtil;


public class MainactivActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double backn = 0;
	
	private ViewPager viewpager1;
	private LinearLayout linear1;
	private BottomNavigationView bottomnavigation2;
	
	private FFragmentAdapter F;
	private SharedPreferences myPrefs;
	private TimerTask backt;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.mainactiv);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		viewpager1 = findViewById(R.id.viewpager1);
		linear1 = findViewById(R.id.linear1);
		bottomnavigation2 = findViewById(R.id.bottomnavigation2);
		F = new FFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
		myPrefs = getSharedPreferences("myPrefs", Activity.MODE_PRIVATE);
		
		viewpager1.addOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				bottomnavigation2.getMenu().getItem(_position).setChecked(true);
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		bottomnavigation2.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem item) {
				final int _itemId = item.getItemId();
				viewpager1.setCurrentItem((int)_itemId);
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		F.setTabCount(5);
		viewpager1.setAdapter(F);
		bottomnavigation2.getMenu().add(0, 0, 0, "Home").setIcon(R.drawable.home_2);
		bottomnavigation2.getMenu().add(0, 1, 0, "Library").setIcon(R.drawable.settings12_3);
		bottomnavigation2.getMenu().add(0, 2, 0, "Live").setIcon(R.drawable.group_2);
		bottomnavigation2.getMenu().add(0, 3, 0, "Chats").setIcon(R.drawable.chat);
		bottomnavigation2.getMenu().add(0, 4, 0, "Settings").setIcon(R.drawable.settings12_2);
		bottomnavigation2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)50, 0xFF37474F, 0xFF37474F));
		
		    
		
		    // Disable swiping by finger in the ViewPager
		    viewpager1.setOnTouchListener(new OnTouchListener() {
			        @Override
			        public boolean onTouch(View v, MotionEvent event) {
				            return true;
				        }
			    });
		
	}
	
	public class FFragmentAdapter extends FragmentStatePagerAdapter {
		// This class is deprecated, you should migrate to ViewPager2:
		// https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2
		Context context;
		int tabCount;
		
		public FFragmentAdapter(Context context, FragmentManager manager) {
			super(manager);
			this.context = context;
		}
		
		public void setTabCount(int tabCount) {
			this.tabCount = tabCount;
		}
		
		@Override
		public int getCount() {
			return tabCount;
		}
		
		@Override
		public CharSequence getPageTitle(int _position) {
			
			return null;
		}
		
		@Override
		public Fragment getItem(int _position) {
			if (_position == 0) {
				return new MainfragFragmentActivity();
			}
			if (_position == 1) {
				return new LibraryfragFragmentActivity();
			}
			if (_position == 2) {
				return new LiveFragmentActivity();
			}
			if (_position == 3) {
				return new ChatFragmentActivity();
			}
			if (_position == 4) {
				return new SettingFragmentActivity();
			}
			return null;
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
							Util.showMessage(getApplicationContext(), "Double press to exit");
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
