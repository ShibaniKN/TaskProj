package com.uttara.test;

import java.util.Comparator;

public class StartDateComparator implements Comparator<TaskBean> {
	public int compare(TaskBean o1,TaskBean o2)
	 {
		 return (o1.getStartdate()).compareTo(o2.getStartdate());
	 }
}
