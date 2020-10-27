package com.uttara.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
	public static final String LOGPATH="C:/Users/Shibani/Desktop/log.txt";
	public static final boolean LOGTOMONITOR = false;
	
	private Logger(){ }
	
	private static Logger obj = null;
	
	public synchronized static Logger getInstance()
	{
		if(obj==null)
			obj = new Logger();
		return obj;
	}
	
	public void log(final String data)
	{
		new Thread(new Runnable()
		{
			public void run()
			{
				BufferedWriter bw = null;
				try
				{
					bw = new BufferedWriter(new FileWriter(LOGPATH,true));
					bw.write(new Date()+ " Thread name : "+ Thread.currentThread().getName()+" DATA : "+data);
					bw.newLine();
					bw.flush();
					if(LOGTOMONITOR)
						System.out.println("LOG DATA : "+data);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				finally
				{
					if(bw!=null)
						try {
							bw.close();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
				}
			}
		}).start();
		
	}
	
	
}
