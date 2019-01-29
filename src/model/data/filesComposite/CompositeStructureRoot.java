package model.data.filesComposite;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.data.serialization.DataSerialization;

import java.util.ArrayList;
import java.util.List;

public class CompositeStructureRoot {

    private ArrayList<Component> listOfComponents;

    public CompositeStructureRoot() {

        this.listOfComponents = new ArrayList<Component>();
    }

    public void addToList(Component component) {
        listOfComponents.add(component);
    }

    public void removeFromList(Component component) {
        listOfComponents.remove(component);
    }

    public ObservableList<Component> getObservableList() {
        return FXCollections.observableList(listOfComponents);
    }
}
