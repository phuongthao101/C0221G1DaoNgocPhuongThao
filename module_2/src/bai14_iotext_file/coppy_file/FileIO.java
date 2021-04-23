package bai14_iotext_file.coppy_file;

import bai14_iotext_file.bai_tap.read_file.ReadFile;

import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        String file1 = "src\\bai14_iotext_file\\coppy_file\\ReadFile";
        String file2 = "src\\bai14_iotext_file\\coppy_file\\WriteFile";
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2,true);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();


    }
}
