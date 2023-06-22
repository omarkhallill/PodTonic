package com.pod.tonic;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
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

public class NotificationsActivity extends AppCompatActivity {
	
	private ScrollView vscroll1;
	private LinearLayout bottomlin;
	private LinearLayout linear1;
	private ImageView imageview9;
	private LinearLayout linear42;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear43;
	private LinearLayout linear8;
	private LinearLayout linear44;
	private LinearLayout linear15;
	private LinearLayout linear45;
	private LinearLayout linear24;
	private LinearLayout linear46;
	private TextView textview1;
	private TextView maintxt;
	private LinearLayout linear7;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview6;
	private LinearLayout linear14;
	private Switch switch3;
	private TextView textview3;
	private LinearLayout linear11;
	private Switch switch1;
	private TextView textview4;
	private LinearLayout linear12;
	private Switch switch2;
	private TextView maintxt2;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview8;
	private LinearLayout linear36;
	private Switch switch4;
	private TextView textview9;
	private LinearLayout linear37;
	private Switch switch5;
	private TextView maintxt3;
	private LinearLayout linear22;
	private LinearLayout linear16;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private TextView textview14;
	private LinearLayout linear41;
	private LinearLayout linear23;
	private Switch switch9;
	private TextView textview11;
	private LinearLayout linear17;
	private Switch switch6;
	private TextView textview12;
	private LinearLayout linear39;
	private LinearLayout linear19;
	private Switch switch7;
	private TextView textview13;
	private LinearLayout linear21;
	private Switch switch8;
	private TextView maintxt4;
	private LinearLayout linear31;
	private LinearLayout linear25;
	private LinearLayout linear27;
	private LinearLayout linear29;
	private LinearLayout linear33;
	private TextView textview19;
	private LinearLayout linear32;
	private Switch switch13;
	private TextView textview16;
	private LinearLayout linear26;
	private Switch switch10;
	private TextView textview17;
	private LinearLayout linear28;
	private Switch switch11;
	private TextView textview18;
	private LinearLayout linear30;
	private Switch switch12;
	private TextView textview20;
	private LinearLayout linear34;
	private Switch switch14;
	
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.notifications);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		bottomlin = findViewById(R.id.bottomlin);
		linear1 = findViewById(R.id.linear1);
		imageview9 = findViewById(R.id.imageview9);
		linear42 = findViewById(R.id.linear42);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear43 = findViewById(R.id.linear43);
		linear8 = findViewById(R.id.linear8);
		linear44 = findViewById(R.id.linear44);
		linear15 = findViewById(R.id.linear15);
		linear45 = findViewById(R.id.linear45);
		linear24 = findViewById(R.id.linear24);
		linear46 = findViewById(R.id.linear46);
		textview1 = findViewById(R.id.textview1);
		maintxt = findViewById(R.id.maintxt);
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		textview6 = findViewById(R.id.textview6);
		linear14 = findViewById(R.id.linear14);
		switch3 = findViewById(R.id.switch3);
		textview3 = findViewById(R.id.textview3);
		linear11 = findViewById(R.id.linear11);
		switch1 = findViewById(R.id.switch1);
		textview4 = findViewById(R.id.textview4);
		linear12 = findViewById(R.id.linear12);
		switch2 = findViewById(R.id.switch2);
		maintxt2 = findViewById(R.id.maintxt2);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textview8 = findViewById(R.id.textview8);
		linear36 = findViewById(R.id.linear36);
		switch4 = findViewById(R.id.switch4);
		textview9 = findViewById(R.id.textview9);
		linear37 = findViewById(R.id.linear37);
		switch5 = findViewById(R.id.switch5);
		maintxt3 = findViewById(R.id.maintxt3);
		linear22 = findViewById(R.id.linear22);
		linear16 = findViewById(R.id.linear16);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		textview14 = findViewById(R.id.textview14);
		linear41 = findViewById(R.id.linear41);
		linear23 = findViewById(R.id.linear23);
		switch9 = findViewById(R.id.switch9);
		textview11 = findViewById(R.id.textview11);
		linear17 = findViewById(R.id.linear17);
		switch6 = findViewById(R.id.switch6);
		textview12 = findViewById(R.id.textview12);
		linear39 = findViewById(R.id.linear39);
		linear19 = findViewById(R.id.linear19);
		switch7 = findViewById(R.id.switch7);
		textview13 = findViewById(R.id.textview13);
		linear21 = findViewById(R.id.linear21);
		switch8 = findViewById(R.id.switch8);
		maintxt4 = findViewById(R.id.maintxt4);
		linear31 = findViewById(R.id.linear31);
		linear25 = findViewById(R.id.linear25);
		linear27 = findViewById(R.id.linear27);
		linear29 = findViewById(R.id.linear29);
		linear33 = findViewById(R.id.linear33);
		textview19 = findViewById(R.id.textview19);
		linear32 = findViewById(R.id.linear32);
		switch13 = findViewById(R.id.switch13);
		textview16 = findViewById(R.id.textview16);
		linear26 = findViewById(R.id.linear26);
		switch10 = findViewById(R.id.switch10);
		textview17 = findViewById(R.id.textview17);
		linear28 = findViewById(R.id.linear28);
		switch11 = findViewById(R.id.switch11);
		textview18 = findViewById(R.id.textview18);
		linear30 = findViewById(R.id.linear30);
		switch12 = findViewById(R.id.switch12);
		textview20 = findViewById(R.id.textview20);
		linear34 = findViewById(R.id.linear34);
		switch14 = findViewById(R.id.switch14);
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		maintxt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		maintxt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		maintxt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		maintxt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		Window window = this.getWindow();
		window.setNavigationBarColor(Color.parseColor("#101010"));
		vscroll1.setVerticalScrollBarEnabled(false);
		SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
		boolean switch2Value = sharedPreferences.getBoolean("switch2", false);
		
		if (switch2Value) {
			
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear43.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFFEEEEEE, 0xFFEEEEEE));
			
			linear44.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFFEEEEEE, 0xFFEEEEEE));
			linear45.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFFEEEEEE, 0xFFEEEEEE));
			linear46.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFFEEEEEE, 0xFFEEEEEE));
			textview1.setTextColor(0xFF757575);
			maintxt.setTextColor(0xFF424242);
			textview3.setTextColor(0xFF212121);
			textview4.setTextColor(0xFF212121);
			textview6.setTextColor(0xFF212121);
			maintxt2.setTextColor(0xFF424242);
			textview8.setTextColor(0xFF212121);
			textview9.setTextColor(0xFF212121);
			maintxt3.setTextColor(0xFF424242);
			textview11.setTextColor(0xFF212121);
			textview12.setTextColor(0xFF212121);
			textview13.setTextColor(0xFF212121);
			textview14.setTextColor(0xFF212121);
			maintxt4.setTextColor(0xFF424242);
			textview16.setTextColor(0xFF212121);
			textview17.setTextColor(0xFF212121);
			textview18.setTextColor(0xFF212121);
			textview19.setTextColor(0xFF212121);
			textview20.setTextColor(0xFF212121);
			
		}
		else {
		}
		imageview9.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View v) {
				        onBackPressed();
				    }
		});
		
		linear43.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
		linear44.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
		linear45.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
		linear46.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
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
