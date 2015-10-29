package csvtojson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

public class CSVtoJSON {

    public static String makeJSON(String INPUT_filePath, String OUTPUT_filePath) throws JSONException, FileNotFoundException, IOException {

        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(new File(INPUT_filePath));

        while (scan.hasNextLine()) {
            sb.append(scan.nextLine()).append("\n");
        }

        scan.close();

        File output = new File(OUTPUT_filePath);

        BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        JSONArray outArray = CDL.toJSONArray(sb.toString());

        writer.write(outArray.toString(2));
        writer.flush();
        writer.close();
        return output.getAbsolutePath();

    }

    public static String makeJSON(String INPUT_filePath) throws JSONException, FileNotFoundException, IOException {
        return makeJSON(INPUT_filePath, "output.json");

    }

    public static void main(String[] args) throws JSONException, FileNotFoundException, IOException {

        CSVtoJSON app = new CSVtoJSON();
        System.out.println("FILE: " + app.makeJSON("FanDuelCSV.csv"));
    }

}
