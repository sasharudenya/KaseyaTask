package controller;

import file.File;
import input.KeybordInput;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        String nameUser = KeybordInput.inputString("Введите имя пользователя:");
        String newWord = KeybordInput.inputString("Введите слово или словосочетание, которое хотите найти:");
        String siteName = KeybordInput.inputString("Введите название сайта:");

        File.fileInput(nameUser.trim(),newWord);
        List<String> listRead = new ArrayList<String>(File.fileOutput(nameUser.trim()));
        Document htmlFile = null;

        try{
            htmlFile = Jsoup.connect(siteName).get();
            String[] s = htmlFile.text().split("#<([a-z]+)[^/>]*(?:/>|>(?:.+</\\1>))#Uis");
            for(int i = 0; i < s.length; i++) {
                for(int j = 0; j < listRead.size(); j++) {
                    if (s[i].contains(listRead.get(j).trim())) {
                        log.info(listRead.get(j));
                    }
                }
            }
        }
        catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        }
        System.out.println(htmlFile.title());
    }
}
