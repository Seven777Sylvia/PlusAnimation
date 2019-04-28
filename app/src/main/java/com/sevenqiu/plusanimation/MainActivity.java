package com.sevenqiu.plusanimation;

import android.animation.ObjectAnimator;
import android.animation.PointFEvaluator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sevenqiu.plusanimation.util.Util;
import com.sevenqiu.plusanimation.view.ProvinceView;

/**
 * @author Seven Qiu
 * @date 2019-04-25
 */
public class MainActivity extends AppCompatActivity {

    private ProvinceView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mView = findViewById(R.id.view);

/*
        ObjectAnimator radiusAni = ObjectAnimator.ofFloat(mView, "radius", Util.dip2Pixl(50));
        radiusAni.setDuration(200);
        radiusAni.setDuration(1000);
        radiusAni.start();
*/


/*     ObjectAnimator bottomAni = ObjectAnimator.ofFloat(mView, "bottomFlipAngle", 30);
        bottomAni.setDuration(1000);

        ObjectAnimator topAni = ObjectAnimator.ofFloat(mView, "topFlipAngle", -30);
        topAni.setStartDelay(200);
        topAni.setDuration(1000);

        ObjectAnimator rotateAni = ObjectAnimator.ofFloat(mView, "rotateAngle", 270);
        rotateAni.setStartDelay(200);
        rotateAni.setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(bottomAni, rotateAni, topAni);
        animatorSet.setStartDelay(500);
        animatorSet.start();
*/

 /*       float distance = Util.dip2Pixl(300);
        Keyframe keyframe1 = Keyframe.ofFloat(0, 0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, distance * 0.4f);
        Keyframe keyframe3 = Keyframe.ofFloat(0.8f, distance * 0.6f);
        Keyframe keyframe4 = Keyframe.ofFloat(1, distance);
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofKeyframe("distance", keyframe1, keyframe2, keyframe3, keyframe4);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mView, propertyValuesHolder);
        objectAnimator.setStartDelay(200);
        objectAnimator.setDuration(1500);
        objectAnimator.start();
*/

     /*   PointF point = new PointF(Util.dip2Pixl(200), Util.dip2Pixl(500));
        ObjectAnimator pointAni = ObjectAnimator.ofObject(mView, "point", new PointFEvaluator(), point);
        pointAni.setStartDelay(200);
        pointAni.setDuration(1000);
        pointAni.start();*/

        ObjectAnimator provinceAni = ObjectAnimator.ofObject(mView, "province", new Util.ProvinceEvaluator(), "澳门特别行政区");
        provinceAni.setStartDelay(200);
        provinceAni.setDuration(2000);
        provinceAni.start();
    }


}
