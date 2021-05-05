package quan_ly_xe_co2.common;

import quan_ly_xe_co2.model.Oto;
import quan_ly_xe_co2.model.PhuongTien;
import quan_ly_xe_co2.model.XeMay;
import quan_ly_xe_co2.model.XeTai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    public static final String PATH = "D:\\C0221G1DaoNgocPhuongThao\\LuyenTap\\src\\quan_ly_xe_co2\\data";

    public static void ghiFile(String fileName, List<PhuongTien> phuongTienList, boolean trangThai) {
        // ghi list phương tiện---------------------------
        File file = new File(PATH + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (PhuongTien phuongTien : phuongTienList) {
                bufferedWriter.write(phuongTien.toString());
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



        // đọc list phương tiện --------------



}




