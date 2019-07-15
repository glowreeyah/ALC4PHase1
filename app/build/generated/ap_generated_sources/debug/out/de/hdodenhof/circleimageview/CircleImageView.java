package de.hdodenhof.circleimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

class CircleImageView extends View {
    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
