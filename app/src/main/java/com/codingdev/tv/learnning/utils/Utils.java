package com.codingdev.tv.learnning.utils;


import java.io.IOException;
import java.io.InputStream;

/**
 * A collection of utility methods. all static.
 */
public class Utils {

    /**
     * read input stream data convert to string.
     * @param inputStream
     * @return
     */
    public static String inputStreamToString(InputStream inputStream){
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
