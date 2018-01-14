package fr.tracky.cyrilstern.selgerancecenter.services;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cyrilstern1 on 13/01/2018.
 */

public class Util {

    public static String getProperty(String key, Context context) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = assetManager.open("configuration.properties");
        properties.load(inputStream);
        return properties.getProperty(key);

    }
}
