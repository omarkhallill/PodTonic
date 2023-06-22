package com.pod.tonic;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class CategoriesActivity extends AppCompatActivity {

	private Timer _timer = new Timer();

	private boolean search = false;
	private boolean close = false;
	private double backn = 0;

	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<String> podcastsCategories = new ArrayList<>();
	private ArrayList<String> podcastCategories = new ArrayList<>();

	private LinearLayout linear4;
	private LinearLayout linear6;
	private ScrollView vscroll2;
	private LinearLayout linear8;
	private TextView textview1;
	private EditText edittext1;
	private LinearLayout linear9;
	private ImageView imageview2;
	private LinearLayout linear7;
	private ListView listview2;
	private Button continueButton;

	private Intent in = new Intent();
	private TimerTask backt;
	private Intent intent = new Intent();
	private SharedPreferences type;

	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.categories);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}

	private void initialize(Bundle _savedInstanceState) {
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		vscroll2 = findViewById(R.id.vscroll2);
		linear8 = findViewById(R.id.linear8);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		linear9 = findViewById(R.id.linear9);
		imageview2 = findViewById(R.id.imageview2);
		linear7 = findViewById(R.id.linear7);
		listview2 = findViewById(R.id.listview2);
		continueButton = findViewById(R.id.continueButton);
		type = getSharedPreferences("type", Activity.MODE_PRIVATE);

		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();

				((ArrayAdapter)listview2.getAdapter()).getFilter().filter(edittext1.getText().toString());

			}

			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {

			}

			@Override
			public void afterTextChanged(Editable _param1) {

			}
		});

		imageview2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transition(linear6, 100);
				if (search) {
					search = false;
					imageview2.setVisibility(View.VISIBLE);
					edittext1.setVisibility(View.GONE);
					imageview2.setImageResource(R.drawable.ic_search_white);

					// clear the text of the search EditText
					edittext1.setText("");
				}
				else {
					search = true;
					imageview2.setVisibility(View.VISIBLE);
					edittext1.setVisibility(View.VISIBLE);
					imageview2.setImageResource(R.drawable.ic_close_white);
					edittext1.requestFocus();
				}
			}
		});

		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if ("OnItemClick".equals("0")) {
					continueButton.setVisibility(View.GONE);
				}
				else {
					continueButton.setVisibility(View.VISIBLE);
				}
			}
		});
	}

	private void initializeLogic() {
		continueButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				type.edit().putString("key", "value").commit();
				intent.setClass(getApplicationContext(), MainactivActivity.class);
				startActivity(intent);
			}
		});
		if (type.getString("key", "").equals("value")) {
			intent.setClass(getApplicationContext(), MainactivActivity.class);
			startActivity(intent);
			finish();
		}
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		edittext1.setVisibility(View.GONE);
		_rippleeffect("#EEEEEE", imageview2);












		// done
		vscroll2.setVerticalScrollBarEnabled(false);

		continueButton.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)5, 0xFF616161, Color.TRANSPARENT));



		String[] podcastCategories = {"Technology", "Science", "Business", "News", "Politics", "History", "Comedy", "Education", "Health & Fitness", "Sports", "Arts", "Society & Culture", "Religion & Spirituality", "True Crime", "TV & Film", "Music", "Kids & Family", "Food", "Travel", "Games & Hobbies", "Books", "Design", "Fashion & Beauty", "Performing Arts", "Personal Journals", "Technology News", "Investing", "Fitness & Nutrition", "Basketball", "Football", "Baseball", "Soccer", "Entertainment News", "Motivation & Inspiration", "Parenting", "Spirituality", "Environment", "Social Sciences", "Language Learning", "Self-Improvement", "Relationships", "Philosophy", "Marketing", "Entrepreneurship", "Psychology", "Investigative Journalism", "Pop Culture", "Visual Arts", "Medical", "Mental Health", "Alternative Health", "Astrology", "Sexuality", "LGBTQ+", "Autos", "Aviation", "Boating", "Cycling", "Golf", "Hiking", "Horseracing", "Martial Arts", "Outdoor", "Running", "Skiing", "Surfing", "Swimming", "Tennis", "Volleyball", "Water Sports", "Wrestling", "College Sports", "Sports News", "Basketball News", "Football News", "Baseball News", "Soccer News", "Gaming", "Board Games", "Video Games", "Card Games", "Role-Playing Games", "Chess", "Poker", "Bridge", "Dungeons & Dragons", "Science Fiction", "Fantasy", "Horror", "Mystery", "Thriller", "Action & Adventure", "Romance", "Western", "Classics", "Young Adult", "Non-Fiction", "Short Stories", "Poetry", "Cooking", "Wine", "Beer", "Cocktails", "Baking", "Vegetarian & Vegan", "Barbecuing", "Regional Cuisine", "Travel Guides", "Adventure Travel", "Budget Travel", "Cultural & Heritage Travel", "Family Travel", "Luxury Travel", "Solo Travel", "Backpacking", "Honeymoon & Romance Travel", "Sustainable Travel", "Camping", "RV Travel", "National Parks", "Beaches", "Mountains", "Cities", "Islands", "Road Trips", "Theme Parks", "Virtual Travel", "Literature", "Biography", "Memoir", "History & Politics", "Science & Technology", "Business & Management", "Finance & Investing", "Leadership", "Sales & Marketing", "Productivity", "Time Management", "Goal Setting", "Mindfulness", "Spiritual Growth", "Personal Finance", "Real Estate", "Stock Market", "Cryptocurrency", "Retirement", "Economy", "International Relations", "Climate Change", "Green Energy", "Environmental Policy", "Social Justice", "Diversity & Inclusion", "Gender & Sexuality", "Human Rights", "Activism", "Volunteering", "Charity", "Self-Care", "Beauty", "Fashion", "Interior Design", "Home Improvement", "DIY", "Gardening", "Pets", "Parenting & Family", "Marriage & Relationships", "Divorce", "Dating", "Friendship", "Death & Grief", "Aging", "Retirement Planning", "Education News", "Early Childhood Education", "K-12 Education", "Higher Education", "Online Learning", "Language Education", "STEM Education", "Special Education", "Art Education", "Music Education", "Physical Education", "Sports Education", "Educational Technology", "Gamification", "Classroom Management", "Curriculum Development", "Teacher Training", "Education Policy", "Education Research", "Education History", "Distance Learning", "Online Courses"};



		// Get the reference to the continue button in the activity's onCreate() method
		Button continueButton = findViewById(R.id.continueButton);
		continueButton.setVisibility(View.GONE);

		listview2.setAdapter(new ArrayAdapter<String>(this, R.layout.custom_list_item_layout, podcastCategories) {
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

		listview2.setTextFilterEnabled (true);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { SearchView mSearchView = new SearchView(getActionBar().getThemedContext());
		mSearchView.setQueryHint("Search");
		mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
			@Override
			public boolean onQueryTextSubmit(String query)
			{
				// TODO: Implement this method
				return false;
			}

			@Override
			public boolean onQueryTextChange(String newText)
			{
				// TODO: Implement this method
				if (TextUtils.isEmpty(newText)) {
					listview2.clearTextFilter();
				} else {
					listview2.setFilterText(newText);
				}
				return true;
			}
		});
		menu.add("Search")
				.setIcon(R.drawable.ic_search_white)
				.setActionView(mSearchView)
				.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);


		return true;

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
	public void _rippleeffect(final String _color, final View _view) {
		ColorStateList clr = new ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		RippleDrawable ripdr = new RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}


	public void _transition(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;

		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}

	public class Listview2Adapter extends BaseAdapter {

		ArrayList<HashMap<String, Object>> _data;

		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
