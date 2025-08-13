package com.example.demo_java;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ANIMATOR_TEXTVIEW_TEXT = "HELLO WORLD!";

    private ValueAnimator colorAnimator;
    private TextView animatorTextView;
    private Button startAnimatorButton;
    private Button cancelAnimatorButton;
    private Button endAnimatorButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initViews();
        bindClickListener();
        initColorAnimator(5000);
    }



    private void initViews(){
        animatorTextView =findViewById(R.id.hello_world);
        animatorTextView.setText(ANIMATOR_TEXTVIEW_TEXT);

        startAnimatorButton=findViewById(R.id.startAnimatorButton);
        endAnimatorButton=findViewById(R.id.endAnimatorButton);
        cancelAnimatorButton=findViewById(R.id.cancelAnimatorButton);
    }

    private void bindClickListener(){
        startAnimatorButton.setOnClickListener(this);
        endAnimatorButton.setOnClickListener(this);
        cancelAnimatorButton.setOnClickListener(this);
    }


    private void initColorAnimator(long duration){
        colorAnimator=ValueAnimator.ofArgb(Color.RED,Color.BLUE);
        colorAnimator.setDuration(duration);
        colorAnimator.addUpdateListener(animation -> {
            animatorTextView.setTextColor((int) animation.getAnimatedValue());
        });
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (R.id.startAnimatorButton == id){
            if(!colorAnimator.isStarted()){
                colorAnimator.start();
            }
        }else if(R.id.endAnimatorButton==id){
            colorAnimator.end();
        } else if (R.id.cancelAnimatorButton==id) {
            colorAnimator.cancel();
        }
    }
}
