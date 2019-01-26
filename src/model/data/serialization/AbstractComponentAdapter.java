package model.data.serialization;

import com.google.gson.*;
import model.data.filesComposite.Component;

import java.lang.reflect.Type;

public class AbstractComponentAdapter implements JsonSerializer<Component>, JsonDeserializer<Component> {

    @Override
    public JsonElement serialize(Component component, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(component.getClass().getSimpleName()));
        result.add("properties", jsonSerializationContext.serialize(component, component.getClass()));
        return result;
    }

    @Override
    public Component deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try{
            return jsonDeserializationContext.deserialize(element, Class.forName("model.data.filesComposite." + type));
        }catch (ClassNotFoundException cnfe){
            throw new JsonParseException("Unknown element type: "+type, cnfe);
        }
    }
}

