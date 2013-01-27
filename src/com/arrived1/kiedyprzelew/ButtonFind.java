package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class ButtonFind extends MyButton {

	public ButtonFind(Activity activity_, int activityId_) {
		super(activity_, activityId_);
	}
	
	public void onClick(View arg0) {
		Toast.makeText(actv.getApplicationContext(), "Dziala, button Szukaj!", Toast.LENGTH_SHORT).show(); 
	}

}
