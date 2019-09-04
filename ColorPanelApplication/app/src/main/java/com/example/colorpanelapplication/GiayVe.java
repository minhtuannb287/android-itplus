package com.example.colorpanelapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GiayVe extends View {

    public GiayVe(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    Path drawPath;
    Paint drawPaint, canvasPaint;
    int drawColor = 0xFF660000; // <=> Color.WHITE :))
    Canvas drawCanvas;
    Bitmap drawBitmap;

    int drawSize = 3;
    private boolean erase = false;

    /*
     * Khởi tạo các đối tượng
     */
    public void init() {
        drawPath = new Path();
        drawPaint = new Paint();
        drawPaint.setColor(drawColor);
        drawPaint.setStrokeWidth(drawSize);
        drawPaint.setStyle(Paint.Style.STROKE);
        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
        drawBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(drawBitmap);
    }

    /*
     * Phương thức vẽ
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(drawBitmap, 0, 0, canvasPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    /*
     * Sự kiện vẽ
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // respond to down, move and up events
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                drawPath.lineTo(event.getX(), event.getY());
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                return false;
        }
        // redraw
        invalidate();
        return true;
    }

    /*
     * Cài đặt màu cho nét vẽ
     */
    public void setColor(String newColor) {
        invalidate();
        drawColor = Color.parseColor(newColor);
        drawPaint.setColor(drawColor);
    }

    // Tẩy nét vẽ trước đó
    public void setErase(boolean isErase) {
        erase = isErase;
        drawPaint.setStrokeWidth(15);
        if (erase)
            drawPaint
                    .setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else
            drawPaint.setXfermode(null);
    }

    // Tạo bản vẽ mới
    public void startNew() {
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }
}
