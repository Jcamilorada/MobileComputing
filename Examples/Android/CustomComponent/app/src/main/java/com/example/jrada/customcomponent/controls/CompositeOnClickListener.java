package com.example.jrada.customcomponent.controls;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern implementation. Enable multiple Click listeners.
 *
 * @author Juan Rada
 */
public class CompositeOnClickListener implements View.OnClickListener
{
    List<View.OnClickListener> listeners = new ArrayList<>(10);

    public CompositeOnClickListener(int capacity)
    {
        listeners = new ArrayList<>(capacity);
    }

    public void addOnClickListener(View.OnClickListener listener)
    {
        listeners.add(listener);
    }

    @Override
    public void onClick(View v)
    {
        for(View.OnClickListener listener : listeners)
        {
            listener.onClick(v);
        }
    }
}
