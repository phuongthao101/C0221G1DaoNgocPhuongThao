package bai15_binaryfile.coppy_file_nhi_phan;

import java.io.*;
import java.util.List;

public class WriteFile<E> {
    public void writeToFile(String path, List<E> studentList)  {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            fos.close();
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  List<E> readFromFile(String path , List<E> studentList){
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<E>) ois.readObject();
            fis.close();
            ois.close();
        }catch ( Exception e){
            e.printStackTrace();
        }
        return studentList ;

    }
}
