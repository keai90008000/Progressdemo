package chenchi1502l20170405.baway.com.progressdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import chenchi1502l20170405.baway.com.progressdemo.View.BetterProgressView;

public class MainActivity extends AppCompatActivity {

  //  private ProgressView progress;
    private BetterProgressView progressView;

   private int max=1000;
    private int progress=max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   progress = (ProgressView) findViewById(R.id.progressView);
        progressView = (BetterProgressView) findViewById(R.id.progressView);
        progressView.initText(progress+"米");
        progressView.setMax(max);
    }
    public  void start(View view){
       // progress.start();
        progress=max;
       new Thread(){
           @Override
           public void run() {
               super.run();
               while (true){
                   //更新进度和文字
                   progress--;
             progressView.setProgressAndText(progress,progress+"米");
                   //控制进度

                   try {
                       sleep(50);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   if (progress==0){
                       break;
                   }
               }
           }
       }.start();
    }
}
