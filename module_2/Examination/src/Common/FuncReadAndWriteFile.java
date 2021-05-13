package Common;

import Model.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadAndWriteFile {
    public static final String PATH = "src/data/"; // từ khóa final

    public static void writeFile(String fileName, List<Phone> phoneList, boolean writeStatus) {
        File file = new File(PATH + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, writeStatus);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Phone phone : phoneList) {
                bufferedWriter.write(phone.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<Phone> readFile(String fileName) {
        File file = null;
        BufferedReader bufferedReader = null;

        List<Phone> phoneList = new ArrayList<>(); // tạo mảng rỗng để chứa cái string
        try {
            //thảo thiếu chổ ni nè
            file = new File(PATH+fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedReader = new BufferedReader(new FileReader(file));
            String[] strings;
            String line = "";
            Phone phone = null;

            while ((line = bufferedReader.readLine()) != null) {
                strings = line.split(",");
                phone = new Phone(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]);
                phoneList.add(phone);
            }
            //cái lỗi ni a gặp lúc đi học rồi mà a k có gỡ bug,bữa đó a lĩnh gỡ.để a suy nghĩ tí
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return phoneList;
    }
}
