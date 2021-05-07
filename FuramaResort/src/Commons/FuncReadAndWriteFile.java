package Commons;

import Models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncReadAndWriteFile {

    public static final String PATH = "src/Data/";

    public static void writeFile(String fileName, List<Services> servicesList, boolean writeStatus){
        File file = new File(PATH+fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            fileWriter = new FileWriter(file,writeStatus);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Services services : servicesList){
                bufferedWriter.write(services.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                bufferedWriter.close();
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static List<Services> readFile(String fileName){
        File file = new File(PATH +fileName);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Services> servicesList = new ArrayList<>();
        String[] strings = null;
        String line = null;
        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null){
                strings = line.split(",");
                if (strings.length == 10){
                    Services villa = new Villa(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],strings[8], strings[9]);
                    servicesList.add(villa);
                }else if(strings.length == 9 ){
                    //String id, String name, String areaUse, String cost, String maxPeople, String rentType, String standardRoom, String description, String floors)
                    Services house = new House(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6],strings[7],strings[8]);
                    servicesList.add(house);
                }else {
                    Services room = new Room(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],new ExtraService(strings[6],Double.parseDouble(strings[7]),strings[8]));
                    servicesList.add(room);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                bufferedReader.close();
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return servicesList;
    }
}
