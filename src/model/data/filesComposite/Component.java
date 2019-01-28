package model.data.filesComposite;

import model.data.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    String path;
    boolean love;
    boolean alreadyDrawn;
    ArrayList<String> tagList;

    public Component(String path, ArrayList<String> tagList) {
        this.path = path;
        this.love = false;
        this.alreadyDrawn = false;
        this.tagList = tagList;
    }

    public String getPath(){
        return path;
    }
}
