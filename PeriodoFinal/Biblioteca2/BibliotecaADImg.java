import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;


public class BibliotecaADImg
{
	private BufferedReader archivoIn;
	private Vector vectorEditoriales, vectorLibros, vectorLibros2, vectorDatos;
	private ImageIcon imagenesLibros[];
	public Vector getEditoriales()
	{
		String editoriales="", str;
		try
		{
		
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
			
			//2.Leer los datos del archivo
			vectorEditoriales = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				vectorEditoriales.add(str);
			}
			//3.Cerrar el archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}
		return vectorEditoriales;
	}
	public String getLibros(String editorial)
	{
		String str, libros="",titulo, autor, edit, datos="";
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorLibros2 = new Vector();
			while(archivoIn.ready())
			{
				datos="";
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				autor = st.nextToken();
				edit=st.nextToken();
				if(editorial.equals(edit))
				{
					datos=datos+"TITULO: "+titulo;
					datos=datos+"\nAUTOR: "+autor;
					datos=datos+"\nEDITORIAL: "+edit+"\n\n";
				}
			}
			
			//3.Cerrar archivo
			archivoIn.close();
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return datos;
	}

	public ImageIcon[] getCoversByTitle(String libro){
		String str,titulo, autor, edit, datos="";
		StringTokenizer st;
		Boolean hasContent = false;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorLibros = new Vector();
			vectorLibros2 = new Vector();
			while(archivoIn.ready())
			{
				datos ="";
				str	  =archivoIn.readLine();
				st	=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				autor = st.nextToken();
				edit=st.nextToken();
				if(titulo.equals(libro))
				{
					hasContent = true;
					datos=datos+"TITULO: "+titulo;
					datos=datos+"\nAUTOR: "+autor;
					datos=datos+"\nEDITORIAL: "+edit+"\n\n";
					vectorLibros.add(titulo);
				}
			}
			if(hasContent == false){
				vectorLibros.add("ERROR");
			}
			//3.Cerrar archivo
			archivoIn.close();
			imagenesLibros = new ImageIcon[vectorLibros.size()];
			String strImg="";
			for (int i = 0; i < vectorLibros.size(); i++) {
				strImg = "img/"+(String)vectorLibros.get(i).toString()+".jpg";
				System.out.println("DASDA:"+ strImg);
				imagenesLibros[i] =  new ImageIcon(((new ImageIcon(strImg)).getImage()).getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return imagenesLibros;
	}
	public ImageIcon[] getCoversByEditorial(String editorial){
		String str,titulo, autor, edit, datos="";
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			
			//2.Leer los datos del archivo
			vectorLibros = new Vector();
			vectorLibros2 = new Vector();
			while(archivoIn.ready())
			{
				datos ="";
				str	  =archivoIn.readLine();
				st	=new StringTokenizer(str, "_");
				titulo = st.nextToken();
				autor = st.nextToken();
				edit=st.nextToken();
				if(edit.equals(editorial))
				{
					datos=datos+"TITULO: "+titulo;
					datos=datos+"\nAUTOR: "+autor;
					datos=datos+"\nEDITORIAL: "+edit+"\n\n";
					vectorLibros.add(titulo);
				}
				if (str == null) {
					vectorLibros.add("ERROR");
				}
				
			}
			
			//3.Cerrar archivo
			archivoIn.close();
			imagenesLibros = new ImageIcon[vectorLibros.size()];
			String strImg="";
			for (int i = 0; i < vectorLibros.size(); i++) {
				strImg = "img/"+(String)vectorLibros.get(i).toString()+".jpg";
				imagenesLibros[i] =  new ImageIcon(((new ImageIcon(strImg)).getImage()).getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("Error: " + fnfe);
		}
		catch(IOException ioe)
		{
			System.out.println("Error: "+ioe);
		}

		return imagenesLibros;
	}
}