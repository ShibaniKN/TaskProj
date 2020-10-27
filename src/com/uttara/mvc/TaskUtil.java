package com.uttara.mvc;

public class TaskUtil {
	public static boolean validateName(String str)
	{
		if (str.split(" ").length > 1)
			return false;
		
		if(!Character.isLetter(str.charAt(0)))
			return false;
		
		for(int i = 1 ; i < str.length() ; i++)
			if(!(Character.isLetter(str.charAt(i)) || Character.isDigit(str.charAt(i))))
				return false;
		
		return true;
	}
}
