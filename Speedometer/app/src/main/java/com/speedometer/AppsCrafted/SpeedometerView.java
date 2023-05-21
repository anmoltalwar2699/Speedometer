
package com.speedometer.AppsCrafted;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class SpeedometerView extends View {
    private static final int START_ANGLE = 135;
    private static final int SWEEP_ANGLE = 270;

    private Paint backgroundPaint;
    private Paint foregroundPaint;
    private float speed;

    public SpeedometerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        backgroundPaint = new Paint();
        backgroundPaint.setColor(android.graphics.Color.GRAY);

        foregroundPaint = new Paint();
        foregroundPaint.setColor(android.graphics.Color.RED);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();

        canvas.drawCircle(width / 2, height / 2, width / 2, backgroundPaint);

        RectF rectF = new RectF(0, 0, width, height);

        float sweepAngle = (speed / 100) * SWEEP_ANGLE;

        canvas.drawArc(rectF, START_ANGLE, sweepAngle, true, foregroundPaint);
    }
}



