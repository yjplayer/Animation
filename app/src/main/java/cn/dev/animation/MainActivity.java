package cn.dev.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cn.dev.animation.animation.TweenActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tweenAnimation(View v){
        startActivity(new Intent(this, TweenActivity.class));
    }

    public void drawableAnimation(View v){

    }

    public void propertyAnimation(View v){

    }

}
