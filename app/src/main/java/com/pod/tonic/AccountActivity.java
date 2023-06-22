package com.pod.tonic;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import com.pod.tonic.R;
import android.widget.Button;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import id.zelory.compressor.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.app.AlertDialog
;
import android.content.DialogInterface
;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AccountActivity extends AppCompatActivity {
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview9;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear35;
	private LinearLayout linear3;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private TextView textview17;
	private LinearLayout linear36;
	private ImageView imageview18;
	private TextView textview2;
	private LinearLayout linear4;
	private LinearLayout linear8;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview3;
	private LinearLayout linear21;
	private ImageView imageview19;
	private TextView textview7;
	private LinearLayout linear22;
	private ImageView imageview20;
	private TextView textview5;
	private LinearLayout linear23;
	private ImageView imageview21;
	private TextView textview6;
	private LinearLayout linear24;
	private ImageView imageview22;
	private LinearLayout linear9;
	private LinearLayout linear5;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private TextView textview8;
	private LinearLayout linear25;
	private ImageView imageview24;
	private TextView textview4;
	private LinearLayout linear26;
	private ImageView imageview25;
	private TextView textview9;
	private LinearLayout linear27;
	private ImageView imageview26;
	private TextView textview10;
	private LinearLayout linear28;
	private ImageView imageview27;
	private TextView textview11;
	private LinearLayout linear29;
	private ImageView imageview28;
	private Button button1;
	private Button button2;
	
	private Intent intent = new Intent();
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
	
	private AlertDialog.Builder dialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.account);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		imageview9 = findViewById(R.id.imageview9);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		linear35 = findViewById(R.id.linear35);
		linear3 = findViewById(R.id.linear3);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear37 = findViewById(R.id.linear37);
		linear38 = findViewById(R.id.linear38);
		textview17 = findViewById(R.id.textview17);
		linear36 = findViewById(R.id.linear36);
		imageview18 = findViewById(R.id.imageview18);
		textview2 = findViewById(R.id.textview2);
		linear4 = findViewById(R.id.linear4);
		linear8 = findViewById(R.id.linear8);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		textview3 = findViewById(R.id.textview3);
		linear21 = findViewById(R.id.linear21);
		imageview19 = findViewById(R.id.imageview19);
		textview7 = findViewById(R.id.textview7);
		linear22 = findViewById(R.id.linear22);
		imageview20 = findViewById(R.id.imageview20);
		textview5 = findViewById(R.id.textview5);
		linear23 = findViewById(R.id.linear23);
		imageview21 = findViewById(R.id.imageview21);
		textview6 = findViewById(R.id.textview6);
		linear24 = findViewById(R.id.linear24);
		imageview22 = findViewById(R.id.imageview22);
		linear9 = findViewById(R.id.linear9);
		linear5 = findViewById(R.id.linear5);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		textview8 = findViewById(R.id.textview8);
		linear25 = findViewById(R.id.linear25);
		imageview24 = findViewById(R.id.imageview24);
		textview4 = findViewById(R.id.textview4);
		linear26 = findViewById(R.id.linear26);
		imageview25 = findViewById(R.id.imageview25);
		textview9 = findViewById(R.id.textview9);
		linear27 = findViewById(R.id.linear27);
		imageview26 = findViewById(R.id.imageview26);
		textview10 = findViewById(R.id.textview10);
		linear28 = findViewById(R.id.linear28);
		imageview27 = findViewById(R.id.imageview27);
		textview11 = findViewById(R.id.textview11);
		linear29 = findViewById(R.id.linear29);
		imageview28 = findViewById(R.id.imageview28);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		auth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		
		imageview9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				onBackPressed();
			}
		});
		
		linear35.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), UserActivity.class);
				startActivity(intent);
			}
		});
		
		imageview18.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), UserActivity.class);
				startActivity(intent);
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
		vscroll1.setVerticalScrollBarEnabled(false);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/extrabold.ttf"), 1);
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)40, (int)40, 0xFF171616, 0xFF171616));
		// Code for Delete Account button with warning
		button2.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View v) {
				        
				        
				
				SharedPreferences loginPrefs = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
				SharedPreferences myPrefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
				SharedPreferences skip = getSharedPreferences("skip", Context.MODE_PRIVATE);
				SharedPreferences type = getSharedPreferences("type", Context.MODE_PRIVATE);
				
				
				
				SharedPreferences.Editor loginEditor = loginPrefs.edit();
				SharedPreferences.Editor myEditor = myPrefs.edit();
				SharedPreferences.Editor skipEditor = skip.edit();
				SharedPreferences.Editor typeEditor = type.edit();
				
				
				loginEditor.clear();
				loginEditor.apply();
				
				myEditor.clear();
				myEditor.apply();
				
				skipEditor.clear();
				skipEditor.apply();
				
				typeEditor.clear();
				typeEditor.apply();
				
				
				

					 AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
				        builder.setTitle("Delete Account");
				        builder.setMessage("Are you sure you want to delete your account?");
				        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					            @Override
					            public void onClick(DialogInterface dialog, int which) {
						                // Code to delete account goes here
						                Toast.makeText(getApplicationContext(), "Account has been deleted", Toast.LENGTH_SHORT).show();
						                
						                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
						
						if (user != null) {
							    user.delete()
							        .addOnSuccessListener(new OnSuccessListener<Void>() {
								            @Override
								            public void onSuccess(Void aVoid) {
									                // Account deleted successfully
									                FirebaseAuth.getInstance().signOut();
									                
									                
									
									                
									                Intent intent = new Intent(AccountActivity.this, FirstActivity.class);
									                startActivity(intent);
									                finish();
									            }
								        })
							        .addOnFailureListener(new OnFailureListener() {
								            @Override
								            public void onFailure(@NonNull Exception e) {
									                // Account deletion failed
									                Toast.makeText(AccountActivity.this, "Account deletion failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
									            }
								        });
						}
						
						
						            }
					        });
				        builder.setNegativeButton("No", null);
				        AlertDialog dialog = builder.create();
				        dialog.show();
				    }
		});
		
		// Code for Logout button with warning
		button1.setOnClickListener(new OnClickListener() {
			    @Override
			    public void onClick(View v) {
				        
				        
				                        
				
				
				SharedPreferences loginPrefs = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE);
				SharedPreferences myPrefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
				SharedPreferences skip = getSharedPreferences("skip", Context.MODE_PRIVATE);
				SharedPreferences type = getSharedPreferences("type", Context.MODE_PRIVATE);
				
				
				
				SharedPreferences.Editor loginEditor = loginPrefs.edit();
				SharedPreferences.Editor myEditor = myPrefs.edit();
				SharedPreferences.Editor skipEditor = skip.edit();
				SharedPreferences.Editor typeEditor = type.edit();
				
				
				loginEditor.clear();
				loginEditor.apply();
				
				myEditor.clear();
				myEditor.apply();
				
				skipEditor.clear();
				skipEditor.apply();
				
				typeEditor.clear();
				typeEditor.apply();
				
				        AlertDialog.Builder builder = new AlertDialog.Builder(AccountActivity.this);
				        builder.setTitle("Logout");
				        builder.setMessage("Are you sure you want to logout?");
				        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					            @Override
					            public void onClick(DialogInterface dialog, int which) {
						                // Code to logout goes here
						                Toast.makeText(getApplicationContext(), "Logged out", Toast.LENGTH_SHORT).show();
						                FirebaseAuth.getInstance().signOut();
						                
						                
						                
						
						
						
						
						Intent intent = new Intent(AccountActivity.this, FirstActivity.class);
						startActivity(intent);
						finish();
						
						            }
					        });
				        builder.setNegativeButton("No", null);
				        AlertDialog dialog = builder.create();
				        dialog.show();
				    }
		});
		
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
