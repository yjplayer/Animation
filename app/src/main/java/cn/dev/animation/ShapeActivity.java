package cn.dev.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by air on 2016/1/17.
 */
public class ShapeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        log(findViewById(R.id.iv01));
        log(findViewById(R.id.iv02));
        log(findViewById(R.id.iv03));
        log(findViewById(R.id.iv04));
        log(findViewById(R.id.iv05));
    }

    public void log(final View view){
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Log.i("LOG",view.getWidth() + "\t" + view.getHeight());
            }
        });
    }
}
