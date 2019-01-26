package model.data.filesComposite;

import model.data.serialization.DataSerialization;

import java.util.ArrayList;
import java.util.List;

public class CompositeStructureRoot {

    private List<Component> listOfComponents;

    public CompositeStructureRoot() {

        this.listOfComponents = new ArrayList<Component>();
    }

    public void addToList(Component component){
        listOfComponents.add(component);
    }
}
