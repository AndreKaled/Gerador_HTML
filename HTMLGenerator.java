import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class HTMLGenerator {

    public static void main(String[] args) {
        // Arquivo de entrada e saída
        String inputFile = "input.txt", outputFile = "output.html";
        File fileHTML = new File(outputFile), fileInput = new File(inputFile);
        
        try {
            Scanner s = new Scanner(fileInput);
            PrintWriter pw = new PrintWriter(fileHTML);
            TAGController tc = new TAGController(pw);
            tc.init();
            while(s.hasNextLine()){
                String[] dados = s.nextLine().split(" ");
                for(String dado : dados){
                    if(tc.defineTAG(dado)){
                        tc.abreTAG();
                        continue;
                    }
                    tc.insereDado(dado);
                }
                tc.fechaTAG();
            }
            tc.close();
        } catch (Exception e) {
        }
    }
}
