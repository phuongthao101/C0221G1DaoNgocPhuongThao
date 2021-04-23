package bai14_iotext_file.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class reader {
    public class TextFileReadingExample1 {

        public  void main(String[] args) {
            try {
                FileReader reader = new FileReader("MyFile.txt");
                int character;

                while ((character = reader.read()) != -1) {
                    System.out.print((char) character);
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();


                //cách 2
                try {
                    FileReader reader = new FileReader("MyFile.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                        String[] temp = line.split(",");
                        //Trường hợp 1: length khác nhau
//                if(temp.length == 6) {
//
//                } else if(temp.length == 7) {
//
//                }

                        //trường hợp 2: length bằng nhau
                        if (temp[0].contains("Villa")) {

                        }
                    }
                    reader.close();

                } catch (IOException e1) {
                    e.printStackTrace();
                }
            }

        }
    }
}

