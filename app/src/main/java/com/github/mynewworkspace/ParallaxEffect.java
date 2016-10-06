package com.github.mynewworkspace;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/10/6.
 */

public class ParallaxEffect extends ListView {
    private ImageView iv;
    private int intrinsicHeight;
    private int originalHeight;

    public ParallaxEffect(Context context) {
        this(context,null);
    }

    public ParallaxEffect(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public ParallaxEffect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
            if (isTouchEvent){
                if (deltaY<0){
                int newHeight=iv.getLayoutParams().height+Math.abs(deltaY);
                    if (newHeight>intrinsicHeight*0.66f){
                        newHeight= (int) (intrinsicHeight*0.66f);
                    }
                    iv.getLayoutParams().height=newHeight;
                    iv.requestLayout();
                }
            }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    public void setImageView(ImageView imageView) {
        this.iv = imageView;
        Drawable drawable = iv.getDrawable();
        intrinsicHeight = drawable.getIntrinsicHeight();
        originalHeight = iv.getLayoutParams().height;
    }
}
