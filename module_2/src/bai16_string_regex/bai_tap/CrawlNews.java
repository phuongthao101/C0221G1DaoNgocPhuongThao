package bai16_string_regex.bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try {
            System.out.println();
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");

            // open the stream and put it into InputStreamReader

//            InputStreamReader inputStreamReader=new InputStreamReader(url.openStream());
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");

            // regex
            Pattern p = Pattern.compile("title=(\"(.*?)\")");
//                        Pattern p = Pattern.compile("((?<=title=\\\")([^\\\"]*))");

            Matcher m = p.matcher(content);
            System.out.println("Danh sach bai viet la : ");
            while (m.find()) {
                System.out.println(m.group(1));
            }
            System.out.println("Done");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
