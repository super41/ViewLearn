package activity.right.com.viewlearn.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xjp on 2017-09-24.
 */
public class RainView extends BaseView{


    private  final  static String TAG="RainView";
    List<RainItem> list;

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.BLACK);
        list=new ArrayList<>();


    }

    public RainView(Context context) {
        super(context);
        this.setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        for(int i=0; i<50 ;i++) {
         RainItem   rainItem = new RainItem(getWidth(), getHeight());
            list.add(rainItem);
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void logic() {
        for(RainItem rainItem : list)
            rainItem.logic();
    }

    @Override
    public void subDraw(Canvas canvas) {
        for(RainItem rainItem : list)
            rainItem.draw(canvas);
    }
}
