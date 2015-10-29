package importapp;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.*;

public class ImportApp {

    File in_file;

    public ImportApp() {
        in_file = new File("FanDuelCSV.csv");
        CSVParser parser = getCSVParser(in_file);
        printRecords(parser);
    }

    public void printRecords(CSVParser par) {
        try {
            ArrayList<CSVRecord> CSVList= (ArrayList<CSVRecord>) par.getRecords();
//            System.out.println(csvRecord.get(0) + "\t" + csvRecord.get(1)+ " \t\t" + csvRecord.get(2)+ "\t" + csvRecord.get(3)+ "\t" + csvRecord.get(4));
            System.out.println("number of records: " + CSVList.size());  
            ListIterator it = CSVList.listIterator();
            
            while(it.hasNext()){
            CSVRecord rec = (CSVRecord)it.next();
            
            Iterator it2 = rec.iterator();
            
                while(it2.hasNext()){
                String s = (String)it2.next();
                    System.out.print(s+" ");
                }
                System.out.println("");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ImportApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public CSVParser getCSVParser(File file) {

        CSVParser parser = null;

        try {
            parser = CSVParser.parse(file, Charset.defaultCharset(), CSVFormat.EXCEL);
        } catch (IOException ex) {
            System.out.println("Get Parser Error!!");
            System.exit(-1);
        }

        return parser;
    }

    public static void main(String[] args) {
        ImportApp app = new ImportApp();
    }

}
