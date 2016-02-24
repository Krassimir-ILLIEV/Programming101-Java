package FileSearch;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSearchForWords {

	public void listingDirectories(){  //moje bi da se sloji path
		
	Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
	
	
	for (Path name: dirs) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(name)) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
	}
	}
	
	
	public static void main(String[] args){
		FileSearchForWords fsf=new FileSearchForWords();
		fsf.listingDirectories();
	}
	
	
}
