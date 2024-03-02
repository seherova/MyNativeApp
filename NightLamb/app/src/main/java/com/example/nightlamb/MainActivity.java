package com.example.nightlamb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permission((this));
        imageView = findViewById(R.id.lamp);


        Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(val == 0){
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 255);
                    val =1;
                }else {
                    Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
                    val=0;
                }

            }
        });

    }
    public void permission(Context c){

        if (Settings.System.canWrite(c)){

        }else{
            Intent i = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            startActivity(i);
        }
    }

}