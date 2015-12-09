# RoundRhombusImageView
## Android 圆角菱形图片

**效果图**
    ![IMG](https://github.com/HayDar-Android/RoundRhombusImageView/blob/master/img.png)
### 使用方法：
**布局文件里**
``` xml
     <com.haydar.rrv.RoundRhombusImageView
         android:id="@+id/img"
         android:layout_width="100dp"
         android:layout_height="100dp"
         android:layout_centerInParent="true"
         android:visibility="visible" />
```
**java代码里**
``` java
 RoundRhombusImageView roundRhombusImageView;
```




``` java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    roundRhombusImageView = (RoundRhombusImageView) findViewById(R.id.img);
    roundRhombusImageView.setRound(50);
    roundRhombusImageViewb.setImageBitmap(roundRhombusImageViewb.processImage(roundRhombusImageViewb.scanBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.img))));
}
```