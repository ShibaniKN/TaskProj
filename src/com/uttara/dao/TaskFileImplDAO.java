package com.uttara.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.uttara.logger.Logger;
import com.uttara.mvc.Constants;
import com.uttara.mvc.TASKDAO;
import com.uttara.test.DurationComparator;
import com.uttara.test.EndDateComparator;
import com.uttara.test.NameComparator;
import com.uttara.test.StartDateComparator;
import com.uttara.test.TaskBean;

public class TaskFileImplDAO implements TASKDAO 
{
	String categoryname;
	String taskname;
	String desc,priority,status,tags;
	String enddate,startdate;
	String wd2search;
    String msg;
    
	
	public boolean checkifcategoryExists(String name) 
	{
		File f=new File(Constants.PATH+name+".txt");
		if(f.exists()==true)
		{
			return true;
		}
		else
       {
    	   File file=new File(Constants.PATH+name+".txt");
    	   try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();Logger.getInstance().log(e.toString());
		}
       }
		return false;
		}
	
	public boolean addTask(TaskBean t, String categoryname)
	{
	BufferedWriter bw=null;
	try
	{
    bw=new BufferedWriter(new FileWriter(Constants.PATH+categoryname+".txt",true));	
    bw.write(t.getName()+" : "+t.getDesc()+" : "+t.getStartdate()+" : "+t.getEnddate()+" : "+t.getPriority()+" : "+t.getStatus()+" : "+
    t.getTags());
    bw.newLine();
   
	}
	
	catch(IOException io)
	{
		io.printStackTrace();Logger.getInstance().log(io.toString());
	}
	finally
	{
		if(bw!=null)
		{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Logger.getInstance().log(e.toString());
			}
			
		}
	}
	 return true;
	}

	
	public List<TaskBean> listTasks(String categoryname,int no) 
	{
		List<TaskBean> al=new ArrayList<TaskBean>();
		String line;
		
		
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(Constants.PATH+categoryname+".txt"));
			
			while((line=br.readLine())!=null)
			{ 
				String sa[]=line.split(" : ");
			
		TaskBean b=new TaskBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
			al.add(b);
			
			}
			
			

			} 
		catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();Logger.getInstance().log(io.toString());
		}
		finally
		{
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();Logger.getInstance().log(e.toString());
				}
			}
		}
		if(no==1)
		{
		Collections.sort(al,new NameComparator());
		return al;
		}
	else if(no==2)
	{
		Collections.sort(al,new EndDateComparator());
		return al;
	}
	else if(no==3)
	{
		Collections.sort(al,new StartDateComparator());
		return al;
	}
	else
		{
			Collections.sort(al,new DurationComparator());
			return al;
		}
		
		
				
	}
	public List<TaskBean> searchTasks(String wd2search,String categoryname)
	{
		List<TaskBean> list=new ArrayList<TaskBean>();
		String line;
		int count=0;
		
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(Constants.PATH+categoryname+".txt"));
			
			while((line=br.readLine())!=null)
			{ 
				if(line.contains(wd2search))
				{
	       String  sa[]=line.split(" : ");
	        
		TaskBean b=new TaskBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
			list.add(b);
			
				/*for(int i=0;i<list.size();i++){
		            for(int j=0;j<sa.length;j++){
		                if(list.get(i).equals(sa[j])){
		                    count++;
		                }
		            }
		            System.out.println("Occurrence of " + list.get(i) + " is " + count + " times.");
		            count=0;	
		}
			/*int numofocc=Collections.frequency(list, wd2search);
			System.out.println("the no of occ of wd2search found are "+numofocc);*/
			}
		}
		}
		catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();
			Logger.getInstance().log(io.toString());
		}
		finally
		{
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();Logger.getInstance().log(e.toString());
				}
			}
		}
		return list;
		}//method search close

	@Override
	public String deleteTask(String taskname, String categoryname) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		String line;
		List<TaskBean> l=new ArrayList<TaskBean>();
				try
		       {
			 br=new BufferedReader(new FileReader(Constants.PATH+categoryname+".txt"));
			 while((line=br.readLine())!=null)
			 {
				     String sa[]=line.split(" : ");
					TaskBean b=new TaskBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
					if(!sa[0].equals(taskname))
					{
						l.add(b);
					}
				 
			 }//while ends here
			 for(TaskBean t:l)
				{
				bw=new BufferedWriter(new FileWriter(Constants.PATH+categoryname+".txt"));
				
				bw.write(t.getName()+" : "+t.getDesc()+" : "+t.getStartdate()+" : "+t.getEnddate()+" : "+t.getPriority()+" : "+t.getStatus()+" : "+
					    t.getTags());
				bw.newLine();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Logger.getInstance().log(e.toString());
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.getInstance().log(e.toString());
				}
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.getInstance().log(e.toString());
				}
			}
		}
				return Constants.SUCCESS;
	}

	@Override
	public String editTask(String taskname, String categoryname) {
		BufferedReader br=null;
		BufferedWriter bw=null;
		String line;
		boolean bl=false;
		Scanner sc2=new Scanner(System.in);
		List<TaskBean> l=new ArrayList<TaskBean>();
				try
		       {
			 br=new BufferedReader(new FileReader(Constants.PATH+categoryname+".txt"));
			 while((line=br.readLine())!=null)
			 {
				     String sa[]=line.split(" : ");
					TaskBean b=new TaskBean(sa[0],sa[1],sa[2],sa[3],sa[4],sa[5],sa[6]);
					if(!sa[0].equals(taskname))
					{
						l.add(b);
					}
					else
					{
						bl=true;
						System.out.println("Enter what you want to edit in task name/desc/startdate/enddate/status/priority/tags");
						String sel=sc2.nextLine();
						switch(sel)
						{
						case "taskname":System.out.println("enter the new taskname to edit");
						            String newname=sc2.nextLine();
						            b.setName(newname);
						            l.add(b);
						            break;
						case "desc":System.out.println("enter the new taskdesc to edit");
			            String newdesc=sc2.nextLine();
			            b.setDesc(newdesc);
			            l.add(b);
			            break;
						case "startdate":System.out.println("enter the new startdate to edit");
			            String newstartdate=sc2.nextLine();
			            b.setStartdate(newstartdate);
			            l.add(b);
			            break;
						case "enddate":System.out.println("enter the new enddate to edit");
			            String newenddate=sc2.nextLine();
			            b.setEnddate(newenddate);
			            l.add(b);
			            break;
						case "status":System.out.println("enter the new status to edit");
			            String newstatus=sc2.nextLine();
			            b.setStatus(newstatus);
			            l.add(b);
			            break;
						case "priority":System.out.println("enter the new priority to edit");
			            String newpriority=sc2.nextLine();
			            b.setPriority(newpriority);
			            l.add(b);
			            break;
						case "tags":System.out.println("enter the new tag to edit");
			            String newtags=sc2.nextLine();
			            b.setTags(newtags);
			            l.add(b);
			            break;
						default:System.out.println("option not supported yet");
						break;
						}
						
						
					}
					
				 
			 }//while ends here
			 for(TaskBean t:l)
				{
				bw=new BufferedWriter(new FileWriter(Constants.PATH+categoryname+".txt"));
				
				bw.write(t.getName()+" : "+t.getDesc()+" : "+t.getStartdate()+" : "+t.getEnddate()+" : "+t.getPriority()+" : "+t.getStatus()+" : "+
					    t.getTags());
				bw.newLine();
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Logger.getInstance().log(e.toString());
		}
		finally
		{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.getInstance().log(e.toString());
				}
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.getInstance().log(e.toString());
				}
			}
		}
		
		return Constants.SUCCESS;
	}
	
	}//class fileimpl close
