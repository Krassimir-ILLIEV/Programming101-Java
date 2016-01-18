package _05_FixSubs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import _02_Utility.FileUtils;

public class FixSubtitles {

	public void fixEncoding(Path path){
		
		String s=path.getName(path.getNameCount()-1).toString();
		int i=s.indexOf('.');
		s=s.substring(0, i)+"(bak)."+s.substring(i+1);
		System.out.println(s);
		String ss=path.subpath(0,path.getNameCount()-1).toString();
		ss+="/"+s;
		ss="/"+ss;
		
		
		Path copyTo = FileSystems.getDefault().getPath(ss);
		
		//File f=new File(ss);
		try{
			//System.out.println(path);
			//System.out.println(copyTo);
			
			Files.copy(path, copyTo,StandardCopyOption.REPLACE_EXISTING);
			//copyFile(path, copyTo);
			encode(copyTo,path);
		}
		catch(IOException ioe){
			System.out.println(ioe);
		}
		
	}
	
	private void encode(Path pathFrom, Path pathTo){
	
		try{
			String lines = FileUtils.getInstance().readFrom(pathFrom);
			
   
        String result = new String(lines.getBytes("windows-1251"), Charset.forName("UTF-8"));
        //System.out.println(result);
        FileUtils.getInstance().writeTo(result,pathTo);
        
    } catch ( IOException e) {
        System.out.println(e);
    }
	}
	public static void copyFile(Path pathFrom, Path pathTo) throws IOException {
		File sourceFile=pathFrom.toFile();
		File destFile=pathTo.toFile();
		System.out.println("0");
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;
//System.out.println("1");
	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        //System.out.println("2");
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}
	public static void main(String[] args){
		FixSubtitles fs=new FixSubtitles();
		Path pa = FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week07Monday1101/src/_03_Parse/test.properties");
		//copyFile
		
	fs.fixEncoding(pa);
	//"/home/ubuntu/workspace/Week07Monday1101/src/_05_FixSubs/testSub.sub"	
	}
}
