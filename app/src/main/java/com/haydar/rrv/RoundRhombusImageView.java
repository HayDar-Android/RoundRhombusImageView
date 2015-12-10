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
    float w;
    float h;

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
        float radius = (float) (bitmap.getWidth() / 4);
        float radiusa = (float) Math.sqrt(radius * radius + radius * radius);
        Canvas canvas = new Canvas(bmp);
        Matrix matrix = new Matrix();
        matrix.postRotate(-45, bmp.getWidth() / 2, bmp.getHeight() / 2);
        shader.setLocalMatrix(matrix);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        int a = getLayoutParams().width - bmp.getWidth();
        RectF rect = new RectF(0, 0,
                bitmap.getWidth(), bitmap.getHeight());
        canvas.rotate(45, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        canvas.translate(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        float canvasScale = bitmap.getWidth() / (w - (radiusa - radius) * 2);
        canvas.scale(canvasScale, canvasScale);
        canvas.translate(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2);
        canvas.drawRoundRect(rect, radius, radius, paint);
        return bmp;

    }


    /**
     * 缩放图片
     *
     * @param bitmap
     * @return
     */
    public Bitmap scanBitmap(Bitmap bitmap) {
        Bitmap newBitmap;
        int width = bitmap.getWidth();//获取资源位图的宽
        int height = bitmap.getHeight();//获取资源位图的高
        if (width >= height) {      //正方形
            width = height;
        } else {
            height = width;
        }
        float djx = (float) Math.sqrt(width * width + height * height);
        w = getLayoutParams().width;
        h = getLayoutParams().width;
        float scale = w / djx;
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        // 得到新的图片
        newBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return newBitmap;
    }
}
