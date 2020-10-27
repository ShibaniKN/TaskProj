package com.uttara.test;

import java.util.Comparator;

public class DurationComparator implements Comparator<TaskBean> {
	 public int compare(TaskBean o1,TaskBean o2)
	 {
		 return (o2.getEnddate().compareTo(o2.getStartdate()))-(o1.getEnddate().compareTo((o1.getStartdate())));
		   
	 }
}
