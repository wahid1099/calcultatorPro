package com.example.sing_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText SingInEmaileditText,SingInPasseditText;
    private TextView Singuptxtview;
    private Button singInbtn;
    private ProgressBar progressbar1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sing In Activity");
        SingInEmaileditText=findViewById(R.id.singInemailadrs);
        SingInPasseditText=findViewById(R.id.singInpasswrd);
        Singuptxtview=findViewById(R.id.singuptxtid);
        singInbtn=findViewById(R.id.singInbtn);
        progressbar1=findViewById(R.id.singInprgrs);
        mAuth = FirebaseAuth.getInstance();
        singInbtn.setOnClickListener(this);
        Singuptxtview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.singInbtn:
                uselogin();
                break;
            case R.id.singuptxtid:
                Intent intent=new Intent(getApplicationContext(),SingupActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void uselogin() {
        String email = SingInEmaileditText.getText().toString().trim();
        String password = SingInPasseditText.getText().toString().trim();
        if (email.isEmpty()) {
            SingInEmaileditText.setError("Email can't be Empty");
            SingInPasseditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            SingInEmaileditText.setError("Enter a valid email address");
            SingInPasseditText.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            SingInEmaileditText.setError("password can't be empty");
            SingInPasseditText.requestFocus();
            return;

        }
        if (password.length() > 6) {
            SingInEmaileditText.setError("Minimum lenth of password should be 6");
            SingInPasseditText.requestFocus();
            return;
        }
        progressbar1.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar1.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent=new Intent(getApplicationContext(),Profile_login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //  updateUI(user);
                        } else {
                            Toast.makeText(MainActivity.this, "Log in unsuccwssfull", Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
                            // Log.w(TAG, "signInWithEmail:failure", task.getException());
                            // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            //         Toast.LENGTH_SHORT).show();
                            //  updateUI(null);
                        }
                    }
                });
    }
}
