package cn.dev.animation.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import cn.dev.animation.R;

/**
 * Created by air on 2015/12/23.
 */
public class AnimationTest extends Activity {

    public LinearLayout ll1;
    public LinearLayout ll2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ll1 = (LinearLayout) findViewById(R.id.ll_01);
        ll2 = (LinearLayout) findViewById(R.id.ll_02);
    }

    public void click(View v){
        TranslateAnimation translateAnimationExit = new TranslateAnimation(Animation.ABSOLUTE,0,Animation.RELATIVE_TO_PARENT,-1.0f,
        Animation.ABSOLUTE,0,Animation.ABSOLUTE,0);
        translateAnimationExit.setDuration(300);
        translateAnimationExit.setFillAfter(true);
        TranslateAnimation translateAnimationEnter = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,1.0f,Animation.RELATIVE_TO_PARENT,0,
                Animation.ABSOLUTE,0,Animation.ABSOLUTE,0);
        translateAnimationEnter.setDuration(300);
        translateAnimationEnter.setFillAfter(true);

        ll1.startAnimation(translateAnimationExit);
        ll2.startAnimation(translateAnimationEnter);
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.VISIBLE);
    }
}
