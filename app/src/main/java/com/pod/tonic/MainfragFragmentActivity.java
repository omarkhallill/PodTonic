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
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
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


public class MainfragFragmentActivity extends Fragment {
	
	private Timer _timer = new Timer();
	
	private boolean search = false;
	private double backn = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear44;
	private LinearLayout linear7;
	private RecyclerView recyclerview2;
	private LinearLayout linear8;
	private RecyclerView recyclerview10;
	private LinearLayout linear9;
	private RecyclerView recyclerview9;
	private LinearLayout linear10;
	private RecyclerView recyclerview8;
	private LinearLayout linear11;
	private RecyclerView recyclerview7;
	private LinearLayout linear28;
	private RecyclerView recyclerview6;
	private LinearLayout linear30;
	private RecyclerView recyclerview5;
	private LinearLayout linear32;
	private RecyclerView recyclerview4;
	private LinearLayout linear38;
	private RecyclerView recyclerview3;
	private LinearLayout linear12;
	private HorizontalScrollView hscroll11;
	private TextView textview1;
	private LinearLayout linear4;
	private EditText edittext1;
	private ImageView imageview2;
	private ImageView imageview1;
	private EditText edittext2;
	private ImageView imageview11;
	private ImageView imagetrend;
	private TextView textview2;
	private ImageView imagelove;
	private TextView textview3;
	private ImageView imagescience;
	private TextView textview4;
	private ImageView imagemotive;
	private TextView textview5;
	private ImageView imagecomedy;
	private TextView textview6;
	private ImageView imageliked;
	private TextView textview12;
	private ImageView imageseeding;
	private TextView textview13;
	private ImageView imageease;
	private TextView textview14;
	private ImageView imagerel;
	private TextView textview15;
	private TextView textview7;
	private LinearLayout linear40;
	private ImageView imageview8;
	private LinearLayout linear37;
	
