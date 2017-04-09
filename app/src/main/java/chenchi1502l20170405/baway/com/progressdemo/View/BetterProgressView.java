package chenchi1502l20170405.baway.com.progressdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 陈驰 on 2017/4/8.
 */

public class BetterProgressView extends View {
    private String text="";
    private int max=100;
    private int progress;
    public BetterProgressView(Context context) {
        super(context);

    }

    public BetterProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BetterProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
      paint.setStyle(Paint.Style.STROKE);

        paint.setAntiAlias(true);

        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,getMeasuredWidth()/2, paint);

        RectF rectF=new RectF(0,0,getMeasuredWidth(),getMeasuredHeight());
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        //绘制圆弧不使用中间点 0-360
       canvas.drawArc(rectF,0,360*progress/max,false,paint);

       //绘制文本 1%-100%
        Rect rect=new Rect();
        paint.setTextSize(30);
        //获取文字的 宽和高，设置给矩形，通过矩形获取
        paint.getTextBounds(text,0,text.length(),rect);

        paint.setColor(Color.BLACK);
        //绘制文本
      canvas.drawText(text,getMeasuredWidth()/2-rect.width()/2,getMeasuredWidth()/2+rect.height()/2,paint);
    }
    public  void setMax(int max){
        this.max=max;
    }
    /*
    * 设置当前进度和中心的文本内容
    * */
public  void setProgressAndText(int progress,String text){
   this.progress=progress;
    this.text=text;
    //重新绘制
    postInvalidate();
}
    //初始化文本内容
    public  void initText(String text){
        this.text=text;
    }
}
