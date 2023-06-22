package com.pod.tonic;

import android.animation.*;
import android.app.*;
import com.pod.tonic.R;
import android.app.Activity;
import com.pod.tonic.FileUtil;
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
import android.view.Window;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;


public class SettingFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	
	private double backn = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear11;
	private TextView textview2;
	private LinearLayout linear2;
	private LinearLayout linear31;
	private LinearLayout linear5;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview3;
	private TextView textview9;
	private TextView textview23;
	private LinearLayout linear32;
	private ImageView imageview29;
	private TextView textview6;
	private LinearLayout linear22;
	private ImageView imageview18;
	private TextView textview13;
	private LinearLayout linear23;
	private ImageView imageview20;
	private TextView textview15;
	private LinearLayout linear24;
	private ImageView imageview21;
	private TextView textview17;
	private LinearLayout linear25;
	private ImageView imageview22;
	private TextView textview18;
	private LinearLayout linear26;
	private ImageView imageview23;
	private TextView textview19;
	private LinearLayout linear27;
	private ImageView imageview24;
	private ImageView imageview25;
	private TextView textview20;
	private LinearLayout linear28;
	private ImageView imageview26;
	private TextView textview21;
	private LinearLayout linear29;
	private ImageView imageview27;
	private TextView textview22;
	private LinearLayout linear30;
	private ImageView imageview28;
	
	private Intent in = new Intent();
	private SharedPreferences themes;
	private SharedPreferences myPrefs;
	private TimerTask timer;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.setting_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		linear11 = _view.findViewById(R.id.linear11);
		textview2 = _view.findViewById(R.id.textview2);
		linear2 = _view.findViewById(R.id.linear2);
		linear31 = _view.findViewById(R.id.linear31);
		linear5 = _view.findViewById(R.id.linear5);
		linear12 = _view.findViewById(R.id.linear12);
		linear13 = _view.findViewById(R.id.linear13);
		linear15 = _view.findViewById(R.id.linear15);
		linear16 = _view.findViewById(R.id.linear16);
		linear17 = _view.findViewById(R.id.linear17);
		linear18 = _view.findViewById(R.id.linear18);
		linear19 = _view.findViewById(R.id.linear19);
		linear20 = _view.findViewById(R.id.linear20);
		textview3 = _view.findViewById(R.id.textview3);
		textview9 = _view.findViewById(R.id.textview9);
		textview23 = _view.findViewById(R.id.textview23);
		linear32 = _view.findViewById(R.id.linear32);
		imageview29 = _view.findViewById(R.id.imageview29);
		textview6 = _view.findViewById(R.id.textview6);
		linear22 = _view.findViewById(R.id.linear22);
		imageview18 = _view.findViewById(R.id.imageview18);
		textview13 = _view.findViewById(R.id.textview13);
		linear23 = _view.findViewById(R.id.linear23);
		imageview20 = _view.findViewById(R.id.imageview20);
		textview15 = _view.findViewById(R.id.textview15);
		linear24 = _view.findViewById(R.id.linear24);
		imageview21 = _view.findViewById(R.id.imageview21);
		textview17 = _view.findViewById(R.id.textview17);
		linear25 = _view.findViewById(R.id.linear25);
		imageview22 = _view.findViewById(R.id.imageview22);
		textview18 = _view.findViewById(R.id.textview18);
		linear26 = _view.findViewById(R.id.linear26);
		imageview23 = _view.findViewById(R.id.imageview23);
		textview19 = _view.findViewById(R.id.textview19);
		linear27 = _view.findViewById(R.id.linear27);
		imageview24 = _view.findViewById(R.id.imageview24);
		imageview25 = _view.findViewById(R.id.imageview25);
		textview20 = _view.findViewById(R.id.textview20);
		linear28 = _view.findViewById(R.id.linear28);
		imageview26 = _view.findViewById(R.id.imageview26);
		textview21 = _view.findViewById(R.id.textview21);
		linear29 = _view.findViewById(R.id.linear29);
		imageview27 = _view.findViewById(R.id.imageview27);
		textview22 = _view.findViewById(R.id.textview22);
		linear30 = _view.findViewById(R.id.linear30);
		imageview28 = _view.findViewById(R.id.imageview28);
		themes = getContext().getSharedPreferences("themes", Activity.MODE_PRIVATE);
		myPrefs = getContext().getSharedPreferences("myPrefs", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), AccountActivity.class);
				startActivity(in);
			}
		});
		
		linear31.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), LanguagesActivity.class);
				startActivity(in);
			}
		});
		
		linear5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), NotificationsActivity.class);
				startActivity(in);
			}
		});
		
		imageview29.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), LanguagesActivity.class);
				startActivity(in);
			}
		});
		
		imageview18.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getContext().getApplicationContext(), NotificationsActivity.class);
				startActivity(in);
			}
		});
	}
	
	private void initializeLogic() {
		textview2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFF757575, Color.TRANSPARENT));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear12.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear15.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear16.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear18.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		linear20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0.5d, 0xFF757575, Color.TRANSPARENT));
		vscroll1.setVerticalScrollBarEnabled(false);
	}
	
}
