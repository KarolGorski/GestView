package model.data.filesComposite;

import model.data.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    String name;
    String path;
    boolean love;
    boolean alreadyDrawn;
    ArrayList<String> tagList;

    public Component(String name, String path, ArrayList<String> tagList) {
        this.name = name;
        this.path = path;
        this.love = false;
        this.alreadyDrawn = false;
        this.tagList = tagList;
    }

    public String getName(){
        return name;
    }
    public String getPath(){
        return path;
    }
}
