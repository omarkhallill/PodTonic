package com.pod.tonic;

import com.pod.tonic.SplashActivity;
import android.animation.*;
import com.pod.tonic.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.*;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import id.zelory.compressor.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	public final int REQ_CD_GOOGLE = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double Firebase = 0;
	private double tl = 0;
	private double tr = 0;
	private double bl = 0;
	private double br = 0;
	private String h = "";
	private String BGcolor = "";
	private String Scolor = "";
	private double Swldth = 0;
	private String GoogleSignInOptions = "";
	GoogleSignInOptions goptions;
	GoogleSignInClient gl;
	private String emailAddress = "";
	private String password = "";
	private double backn = 0;
	
	private ScrollView vscroll1;
	private LinearLayout linear_login;
	private LinearLayout linear10;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private Button button1;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private TextView textview5;
	private LinearLayout linear8;
	private EditText edittext2;
	private EditText edittext1;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private Button hide;
	private Button show;
	private Button button3;
	private TextView textview4;
	private Button button2;
	private ImageView imageview6;
	private ImageView imageview7;
	
	private Intent in = new Intent();
	private Intent In = new Intent();
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
	
	private GoogleSignInClient google;
	private SharedPreferences configuration;
	private SharedPreferences settings;
	private SharedPreferences loginPrefs;
	private TimerTask backt;
	private DatabaseReference db = _firebase.getReference("users/username");
	private ChildEventListener _db_child_listener;
	private ObjectAnimator Animation = new ObjectAnimator();
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear_login = findViewById(R.id.linear_login);
		linear10 = findViewById(R.id.linear10);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		button1 = findViewById(R.id.button1);
		linear9 = findViewById(R.id.linear9);
		linear7 = findViewById(R.id.linear7);
		textview5 = findViewById(R.id.textview5);
		linear8 = findViewById(R.id.linear8);
		edittext2 = findViewById(R.id.edittext2);
		edittext1 = findViewById(R.id.edittext1);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		hide = findViewById(R.id.hide);
		show = findViewById(R.id.show);
		button3 = findViewById(R.id.button3);
		textview4 = findViewById(R.id.textview4);
		button2 = findViewById(R.id.button2);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		auth = FirebaseAuth.getInstance();
		configuration = getSharedPreferences("configuration", Activity.MODE_PRIVATE);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		loginPrefs = getSharedPreferences("loginPrefs", Activity.MODE_PRIVATE);
		
		linear5.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		linear5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("") || edittext2.getText().toString().equals("")) {
					Util.showMessage(getApplicationContext(), "Please enter a valid email and password");
				}
				else {
					Util.showMessage(getApplicationContext(), "Logging in ...");
					auth.signInWithEmailAndPassword(edittext2.getText().toString(), edittext1.getText().toString()).addOnCompleteListener(MainActivity.this, _auth_sign_in_listener);
				}
			}
		});
		
		edittext2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		linear12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				int cursorPos = edittext1.getSelectionStart();
				edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
				edittext1.setSelection(cursorPos);
				
				show.setVisibility(View.VISIBLE);
				hide.setVisibility(View.GONE);
				linear12.setVisibility(View.GONE);
				linear13.setVisibility(View.VISIBLE);
			}
		});
		
		linear13.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				int cursorPos = edittext1.getSelectionStart();
				edittext1.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
				edittext1.setSelection(cursorPos);
				
				show.setVisibility(View.GONE);
				hide.setVisibility(View.VISIBLE);
				linear13.setVisibility(View.GONE);
				linear12.setVisibility(View.VISIBLE);
				
			}
		});
		
		hide.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				int cursorPos = edittext1.getSelectionStart();
				edittext1.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
				edittext1.setSelection(cursorPos);
				
				show.setVisibility(View.VISIBLE);
				hide.setVisibility(View.GONE);
				linear12.setVisibility(View.GONE);
				linear13.setVisibility(View.VISIBLE);
			}
		});
		
		show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				int cursorPos = edittext1.getSelectionStart();
				edittext1.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
				edittext1.setSelection(cursorPos);
				
				show.setVisibility(View.GONE);
				hide.setVisibility(View.VISIBLE);
				linear13.setVisibility(View.GONE);
				linear12.setVisibility(View.VISIBLE);
				
			}
		});
		
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), ResetpasswordActivity.class);
				startActivity(in);
			}
		});
		
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), Main1Activity.class);
				startActivity(in);
			}
		});
		
		imageview6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = com.google.android.gms.common.AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"}, false, null, null, null, null); startActivityForResult(intent, 94);
			}
		});
		
		_db_child_listener = new ChildEventListener() {
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
		db.addChildEventListener(_db_child_listener);
		
		Animation.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationCancel(Animator _param1) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator _param1) {
				
			}
		});
		
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
				if (_success) {
					loginPrefs.edit().putString("login", "skip").commit();
					Util.showMessage(getApplicationContext(), "Logged in successfully ");
					intent.setClass(getApplicationContext(), MainactivActivity.class);
					startActivity(intent);
					In.putExtra("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
					finish();
				}
				else {
					if (_errorMessage.equals("There is no user record corresponding to this identifier, try signup")) {
						auth.createUserWithEmailAndPassword(emailAddress, password).addOnCompleteListener(MainActivity.this, _auth_create_user_listener);
					}
					else {
						Util.showMessage(getApplicationContext(), _errorMessage);
					}
				}
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
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)5, 0xFF757575, Color.TRANSPARENT));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)20, 0xFF616161, 0xFF616161));
		linear6.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)20, 0xFF616161, 0xFF616161));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)20, Color.TRANSPARENT, Color.TRANSPARENT));
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)40, Color.TRANSPARENT));
		button3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)40, Color.TRANSPARENT));
		button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		vscroll1.setVerticalScrollBarEnabled(false);
		Window window = this.getWindow();window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.setNavigationBarColor(Color.parseColor("#101010"));
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		hide.setVisibility(View.GONE);
		if (loginPrefs.getString("login", "").equals("skip")) {
			Intent intent = new Intent("finish_activity");
			sendBroadcast(intent);
			
			
			finish(); // Finish the current activity
			
			
			      
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_GOOGLE:
			if (_resultCode == Activity.RESULT_OK) {
				Task<GoogleSignInAccount> _task = GoogleSignIn.getSignedInAccountFromIntent(_data);
				
				
			}
			else {
				
			}
			break;
			default:
			break;
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
	public void _shape() {
		
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
