package com.n.keystoresecuirty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author nithin
 */

public class Splash extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    String user=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();

        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        user=sharedpreferences.getString("User",null);

        if(user!=null){
            Toast.makeText(getApplicationContext(),"Welcome: "+user,Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
        }else{
            Intent intent = new Intent(this, Register.class);
                startActivity(intent);
                finish();
        }




    }
}