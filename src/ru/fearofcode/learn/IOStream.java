package ru.fearofcode.learn;

import java.io.*;
import java.util.Date;

/**
 * Created by maks on 6/15/2017.
 */
public class IOStream {
    public static void main(String[] args) {
        String name = "xyz.dat";
        double startWrite = System.currentTimeMillis();
        write(name);
        double endWriteOrBeginRead = System.currentTimeMillis();
        read(name);
        double endRead = System.currentTimeMillis();
        System.out.println("I start at "+ startWrite);
        System.out.println("I finished write at "+ endWriteOrBeginRead);
        System.out.println("I finished read at "+ endRead);
    }

    private static void read(String name) {
        FileInputStream myFile = null;
        try{
            myFile = new FileInputStream(name);
            boolean eof = false;
            while (!eof){
                int byteValue = myFile.read();
                System.out.print(byteValue+ " ");
                if (byteValue == -1){
                    eof = true;
                }
                //myFile.close(); //Do not do it here!!!
            }
        }catch(Exception e){
            System.out.println("Could not read file: " + e.toString());
        }finally{
            if (myFile != null){
                try{
                    myFile.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    private static void write(String name){
        //int someData[] = {60,61,13,64,54};
        FileOutputStream myFile = null;
        try{
            myFile = new FileOutputStream(name);
            for (int i = 0; i < 20000000; i++){
                //for (int j = 0; j < 30; j++) {
                //   myFile.write((int) Math.random() * 200);
                //}
                myFile.write((int)(Math.random() * 255));
            }
        }catch(Exception e){
            System.out.println("Could not write to a file: " + e.toString());
        }finally{
            if (myFile != null){
                try{
                    myFile.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


}
