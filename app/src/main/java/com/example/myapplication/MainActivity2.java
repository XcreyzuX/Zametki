package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
public class MainActivity2 extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv=findViewById(R.id.textView);
        String str = getIntent().getStringExtra("block");
        tv.setText(str);



    }




    /**/
}
public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new MySurfaceView(this));
    }

    class MySurfaceView extends SurfaceView {

        Path path;

        Thread thread = null;
        SurfaceHolder surfaceHolder;
        volatile boolean running = false;

        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Random random;

        public MySurfaceView(Context context) {
            super(context);
            surfaceHolder = getHolder();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);
            paint.setColor(Color.WHITE);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                path = new Path();
                path.moveTo(event.getX(), event.getY());
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                path.lineTo(event.getX(), event.getY());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                path.lineTo(event.getX(), event.getY());
            }

            if (path != null) {
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawPath(path, paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            return true;
        }
    }
}