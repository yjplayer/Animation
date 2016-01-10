package cn.dev.animation.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import cn.dev.animation.R;

/**
 * Created by air on 2015/12/25.
 */
public class DrawableActivity extends Activity {

//    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawable);

        ImageView rocketImage = (ImageView) findViewById(R.id.iv);
        rocketImage.setBackgroundResource(R.drawable.da);
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.start();
        Log.i("Drawable","onCreate");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i("Drawable",hasFocus+"");
    }
}
