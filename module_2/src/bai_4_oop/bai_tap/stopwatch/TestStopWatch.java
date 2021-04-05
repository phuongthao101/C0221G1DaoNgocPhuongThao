package bai_4_oop.bai_tap.stopwatch;

import com.sun.xml.internal.ws.resources.UtilMessages;

import java.lang.reflect.Array;
import java.util.Scanner;

public class TestStopWatch {
    public static void main(String[] args) {
        StopWatch test = new StopWatch();
        test.start() ;
        int[] array = new int [100000] ;
        for(int i=0; i<array.length; i++){
            array[i] = (int) (Math.random() * 1000);

    }
        test.stop();
        System.out.println("time :" + test.getElapsedTime());
    }

}
