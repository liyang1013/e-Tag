package com.keboda.eomsback.utils;

public class FileUtils {

    /**
     * 得到文件得后缀格式
     * @param fileName {string} 源文件名
     * @return {string} 文件后缀
     */
    public static String extractFileSuffix(String fileName){
        String suffix= null;
        String reverseName = new StringBuilder(fileName).reverse().toString();
        if(reverseName.split("\\.").length > 1){
            suffix = new StringBuilder(reverseName.split("\\.")[0]).reverse().toString();
        }else throw new RuntimeException("文件格式错误");
        return suffix;
    }
}
