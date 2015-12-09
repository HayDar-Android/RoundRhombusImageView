package com.haydar.rrv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by gjy on 15/11/23.
 */
public class RoundRhombusImageView extends ImageView {


    private int round = 30;
    private Context context;

    public void setRound(int round) {
        this.round = round;
    }

    public RoundRhombusImageView(Context context) {
        super(context);
        this.context = context;
    }

    public RoundRhombusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public RoundRhombusImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public Bitmap processImage(Bitmap bitmap) {
        Bitmap bmp;
        bmp = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        BitmapShader shader = new BitmapShader(bitmap,
                BitmapShader.TileMode.CLAMP,
                BitmapShader.TileMode.CLAMP);
        float radius = bmp.getWidth() / 4;
        Canvas canvas = new Canvas(bmp);
        Matrix matrix = new Matrix();
        matrix.postRotate(-45, bmp.getWidth() / 2, bmp.getHeight() / 2);
        shader.setLocalMatrix(matrix);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        RectF rect = new RectF(0 + radius / 3, 0 + radius / 3,
                bitmap.getWidth() - radius / 3, bitmap.getHeight() - radius / 3);
        canvas.rotate(45, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        // canvas.drawRect(rect,paint);
        canvas.drawRoundRect(rect, radius, radius, paint);
        return bmp;

    }

    public Bitmap scanBitmap(Bitmap bitmap) {
        Bitmap bitmap1;
        int width = bitmap.getWidth();//获取资源位图的宽
        int height = bitmap.getHeight();//获取资源位图的高
        float w = getLayoutParams().width;
        float h = getLayoutParams().width;
        float scaleWidth = ((float) w) / width;
        float scaleHeight = ((float) h) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return bitmap1;
    }
}
