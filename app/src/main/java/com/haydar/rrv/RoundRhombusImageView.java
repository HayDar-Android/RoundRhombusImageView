package com.haydar.rrv;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by gjy on 15/11/23.
 */
public class RoundRhombusImageView extends ImageView {


    private int round = 10;

    public void setRound(int round) {
        this.round = round;
    }

    public RoundRhombusImageView(Context context) {
        super(context);
    }

    public RoundRhombusImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundRhombusImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Bitmap processImage(Bitmap bitmap) {
        Bitmap bmp;
        float w = bitmap.getWidth();
        float h = bitmap.getHeight();
        bmp = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        BitmapShader shader = new BitmapShader(bitmap,
                BitmapShader.TileMode.CLAMP,
                BitmapShader.TileMode.CLAMP);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);
        Path path = new Path();
        path.moveTo(w / 2 - round, round);
        path.cubicTo(w / 2 - round, round, w / 2, 0, w / 2 + round, round);
        path.lineTo(w - round, h / 2 - round);
        path.cubicTo(w - round, h / 2 - round, w, h / 2, w - round, h / 2 + round);
        path.lineTo(w / 2 + round, h - round);
        path.cubicTo(w / 2 + round, h - round, w / 2, h, w / 2 - round, h - round);
        path.lineTo(0 + round, h / 2 + round);
        path.cubicTo(0 + round, h / 2 + round, 0, h / 2, 0 + round, h / 2 - round);
        path.moveTo(0 + round, h / 2 - round);
        path.lineTo(w / 2 - round, round);
        canvas.drawPath(path, paint);
        return bmp;

    }

}
