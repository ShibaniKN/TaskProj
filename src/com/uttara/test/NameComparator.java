package com.uttara.test;

import java.util.Comparator;

public class NameComparator implements Comparator<TaskBean> {

	public int compare(TaskBean o1, TaskBean o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
