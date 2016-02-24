package FileSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FileWalker {

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				System.out.println("File:" + f.getAbsoluteFile());
			}
		}
	}

	public static Collection<File> listFileTree(File dir, Set<String> filterExtensions) {

		Set<File> fileTree = new HashSet<File>();

		if (dir.listFiles() != null) {
			for (File entry : dir.listFiles()) {
				//System.out.println(entry.getAbsolutePath());
				if (!entry.isDirectory()){
					//System.out.println(entry.getName());
					String[] nameAndExtension = entry.getName().split("\\.");
					//System.out.println(nameAndExtension.length);
					if(filterExtensions.contains(nameAndExtension[nameAndExtension.length-1])){
					fileTree.add(entry);
					}
				}
				else
					fileTree.addAll(listFileTree(entry, filterExtensions));
			}
		}
		return fileTree;
	}
	
	class FoundWords{
		int countOccurrences=0;
		String foundInLines="";
		String fileName;
		
		public FoundWords(String fileName){
			this.fileName=fileName;
		}
		public void incrementOccurrences(int line){
			countOccurrences++;
			foundInLines+=line+",";
		}
		
		public String toString(){
			String s="";
			if(!this.equals(null)){
			s="File: "+fileName+";number of occurrences: "+countOccurrences+" in the following lines: "+foundInLines;
			}
			return s;
		}
		
	}
	
	
	
	public FoundWords stringFinder(File file, String searchedWord){
	
		FoundWords found=null;
		String s;
		int lines=0;
		try{
		BufferedReader br=new BufferedReader(new FileReader(file));
		
		
		while((s=br.readLine())!=null){
			lines++;
			s = s.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();
		    String[] words=s.split(" ");
			
				for (String word : words) {
					if (word.equals(searchedWord)) {
						if(found==null){
						found=new FoundWords(file.getName());
						}
						found.incrementOccurrences(lines);
						
					}
				}
		}
		
		br.close();
		
		
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		return found;
	}

	public static List<File> addFiles(List<File> files, File dir) {
		if (files == null)
			files = new LinkedList<File>();

		if (!dir.isDirectory()) {
			files.add(dir);
			return files;
		}

		for (File file : dir.listFiles())
			addFiles(files, file);
		return files;
	}

	public static void main(String[] args) {
		 FileWalker fw = new FileWalker();
		// fw.walk("//home" );
		// Path path = Paths.get("/");

		
		Collection<File> listToPrint;// = new LinkedList<File>();
		// List<File> list = new LinkedList<File>();
		Set<String> set = new HashSet<String>();
		set.add("txt");
		listToPrint = listFileTree(new File("//home"), set);

		for (File file : listToPrint) {
			//System.out.println(file.getAbsoluteFile());
			FoundWords foundWords=fw.stringFinder(file,"log");
			if(foundWords!=null){
			System.out.println(foundWords);
			}
		}


		/*
		 * try{
		 * 
		 * Files.walk(Paths.get("//home")) .filter(Files::isRegularFile)
		 * .forEach(System.out::println); } catch(IOException e){
		 * e.printStackTrace(); }
		 */

		/*
		 * List<File> allFiles = new ArrayList<File>(); Queue<File> dirs = new
		 * LinkedList<File>(); dirs.add(new File("/")); while (!dirs.isEmpty())
		 * { for (File f : dirs.poll().listFiles()) { if (f.isDirectory()) {
		 * dirs.add(f); } else if (f.isFile()) { allFiles.add(f); } } }
		 */
	}

}
