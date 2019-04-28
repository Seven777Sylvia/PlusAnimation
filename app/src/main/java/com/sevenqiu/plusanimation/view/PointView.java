package com.sevenqiu.plusanimation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.sevenqiu.plusanimation.util.Util;

/**
 * @author Seven Qiu
 * @date 2019-04-25
 */
public class PointView extends View {

    private PointF point = new PointF(Util.dip2Pixl(50), Util.dip2Pixl(100));

    private Paint mPaint;

    public PointView(Context context) {
        super(context);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(Util.dip2Pixl(30));
    }

    public PointF getPoint() {
        return point;
    }

    public void setPoint(PointF point) {
        this.point = point;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //   canvas.drawPoint(50 + distance, 100 + distance, mPaint);
        canvas.drawPoint(point.x, point.y, mPaint);
    }

}
