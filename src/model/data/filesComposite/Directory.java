package model.data.filesComposite;

import model.data.Tag;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Component {

    public Directory(String path, List<Tag> tagList) {
        super(path, tagList);
        listOfComponents = new ArrayList<Component>();
    }

    public void addToList(Component component){
        listOfComponents.add(component);
    }

    public void removeFromList(Component component){
        listOfComponents.remove(component);
    }

    List<Component> listOfComponents;
}
