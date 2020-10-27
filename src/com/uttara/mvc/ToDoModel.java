package com.uttara.mvc;

import java.util.List;

import com.uttara.dao.DAOfactory;
import com.uttara.test.TaskBean;

public class ToDoModel {
	public boolean checkifcategoryExists(String categoryname)
	{
		TASKDAO dao=DAOfactory.getDAO();
		return dao.checkifcategoryExists(categoryname);
	}
	public boolean addTask(TaskBean t,String categoryname)
	{
		TASKDAO dao=DAOfactory.getDAO();
		return dao.addTask(t,categoryname);
	}
   public List<TaskBean> listTasks(String categoryname,int no)
   {
	   TASKDAO dao=DAOfactory.getDAO();
		return dao.listTasks(categoryname,no);
   }
   public List<TaskBean> searchTasks(String wd2search,String categoryname)
   {
	   TASKDAO dao=DAOfactory.getDAO();
		return dao.searchTasks(wd2search,categoryname);
   }
   public String deleteTask(String taskname, String categoryname) {
	   TASKDAO dao=DAOfactory.getDAO();
		return dao.deleteTask(taskname,categoryname);
	}
   public String editTask(String taskname, String categoryname) {
	   TASKDAO dao=DAOfactory.getDAO();
		return dao.editTask(taskname,categoryname);
	}
}