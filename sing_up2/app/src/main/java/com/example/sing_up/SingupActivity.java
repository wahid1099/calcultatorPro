package com.example.sing_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SingupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText SingupEmaileditText, SingupPasseditText;
    private TextView Singinstxtview;
    private Button singupbtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        this.setTitle("Sing Up Activity");
        SingupEmaileditText = findViewById(R.id.singupemailadrs);
        SingupPasseditText = findViewById(R.id.singuppasswrd);
        Singinstxtview = findViewById(R.id.singintxt);
        mAuth = FirebaseAuth.getInstance();
        progressbar=findViewById(R.id.singupprgrs);

        singupbtn = findViewById(R.id.singupbtn);
        singupbtn.setOnClickListener(this);
        Singinstxtview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.singupbtn:
                userRegister();
                break;
            case R.id.singintxt:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        String email = SingupEmaileditText.getText().toString().trim();
        String password = SingupPasseditText.getText().toString().trim();
        if (email.isEmpty()) {
            SingupEmaileditText.setError("Email can't be Empty");
            SingupEmaileditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            SingupEmaileditText.setError("Enter a valid email address");
            SingupEmaileditText.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            SingupPasseditText.setError("password can't be empty");
            SingupPasseditText.requestFocus();
            return;

        }
        if (password.length() > 6) {
            SingupPasseditText.setError("Minimum lenth of password should be 6");
            SingupPasseditText.requestFocus();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressbar.setVisibility(View.GONE);
                    // Sign in success, update UI with the signed-in user's information
                    // Log.d(TAG, "createUserWithEmail:success");
                    //  FirebaseUser user = mAuth.getCurrentUser();
                    ///   updateUI(user);
                    Toast.makeText(SingupActivity.this, "Register is succesfull", Toast.LENGTH_SHORT).show();
                } else {

                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(SingupActivity.this, "User is Already Register", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SingupActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    // If sign in fails, display a message to the user.
                    //  Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                    //      Toast.LENGTH_SHORT).show();
                    // updateUI(null);
                   /// Toast.makeText(SingupActivity.this, "Register is not succesfull", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}