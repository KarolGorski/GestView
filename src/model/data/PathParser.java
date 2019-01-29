package model.data;

import displayKeys.Keys;
import model.data.filesComposite.Component;
import model.data.filesComposite.Directory;
import model.data.filesComposite.Image;

import java.io.File;
import java.util.ArrayList;

public class PathParser {

    public static Component parse(String path, ArrayList<String> tagList){
        
        String name = path.substring(path.lastIndexOf('\\')+1);

        File dir = new File(path);
        Component currentDir = new Directory(name, path, tagList);

        File[] directoryListing = dir.listFiles();
        if(directoryListing != null){
            for(File child : directoryListing){
                name = child.getAbsolutePath().substring(path.lastIndexOf('/')+1);
                if(child.isFile())
                    ((Directory) currentDir).addToList(new Image(name, child.getAbsolutePath(),tagList));
                //if(child.isDirectory())
                //    ((Directory) currentDir).addToList(parse(child.getAbsolutePath(),tagList));
            }
        }

        return currentDir;
    }
}
