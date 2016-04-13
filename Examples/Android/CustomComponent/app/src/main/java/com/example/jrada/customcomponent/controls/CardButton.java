package com.example.jrada.customcomponent.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.jrada.customcomponent.R;

/**
 * CardButton Custom control implementation.
 *
 * @author Juan Rada
 */
public class CardButton extends Button
{
    private CompositeOnClickListener compositeOnClickListener = new CompositeOnClickListener(2);

    private boolean open = false;

    private int backColor;
    private int frontColor;

    @Override
    public void setOnClickListener(OnClickListener clickListener)
    {
        compositeOnClickListener.addOnClickListener(clickListener);
    }

    public CardButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardButton, 0, 0);
        this.backColor = typedArray.getColor(
                R.styleable.CardButton_backColor, getResources().getColor(android.R.color.darker_gray));
        this.frontColor = typedArray.getColor(
                R.styleable.CardButton_frontColor, getResources().getColor(android.R.color.darker_gray));

        this.setBackgroundColor(backColor);
        super.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (CardButton.this.open)
                {
                    open = false;
                    CardButton.this.setBackgroundColor(backColor);
                }

                else
                {
                    CardButton.this.open = true;
                    CardButton.this.setBackgroundColor(frontColor);
                }
            }
        });
    }
}
