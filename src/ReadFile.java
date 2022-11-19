import java.io.*;
import java.util.*;


public class ReadFile {
    public static ArrayList<String> readFileToArrList(String filePath){
//        String file = FlatFileGraphic.class.getResource("")+filePath;
        File csv = new File(filePath);

        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(csv), "UTF-8");
            br = new BufferedReader(inputStreamReader);
        }catch (Exception e){
            e.printStackTrace();
        }
        String line = "";
        ArrayList<String> record = new ArrayList<>();
        try {
            line = br.readLine();
            while (line != null){
                System.out.println(line);
                record.add(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return record;
    }
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

    /*
     * function for writing the input file to another
     */
    public static String writeIn(String writeFileName, String readFileName) {
        String readFilePath = GUI.class.getResource("") + readFileName;
        readFilePath = readFilePath.split(":")[1];
        String writeFilePath = GUI.class.getResource("") + writeFileName;
        writeFilePath = writeFilePath.split(":")[1];
//        String path = "/Users/shengjiemao/Desktop/readFile/src/";
//        String contentPath = "/Users/shengjiemao/Desktop/readFile/src/" + readFileName;
        File file;
        String writer;
        StringBuilder sb;
        try {
            /*
             * create new file
             */
            file = new File(writeFilePath);
            file.createNewFile();

            /*
             * update the content from file input to new file
             */
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

                /*
                 * store the updated first five lines
                 */
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
