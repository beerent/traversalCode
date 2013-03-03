import java.io.File;
import java.util.Array List;

/*The class Dirtrav (Directory Traversal) will recursively search through a specified directory, searching for files that
 *match the String target.
*/
public class Dirtrav {
	public String directory;
	public File currentDir; //
	private ArrayList<File> possibleFiles; //ArrayList of matched target files.
	
	//Constructor
	//Sets directory to the passed in location, Appends ~ to the home user.
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
	
	//Returns: the current directory, as a File.
	public File getDir(){
		return currentDir;
	}
	
	public void usage(){
		System.out.println("Error: Requires one parameter; the location of the directory youd like to run" + 
		" this program in, FROM, BUT NOT INCLUDING YOUR HOME FOLDER. EX.  /Documents/music/  The ~ is appended" +
		" on for you");
		System.exit(1);
	}
	
	//
	public static void main(String [] args){
		if(args.length != 1) usage();
		Dirtrav dtrv = new Dirtrav(args[0]);
		dtrv.traverseGrab("index", dtrv.getDir());
		System.out.println("done");
	}
}
