package skadistats.clarity.examples.pdc04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import skadistats.clarity.processor.runner.SimpleRunner;
import skadistats.clarity.source.MappedFileSource;

//public class Dota2TeamsPickSets {
public class Main {

    public static void main(String[] args) throws Exception {
        //int matchId=35811732;
        // int matchId=1995747138;//1987164251
    	
    	String path_directory = args[0];
    	File[] files = new File(path_directory).listFiles();
    	String outputFile2 = args[1];

    	try{
    		PrintWriter myWriter = new PrintWriter(outputFile2, "UTF-8");
    		PrintWriter metaWriter = new PrintWriter(path_directory+"/metadata.csv", "UTF-8");
    		metaWriter.println("match id;replay name");
		myWriter.println("match id;time (seconds);sum Level;nb remaining tower;highest item gold;divine rapier is bought?;max attack power among heroes;max level Tower destroyed;nb of melee barrack destroyed;is mega creep?;temps restant (seconds)");//;level (ligue);nombre de joeurs
    		
	    	int counter = 0;
	    	for (File file : files) {
	    		if (file.isFile()) {
	    			counter = counter + 1;
	    			int matchId = Integer.parseInt(file.getName().substring(0,file.getName().length()-4));

			        String filename = path_directory+"/"+file.getName();
			        metaWriter.println(counter+";"+file.getName());
			        System.out.println("Parsing "+matchId+" replay ...");
			        
			        DotaProcessor proc = new DotaProcessor();
			        new SimpleRunner(new MappedFileSource(filename)).runWith(proc);
			        //Runner r = new SimpleRunner(new MappedFileSource(filename)).runWith(proc);
			        
			        proc.writeTraceFile(myWriter, counter);
			    }
	    	}
	    	myWriter.close();
	    	metaWriter.close();
    	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		e.printStackTrace();
    	}  	
    }        
}


