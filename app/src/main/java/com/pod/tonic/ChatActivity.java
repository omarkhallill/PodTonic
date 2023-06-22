package com.pod.tonic;

import android.animation.*;
import android.app.*;
import android.content.*;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.shimmer.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import de.hdodenhof.circleimageview.*;
import id.zelory.compressor.*;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ChatActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String myEmail = "";
	private String userEmail = "";
	private String message = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String time = "";
	private String retract = "";
	private String read = "";
	private String key = "";
	private String urlChat1 = "";
	
	private ArrayList<String> email_ar = new ArrayList<>();
	private ArrayList<String> message_ar = new ArrayList<>();
	private ArrayList<String> time_ar = new ArrayList<>();
	private ArrayList<String> read_ar = new ArrayList<>();
	private ArrayList<String> key_ar = new ArrayList<>();
	private ArrayList<String> retract_ar = new ArrayList<>();
	private ArrayList<String> uid_ar = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	
	private LinearLayout linear1;
	private Toolbar toolbar;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private CircleImageView profile;
	private TextView txt_name;
	private ListView listview1;
	private ImageView imageview2;
	private EditText edittext1;
	private ImageView imageview1;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference chat = _firebase.getReference("message");
	private ChildEventListener _chat_child_listener;
	private DatabaseReference con = _firebase.getReference("conversation");
	private ChildEventListener _con_child_listener;
	private Calendar c = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chat);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		toolbar = findViewById(R.id.toolbar);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		profile = findViewById(R.id.profile);
		txt_name = findViewById(R.id.txt_name);
		listview1 = findViewById(R.id.listview1);
		imageview2 = findViewById(R.id.imageview2);
		edittext1 = findViewById(R.id.edittext1);
		imageview1 = findViewById(R.id.imageview1);
		auth = FirebaseAuth.getInstance();
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				return true;
			}
		});
		
		imageview1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				message = edittext1.getText().toString();
				if (message.length() > 0) {
					c = Calendar.getInstance();
					time = new SimpleDateFormat("hh:mm").format(c.getTime());
					retract = "false";
					read = "false";
					key = chat.push().getKey();
					map.clear();
					map = new HashMap<>();
					map.put("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("message", message);
					map.put("time", time);
					map.put("retract", retract);
					map.put("read", read);
					map.put("key", key);
					chat.child(myEmail.concat("/".concat(userEmail.concat("/".concat(key))))).updateChildren(map);
					chat.child(userEmail.concat("/".concat(myEmail.concat("/".concat(key))))).updateChildren(map);
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					con.child(userEmail.concat("/".concat("conversation".concat("/".concat(myEmail))))).updateChildren(map);
					map.put("uid", userEmail);
					
					con.child(myEmail.concat("/".concat("conversation".concat("/".concat(userEmail))))).updateChildren(map);
					edittext1.setText("");
				}
			}
		});
		
		_chat_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		chat.addChildEventListener(_chat_child_listener);
		
		_con_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		con.addChildEventListener(_con_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		setSupportActionBar(toolbar);
		
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		
		toolbar.setNavigationOnClickListener(new OnClickListener() {
			
			@Override public void onClick(View v) { 
				    onBackPressed(); 
				    }
			
		});
		myEmail = FirebaseAuth.getInstance().getCurrentUser().getUid();
		userEmail = getIntent().getStringExtra("uid");
		urlChat1 = myEmail.concat("/".concat(userEmail));
		listview1.setStackFromBottom(true);
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		txt_name.setText(getIntent().getStringExtra("email"));
		_load();
		edittext1.setTextColor(0xFFE0E0E0);
	}
	
	public void _load() {
		chat.child(urlChat1).addValueEventListener(new ValueEventListener() { @Override public void onDataChange(DataSnapshot ds) { _clear();
				
				for (DataSnapshot ac : ds.getChildren()) {
					
					//phone
					
					email_ar.add(((String)
					
					ac.child("email").getValue())); //message
					
					message_ar.add(((String) ac.child("message").getValue()));
					
					//time
					
					time_ar.add(((String) ac.child("time").getValue()));
					
					//uid
					
					uid_ar.add(((String) ac.child("uid").getValue()));
					
					//retract
					
					retract_ar.add(((String) ac.child("retract").getValue()));
					
					//key
					
					key_ar.add(((String) ac.child("key").getValue()));
					
					//read
					
					read_ar.add(((String)
					
					ac.child("read").getValue()));
					
					HashMap < String, Object > map = new HashMap < String, Object > (); maplist.add(map);
				}
				listview1.setAdapter(new Listview1Adapter(maplist));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			 @Override public void onCancelled(DatabaseError de) { } });
	}
	
	
	public void _clear() {
		if (uid_ar.size() > 0) {
			email_ar.clear();
			message_ar.clear();
			time_ar.clear();
			read_ar.clear();
			key_ar.clear();
			retract_ar.clear();
			uid_ar.clear();
			maplist.clear();
		}
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
				_view = _inflater.inflate(R.layout.chat_list, null);
			}
			
			final LinearLayout chat_me = _view.findViewById(R.id.chat_me);
			final LinearLayout chat_user = _view.findViewById(R.id.chat_user);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView txt_msg_1 = _view.findViewById(R.id.txt_msg_1);
			final TextView txt_time_1 = _view.findViewById(R.id.txt_time_1);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView txt_msg_2 = _view.findViewById(R.id.txt_msg_2);
			final TextView txt_time_2 = _view.findViewById(R.id.txt_time_2);
			
			if (uid_ar.get((int)(_position)).equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
				chat_me.setVisibility(View.VISIBLE);
				chat_user.setVisibility(View.GONE);
				txt_msg_1.setText(message_ar.get((int)(_position)));
				txt_time_1.setText(time_ar.get((int)(_position)));
			}
			else {
				chat_me.setVisibility(View.GONE);
				chat_user.setVisibility(View.VISIBLE);
				txt_msg_2.setText(message_ar.get((int)(_position)));
				txt_time_2.setText(time_ar.get((int)(_position)));
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
