package com.n.keystoresecuirty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author nithin
 */

public class Register  extends AppCompatActivity {
    EditText email,password;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

         email=(EditText)findViewById(R.id.email);
         password=(EditText)findViewById(R.id.password);

        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);


        Button signup=(Button)findViewById(R.id.signup);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String em=email.getText().toString();
                    String pass=password.getText().toString();

                    if(em.equals("") && pass.equals("")){
                        Toast.makeText(Register.this, "Null", Toast.LENGTH_SHORT).show();
                    }else{

                        String key=KeyStoreSecurity.getKey(getApplicationContext());

                        String enc=KeyStoreSecurity.encryptString(key,pass);

//                        Toast.makeText(Register.this, key+" : "+enc+" Data: "+em+pass, Toast.LENGTH_SHORT).show();


                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("User", em);
                        editor.putString("EnKey", enc);

                        editor.commit();
                        Toast.makeText(Register.this," Registered! ",Toast.LENGTH_LONG).show();


                        Intent inte=new Intent(Register.this,MainActivity.class);
                            startActivity(inte);
                            finish();

                    }
                }
            });
    }







}