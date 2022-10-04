package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.tinylog.Logger;

import java.io.FileReader;

public class JsonReaderUtil {
    private static final JsonParser parser = new JsonParser();

    public static String getJsonDataProperty(String property, String sourceFile) {
        try {
            Object obj = parser.parse(new FileReader(sourceFile));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return "";
    }
}
