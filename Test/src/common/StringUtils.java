package common;

public class StringUtils {
    public static final String COMMA = ",";
    public static final String CSV = ".csv";


    public static String concat(String[] content, String comma){
        StringBuffer strBuffer = new StringBuffer(content[0]);

        for(int i =1;i<content.length;i++){
            strBuffer.append(COMMA);
            strBuffer.append(content[i]);
        }
        return strBuffer.toString();
    }

}
