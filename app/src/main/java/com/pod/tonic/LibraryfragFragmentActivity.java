package com.pod.tonic;

import android.animation.*;
import com.pod.tonic.R;
import android.app.*;
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
import android.content.Context;


public class LibraryfragFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	
	private double backn = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear23;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private LinearLayout linear17;
	private LinearLayout linear4;
	private LinearLayout linear18;
	private LinearLayout linear5;
	private LinearLayout linear19;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview7;
	private TextView textview1;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private TextView textview5;
	private TextView textview6;
	private ImageView imageview15;
	private TextView textview2;
	private LinearLayout linear20;
	private ImageView imageview12;
	private ImageView imageview16;
	private TextView textview3;
	private LinearLayout linear21;
	private ImageView imageview13;
	private ImageView imageview17;
	private TextView textview4;
	private LinearLayout linear22;
	private ImageView imageview14;
	
	private TimerTask time;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.libraryfrag_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		linear23 = _view.findViewById(R.id.linear23);
		linear8 = _view.findViewById(R.id.linear8);
		linear3 = _view.findViewById(R.id.linear3);
		linear17 = _view.findViewById(R.id.linear17);
		linear4 = _view.findViewById(R.id.linear4);
		linear18 = _view.findViewById(R.id.linear18);
		linear5 = _view.findViewById(R.id.linear5);
		linear19 = _view.findViewById(R.id.linear19);
		linear6 = _view.findViewById(R.id.linear6);
		linear7 = _view.findViewById(R.id.linear7);
		textview7 = _view.findViewById(R.id.textview7);
		textview1 = _view.findViewById(R.id.textview1);
		linear9 = _view.findViewById(R.id.linear9);
		linear11 = _view.findViewById(R.id.linear11);
		textview5 = _view.findViewById(R.id.textview5);
		textview6 = _view.findViewById(R.id.textview6);
		imageview15 = _view.findViewById(R.id.imageview15);
		textview2 = _view.findViewById(R.id.textview2);
		linear20 = _view.findViewById(R.id.linear20);
		imageview12 = _view.findViewById(R.id.imageview12);
		imageview16 = _view.findViewById(R.id.imageview16);
		textview3 = _view.findViewById(R.id.textview3);
		linear21 = _view.findViewById(R.id.linear21);
		imageview13 = _view.findViewById(R.id.imageview13);
		imageview17 = _view.findViewById(R.id.imageview17);
		textview4 = _view.findViewById(R.id.textview4);
		linear22 = _view.findViewById(R.id.linear22);
		imageview14 = _view.findViewById(R.id.imageview14);
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		linear9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFF9E9E9E, Color.TRANSPARENT));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)5, 0xFF9E9E9E, Color.TRANSPARENT));
		textview3.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)1, 0xFF9E9E9E, Color.TRANSPARENT));
		linear18.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)1, 0xFF9E9E9E, Color.TRANSPARENT));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)1, 0xFF9E9E9E, Color.TRANSPARENT));
		vscroll1.setVerticalScrollBarEnabled(false);
	}
	
}
