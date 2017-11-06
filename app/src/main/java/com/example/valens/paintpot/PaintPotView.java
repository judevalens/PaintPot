package com.example.valens.paintpot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Valens on 11/5/17.
 */

public class PaintPotView extends View implements View.OnTouchListener {
    private final int DEFAULT_DOT_SIZE = 10;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 5;
    private int mDotSize;
    private final int DEFAULT_PEN_COLOR = Color.GREEN;
    private int mPenColor;

    private Path mPath;
    private Paint mPaint;

    private ArrayList<Path> mPaths;
    private ArrayList<Paint> mPaints;

    private float mX, mY;

    public PaintPotView(Context context) {
        super(context);
        this.init();

    }

    public PaintPotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.init();
    }


    public PaintPotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();

    }


    private void init() {

        mDotSize = DEFAULT_DOT_SIZE;
        mPenColor = DEFAULT_PEN_COLOR;
        this.mPaths = new ArrayList<Path>();
        this.mPaints = new ArrayList<Paint>();
this.mPath = new Path();
        this.addPath();

        this.mX = this.mY = (float) 0.0;
        this.setOnTouchListener(this);
    }

    private void addPath() {
        mPath = new Path();

        mPaths.add(mPath);

        mPaint = new Paint();
        mPaints.add(mPaint);
        mPaint.setColor(mPenColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mDotSize);
    }

    public int getDotSize() {
        return mDotSize;
    }

    public void setDotsize(int increment) {
        this.mDotSize += increment;
        this.mDotSize = Math.max(mDotSize, MIN_DOT_SIZE);
        this.mDotSize = Math.min(mDotSize, MAX_DOT_SIZE);

    }

    public int getPenColor() {
        return mPenColor;
    }

    public void setPenColor(int PenColor) {
        this.mPenColor = PenColor;
        this.mPaint.setColor(mPenColor);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mPaths.size(); ++i)
            canvas.drawPath(mPaths.get(i), mPaints.get(i));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        mX = motionEvent.getX();
        mY = motionEvent.getY();

        Log.d("Touched", " (" + mX + "," + mY + ")");

        int evnt = motionEvent.getAction();

        if (evnt == motionEvent.ACTION_DOWN){
            this.addPath();
            this.mPath.moveTo(mX, mY);
        }


        if (evnt == motionEvent.ACTION_MOVE)
            this.mPath.lineTo(mX, mY);

        if (evnt == motionEvent.ACTION_UP)


            this.invalidate();

        return true;
    }
}
