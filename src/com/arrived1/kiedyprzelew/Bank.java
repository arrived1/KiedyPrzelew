package com.arrived1.kiedyprzelew;

public class Bank {
	private String BankName = "";
	private MyTime timeOut1;
	private MyTime timeOut2;
	private MyTime timeOut3;
	private MyTime timeIn1;
	private MyTime timeIn2;
	private MyTime timeIn3;
	
	//TODO: What with that shit?
	@SuppressWarnings("unused")
	public Bank(String BankName_, 
				MyTime timeOut1_, MyTime timeOut2_, MyTime timeOut3_, 
				MyTime timeIn1_, MyTime timeIn2_, MyTime timeIn3_) {
		String BankName = BankName_;
		MyTime timeOut1 = timeOut1_;
		MyTime timeOut2 = timeOut2_;
		MyTime timeOut3 = timeOut3_;
		MyTime timeIn1 = timeIn1_;
		MyTime timeIn2 = timeIn2_;
		MyTime timeIn3 = timeIn3_;
	}
	
	private int calcullateDifference(MyTime t1, MyTime t2) {
		int min = Math.abs(t1.getMin() - t2.getMin());
		int hour = Math.abs(t1.getHour() - t2.getHour());
		
		return hour * 60 + min;
	}
	
	private int min(int i1, int i2, int i3) {
		return Math.min(Math.min(i1, i2), i3);
	}
	
	public MyTime nearestOutgoingTime(MyTime transferTime) {
		int diff1 = calcullateDifference(transferTime, timeOut1);
		int diff2 = calcullateDifference(transferTime, timeOut2);
		int diff3 = calcullateDifference(transferTime, timeOut3);
		
		int minValue = min(diff1, diff2, diff3);
		
		if(minValue == diff1)
			return timeOut1;
		else if(minValue == diff2)
			return timeOut2;
		else if(minValue == diff3)
			return timeOut3;
		return new MyTime(0, 0);
	}
	
	public MyTime nearestIncomigTime(MyTime transferTime) {
		int diff1 = calcullateDifference(transferTime, timeIn1);
		int diff2 = calcullateDifference(transferTime, timeIn2);
		int diff3 = calcullateDifference(transferTime, timeIn3);
		
		int minValue = min(diff1, diff2, diff3);
		
		if(minValue == diff1)
			return timeIn1;
		else if(minValue == diff2)
			return timeIn2;
		else if(minValue == diff3)
			return timeIn3;
		return new MyTime(0, 0);
	}
	
	public String getName() {
		return BankName;
	}
}
