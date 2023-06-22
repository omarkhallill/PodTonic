package com.pod.tonic;

import android.animation.*;
import android.app.*;
import com.pod.tonic.R;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import java.util.regex.*;
import org.json.*;

public class LanguagesActivity extends AppCompatActivity {
	
	private boolean search = false;
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private ImageView imageview9;
	private TextView textview1;
	private LinearLayout linear27;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private LinearLayout linear19;
	private LinearLayout linear21;
	private LinearLayout linear23;
	private LinearLayout linear25;
	private TextView textview2;
	private LinearLayout linear8;
	private RadioButton radiobutton1;
	private TextView textview3;
	private LinearLayout linear10;
	private RadioButton radiobutton2;
	private TextView textview4;
	private LinearLayout linear12;
	private RadioButton radiobutton3;
	private TextView textview5;
	private LinearLayout linear14;
	private RadioButton radiobutton4;
	private TextView textview6;
	private LinearLayout linear16;
	private RadioButton radiobutton5;
	private TextView textview7;
	private LinearLayout linear18;
	private RadioButton radiobutton6;
	private TextView textview8;
	private LinearLayout linear20;
	private RadioButton radiobutton7;
	private TextView textview9;
	private LinearLayout linear22;
	private RadioButton radiobutton8;
	private TextView textview10;
	private LinearLayout linear24;
	private RadioButton radiobutton9;
	private TextView textview11;
	private LinearLayout linear26;
	private RadioButton radiobutton10;
	private TextView textview12;
	private LinearLayout linear28;
	private RadioButton radiobutton11;
	private TextView textview13;
	private LinearLayout linear29;
	private RadioButton radiobutton12;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.languages);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		imageview9 = findViewById(R.id.imageview9);
		textview1 = findViewById(R.id.textview1);
		linear27 = findViewById(R.id.linear27);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear9 = findViewById(R.id.linear9);
		linear11 = findViewById(R.id.linear11);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		linear17 = findViewById(R.id.linear17);
		linear19 = findViewById(R.id.linear19);
		linear21 = findViewById(R.id.linear21);
		linear23 = findViewById(R.id.linear23);
		linear25 = findViewById(R.id.linear25);
		textview2 = findViewById(R.id.textview2);
		linear8 = findViewById(R.id.linear8);
		radiobutton1 = findViewById(R.id.radiobutton1);
		textview3 = findViewById(R.id.textview3);
		linear10 = findViewById(R.id.linear10);
		radiobutton2 = findViewById(R.id.radiobutton2);
		textview4 = findViewById(R.id.textview4);
		linear12 = findViewById(R.id.linear12);
		radiobutton3 = findViewById(R.id.radiobutton3);
		textview5 = findViewById(R.id.textview5);
		linear14 = findViewById(R.id.linear14);
		radiobutton4 = findViewById(R.id.radiobutton4);
		textview6 = findViewById(R.id.textview6);
		linear16 = findViewById(R.id.linear16);
		radiobutton5 = findViewById(R.id.radiobutton5);
		textview7 = findViewById(R.id.textview7);
		linear18 = findViewById(R.id.linear18);
		radiobutton6 = findViewById(R.id.radiobutton6);
		textview8 = findViewById(R.id.textview8);
		linear20 = findViewById(R.id.linear20);
		radiobutton7 = findViewById(R.id.radiobutton7);
		textview9 = findViewById(R.id.textview9);
		linear22 = findViewById(R.id.linear22);
		radiobutton8 = findViewById(R.id.radiobutton8);
		textview10 = findViewById(R.id.textview10);
		linear24 = findViewById(R.id.linear24);
		radiobutton9 = findViewById(R.id.radiobutton9);
		textview11 = findViewById(R.id.textview11);
		linear26 = findViewById(R.id.linear26);
		radiobutton10 = findViewById(R.id.radiobutton10);
		textview12 = findViewById(R.id.textview12);
		linear28 = findViewById(R.id.linear28);
		radiobutton11 = findViewById(R.id.radiobutton11);
		textview13 = findViewById(R.id.textview13);
		linear29 = findViewById(R.id.linear29);
		radiobutton12 = findViewById(R.id.radiobutton12);
		
		imageview9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		linear27.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)30, 0xFF212121, 0xFF212121));
	}
	
	public void _transition(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
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
