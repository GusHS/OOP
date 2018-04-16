import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;

public class BibliotecaAD{
    private BufferedReader archivoIn;
    private Vector vectorEditorial, vectorLibros;
    private ImageIcon imagenesLibros[];
    
    public Vector getEditorial(){
        String str;
        try {
            //Abrir el archivo con los Datos.
            archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
            //Leer los datos del archivo.
            vectorEditorial = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				vectorEditorial.add(str);
			}
            //Cerrar el archivo
            archivoIn.close();
        }
        catch(FileNotFoundException fnfe){
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			System.out.println("Error: "+ioe);
        }
        return vectorEditorial;
    }
    public String getLibros(String edit){
        String str, autor, titulo, editorial, strLibros ="", output="";
        StringTokenizer st;
        try {
            //Abrir el archivo con los datos.
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vectorLibros = new Vector();
            
            while(archivoIn.ready()){
				str = archivoIn.readLine();
				st  = new StringTokenizer(str, "_");
				titulo = st.nextToken();
                autor  = st.nextToken();
                editorial = st.nextToken();
                
				if(edit.equals(editorial))
				{
                    strLibros = "Titulo: "+ titulo+"\n"+"Autor: "+autor+"\n"+"Editorial: "+editorial+"\n";
                    output = output+"\n"+ strLibros;
				}
        
            }
            archivoIn.close();
        }
        catch(FileNotFoundException fnfe){
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			System.out.println("Error: "+ioe);
        }
        return output;
    }
    public Vector getImagenesLibros(String edit){
        String str,strImagen, autor, titulo, editorial, strLibros ="", output="";
        StringTokenizer st;
        try {
            //Abrir el archivo con los datos.
            archivoIn = new BufferedReader(new FileReader("Libros.txt"));
            vectorLibros = new Vector();
            
            while(archivoIn.ready()){
				str = archivoIn.readLine();
				st  = new StringTokenizer(str, "_");
				titulo = st.nextToken();
                autor  = st.nextToken();
                editorial = st.nextToken();
                
				if(edit.equals(editorial))
				{
                    vectorLibros.add(titulo);
				}
        
            }
            archivoIn.close();
        }
        catch(FileNotFoundException fnfe){
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe){
			System.out.println("Error: "+ioe);
        }
        imagenesLibros = new ImageIcon[vectorLibros.size()];
        for (int i = 0; i < vectorLibros.size(); i++) {
            strImagen = "img/"+vectorLibros.get(i).toString()+".jpg";
            imagenesLibros[i]=  new ImageIcon(((new ImageIcon(strImagen)).getImage()).getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
        }
        return velibros;
    }

}