package activity.right.com.viewlearn.View;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Xjp on 2017-09-24.
 */
public abstract class BaseView  extends View {

    protected int sleepTime=30;
    private  DrawThread drawThread=null;
    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public BaseView(Context context) {
        super(context);

    }


    public abstract void logic();
    public abstract void subDraw(Canvas canvas);

    @Override
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(drawThread==null){
            drawThread =new DrawThread();
            drawThread.start();
        }else {
            subDraw(canvas);
        }

    }

    class DrawThread extends  Thread{

        @Override
        public void run() {

            while (true){
                postInvalidate();
                logic();
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
