package _03_Parse;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Paths;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import _02_Utility.FileUtils;

public class ParseUtility {

	private Map<String, String> mapProperties;
	
	public ParseUtility(){
		
		mapProperties= new HashMap<String,String>();
		
	}
	
	public void parseProperties(Path path){
		
		try{
		String[] lines = FileUtils.getInstance().readFrom(path).split(System.lineSeparator());
		
		for(String line: lines){
			
			while(line.length()>0 && line.charAt(0)==' '){
				line=line.substring(1);
			}
			
			if(line.length()>0 && line.charAt(0)!='#'){
			genMapFromList(line);
			}
		}
		
		} 
			catch (IOException io){
				System.out.println(io);
		}
	}
	
	private void genMapFromList(String line){
		
		int equalsSignPosition=line.indexOf('=');
		if(equalsSignPosition!=-1){
		String property=line.substring(0,equalsSignPosition).trim();
		String value=line.substring(equalsSignPosition+1);
		
		mapProperties.put(property, value);
		}
		
	}

	public static void main(String[] args){
		ParseUtility p = new ParseUtility();
		Path pa = FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week07Monday1101/src/_03_Parse/test.properties");
		//Path pa = FileSystems.getDefault().getPath("/home/ubuntu/test.properties");
		//File f=pa.toFile();
		p.parseProperties(pa);
		
		//p.parseProperties(Pat
		/*
		 p.genMapFromList("a2 =b2");
		 
		p.genMapFromList("a3    =    b3");
		p.genMapFromList("a5=b6=b7=b8");
		p.genMapFromList("a6=b9 #comment");
		p.genMapFromList("a7==b10");
		*/
		
				 
		
		System.out.println(p.mapProperties.keySet());
		System.out.println(p.mapProperties.values());
		
	}
	
}
