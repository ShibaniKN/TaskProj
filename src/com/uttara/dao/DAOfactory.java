package com.uttara.dao;

import com.uttara.mvc.Constants;
import com.uttara.mvc.TASKDAO;

public class DAOfactory {

	public static TASKDAO getDAO()
	{
		switch(Constants.DAOTYPE)
		{
			case "file":
					return new TaskFileImplDAO();
			/*
			 * case "db":
			 * 		return new TaskDBDAOImpl();
			 */
		
		}
		return null;
	}

}
