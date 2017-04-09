package chenchi1502l20170405.baway.com.progressdemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 陈驰 on 2017/4/8.
 */

public class ProgressView extends View {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                if (progress<100){

                progress++;
                invalidate();
                sendEmptyMessageDelayed(1,10);

                }
            }
        }
    };
    private int progress;
    public ProgressView(Context context) {
        super(context);

    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
      //  paint.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        canvas.drawCircle(100,100,100, paint);
        RectF rectF=new RectF(0,0,200,200);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        //绘制圆弧不使用中间点 0-360
      //  canvas.drawArc(rectF,0,360*progress/100,false,paint);
        canvas.drawArc(rectF,0,360*progress/100,true,paint);
        String text=progress+"%";
        //绘制文本 1%-100%
        Rect rect=new Rect();
        paint.setTextSize(30);
        //获取文字的 宽和高，设置给矩形，通过矩形获取
        paint.getTextBounds(text,0,text.length(),rect);

        paint.setColor(Color.BLACK);
        //绘制文本
     //   canvas.drawText(text,100-rect.width()/2,100+rect.height()/2,paint);
    }
    public void start(){
        progress=0;
        handler.sendEmptyMessageDelayed(1,10);
    }
}
