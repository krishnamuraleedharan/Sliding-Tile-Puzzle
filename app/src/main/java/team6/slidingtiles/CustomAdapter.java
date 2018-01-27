package com.example.samanoudy.sample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by samanoudy on 1/25/18.
 */

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Button> mButtons;
    private int mColumnWidth, mColumnHeight;

    public CustomAdapter(ArrayList<Button> buttons, int columnWidth, int columnHeight) {
        mButtons = buttons;
        mColumnHeight=columnHeight;
        mColumnWidth=columnWidth;
    }

    @Override
    public int getCount() {
        return mButtons.size();
    }

    @Override
    public Object getItem(int i) {
        return (Object) mButtons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        if(view == null){
            button=mButtons.get(i);
        }
        else{
            button= (Button) view;
        }

        android.widget.AbsListView.LayoutParams params=
                new android.widget.AbsListView.LayoutParams(mColumnWidth, mColumnHeight);
        button.setLayoutParams(params);

        return button;
    }
}
