package cn.dev.animation.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import cn.dev.animation.R;

/**
 * Created by air on 2016/1/10.
 */
public class PropertyActivity extends Activity {

    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_activity);

        imageView = (ImageView) findViewById(R.id.iv);
    }

    public void code1(View view){

        imageView.setPivotX(50);
        imageView.setPivotY(50);

        ObjectAnimator.ofFloat(imageView,"x",0,100).setDuration(2000).start();
        ObjectAnimator.ofFloat(imageView,"y",0,100).setDuration(2000).start();
    }

    public void xml(View view){
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animatorset);
        animator.setTarget(imageView);
        animator.start();
    }

    public void propertyValuesHolder(View view){
        PropertyValuesHolder x = PropertyValuesHolder.ofFloat("x", 0, 100);
        PropertyValuesHolder y = PropertyValuesHolder.ofFloat("y", 0, 100);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f);
//        PropertyValuesHolder rotationX = PropertyValuesHolder.ofFloat("rotationX", 0, 360f);
        ObjectAnimator.ofPropertyValuesHolder(imageView,x,y,
                scaleX,scaleY).setDuration(3000).start();
    }

    public void keyframe(View view){
        Keyframe a = Keyframe.ofFloat(0, 0);
        Keyframe b = Keyframe.ofFloat(0.5f, 50);
        Keyframe c = Keyframe.ofFloat(1.0f, 100);

        PropertyValuesHolder x = PropertyValuesHolder.ofKeyframe("x", a, b, c);
        PropertyValuesHolder y = PropertyValuesHolder.ofKeyframe("y", a, b, c);
        ObjectAnimator.ofPropertyValuesHolder(imageView,x,y).setDuration(3000).start();
    }

    public void valueAnimator(View view){
        final ImageView ball = (ImageView) findViewById(R.id.iv01);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.setDuration(3000);
        valueAnimator.setTarget(ball);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                ball.setX(animatedValue);
                ball.setY((1.0f/50)*animatedValue*animatedValue);
                Log.i(TAG,ball.getX() + "\t"+ ball.getY());
            }
        });
        valueAnimator.start();
    }

    public static final String TAG = "PropertyActivity";
}
