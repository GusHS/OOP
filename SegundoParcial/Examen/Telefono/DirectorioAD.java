import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class DirectorioAD {
    private BufferedReader archivoIn;
    private Vector vectorDirectorio, vectorDatos;

    public Vector getPersonas() {
        String str;
        try {
            //Abrir el archivo con los Datos.
            archivoIn = new BufferedReader(new FileReader("Directorio.txt"));
            //Leer los datos del archivo.
            vectorDirectorio = new Vector();
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                vectorDirectorio.add(str);
            }
            //Cerrar el archivo
            archivoIn.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
        return vectorDirectorio;
    }

    public String getDatos(String edit) {
        String str, casa, nombre, celular, direccion,strLibros = "", output = "";
        StringTokenizer st;
        try {
            //Abrir el archivo con los datos.
            archivoIn = new BufferedReader(new FileReader("Datos.txt"));
            vectorDatos = new Vector();

            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                st = new StringTokenizer(str, "_");
                nombre = st.nextToken();
                casa = st.nextToken();
                celular = st.nextToken();
                direccion = st.nextToken();

                if (edit.equals(nombre)) {
                    strLibros = "Nombre: " + nombre + "\n" + "Telefono de casa: " + casa + "\n" + "Telefono celular: " + celular+ "\n"+ "Direccion: " + direccion+ "\n";
                    output = output + "\n" + strLibros;
                }
            }
            archivoIn.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
        return output;
    }

}