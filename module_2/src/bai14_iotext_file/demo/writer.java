package bai14_iotext_file.demo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class writer {
    public static void main(String[] args) {
//        try {
//            FileWriter writer = new FileWriter("MyFile.txt", true);
//            writer.write("Xin chào");
//            writer.write("\r\n");   // write new line
//            writer.write("Good Bye!");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

// đọc ghi file UTF-16
        try {
            FileOutputStream outputStream = new FileOutputStream("MyFile.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("Xin chào");
            bufferedWriter.newLine();
            bufferedWriter.write("Hẹn gặp lại!");

            bufferedWriter.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }

    }

}
