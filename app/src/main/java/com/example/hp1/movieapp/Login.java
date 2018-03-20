package com.example.hp1.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity implements OnClickListener{
	Button breturn,blogin;
	TextView tvwelcome,tvmail,tvpassword;
	EditText etmail,etpassword;
	String[] email = {"elie"};
	String[] password = {"elie"};
	String pass,mail;
	Boolean p=false;
	Boolean e=false;

	private FirebaseAuth mAuth;
	private FirebaseAuth.AuthStateListener mAuthListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

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
		blogin=(Button)findViewById(R.id.blogin);


		etpassword=(EditText)findViewById(R.id.etpassword);
		etmail=(EditText)findViewById(R.id.etmail);

		breturn.setOnClickListener(this);
		blogin.setOnClickListener(this);
	}
	@Override
	public void onStart() {
		super.onStart();
		mAuth.addAuthStateListener(mAuthListener);
	}

	@Override
	public void onStop() {
		super.onStop();
		if (mAuthListener != null) {
			mAuth.removeAuthStateListener(mAuthListener);
		}
	}

	public void signIn(String email, String password){
		mAuth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Log.d("SIGN IN", "signInWithEmail:onComplete:" + task.isSuccessful());

						// If sign in fails, display a message to the user. If sign in succeeds
						// the auth state listener will be notified and logic to handle the
						// signed in user can be handled in the listener.
						if (!task.isSuccessful()) {
							Log.w("SIGN IN", "signInWithEmail", task.getException());
							Toast.makeText(Login.this, "Authentication failed.",
									Toast.LENGTH_SHORT).show();
						}else{
							Intent i=new Intent(getBaseContext(),Home.class);
							startActivity(i);
						}

					}
				});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent i=new Intent(this, MainActivity.class);
			startActivity(i);
		}
		if(v==blogin){
			pass=etpassword.getText().toString();
			mail=etmail.getText().toString();

			signIn(mail, pass);

		}
	}
}



