/**
 * Assignment7
 * [Yuhao Zhang]
 * [002743843]
 * [Section08]
 */


import java.io.*;
import java.util.*;


public class ReadFile {
    public static String readFile(String filePath) {
        String res;
        StringBuilder sb = new StringBuilder();
        try{
            File csv = new File(filePath);
            csv.setReadable(true);
            csv.setWritable(true);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(csv), "UTF-8");
            BufferedReader br = new BufferedReader(inputStreamReader);
            String str;
            int i = 0;
            while ((str = br.readLine()) != null && i < 6){
                sb.append(str + "\n");
                i += 1;
            }
            res = sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

//write files
    public static String writeFile(String writeFileName, String readFileName) {
        String readFilePath = GUI.class.getResource("") + readFileName;
        readFilePath = readFilePath.split(":")[1];
        String writeFilePath = GUI.class.getResource("") + writeFileName;
        writeFilePath = writeFilePath.split(":")[1];
        File file;
        String writer;
        StringBuilder sb;
        try {
            file = new File(writeFilePath);
            file.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            InputStreamReader br = new InputStreamReader(new FileInputStream(readFilePath));
            BufferedReader reader = new BufferedReader(br);

            InputStreamReader br2 = new InputStreamReader(new FileInputStream(file));
            BufferedReader reader2 = new BufferedReader(br);
            sb = new StringBuilder();

            int i = 0;
            while ((writer = reader.readLine()) != null) {
                String[] sep = writer.split(",");
                bw.append(sep[0] + "," + sep[1] + "," + sep[2] + "\n");


                if (i < 6) {
                    sb.append(sep[0] + "," + sep[1] + "," + sep[2] + "\n");
                    i++;
                }
            }
            writer = sb.toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writer;
    }
}
