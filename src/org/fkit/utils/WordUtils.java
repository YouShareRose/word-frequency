package org.fkit.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordUtils {
    public static void main(String[] args) {
        String articals = "I confess that when first I made acquaintance with Charles Strickland I never for a moment discerned that there was in him anything out of the ordinary. [坦白来说，刚认识查兰时，我根本看不出他有任何出类拔萃的地方。]Yet now few will be found to deny his greatness.[而现在，很少会有人否认他的伟大。] I do not speak of that greatness which is achieved by the fortunate politician or the successful soldier; that is a quality which belongs to the place he occupies rather than to the man; and a change of circumstances [时过境迁]reduces it to very discreet proportions[比例].";
        String fileName = "D:\\Tencent\\MobileFile\\1_the moone and sixpence-2.txt";

        Map<String,Integer> words = new HashMap<>();


        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
                countWords(tempString,words);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        // 写到文件里
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("word-list.txt", "UTF-8");

            for (String key : words.keySet()) {
                int v =words.get(key);
                System.out.println(key+"\t\t"+v);
                if(v<20){
                    writer.println(key);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    private static void countWords(String articals, Map<String, Integer> words) {

        String wordPattern = "\\w{2,20}";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(articals);
        while (matcher.find()){
            String w = matcher.group();
            if(words.get(w) == null){
                words.put(w,1);
            }else {
                int count = words.get(w);
                words.put(w,++count);
            }
        }
    }
}
