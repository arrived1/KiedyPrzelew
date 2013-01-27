package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.View;

public class MyButton  implements View.OnClickListener {
	protected Activity actv;
	protected int actvId;
	
	public MyButton(Activity activity_, int activityId_) {
		this.actv = activity_;
		this.actvId = activityId_;
	}

	@Override
	public void onClick(View arg0) { 
	}
}
