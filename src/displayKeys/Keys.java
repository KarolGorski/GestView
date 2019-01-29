package displayKeys;

import app.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Keys {

    static public class Paths{
        public static String SERIALIZED_DATA_PATH ="serializedData";
    }
    static public class Style{
        static public String STYLE = "/views/style.css";
    }

    static public class Views{

        static public String MAIN_MENU = "/views/mainMenuView.fxml";
        static public String LOGIN_VIEW = "/views/loginView.fxml";
        static public String DRAW_VIEW = "/views/drawView.fxml";
    }

    static public class Tags{

        static private ArrayList<String> TAGS = new ArrayList<String>(
                Arrays.asList(
                "Nude",
                "Clothes",
                "Man",
                "Woman",
                "Group",
                "Animal",
                "Action",
                "Stationary"));

        static public boolean loadTags(ArrayList<String> loadedTags){
            if(loadedTags == null)
                return false;
            else
                TAGS = loadedTags;
            return true;
        }

        static public void addToTags(String newTag){
            TAGS.add(newTag);
        }

        static public ArrayList<String> getTags(){
            return TAGS;
        }
    }

}
