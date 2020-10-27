package com.uttara.test;

import java.io.BufferedReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.uttara.logger.Logger;

public class TaskBean implements Serializable
{
	private String name;
	private String desc;
	private String startdate;
	private String enddate;
	private String priority;
	private String status;
	private String tags;
	
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate= enddate;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	@Override
	public String toString() {
		return "TaskBean [name=" + name + ", desc=" + desc + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", priority=" + priority + ", status=" + status + ", tags=" + tags + "]";
	}


	public TaskBean()
	{
		//no arg constr
	}
		
	
	public TaskBean(String name, String desc, String startdate, String enddate, String priority, String status,
			String tags) {
		super();
		this.name = name;
		this.desc = desc;
		this.startdate=startdate;
		this.enddate=enddate;
		this.priority = priority;
		this.status = status;
		this.tags = tags;
	}


	@Override
	public int hashCode() {
		
		return (name+desc+startdate+enddate+priority+status+tags).hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskBean other = (TaskBean) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (enddate == null) {
			if (other.enddate  != null)
				return false;
		} else if (!enddate .equals(other.enddate ))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}

public String validate()
{
	if(startdate!=null)
   {
   SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
   sdf.setLenient(false);   // very imp here..
   try {
	Date d=sdf.parse(startdate);
        } 
   catch (ParseException e) {
	
    e.printStackTrace();Logger.getInstance().log(e.toString());
      }
       }//endif
	if(enddate!=null)
	   {
	   SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	   sdf.setLenient(false);   // very imp here..
	   try {
		Date d=sdf.parse(enddate);
	        } 
	   catch (ParseException e) {
		
	    e.printStackTrace();Logger.getInstance().log(e.toString());
	      }
	       }//endif
	return null;
}
}







