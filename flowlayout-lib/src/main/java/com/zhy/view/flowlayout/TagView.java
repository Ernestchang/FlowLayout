package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * model code for add a custom state to custom view.
 * also use #tagView.setDuplicateParentStateEnabled(true) to set parent's state to child,
 * so child can chang state by selector
 */
public class TagView extends FrameLayout implements Checkable
{
    private boolean isChecked;
    private static final int[] CHECK_STATE = new int[]{android.R.attr.state_checked};

    public TagView(Context context)
    {
        super(context);
    }

    public View getTagView()
    {
        return getChildAt(0);
    }

    // add custom state
    @Override
    public int[] onCreateDrawableState(int extraSpace)
    {
        // model code
        int[] states = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked())
        {
            mergeDrawableStates(states, CHECK_STATE);
        }
        return states;
    }


    /**
     * Change the checked state of the view
     *
     * @param checked The new checked state
     */
    @Override
    public void setChecked(boolean checked)
    {
        if (this.isChecked != checked)
        {
            this.isChecked = checked;
            refreshDrawableState();
        }
    }

    /**
     * @return The current checked state of the view
     */
    @Override
    public boolean isChecked()
    {
        return isChecked;
    }

    /**
     * Change the checked state of the view to the inverse of its current state
     */
    @Override
    public void toggle()
    {
        setChecked(!isChecked);
    }


}
