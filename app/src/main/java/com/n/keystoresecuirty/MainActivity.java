package com.n.keystoresecuirty;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author nithin
 */

public class MainActivity  extends AppCompatActivity {
    TextView userTv,before,after;
    SharedPreferences sharedpreferences;
    String user,encyptedKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        try {
            sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

            user=sharedpreferences.getString("User",null);
            encyptedKey=sharedpreferences.getString("EnKey",null); // Key


            userTv=(TextView)findViewById(R.id.user);
            userTv.setText(user);

            before=(TextView)findViewById(R.id.before);
            before.setText(encyptedKey);


            after=(TextView)findViewById(R.id.after);
            after.setText("");

            Button decryptBtn=(Button)findViewById(R.id.decryptBtn);
                decryptBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String key=KeyStoreSecurity.getKey(getApplicationContext());

                        String enc=KeyStoreSecurity.decryptString(key,encyptedKey); // Decrypt Password
                        after.setText(enc);
                    }
                });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
