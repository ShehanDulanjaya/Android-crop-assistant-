package com.example.sheha.ftest;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn,regbtn;
    private EditText ed1,ed2;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btn);
        regbtn=(Button)findViewById(R.id.reg);
        ed1=(EditText)findViewById(R.id.user);
        ed2=(EditText)findViewById(R.id.pass);
        auth= FirebaseAuth.getInstance();
        btn.setOnClickListener(this);
        regbtn.setOnClickListener(this);
    }

    private void register(){

        String email=ed1.getText().toString().trim();
        String pass=ed2.getText().toString().trim();
        auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(Task<AuthResult> task){
                if(task.isSuccessful()){
                   if( FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()) {
                       Toast.makeText(MainActivity.this, "registerd", Toast.LENGTH_SHORT).show();
                   }
                }
                else
                    Toast.makeText(MainActivity.this, "not registerd",Toast.LENGTH_SHORT).show();

            }

        });



    }


    @Override
    public void onClick(View v) {

        if(v==regbtn){
           // Toast.makeText(this, "registerd",Toast.LENGTH_SHORT);
            register();
        }

        if(v==btn){
            Toast.makeText(this, "registerd",Toast.LENGTH_SHORT).show();

        }

    }
}
