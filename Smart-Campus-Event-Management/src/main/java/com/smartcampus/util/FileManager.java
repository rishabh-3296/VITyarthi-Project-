package com.smartcampus.util;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
public final class FileManager {
    private FileManager(){}
    public static List<String> read(String path){
        try{Path p=Paths.get(path); if(!Files.exists(p)) return new ArrayList<>(); return Files.readAllLines(p);}
        catch(IOException e){throw new IllegalStateException("Unable to read "+path,e);}
    }
    public static void write(String path,List<String> lines){
        try{Path p=Paths.get(path); if(p.getParent()!=null)Files.createDirectories(p.getParent()); Files.write(p,lines);}
        catch(IOException e){throw new IllegalStateException("Unable to write "+path,e);}
    }
}
