package com.arrived1.kiedyprzelew;

class Date {
	public int h;
	public int m;
	
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
	
	public Boolean equal(Date t) {
		if(h == t.h && m == t.m)
			return true;
		return false;
	}
	
	public Boolean greaterThan(Date t) {
		if((h > t.h) || (h == t.h && m > t.m))
			return true;
		return false;
	}
	
	public Boolean lessThan(Date t) {
		if((h < t.h) || (h == t.h && m < t.m))
			return true;
		return false;
	}
}
