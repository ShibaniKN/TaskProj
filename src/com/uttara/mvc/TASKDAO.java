package com.uttara.mvc;

import java.util.List;

import com.uttara.test.TaskBean;

public interface TASKDAO {

	public boolean checkifcategoryExists(String name);
	public boolean addTask(TaskBean t,String categoryname);
	public List<TaskBean> listTasks(String categoryname,int no);
	public List<TaskBean> searchTasks(String wd2search,String categoryname);
	public String deleteTask(String taskname,String categoryname);
	public String editTask(String taskname,String categoryname);
}
