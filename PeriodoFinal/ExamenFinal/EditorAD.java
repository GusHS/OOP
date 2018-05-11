import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.io.PrintWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;


public class EditorAD {
    private BufferedReader archivoIn;
    private PrintWriter archivoOut;

    public Vector showFiles(){
        Vector vectorFiles = new Vector<>();
        File path = new File("Docs/");
        String directorio[] = path.list();
        for(int i=0; i<directorio.length; i++){
            vectorFiles.add(directorio[i]);
        }
        return vectorFiles;
    }
    public void copyFile (String nombreArchivo, String datos){
        String fileName;
        String name[]= nombreArchivo.split("\\.");
        fileName = name[0]+" copia."+name[1];
        System.out.println("[COPIED]:" + fileName);
        try {
            archivoOut = new PrintWriter(new FileWriter("Docs/"+fileName));
            archivoOut.print(datos);
            archivoOut.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }    
    }

    public void deleteFile(String nombreArchivo){
        File file = new File("Docs/"+nombreArchivo);
        file.delete();
        System.out.println("File: "+ nombreArchivo+ " has been successfully deleted.");
    }
    
    public String openFile(String nombreArchivo) {
        //Check if name already exists.
        File path = new File("Docs/");
        String directorio[] = path.list();
        String data = "", str;
        for(int i=0; i<directorio.length; i++){
            if((directorio[i]).equals(nombreArchivo)){
               System.out.println("HIT");
                try
                {
                    //1.Abrir el archivo de datos
                    archivoIn = new BufferedReader(new FileReader("Docs/"+nombreArchivo));   
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
            archivoOut = new PrintWriter(new FileWriter("Docs/"+nombreArchivo));
            archivoOut.print(datos);
            archivoOut.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }      
    }
    
    public void saveFileAs(String nombreArchivo, String datos){
        Boolean fileExists = false;
        File path = new File("Docs/");
        String directorio[] = path.list();
        for(int i=0; i<directorio.length; i++){
            if(directorio[i]==nombreArchivo){
                fileExists = true;
            }
        }
        if (fileExists) {
            JOptionPane.showMessageDialog(null, "Error File Exists");
        }else{
            try {
                archivoOut = new PrintWriter(new FileWriter("Docs/"+nombreArchivo));
                archivoOut.print(datos);
                archivoOut.close();
                
            } catch (Exception e) {
                //TODO: handle exception
            } 
        }          
    }
    
}