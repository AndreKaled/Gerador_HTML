import java.io.PrintWriter;

public class TAGController {
    PrintWriter pw;
    String TAG_open, TAG_close;

    public TAGController(PrintWriter pw){
        this.pw = pw;
        nullState();
    }

    public boolean defineTAG(String command){
        boolean mudou = false;
        switch (command) {
            case "TITULO":
                TAG_open = "<h1>";
                TAG_close = "</h1>";
                mudou = true;
                break;
            default:
                break;
        }
        return mudou;
    }

    public void abreTAG(){
        pw.println(TAG_open);
    }

    public void fechaTAG(){
        pw.println(TAG_close);
        nullState();
    }

    private void nullState(){
        TAG_open = null;
        TAG_close = null;
    }

    public void insereDado(String d){
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
