package json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DiverDemo {

	public static void main(String[] args)
	{
		try 
		{
			ObjectMapper map=new ObjectMapper();
			Student stu=map.readValue(new File("data/sample-full.json"),Student.class);
			System.out.println("received object is "+stu);
		    
			String[] lang= {"a","b"};
			map.writeValue(new File("data/sample-class.json"),new Student(5,"sd","ss",false,stu.getAddress(),lang));
			System.out.println("json file created");
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
