package com.uttara.test;

import java.util.Comparator;

public class EndDateComparator implements Comparator<TaskBean> {

	 public int compare(TaskBean o1,TaskBean o2)
	 {
		 return (o1.getEnddate()).compareTo(o2.getEnddate());
	 }
}
