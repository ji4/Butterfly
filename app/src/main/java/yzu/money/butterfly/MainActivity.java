package yzu.money.butterfly;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    int img=0;
    int []images= {
            R.drawable.p0,
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6,
            R.drawable.p7,
            R.drawable.p8,
            R.drawable.p9,
            R.drawable.p10,
            R.drawable.p11,
            R.drawable.p12,
            R.drawable.p13,
            R.drawable.p14,
            R.drawable.p15,
    };
    ImageView iv;

    Handler handler=new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            iv= (ImageView) findViewById(R.id.imageView);
            iv.setImageResource(images[img]);
            img=(img+1)%16;
            handler.postDelayed(this,100);
        }
    };

    @Override
    protected void onDestroy() {
        if(handler!=null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                handler.postDelayed(runnable,30);
            }
        });
    }
}
