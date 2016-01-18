package _08_Compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import _02_Utility.FileUtils;
import _03_Parse.ParseUtility;

public class Compressor{

	
	private static class InformationBearer implements java.io.Serializable{
		private	String[] decodingArray;
		private String encodedWordsString;
		}
	
	private Path createNewPath(Path filePath, String extension){
		
		String fileName=filePath.getName(filePath.getNameCount()-1).toString();
		int indexOfDot=fileName.indexOf('.');
		//System.out.printf("s: %s, i:%d",s,i);
		fileName=fileName.substring(0, indexOfDot)+"."+extension;
	
		String newPath=filePath.subpath(0,filePath.getNameCount()-1).toString();
		newPath ="/"+newPath+"/"+fileName;
				
		return FileSystems.getDefault().getPath(newPath);
	}
	
	public void compress(Path filePath){

		Map<String, Integer> encodingMap= new HashMap<String,Integer>();
		
		try{
			
			InformationBearer ib=new InformationBearer();
			ib.encodedWordsString="";
			
			String lines = FileUtils.getInstance().readFrom(filePath);
			
			lines=lines.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();	
			
			String[] wordsToEncode=lines.split(" ");
			String[] encodedWords=new String[wordsToEncode.length];
			
			int index=0;
			int j=0;
			for(String word: wordsToEncode ){
				if(!encodingMap.containsKey(word)){
					encodingMap.put(word, index++);
				} 
				ib.encodedWordsString+="~"+encodingMap.get(wordsToEncode[j++]);
			}
		
			ib.decodingArray=new String[encodingMap.size()];
			
			for(Entry<String, Integer> e: encodingMap.entrySet()){
				ib.decodingArray[e.getValue()]=e.getKey();
			    }
			Path writeTo=createNewPath(filePath,"compr");
			serializeCompressor(ib,writeTo);
			
			} 
				catch (IOException io){
					System.out.println(io);
			}
		}
	
	private void serializeCompressor(InformationBearer ib, Path path){
		
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(path.toFile());
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(ib);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in %s\n",path.toString());
	      }catch(IOException ioe)
	      {
	          ioe.printStackTrace();
	      }
	}
	
	private void deserializeCompressor(Path path){
		InformationBearer ib = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(path.toFile());
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ib = (InformationBearer) in.readObject();
	         in.close();
	         fileIn.close();
				
	         
	         String[] wordsToDecode=ib.encodedWordsString.split("~");
	         String decodedWords="";

	         
	         for(int i=1;i<wordsToDecode.length;i++){    	 
	        	 int j=Integer.parseInt(wordsToDecode[i]);
	        	 decodedWords+=ib.decodingArray[j]+" ";  	 
	         }
	         
	         decodedWords=decodedWords.trim();
	         
				//System.out.println(decodedWords);
		Path writeTo=createNewPath(path,"uncompr");
		FileUtils.getInstance().writeTo(decodedWords, writeTo);
		 System.out.printf("Deserialized data is saved in %s\n",writeTo.toString());
				
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException cnfe)
	      {
	         System.out.println("InformationBearer class not found");
	         cnfe.printStackTrace();
	         return;
	      }
	}
	
	public void decompress(Path path){
		deserializeCompressor(path);
	}
	
	public static void main(String[] args){
		
		Compressor c = new Compressor();
		Path pathToEncode = FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week07Monday1101/src/_08_Compression/testFileToEncode.doc");
		c.compress(pathToEncode);
		Path pathToDecode = FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week07Monday1101/src/_08_Compression/testFileToEncode.compr");
		c.decompress(pathToDecode);
	}
}

