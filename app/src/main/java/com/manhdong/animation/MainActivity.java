package com.manhdong.animation;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button start,stop, rotate, scale, alpha, translate, nextScreen, changeAlpha, moreEffect;
    Animation animation;
    LinearLayout screen1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.animPic);
        start = (Button) findViewById(R.id.btnStart);
        stop = (Button) findViewById(R.id.btnStop);
        alpha = (Button) findViewById(R.id.btnAlpha);
        rotate = (Button) findViewById(R.id.btnRotate);
        scale = (Button) findViewById(R.id.btnScale);
        translate = (Button) findViewById(R.id.btnTranslate);
        nextScreen = (Button) findViewById(R.id.nextScreen);
        changeAlpha = (Button) findViewById(R.id.changeAlpha);
        moreEffect = (Button) findViewById(R.id.moreEffect);
        screen1 = (LinearLayout) findViewById(R.id.screen1);

        img.setBackgroundResource(R.drawable.animation);

        final AnimationDrawable anim = (AnimationDrawable) img.getBackground();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.stop();
            }
        });

//        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
//        screen1.setAnimation(animation);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
                alpha.startAnimation(animation);
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
                rotate.startAnimation(animation);


            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
                scale.startAnimation(animation);
            }
        });
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);
                translate.startAnimation(animation);
            }
        });

        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Screen_2.class);
                //Animation anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_out, R.anim.transition_from_right);
            //    finish();
            }
        });

        changeAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator oAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.change_alpha);
                oAnim.setTarget(changeAlpha);
                oAnim.start();
            }
        });

        moreEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator oAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.more_animator);
                oAnim.setTarget(moreEffect);
                oAnim.start();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.transition);
        screen1.setAnimation(animation);
    }
}

//overwrite onAnimationStart
//overwritependingTransition - để đâu mới chạy?