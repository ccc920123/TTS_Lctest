package com.cdjysd.tts_lctest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cdjysd.ttsloc.utils.TTSUtils;

public class MainActivity extends AppCompatActivity {


    private EditText mEd;
    private Button mSpeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEd=findViewById(R.id.edit);
        mSpeak=findViewById(R.id.speak);


        mSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TTSUtils.getInstance().speak(mEd.getText().toString());


            }
        });




    }


    @Override
    protected void onDestroy() {
        TTSUtils.getInstance().release();
        super.onDestroy();
    }
}
