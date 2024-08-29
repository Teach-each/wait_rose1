package com.Helper.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wait.rose_constants.constants;

import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class Helper {

	
	public static String  load_Properties(String data) throws IOException { 
		FileReader reader=null;
try {
		 reader = new FileReader("config.properties");
           }
      catch(FileNotFoundException e) {
           e.printStackTrace();
                }
	Properties pp = new Properties();
		try { 
	    pp.load(reader);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return (String)pp.getProperty(data);


}
	
	public static String read_JSON(String filename,String key) throws IOException, ParseException {
		FileReader reader = null;
		try {
		 reader=new
		FileReader("C:\\Users\\Sathiyamoorthi\\Desktop\\rajasekar\\Interview java\\restAssured_learnings\\BDD_Framework\\BDD\\Toast_messages\\"+filename+".json");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
		JSONParser jp = new JSONParser();
		Object par = jp.parse(reader);
		JSONObject jo=(JSONObject)par;
		String json_value = (String)jo.get(key);
		return json_value;
		
		}
        
public static void get_Browser_Type(String browser) throws IOException {
	constants.browser_con=load_Properties(browser);
	//System.out.println(constants.browser_con);
}

public static void getURL(String url) throws IOException {
	constants.app_url_con=load_Properties(url);
}

public static void getname(String name) {
	
}
	
}
