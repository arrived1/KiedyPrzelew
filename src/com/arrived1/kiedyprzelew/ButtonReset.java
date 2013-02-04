package com.arrived1.kiedyprzelew;

import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class ButtonReset extends MyButton {

	public ButtonReset(Activity activity_, int activityId_) {
		super(activity_, activityId_);
	}
	
	public void onClick(View arg0) { 
		TextView nastepnegoDnia = (TextView)actv.findViewById(R.id.nextDay);
		nastepnegoDnia.setText("");
		
		TextView pokazCzas = (TextView)actv.findViewById(R.id.deliveryTime);
		pokazCzas.setText("");
		
		Spinner spinn1 = (Spinner)actv.findViewById(R.id.spinnerBank1);
		spinn1.setSelection(0,true);
		Spinner spinn2 = (Spinner)actv.findViewById(R.id.spinnerBank2);
		spinn2.setSelection(0,true);
	}
}