	private Intent intent = new Intent();
	private SharedPreferences login;
	private TimerTask timer;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.mainfrag_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		linear2 = _view.findViewById(R.id.linear2);
		linear44 = _view.findViewById(R.id.linear44);
		linear7 = _view.findViewById(R.id.linear7);
		recyclerview2 = _view.findViewById(R.id.recyclerview2);
		linear8 = _view.findViewById(R.id.linear8);
		recyclerview10 = _view.findViewById(R.id.recyclerview10);
		linear9 = _view.findViewById(R.id.linear9);
		recyclerview9 = _view.findViewById(R.id.recyclerview9);
		linear10 = _view.findViewById(R.id.linear10);
		recyclerview8 = _view.findViewById(R.id.recyclerview8);
		linear11 = _view.findViewById(R.id.linear11);
		recyclerview7 = _view.findViewById(R.id.recyclerview7);
		linear28 = _view.findViewById(R.id.linear28);
		recyclerview6 = _view.findViewById(R.id.recyclerview6);
		linear30 = _view.findViewById(R.id.linear30);
		recyclerview5 = _view.findViewById(R.id.recyclerview5);
		linear32 = _view.findViewById(R.id.linear32);
		recyclerview4 = _view.findViewById(R.id.recyclerview4);
		linear38 = _view.findViewById(R.id.linear38);
		recyclerview3 = _view.findViewById(R.id.recyclerview3);
		linear12 = _view.findViewById(R.id.linear12);
		hscroll11 = _view.findViewById(R.id.hscroll11);
		textview1 = _view.findViewById(R.id.textview1);
		linear4 = _view.findViewById(R.id.linear4);
		edittext1 = _view.findViewById(R.id.edittext1);
		imageview2 = _view.findViewById(R.id.imageview2);
		imageview1 = _view.findViewById(R.id.imageview1);
		edittext2 = _view.findViewById(R.id.edittext2);
		imageview11 = _view.findViewById(R.id.imageview11);
		imagetrend = _view.findViewById(R.id.imagetrend);
		textview2 = _view.findViewById(R.id.textview2);
		imagelove = _view.findViewById(R.id.imagelove);
		textview3 = _view.findViewById(R.id.textview3);
		imagescience = _view.findViewById(R.id.imagescience);
		textview4 = _view.findViewById(R.id.textview4);
		imagemotive = _view.findViewById(R.id.imagemotive);
		textview5 = _view.findViewById(R.id.textview5);
		imagecomedy = _view.findViewById(R.id.imagecomedy);
		textview6 = _view.findViewById(R.id.textview6);
		imageliked = _view.findViewById(R.id.imageliked);
		textview12 = _view.findViewById(R.id.textview12);
		imageseeding = _view.findViewById(R.id.imageseeding);
		textview13 = _view.findViewById(R.id.textview13);
		imageease = _view.findViewById(R.id.imageease);
		textview14 = _view.findViewById(R.id.textview14);
		imagerel = _view.findViewById(R.id.imagerel);
		textview15 = _view.findViewById(R.id.textview15);
		textview7 = _view.findViewById(R.id.textview7);
		linear40 = _view.findViewById(R.id.linear40);
		imageview8 = _view.findViewById(R.id.imageview8);
		linear37 = _view.findViewById(R.id.linear37);
		login = getContext().getSharedPreferences("prefs", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transition(linear1, 100);
				if (search) {
					search = false;
					imageview1.setVisibility(View.VISIBLE);
					textview1.setVisibility(View.VISIBLE);
					imageview2.setVisibility(View.VISIBLE);
					edittext1.setVisibility(View.GONE);
					imageview2.setImageResource(R.drawable.magnify);
					
					        // clear the text of the search EditText
					        edittext1.setText("");
				}
				else {
					search = true;
					imageview1.setVisibility(View.GONE);
					textview1.setVisibility(View.GONE);
					edittext1.setVisibility(View.VISIBLE);
					imageview2.setVisibility(View.VISIBLE);
					imageview2.setImageResource(R.drawable.close);
					edittext1.requestFocus();
				}
			}
		});
		
		imageview11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext2.setText("");
			}
		});
	}
	
	private void initializeLogic() {
		vscroll1.setVerticalScrollBarEnabled(false);
		textview1.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		edittext1.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		edittext1.setVisibility(View.GONE);
		_rippleeffect("#EEEEEE", imageview1);
		_rippleeffect("#EEEEEE", imageview2);
		edittext2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview5.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview6.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview12.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview13.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview14.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		textview15.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 1);
		linear44.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)5, 0xFF424242, 0xFF101010));
		imageview11.setVisibility(View.GONE);
		edittext2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/extrabold.ttf"), 0);
		
		linear1.setBackgroundColor(0xFF101010);
		vscroll1.setBackgroundColor(0xFF101010);
		vscroll1.setOnScrollChangeListener(new OnScrollChangeListener() {
			    private boolean isVisible = false; // Track the visibility of the linear44 and linear45 layouts
			
			    @Override
			    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				        if (scrollY > linear2.getHeight()) {
					            if (!isVisible) {
						                // Fade in the linear44 and linear45 layouts
						                linear44.setVisibility(View.VISIBLE);
						                
						                linear44.setAlpha(0f);
						                
						                linear44.animate().alpha(1f).setDuration(500);
						              
						                isVisible = true;
						            }
					        } else {
					            if (isVisible) {
						                // Fade out the linear44 and linear45 layouts
						                linear44.animate().alpha(0f).setDuration(500).withEndAction(new Runnable() {
							                    @Override
							                    public void run() {
								                        linear44.setVisibility(View.GONE);
								                    }
							                });
						                
						                isVisible = false;
						            }
					        }
				    }
		});
		
		// Set the initial state of the linear44 layout
		linear44.setVisibility(View.GONE);
		linear44.setAlpha(0f);
		linear44.setBackground(new GradientDrawable() {
			    public GradientDrawable getIns(int a, int b, int c, int d) {
				        this.setCornerRadius(a);
				        this.setStroke(b, c);
				        this.setColor(d);
				        return this;
				    }
		}.getIns((int)30, (int)5, 0xFF424242, Color.TRANSPARENT));
	}
	
	public void _rippleeffect(final String _color, final View _view) {
		ColorStateList clr = new ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		RippleDrawable ripdr = new RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _transition(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	public class Recyclerview2Adapter extends Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
			
			linear1.addView(linear1);
			linear2.addView(linear2);
			linear3.addView(linear3);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview10Adapter extends Adapter<Recyclerview10Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview10Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview9Adapter extends Adapter<Recyclerview9Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview9Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview8Adapter extends Adapter<Recyclerview8Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview8Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview7Adapter extends Adapter<Recyclerview7Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview7Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview6Adapter extends Adapter<Recyclerview6Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview6Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview5Adapter extends Adapter<Recyclerview5Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview5Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview4Adapter extends Adapter<Recyclerview4Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview3Adapter extends Adapter<Recyclerview3Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _v = _inflater.inflate(R.layout.customshimmer, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final com.facebook.shimmer.ShimmerFrameLayout linear3 = _view.findViewById(R.id.linear3);
			final com.facebook.shimmer.ShimmerFrameLayout linear1 = _view.findViewById(R.id.linear1);
			final com.facebook.shimmer.ShimmerFrameLayout linear2 = _view.findViewById(R.id.linear2);
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
}
