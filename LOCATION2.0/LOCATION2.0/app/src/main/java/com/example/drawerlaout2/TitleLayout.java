package com.example.drawerlaout2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TitleLayout extends LinearLayout {

	private ImageView back;
	public TitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.activity_title, this);
		back = (ImageView) findViewById(R.id.iv);
	}

	public ImageView getBackView(){
		if(back!=null){
			return back;
		}
		return null;
	}
}
