package model.data.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.data.filesComposite.Component;
import model.data.filesComposite.CompositeStructureRoot;
import model.data.filesComposite.Directory;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataSerialization {
    //https://github.com/google/gson
    //or
    //https://www.tutorialspoint.com/java/java_serialization.htm

    private String pathToSerializedData;
    private Gson gson;

    public DataSerialization(String pathToSerializedData) {
        this.pathToSerializedData = pathToSerializedData;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Component.class, new AbstractComponentAdapter());
        this.gson = gsonBuilder.create();
    }

    public void setPathToSerializedData(String pathToSerializedData) {
        this.pathToSerializedData = pathToSerializedData;
    }

    public boolean saveContent(CompositeStructureRoot root){
        String rootJson = gson.toJson(root);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToSerializedData))){
            bufferedWriter.write(rootJson);
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Writing to file didn't go as expected");
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        System.out.println("Saving data is done! :3 ");
        return true;
    }

    public CompositeStructureRoot getDataOrCreateNew(){
        String rootJson;
        CompositeStructureRoot root=null;
        try{
            rootJson = new String(Files.readAllBytes(Paths.get(pathToSerializedData)), StandardCharsets.UTF_8);
            root = gson.fromJson(rootJson, CompositeStructureRoot.class);
            System.out.println("Reading data is done! :3 ");
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Reading from file didn't go as expected");
        }catch (Exception e){
            e.printStackTrace();
        }

        return root==null?new CompositeStructureRoot():root;
    }


}
