package guardarRegistro;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class hacecsv {
    public BufferedReader csvreader = null;
    public BufferedWriter csvwriter = null;
    public FileWriter filewriter = null;
    public PrintWriter printWriter = null;
    public String filepath = "src/main/java/guardarRegistro/registro";

    public String readFiles(int identificator) {
        String record = "";
        String row;
        String ident = String.valueOf(identificator);
        boolean conter = false;
        try {
            csvreader = new BufferedReader(new FileReader(filepath));
            while ((row = csvreader.readLine()) != null) {
                if (row.charAt(0) == ident.charAt(0) && conter) {
                    record += "," + row;
                } else if (row.charAt(0) == ident.charAt(0) && !conter) {
                    record += row;
                    conter = true;
                }
            }
            System.out.println(record);
            return record;
        } catch (Exception e) {
            e.printStackTrace();
            return "error en registro";
        }
    }

    public void writeFiles(int identificator, String operation, String result) {
        Calendar calendar = GregorianCalendar.getInstance();
        String ident = String.valueOf(identificator);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String minutes = String.valueOf(calendar.get(Calendar.MINUTE));
        String seconds = String.valueOf(calendar.get(Calendar.SECOND));
        String time = hour + ":" + minutes + ":" + seconds;

        try {
            filewriter = new FileWriter(filepath, true);
            csvwriter = new BufferedWriter(filewriter);
            printWriter = new PrintWriter(csvwriter);

            printWriter.println(ident + "," + operation + "," + result + "," + date + "," + time);
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}