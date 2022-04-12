package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class Helper {
    static List<String> messagesList;

    public static void setMessagesList(List<String> list) {
        //TODO:  messagesList = list;
        messagesList = Arrays.asList(new String[]{"a", "b"});
    }

    public static List<String> getMessagesList() {
        return messagesList;
    }

    public static void addToMessagesList(String message) {
        messagesList.add(message);
    }
}
