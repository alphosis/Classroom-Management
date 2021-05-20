package fileio;

import java.lang.*;
import java.io.*;

public class FacultyRecord
{
	private File file;				
	private FileWriter writer;		
	private FileReader reader;		
	private BufferedReader bfr;		
	
	
	public void writeinFile(String s)
	{
		
		try
		{
			file = new File("fileio/files/FacultyRecord.txt");	
			file.createNewFile();					
			writer = new FileWriter(file, true);	
			writer.write(s+"\r\n");				
			writer.flush();							
			writer.close();							
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public void readFromFile()
	{
		
		try
		{
			reader = new FileReader("fileio/files/FacultyRecord.txt");			
			bfr = new BufferedReader(reader);		
			String text="", temp;					
			
			while((temp=bfr.readLine())!=null)		
			{
				text=text+temp+"\n\r";			
			}
			
			System.out.println(text);				
			reader.close();							
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public boolean verify(String name, String Id)
	{
		
		boolean flag =false;
        try{ 
		
		
		 reader = new FileReader("fileio/files/FacultyRecord.txt");			//creating the reader object to read from a file.
		 bfr = new BufferedReader(reader);
		 String v;

		 
		while((v=bfr.readLine())!=null && !flag)
		{
			
			String sp[]= v.split(";");
			if((sp[0].equals(name)) && (sp[1].equals(Id))){flag=true; }
				
			
			
		}
			 
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return flag;
	}
	
}