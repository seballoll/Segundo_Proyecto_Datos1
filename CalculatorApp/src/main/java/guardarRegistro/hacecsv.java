package guardarRegistro;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class hscecsv implements Serializable {

    static String infix;

    static String postfix;

    static String resultado;

    public List<String[]> csvArraylist;

    java.util.Date fecha = new Date();

    public List<String[]> getCsvArraylist() {
        return csvArraylist;
    }


    public String getResultado() {
        return resultado;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        hacecsv.infix = infix;
    }

    public void calcular() {
        postfix = InfixToPostfix.toPostfix(infix);
        ExpressionTree et = new ExpressionTree();
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
        resultado = Integer.toString(et.evalTree(root));
        writeDataAtEnd("C:\\Users\\Gollo\\OneDrive\\Documentos\\GitHub\\Segundo_Proyecto_Datos1\\CalculatorApp\\src\\main\\java\\guardarRegistro\\registrocalc");
        csvArraylist = CSVtoArray("C:\\Users\\Gollo\\OneDrive\\Documentos\\GitHub\\Segundo_Proyecto_Datos1\\CalculatorApp\\src\\main\\java\\guardarRegistro\\registrocalc");
    }

    public List<String[]> CSVtoArray(String filePath){
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
            r.remove(0);
            return r;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeDataAtEnd(String filePath) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));

            //Verifying the read data here
            String[] data = {infix, resultado, fecha.toString()};
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}