package com.arrived1.kiedyprzelew;

import android.text.format.Time;

public class MyTime {
	
	private Time t1 = new Time();
	private Time t2 = new Time();
	
	
	public MyTime(int hour, int min) {
		t1.minute = min;
		t1.hour = hour;
		t2.minute = 0;
		t2.hour = 0;
	}
	
	public MyTime(int hour1, int min1, int hour2, int min2) {
		t1.minute = min1;
		t1.hour = hour1;
		t2.minute = min2;
		t2.hour = hour2;
	}
	
	//TODO: what with t2?
	public int getMin() {
		return t1.minute;
	}
	
	public int getHour() {
		return t1.hour;
	}
}
