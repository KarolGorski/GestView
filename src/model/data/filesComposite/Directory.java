package model.data.filesComposite;

import model.data.Tag;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Component {
    List<Component> listOfComponents;

    public Directory(String name, String path, ArrayList<String> tagList) {
        super(name, path, tagList);
        listOfComponents = new ArrayList<Component>();
    }

    public void addToList(Component component){
        listOfComponents.add(component);
    }

    public void removeFromList(Component component){
        listOfComponents.remove(component);
    }

    public List<Component> getListOfComponents(){
        return listOfComponents;
    }

    public int getComponentsNumber(){
        return listOfComponents.size();
    }
}
