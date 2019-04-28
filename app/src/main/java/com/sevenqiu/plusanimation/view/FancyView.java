package com.sevenqiu.plusanimation.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.sevenqiu.plusanimation.R;

import static com.sevenqiu.plusanimation.util.Util.dip2Pixl;
import static com.sevenqiu.plusanimation.util.Util.getCameraZ;

/**
 * @author Seven Qiu
 * @date 2019-04-25
 */
public class FancyView extends View {
    private static final float SIZE = dip2Pixl(200);

    private Bitmap mBitmap;
    private Camera mCamera;
    private Point mMiddlePoint;
    private Paint mPaint;
    private Path mUpperPart;
    private Path mLowerPart;

    private float rotateAngle = 0;
    private float topFlipAngle = 0;
    private float bottomFlipAngle = 0;

    private float getRotateAngle() {
        return rotateAngle;
    }

    private void setRotateAngle(float rotateAngle) {
        this.rotateAngle = rotateAngle;
        invalidate();
    }

    private float getTopFlipAngle() {
        return topFlipAngle;
    }

    private void setTopFlipAngle(float topFlipAngle) {
        this.topFlipAngle = topFlipAngle;
        invalidate();
    }

    private float getBottomFlipAngle() {
        return bottomFlipAngle;
    }

    private void setBottomFlipAngle(float bottomFlipAngle) {
        this.bottomFlipAngle = bottomFlipAngle;
        invalidate();
    }

    public FancyView(Context context) {
        super(context);
    }

    public FancyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FancyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = getBitmapInSize((int) SIZE);
        mCamera = new Camera();
        mCamera.setLocation(0, 0, getCameraZ());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mMiddlePoint = new Point(getWidth() / 2, getHeight() / 2);

        mUpperPart = new Path();
        mUpperPart.addRect(-SIZE, -SIZE,
                SIZE, 0, Path.Direction.CW);

        mLowerPart = new Path();
        mLowerPart.addRect(-SIZE, 0, SIZE, SIZE, Path.Direction.CW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //UpperPart
        canvas.save();
        canvas.translate(mMiddlePoint.x, mMiddlePoint.y);
        canvas.rotate(-rotateAngle);
        mCamera.save();
        mCamera.rotateX(topFlipAngle);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.clipPath(mUpperPart);
        canvas.rotate(rotateAngle);
        canvas.translate(-mMiddlePoint.x, -mMiddlePoint.y);
        canvas.drawBitmap(mBitmap, mMiddlePoint.x - SIZE / 2, mMiddlePoint.y - SIZE / 2, mPaint);
        canvas.restore();

        //LowerPart
        canvas.save();
        canvas.translate(mMiddlePoint.x, mMiddlePoint.y);
        canvas.rotate(-rotateAngle);
        mCamera.save();
        mCamera.rotateX(bottomFlipAngle);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.clipPath(mLowerPart);
        canvas.rotate(rotateAngle);
        canvas.translate(-mMiddlePoint.x, -mMiddlePoint.y);
        canvas.drawBitmap(mBitmap, mMiddlePoint.x - SIZE / 2, mMiddlePoint.y - SIZE / 2, mPaint);
        canvas.restore();
    }

    private Bitmap getBitmapInSize(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.tang, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.tang, options);
    }
}
