import java.io.*;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        URL website = new URL("https://www.policeone.com/resources/247166006-Non-Emergency-Police-Phone-Numbers/");
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
            String[] inputArr;
            int i = 0;
            Scanner scan = new Scanner(in);
            scan.useDelimiter("\\Z");
            String content = scan.next();

            inputArr = content.split("<tr>|</tr>");
            //System.out.println(Arrays.toString(inputArr));
            scan.close();
            in.close();
            PrintWriter writer = new PrintWriter("emergencyNumbers.txt", "UTF-8");
            while(i < inputArr.length) {
                if (inputArr[i].contains("<td>")) {
                    writer.println(inputArr[i]);
                    ++i;
                } else {
                    ++i;
                }
            }
            writer.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
