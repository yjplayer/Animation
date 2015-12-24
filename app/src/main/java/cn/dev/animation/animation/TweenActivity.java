package cn.dev.animation.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import cn.dev.animation.R;

/**
 * Created by air on 2015/12/23.
 */
public class TweenActivity extends Activity {

    public ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tween);
        mImageView = (ImageView) findViewById(R.id.image_tween);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TweenActivity.this,"click me",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void custom(View view){
        CustomAnimation customAnimation = new CustomAnimation(
                Animation.RELATIVE_TO_PARENT,0, Animation.RELATIVE_TO_PARENT,0.8f,
                Animation.ABSOLUTE,1.0f, Animation.RELATIVE_TO_PARENT,-1.0f
        );
        customAnimation.setDuration(1500);
        customAnimation.setFillAfter(true);
        mImageView.startAnimation(customAnimation);
    }

    /**
     * 0.0全透明
     * 1.0不透明
     * @param view
     */
    public void alpha(View view){
//        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
//        alphaAnimation.setDuration(3000);
//        mImageView.startAnimation(alphaAnimation);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        mImageView.startAnimation(animation);
    }

    public void rotate(View view){
//        RotateAnimation rotateAnimation = new RotateAnimation(0,360,
//                Animation.RELATIVE_TO_PARENT,0.3f,
//                Animation.RELATIVE_TO_PARENT,0.3f);
//        rotateAnimation.setDuration(3000);
//        mImageView.startAnimation(rotateAnimation);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        mImageView.startAnimation(animation);
    }

    public void scale(View view){
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,
//                Animation.RELATIVE_TO_SELF,0.5f,
//                Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setDuration(3000);
//        mImageView.startAnimation(scaleAnimation);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        mImageView.startAnimation(animation);
    }

    public void translate(View view){
//        TranslateAnimation translateAnimation = new TranslateAnimation(
//                Animation.ABSOLUTE,0, Animation.ABSOLUTE,300,
//                Animation.ABSOLUTE,0, Animation.ABSOLUTE,-300
//        );
//        translateAnimation.setDuration(3000);
//        translateAnimation.setFillAfter(true);
//        mImageView.startAnimation(translateAnimation);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        mImageView.startAnimation(animation);
    }

}
