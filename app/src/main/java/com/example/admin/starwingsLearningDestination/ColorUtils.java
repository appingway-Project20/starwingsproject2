package com.example.admin.starwingsLearningDestination;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

/**
 * Created by admin on 7/1/2017.
 */

public class ColorUtils {

    public static int getBackgroundColor(Context context, int instanceNum){
        switch (instanceNum){
            case 0:
                    return ContextCompat.getColor(context, R.color.orange);
            case 1:
                    return ContextCompat.getColor(context,R.color.green);
            case 2:
                    return ContextCompat.getColor(context,R.color.oliveGreen);
            case 3:
                    return ContextCompat.getColor(context, R.color.orange);
            case 4:
                    return ContextCompat.getColor(context,R.color.green);
            case 5:
                    return ContextCompat.getColor(context,R.color.oliveGreen);
            case 6:
                    return ContextCompat.getColor(context, R.color.orange);
            default:
                    return Color.WHITE;

        }
    }
}
