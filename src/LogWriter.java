import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {

    public LogWriter() {
    }

    public void escribir(String texto) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String fechaHoraActual = formatter.format(date);

        try {
            String RUTA = "src/log.txt";
            FileWriter fw = new FileWriter(RUTA, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Fecha y hora: " + fechaHoraActual);
            pw.println(texto);
            pw.println();
            pw.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
