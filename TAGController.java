import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TAGController {
    PrintWriter pw;
    String[] key = {"TITULO", "SUBTITULO","TEXTO","LISTA","LISTA_ORD"};
    String[] tags_open = {"<h1>","<h2>","<p>","<ul>","<ol>"};
    String[] tags_close = new String[tags_open.length];
    char INDICE = 99;
    Map<String, Character> map = new HashMap<>();

    public TAGController(PrintWriter pw){
        this.pw = pw;
        inicializaDados();
    }

    private void inicializaDados(){
        for(char i = 0; i < tags_open.length; i++){
            tags_close[i] = tags_open[i];
            tags_close[i] = tags_close[i].replace("<", "</");
            map.put(key[i], i);
        }
    }

    public boolean defineTAG(String command){
        boolean mudou = false;
        if(map.containsKey(command)){
            mudou = true;
            INDICE = map.get(command);
        }
        return mudou;
    }

    public void abreTAG(){
        pw.println(tags_open[INDICE]);
    }

    public void fechaTAG(){
        pw.println(tags_close[INDICE]);
    }

    public void insereDado(String d){
        if(key[INDICE].equals("LISTA")||key[INDICE].equals("LISTA_ORD")){
            pw.println("<li>" +d +"</li>");
            return;
        }
        pw.println(d);
    }

    public void init(){
        pw.println("<html>");
        pw.println("<body>");
    }


    public void close(){
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
