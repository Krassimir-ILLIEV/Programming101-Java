package DownloadPic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class dwndPicFromUrl {

	public void download(String str, String path){
		try{
	URL url = new URL(str);
	InputStream in = new BufferedInputStream(url.openStream());
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	byte[] buf = new byte[1024];
	int n = 0;
	while (-1!=(n=in.read(buf)))
	{//System.out.println(n);
	   out.write(buf, 0, n);
	}
	out.close();
	in.close();
	byte[] response = out.toByteArray();
	
	
	store(response,path);
	
		} catch (Exception e){
			System.out.println(e.getMessage());
				}
	
	}

	private void store(byte[] response, String path) throws FileNotFoundException, IOException{
		try{
			
			File pictureFile = new File(path);
			FileOutputStream fos = new FileOutputStream(pictureFile); 		
	//FileOutputStream fos = new FileOutputStream(path);  //this used to work in windows
	fos.write(response);
	fos.close();
		}
		
		catch (FileNotFoundException fnfe ) {
			System.out.println(fnfe.getMessage());
		}
		
		catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}
	}
	
	public Long downloadAndStore(String str,String path){
	
	try(InputStream in = new URL(str).openStream()){
	    return Files.copy(in, Paths.get(path),StandardCopyOption.REPLACE_EXISTING);
	}
	catch (Exception e){
		System.out.println(e.getMessage());
	return null;
	}
	
	}
	
	public void downloadAndStore2(String str, String picName){
		try{
		URL url = new URL(str);
		InputStream in = new BufferedInputStream(url.openStream());
		File pictureFile = new File(picName);
		OutputStream out = new BufferedOutputStream(new FileOutputStream(pictureFile));

		byte[] buf = new byte[1024];
		
		int n = 0;
		while ((n=in.read(buf))!=-1)
		{//System.out.println(n);
		   out.write(buf, 0, n);
		}
		
		//for ( int i; (i = in.read()) != -1; ) {   //do not transform to integers, use bytes //for ( int i; (i = in.read()) != -1; )
		  //  out.write(i);
		//}
		in.close();
		out.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args){
		dwndPicFromUrl dwnd= new dwndPicFromUrl();
		//dwnd.download("https://pp.vk.me/c633830/v633830020/c376/4qaBx61DXhg.jpg", "//home/Downloads/picture2");
				
		//Long l =dwnd.downloadAndStore("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg","//home/Downloads/picture2.jpg");
		//System.out.println(l); https://pp.vk.me/c633830/v633830020/c376/4qaBx61DXhg.jpg",
		dwnd.downloadAndStore2("https://pp.vk.me/c633830/v633830020/c376/4qaBx61DXhg.jpg", "//home/Downloads/picture2");//"C:/picture2.jpg");
		
	}
}
