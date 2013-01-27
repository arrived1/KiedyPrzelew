package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class ButtonReset extends MyButton {

	public ButtonReset(Activity activity_, int activityId_) {
		super(activity_, activityId_);
	}
	
	public void onClick(View arg0) { 
		Toast.makeText(actv.getApplicationContext(), "Dziala, button Reset!", Toast.LENGTH_SHORT).show(); 
	}
}
