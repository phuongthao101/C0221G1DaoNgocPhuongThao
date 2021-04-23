package bai14_iotext_file.bai_tap.read_file;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {
//        try {
//            FileWriter fileWriter = new FileWriter("src\\bai14_iotext_file\\bai_tap\\Reader", true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("hello");
//            bufferedWriter.newLine();
//            bufferedWriter.write("Bye");
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            FileReader fileReader = new FileReader("src\\bai14_iotext_file\\bai_tap\\Reader");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line); // đọc tất cả nội dung trong mảng
                String[] strings = line.split(",");
                System.out.println(strings[strings.length - 1]); // đọc phần tử cuối cùng trong mảng trong ctrinh
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
