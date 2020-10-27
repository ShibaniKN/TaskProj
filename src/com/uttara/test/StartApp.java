package com.uttara.test;



import java.io.File;

import java.util.List;
import java.util.Scanner;

import com.uttara.logger.Logger;
import com.uttara.mvc.Constants;
import com.uttara.mvc.TaskUtil;
import com.uttara.mvc.ToDoModel;

public class StartApp {
	
	
	

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		int ch=0;
		int ch1=0;
		int ch2=0;
		String categoryname,taskname = null;
		String wd2search = null;
		
		String name,desc,priority,status,tags;
		String startdate,enddate;
		int no=0;
		ToDoModel model=new ToDoModel();
		
		try{
			while(ch!=5)
			{
			System.out.println("Press 1 to create category");
			System.out.println("Press 2 to load category");
			System.out.println("Press 3 to search category");
			System.out.println("Press 4 to list category");
			System.out.println("Press 5 to exit");
			System.out.println("Enter choice");
			ch=sc1.nextInt();
			System.out.println("The choice entered is= "+ch);
			switch(ch)
          {
          case 1:System.out.println("Enter category name");
          categoryname=sc2.nextLine();
          if(model.checkifcategoryExists(categoryname))
			{
				System.out.println("Category "+categoryname+" already exists! Choose another!!");
				break;
			}
			else
			{
				//category does not exist...show next menu...
				System.out.println("category does not exist..."+model.checkifcategoryExists(categoryname)+" "+categoryname+" created");
				
			}
          
          while(ch!=6)
          {
        	  System.out.println(" Press 1 to Add a Task!");
			  System.out.println(" Press 2 to Edit a Task!");
			  System.out.println("Press 3 to Remove a Task!");
			  System.out.println("Press 4 to List the Tasks!");
			  System.out.println("Press 5 to Search!");
			  System.out.println("Press 6 to Go back!");
			  System.out.println("Enter choice");
			  ch1=sc1.nextInt();
			  System.out.println("the entered choice is= "+ch1);
			  switch(ch1)
			  {
			  case 1: System.out.println("enter the name of the task to be added");
			  name=sc2.nextLine();
				 
				  System.out.println("enter the desc of the task to be added");
				  desc=sc2.nextLine();
				  System.out.println("enter the startdate of the task to be added dd/MM/yyyy");
				  startdate = sc2.nextLine();
				  
				  System.out.println("enter the enddate of the task to be added");
				  enddate = sc2.nextLine();
				  
				  System.out.println("enter the priority of the task to be added");
				  priority=sc2.nextLine();
				  System.out.println("enter the status of the task to be added");
				  status=sc2.nextLine();
				  System.out.println("enter the tags of the task to be added");
				  tags=sc2.nextLine();
				  TaskBean bean=new TaskBean(name,desc,startdate,enddate, priority,status,tags);
				  //model.addTask(bean,categoryname);
				  Boolean msg = model.addTask(bean,categoryname);
				  if(msg==true)
				  System.out.println("added successfully");// indicates addition succeeded, show msg to user!
				  else
				  System.out.println("false"); // display error msg to user!
				  break;
			  
			  case 2:
				  System.out.println("Enter the category name from which you want to edit");
				  categoryname=sc2.nextLine();
				  System.out.println("Enter the taskname you want to edit");
				  taskname=sc2.nextLine();
				  String s2=model.editTask(taskname, categoryname);
				  System.out.println(s2);
				  
			        break;
			  case 3:
				  System.out.println("enter the category name to delete");
				  categoryname=sc2.nextLine();
				  System.out.println("enter the taskname to delete");
				  taskname=sc2.nextLine();
				  String s1=model.deleteTask(taskname, categoryname);
				  System.out.println(s1);
				  
				  
			       break;
			  case 4:while(ch!=5){
				     
				     System.out.println("---------------------------------------------------");
				     System.out.println("Enter 1 to list tasks by alphabetical listing by name");
			         System.out.println("Enter 2 to list tasks by due date");
			         System.out.println("Enter 3 to list tasks by created date");
			         System.out.println("Enter 4 to list tasks by longest time");
			         System.out.println("Enter 5 to Go Back");
			         System.out.println("--------------------------------------------------------");
			         System.out.println("Enter choice");
			          ch=sc1.nextInt();
			        
			         switch(ch)
			         {
			         case 1:List<TaskBean> al=model.listTasks(categoryname,1);
			                for(TaskBean tb:al)
				    	        System.out.println("Name: "+tb.getName()+"  Description: "+tb.getDesc()+" Start Date: "+tb.getStartdate()+"  End Date: "+tb.getEnddate()+"  Tags: "+tb.getTags()+"  Status: "+tb.getStatus()+" Priority: "+tb.getPriority());
			        	   break;
			         case 2:List<TaskBean> al1=model.listTasks(categoryname,2);
			                for(TaskBean tb:al1)
			                	System.out.println("Name: "+tb.getName()+"  Description: "+tb.getDesc()+" Start Date: "+tb.getStartdate()+" End Date: "+tb.getEnddate()+" Tags: "+tb.getTags()+" Status: "+tb.getStatus()+" Priority: "+tb.getPriority());
			        	   break;
			         case 3:List<TaskBean> al2=model.listTasks(categoryname,3);	
			               for(TaskBean tb:al2)
			            	   System.out.println("Name: "+tb.getName()+"  Description: "+tb.getDesc()+"  Start Date: "+tb.getStartdate()+" End Date: "+tb.getEnddate()+" Tags: "+tb.getTags()+"  Status: "+tb.getStatus()+"  Priority: "+tb.getPriority());
			        	   break;
			         case 4:List<TaskBean> al3=model.listTasks(categoryname,4);
			               for(TaskBean tb:al3)
			            	   System.out.println("Name: "+tb.getName()+"  Description: "+tb.getDesc()+" Start Date: "+tb.getStartdate()+"End Date: "+tb.getEnddate()+" Tags: "+tb.getTags()+" Status: "+tb.getStatus()+" Priority: "+tb.getPriority());
			        	   break;
			         case 5: break;   
			         default:System.out.println("Enter a valid choice.. Enter number between 1 and 5");
			        	   break;
			         }
			  }
			         break;
				 
			  case 5:
				  System.out.println("enter the categoryname for search");
				  categoryname=sc2.nextLine();
				  System.out.println("enter the word to search");
				  wd2search=sc2.nextLine();
				  List<TaskBean> s=model.searchTasks(wd2search,categoryname);
			      System.out.println(s);
			     
			  }
          }
          //loading of files
          case 2:System.out.println("Enter the category name to load");
                categoryname=sc2.nextLine();
                
                //ch2=sc1.nextInt();
                if(model.checkifcategoryExists(categoryname))
                {
                	 ch2=0;  
               	  while(ch2!=6)   
               	  {
               		System.out.println("Enter 1 to add task");  
               		System.out.println("Enter 2 to edit task");
               		System.out.println("Enter 3 to remove task");
               		System.out.println("Enter 4 to list of tasks");
               		System.out.println("Enter 5 to search");
               		System.out.println("Enter 6 to go back");
               		System.out.println(" ");
               	
               	  
               	  while(!sc1.hasNextInt())
               	  {
               		  System.out.println("Enter integer input only");
               		  sc1.next();
               	  }
               	System.out.println("enter choice to add/edit/remove/list/search tasks");
               	  ch2=sc1.nextInt();
               	  System.out.println("you have selected option "+ch2);
               	  
               	  switch (ch2) {
               	case 1:System.out.println("Adding of task");
               	System.out.println("Enter name of the task");
               	name=sc2.nextLine();
               	System.out.println("Enter Description of the task");
               	desc=sc2.nextLine();
               	System.out.println("Enter startdate");
               	startdate=sc2.nextLine();
               	System.out.println("Enter end date in dd/MM/yyyy format");
               	enddate=sc2.nextLine();
               	System.out.println("Enter priority");
               	priority=sc2.nextLine();
               	 System.out.println("Enter status");
               	 status=sc2.nextLine();
               	 System.out.println("Enter tags");
               	 tags=sc2.nextLine();
               	 
               	  TaskBean tb=new TaskBean(name,desc,startdate,enddate,priority,status,tags);
               	  boolean hold=model.addTask(tb,categoryname);
               	  if(hold==Constants.TRUE)
               		  System.out.println("Task is addded sucess fully");
               	  else
               		  System.out.println(hold);
               	
               	break;
               	case 2:System.out.println("Editing of task");
               	     model.editTask(taskname,categoryname);
               	
               	break;
               	case 3:System.out.println("Removing of task");
               	       model.deleteTask(taskname,categoryname);
               	break;
               	case 4:System.out.println("Listing of task");
               	   model.listTasks(categoryname,no);
               	break;
               	case 5:System.out.println("Searching of task");
               	   model.searchTasks(wd2search,categoryname);
               	   
               	break;
               	case 6:System.out.println("Adios");
               		break;
               default:System.out.println("Option not supported yet");
               		break;
                }
               	}
                }
        	  break;
          case 3:System.out.println("Searching Of Categeory");
    	  System.out.println("Enter categeory name to search");
    	  categoryname=sc2.nextLine();
    	  boolean boo=model.checkifcategoryExists(categoryname); 
    	  if(boo)
    	  {
    		  System.out.println(categoryname+" found");
    	  }
    	  else
    		  System.out.println(categoryname+"not found ");
        	  break;
         
         
        	  case 4:System.out.println("Listing Of Category");
        	 
               File f=null;
        	  try
        	  {
        		
        		  f=new File(Constants.PATH);
        		  File[] fl=f.listFiles();
        		  
        		  for(File g:fl)
        		  {
        		 System.out.println(g.getName());
        		}
        		  
        	  }
        	  catch (Exception e) {
    			e.printStackTrace();
    			Logger.getInstance().log(e.toString());
    		}
        	  
        	  break;
        	  case 5:System.out.println("GoodBye!!Come back again!!");
        	  break;
        	  default:
        		  System.out.println("Invalid choice");
        		  break;
          }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Logger.getInstance().log(e.toString());
		}
		finally
		{
			if(sc1!=null)
			{
				sc1.close();
			}
			if(sc2!=null)
			{
				sc2.close();
			}
		}
		
	}//main close

}//class close
