package demo.third.com.exceldemo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

public class CustomGson {

    public static <T> T fromJson(String json, Class<T> classOfT)
            throws JsonSyntaxException {

        // 统一将遇到的[]替换为null
//        json = json.replace("[]", "null");
//        json = json.replace("\"\"", "null");

        Gson gson = new Gson();
        Object object;
        try {
            object = gson.fromJson(json, (Type) classOfT);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return CustomPrimitives.wrap(classOfT).cast(object);
    }

}
