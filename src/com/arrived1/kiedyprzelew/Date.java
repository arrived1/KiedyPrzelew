package com.arrived1.kiedyprzelew;

class Date {
	private int h;
	private int m;
	private Boolean nextDay = false;
	
	public Date() {
		this.h = 0;
		this.m = 0;
	}
	
	public Date(int h, int m) {
		this.h = h;
		this.m = m;
	}
	
	public Date(String t) {
		String[] hourAndMin = t.split(":");
		this.h = Integer.parseInt(hourAndMin[0]);
		this.m = Integer.parseInt(hourAndMin[1]);
	}
	
	public Date(Date d) {
		h = d.h;
		m = d.m;
		nextDay = d.nextDay;
	}
	
	public void setNextDay(Boolean day) {
		nextDay = day;
	}
	
	public Boolean isNextDay() {
		return nextDay;
	}
	
	public Boolean greaterEqualThan(Date t) {
		if((h >= t.h) || (h == t.h && m >= t.m))
			return true;
		return false;
	}
	
	public Boolean lessThan(Date t) {
		if((h < t.h) || (h == t.h && m < t.m))
			return true;
		return false;
	}
	
	public String toString() {
		String txt = Integer.toString(h) + ":";
		if(m == 0)
			txt += "00";
		else
			txt += Integer.toString(m);
		return txt; 
	}
}
