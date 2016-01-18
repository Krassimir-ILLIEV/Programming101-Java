package _04_WC;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import _02_Utility.FileUtils;

public class WordCount {

	public WordCountResult wordCount(Path path){
		return wordCount(path.toFile());
	}
	
    public WordCountResult wordCount(File file){
    	long lineCount=0;
		long characterCount=0;
		long wordCount=0;
		
    	try{
    	FileUtils fileUtils=FileUtils.getInstance();
		String[] lines =fileUtils.readFrom(file).split(System.lineSeparator());
		lineCount=lines.length;
				
		for(String line: lines){
			characterCount+=line.length();
		line=line.replaceAll("\\p{javaSpaceChar}{2,}", " ").trim();
		if(line.length()>0){
			wordCount+=line.split(" ").length;
		}
		}
		
		
    	} catch(IOException ioe){
    		System.out.println(ioe);
    	}
    	
    	return new WordCountResult(lineCount, wordCount, characterCount);
	}

    public static class WordCountResult{
    	private final long lineCount;
    	private final long wordCount;
    	private final long characterCount;
    	
    	public WordCountResult(long lineCount, long wordCount, long characterCount){
    		this.lineCount=lineCount;
    		this.wordCount=wordCount;
    		this.characterCount=characterCount;
    	}

		public long getLineCount() {
			return lineCount;
		}

		public long getWordCount() {
			return wordCount;
		}

		public long getCharacterCount() {
			return characterCount;
		}

		public String toString(){
			 return String.format("The file contains %d lines, %d words and %d characters.", lineCount,wordCount,characterCount);
		}
    }
    
    public static void main(String[] args){
    	
    	Path pa = FileSystems.getDefault().getPath("/home/ubuntu/workspace/Week07Monday1101/src/_03_Parse/test.properties");
    	WordCount wc=  new WordCount();
    	System.out.println(wc.wordCount(pa));
    }
}
