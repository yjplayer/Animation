package cn.dev.animation.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by air on 2015/12/24.
 */
public class CustomAnimation extends Animation{

    public static final String TAG = "CustomAnimation";

    private int mFromXType = ABSOLUTE;
    private int mToXType = ABSOLUTE;
    private int mFromYType = ABSOLUTE;
    private int mToYType = ABSOLUTE;

    protected float mFromXValue = 0.0f;
    protected float mToXValue = 0.0f;
    protected float mFromYValue = 0.0f;
    protected float mToYValue = 0.0f;

    protected float mFromXDelta;
    protected float mToXDelta;
    protected float mFromYDelta;
    protected float mToYDelta;

    public CustomAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
                           int fromYType, float fromYValue, int toYType, float toYValue){
        mFromXValue = fromXValue;
        mToXValue = toXValue;
        mFromYValue = fromYValue;
        mToYValue = toYValue;

        mFromXType = fromXType;
        mToXType = toXType;
        mFromYType = fromYType;
        mToYType = toYType;
    }

//    y=ax2
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Log.i(TAG,"applyTransformation"+"\n"+interpolatedTime+"\n"+
                mFromXDelta+"::"+mFromYDelta);
        float dx = mFromXDelta;
        float dy = mFromYDelta;
        if (mFromXDelta != mToXDelta) {
            dx = mFromXDelta + ((mToXDelta - mFromXDelta) * interpolatedTime);
        }
        if (mFromYDelta != mToYDelta) {
//            dy = mFromYDelta + ((mToYDelta - mFromYDelta) * interpolatedTime);
            dy = - dx*dx/1200;
        }
        Log.i(TAG,"applyTransformation"+"\n"+dx+"::"+dy);
        t.getMatrix().setTranslate(dx, dy);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        Log.i(TAG,"initialize");
        mFromXDelta = resolveSize(mFromXType, mFromXValue, width, parentWidth);
        mToXDelta = resolveSize(mToXType, mToXValue, width, parentWidth);
        mFromYDelta = resolveSize(mFromYType, mFromYValue, height, parentHeight);
        mToYDelta = resolveSize(mToYType, mToYValue, height, parentHeight);
    }
}
