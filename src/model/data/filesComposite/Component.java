package model.data.filesComposite;

import model.data.Tag;

import java.util.List;

public abstract class Component {

    String path;
    boolean love;
    boolean alreadyDrawn;
    List<Tag> tagList;

    public Component(String path, List<Tag> tagList) {
        this.path = path;
        this.love = false;
        this.alreadyDrawn = false;
        this.tagList = tagList;
    }

    public String getPath(){
        return path;
    }
}
