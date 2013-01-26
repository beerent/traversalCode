package subClasses;

import java.io.File;
import java.util.ArrayList;

public class Dirtrav {
	public String directory;
	public File currentDir;
	private ArrayList<File> possibleFiles;
	
	public Dirtrav(String directory){
		this.directory = directory;
		currentDir = new File(System.getProperty("user.home") + directory);
		possibleFiles = new ArrayList<File>();
	}
	
	public void traverse(File dir){
		for (File file : dir.listFiles()){
			if (file.isDirectory()){
				System.out.println("DIR: " + file);
				traverse(file);	
			} else {
				System.out.println("FIL: " + file);
			}
			
		}
	}
	
	public void traverseSearch(String target, File dir){
		for (File file : dir.listFiles()){
			if(file.getName().contains(target)) possibleFiles.add(file);
			if (file.isDirectory()){
				traverse(file);	
			} else {
			}
			
		}
	}
	
	public void traverseGrab(String target, File dir){
		for (File file : dir.listFiles()){
			if(file.getName().contains(target)) possibleFiles.add(file);
			if (file.isDirectory()){
				traverse(file);	
			}
			System.out.println("respond with id#, or anything else to cancel.");
			for(int i = 0; i < possibleFiles.size(); i++){
				System.out.println("id: #" + i + "| " +possibleFiles.get(i).getName());
			}
		}
	}
	
	public File getDir(){
		return currentDir;
	}
	
	public static void main(String [] args){
		Dirtrav dtrv = new Dirtrav("/Documents/website");
		dtrv.traverseGrab("index", dtrv.getDir());
		System.out.println("done");
	}
}
