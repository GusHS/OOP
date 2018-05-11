import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class EditorAD {
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;

    public String openFile(String nombreArchivo) {
        //Check if name already exists.
        File path = new File("C:/OOP/PeriodoFinal/EditorTextos/archives/");
        String directorio[] = path.list();
        String data = "", str;
        for(int i=0; i<directorio.length; i++){
            if((directorio[i]).equals(nombreArchivo)){
               System.out.println("HIT");
                try
                {
                    //1.Abrir el archivo de datos
                    archivoIn = new BufferedReader(new FileReader("C:/OOP/PeriodoFinal/EditorTextos/archives/"+nombreArchivo));   
                    //2.Leer los datos del archivo
                    
                    while(archivoIn.ready())
                    {
                        str=archivoIn.readLine();
                        data = data + str+"\n";
                    }
                    //3.Cerrar el archivo
                    archivoIn.close();
                }
                catch(FileNotFoundException fnfe){
                   JOptionPane.showMessageDialog(null, "File Not Found");
                }
                catch(IOException ioe){
                    System.out.println("Error: "+ioe);
                }
            }
        }
        return data;
    }

    public void saveFile(String nombreArchivo, String datos){
        try {
            archivoOut = new PrintWriter(new FileWriter("C:/OOP/PeriodoFinal/EditorTextos/archives/"+nombreArchivo));
            archivoOut.print(datos);
            archivoOut.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }      
    }
}