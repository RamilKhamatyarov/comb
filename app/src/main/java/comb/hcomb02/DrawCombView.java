package comb.hcomb02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Asus on 26.08.2016.
 */
// http://stackoverflow.com/questions/16650419/draw-in-canvas-by-finger-android
class DrawCombView extends View {

    public int width;
    public int height;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint bitmapPaint;
    private Path path;
    Context context;
    private Paint circlePaint;
    private Path circlePath;

    Paint paint;

    public DrawCombView (Context context) {
        super(context);
        this.context = context;
        path = new Path();
        bitmapPaint = new Paint(Paint.DITHER_FLAG);
        circlePath = new Path();
        circlePaint = new Paint();
        bitmapPaint.setAntiAlias(true);
        circlePaint.setColor(Color.BLUE);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeJoin(Paint.Join.MITER);
        circlePaint.setStrokeWidth(3f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
        canvas.drawPath(path, paint);
        canvas.drawPath(circlePath, circlePaint);
    }

    private float x0, y0;
    private static final float TOUCH_TOLERANCE = 4;

    private void touchStart(float x, float y) {
        path.reset();
        path.moveTo(x, y);
        x0 = x; y0 = y;
    }
    private void touchMove(float x, float y) {
        float dx = Math.abs(x - x0);
        float dy = Math.abs(y - y0);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            path.quadTo(x0, y0, (x + x0)/2, (y + y0)/2);
            x0 = x; y0 = y;

            circlePath.reset();
            circlePath.addCircle(x0, y0, 30, Path.Direction.CW);
        }
    }

    private void touchUp() {
        path.lineTo(x0, y0);
        circlePath.reset();
        canvas.drawPath(path, paint); //commit the path to our offscreen
        path.reset(); // kill this so we don't double draw
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp();
                invalidate();
                break;
        }
        return true;
    }

    public void initPaint(){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(12);
    }
}
