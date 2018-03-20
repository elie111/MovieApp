package com.example.hp1.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements OnClickListener{
	Button breturn, btSignUp;
	TextView tvsign,tvmail,tvpassword;
	EditText etmail,etpassword;
	String mail;
	String pass;
	Boolean p=false;
	Boolean e=false;

	private FirebaseAuth mAuth;
	private FirebaseAuth.AuthStateListener mAuthListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign);

		mAuth = FirebaseAuth.getInstance();
		mAuthListener = new FirebaseAuth.AuthStateListener() {
			@Override
			public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
				FirebaseUser user = firebaseAuth.getCurrentUser();
				if (user != null ) {
					// User is signed in
					Log.d(" LOGIN ", "onAuthStateChanged:signed_in:" + user.getUid());
				} else {
					// User is signed out
					Log.d(" LOGIN", "onAuthStateChanged:signed_out");
				}
				// ...
			}
		};

		breturn=(Button)findViewById(R.id.breturn);
		breturn.setOnClickListener(this);

		btSignUp = (Button) findViewById(R.id.btSignUp);
		btSignUp.setOnClickListener(this);

		tvsign=(TextView)findViewById(R.id.tvsign);
		tvmail=(TextView)findViewById(R.id.tvmail);
		tvpassword=(TextView)findViewById(R.id.tvpassword);

		etmail=(EditText)findViewById(R.id.etmail);
		etpassword=(EditText)findViewById(R.id.etpassword);


	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent intent=new Intent(SignUp.this,MainActivity.class);
			startActivity(intent);
		}else{
			if(etmail.getText().toString().equals("") ||etpassword.getText().toString().equals("") ){
				Toast.makeText(SignUp.this, "Empty Email or Password",Toast.LENGTH_SHORT).show();
			}else {
				try {
					createAccount(etmail.getText().toString(), etpassword.getText().toString());
				}catch (Exception e) {
					Toast.makeText(SignUp.this, "Failed to Create Account", Toast.LENGTH_SHORT).show();
				}
			}
		}

	}

	public void createAccount(String email, String password){
		mAuth.createUserWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Log.d("NEW ACCOUNT", "createUserWithEmail:onComplete:" + task.isSuccessful());

						// If sign in fails, display a message to the user. If sign in succeeds
						// the auth state listener will be notified and logic to handle the
						// signed in user can be handled in the listener.
						if (!task.isSuccessful()) {
							Toast.makeText(SignUp.this, "Authentication failed.",
									Toast.LENGTH_SHORT).show();
						}else{
							Intent i=new Intent(getApplicationContext(), Login.class);
							startActivity(i);
						}
					}
				});
	}

}
