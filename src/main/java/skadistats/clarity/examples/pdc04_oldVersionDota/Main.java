package skadistats.clarity.examples.pdc04_oldVersionDota;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import skadistats.clarity.processor.runner.SimpleRunner;
import skadistats.clarity.source.MappedFileSource;

//public class Dota2TeamsPickSets {
public class Main {

	public static void main(String[] args) throws Exception {
    	
    	String path_directory = args[0];
    	File[] files = new File(path_directory).listFiles();
    	String outputFile2 = args[1];

    	try{
    		PrintWriter myWriter = new PrintWriter(outputFile2, "UTF-8");
    		PrintWriter metaWriter = new PrintWriter(path_directory+"/metadata_oldDotaVersion.csv", "UTF-8");
    		metaWriter.println("match id;replay name");
			myWriter.println("match id;time (seconds);sum Level;nb remaining tower;highest item gold;divine rapier is bought?;max attack power among heroes;max level Tower destroyed;nb of melee barrack destroyed;is mega creep?;temps restant (seconds)");//;level (ligue);nombre de joeurs
    		
	    	int counter = 1;
	    	for (File file : files) {
	    		if (file.isFile() && file.getName().substring(file.getName().length()-4, file.getName().length()).equals(".dem") ) {
	    			int matchId = Integer.parseInt(file.getName().substring(0,file.getName().length()-4));
			        String filename = path_directory+"/"+file.getName();
			        
			        System.out.println("Parsing "+matchId+" replay ...");
			        
			        DotaProcessor proc = new DotaProcessor();
			        new SimpleRunner(new MappedFileSource(filename)).runWith(proc);
			        
			        if(proc.writeTraceFile(myWriter, counter)){
			        	metaWriter.println(counter+";"+file.getName());
			        	counter = counter + 1;
			        }
			    }
	    	}
	    	myWriter.close();
	    	metaWriter.close();
    	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		e.printStackTrace();
    	}  	
    }     
}


