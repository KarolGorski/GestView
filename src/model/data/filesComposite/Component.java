package model.data.filesComposite;

import model.data.Tag;

import java.util.List;

public abstract class Component {

    public Component(String path, List<Tag> tagList) {
        this.path = path;
        this.love = false;
        this.alreadyDrawn = false;
        this.tagList = tagList;
    }

    String path;
    boolean love;
    boolean alreadyDrawn;
    List<Tag> tagList;
}
