package Bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class SerializeDeserialize {

public static <Item> void  serialize(Item item, Path path){
		
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(path.toFile());
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(item);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in %s\n",path.toString());
	      }catch(IOException ioe)
	      {
	          ioe.printStackTrace();
	      }
	}
	
	public static <Item> Item deserialize(Path path){
		Item item = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream(path.toFile());
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         item = (Item) in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.printf("Deserialized data is saved in %s\n",path.toString());
	         
	         return item;
				
	      }catch(IOException ioe)
	      {
	         ioe.printStackTrace();
	         return null;
	         
	      }catch(ClassNotFoundException cnfe)
	      {
	         System.out.println("InformationBearer class not found");
	         cnfe.printStackTrace();
	         return null;
	      }
}
	
public static Path createNewPath(Path filePath, String extension){
		
		String fileName=filePath.getName(filePath.getNameCount()-1).toString();
		int indexOfDot=fileName.indexOf('.');
	
		fileName=fileName.substring(0, indexOfDot)+"."+extension;
	
		String newPath=filePath.subpath(0,filePath.getNameCount()-1).toString();
		newPath ="/"+newPath+"/"+fileName;
				
		return FileSystems.getDefault().getPath(newPath);
	}

public static void main(String[] args){
	//TheBank bank=new TheBank();
	String[] str1 = new String[10];
	for(Integer i=0;i<10;i++){
		str1[i]=i.toString();
	}
	
	//serialize(bank,);
	 String str=System.getProperty("user.dir");
	 str+="/serializedBank.ser";
	 System.out.println(str);
	 Path path = FileSystems.getDefault().getPath(str);
	 for(Integer i=0;i<10;i++){
			System.out.println(str1[i]);			
		}
	 SerializeDeserialize.<String[]>serialize(str1, path);
	 String[] str3=SerializeDeserialize.<String[]>deserialize(path);
	 System.out.println("---");
	 for(Integer i=0;i<str3.length;i++){
			System.out.println(str3[i]);			
		}
	 
}
}
