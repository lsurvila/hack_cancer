package co.hackcancer.hackcancer.helper;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {

    public static <T> List<T> getJsonAsListOfObjectsFromAssetsFile(Context context, String fileName, Type type) {
        Gson gson = new Gson();
        List<T> list = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            list = gson.fromJson(inputStreamReader, type);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
