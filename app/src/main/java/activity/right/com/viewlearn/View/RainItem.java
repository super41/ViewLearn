package activity.right.com.viewlearn.View;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Xjp on 2017-09-24.
 */
public class RainItem implements OnRainInterface{
    int startX;
    int startY;
    int length;
    float ratio;
    int speed;
    Paint paint;
    int width;
    int height;
    public RainItem(int width,int height){
        this.width=width;
        this.height=height;
        paint=new Paint();
        init();
    }

    public void init(){
        Random random=new Random();
        int r= random.nextInt(256);
        int g=random.nextInt(256);
        int b=random.nextInt(256);
        paint.setARGB(255,r,g,b);
        startX=random.nextInt(width+1);
        startY=random.nextInt(height+1);
        length=30+random.nextInt(30);
        ratio=0.5f+random.nextInt(10);
        speed = 5 + random.nextInt(5);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(startX,startY,startX+length,startY+length*ratio,paint);
    }

    @Override
    public void logic() {
        startX += speed;
        startY+= speed * ratio;
        if(startY> height || startX>width)
            init();
    }
}
