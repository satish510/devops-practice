package com.hp.fb.integration;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import com.google.gson.Gson;  
public class ConvertJsonToJava 
{   
	 public void JsonToJava()
	 {      
	  try
            {   
	   // obtained a file object from json file  
	   File file = new File("json/student.json");  
	  
	   // get json as buffer  
	   BufferedReader br = new BufferedReader(new FileReader(file));  
	  
	   // obtained Gson object  
	   Gson gson = new Gson();  
	  
	   // called fromJson() method and passed incoming buffer from json file  
	   // passed PostVO class reference to convert converted result as PostVO object  
	   PostVO po = gson.fromJson(br, PostVO.class);  
	     
	   // printed student data on console  
	   System.out.println("UserMailId: "+po.getUserMailId()+" first_name:"+po.getFirst_name()  
	   +" postURL: "+po.getPostURL()+"totalLikes:"+po.getTotalLikes()+" Gender: "+po.getGender());  
	     
	   System.out.println("LikeNames: ");  
	   for(int i=0;i<=po.getLikeNames().size()-1;i++){  
	    System.out.println(po.getLikeNames().get(i));  
	   }  
  	  } 
	  catch (FileNotFoundException e)
	  {  
	   e.printStackTrace();  
	  }   
	    
	 } 

}
