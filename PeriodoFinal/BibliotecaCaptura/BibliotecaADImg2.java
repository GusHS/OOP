import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;

public class BibliotecaADImg2{
	
	private BufferedReader archivoIn;
	private PrintWriter archivoOut;
	private Vector vectorEditoriales, vectorLibros;
	
	private ImageIcon imagenesLibros[];
		
    public Vector ObtenerEditoriales(){
    	
		String editoriales="",str;
		
		try
		{
		//Abrir el archivo de datos
		archivoIn = new BufferedReader(new FileReader("Editoriales.txt"));
		
		//Leer todos los datos del archivo
		vectorEditoriales = new Vector();
		
		while(archivoIn.ready())
		{
			str = archivoIn.readLine();
			
			//artistas = artistas + str + "\n";
			vectorEditoriales.add(str);

		}
		//Cerrar el archivo 
		archivoIn.close();
	
		}catch(FileNotFoundException e)
		{
		System.out.println("Error: "+ e);
		}catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		
		return vectorEditoriales;
	}
	
	public Vector ObtenerLibros(String ed)
	{
		String str, libros="", editorial, libro, autor;
		StringTokenizer st;
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			//Leer los datos del artista 
			
			vectorLibros = new Vector();
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial = st.nextToken();
				
				
				System.out.println(libro);
				
				if(editorial.equals(ed))
				{
					//albums = albums + album + "\n";
					vectorLibros.add(libro);
				}
			}
			//Cerra el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return vectorLibros;
	}
	
	public String getInfo(String libroElegido)
	{
		String str, titulo, autor, editorial, datos="";
		StringTokenizer st;
		
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			//Leer los datos de la persona 
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_,\n");
				titulo = st.nextToken();
				autor = st.nextToken();
				editorial = st.nextToken();
				
				if(libroElegido.equals(titulo))
				{
					datos =datos + "Titulo: " + titulo +  "\nAutor: " + autor +  "\nEditorial: " + editorial + "\n\n";
					
					System.out.println(titulo);
					System.out.println(autor);
					System.out.println(editorial);
				}
			}
			
			//Cerra el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return datos;
	}
	
	
	
	public String consultarLibros()
	{
		String str, titulo, autor, editorial, datos="";
		StringTokenizer st;
		
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			//Leer los datos de la persona 
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
		
				datos = datos + str +"\n";	
			}
			
			//Cerra el archivo
			archivoIn.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return datos;
	}
	
	public ImageIcon[] obtenerImagenesLibros(String ed)
	{
		String str, libros="", editorial, libro, autor;
		StringTokenizer st;
		
		try
		{
			//Abrir el archivo
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			//Leer los datos del artista 
			
			vectorLibros = new Vector();
			
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				libro = st.nextToken();
				autor = st.nextToken();
				editorial = st.nextToken();
				
				
				System.out.println(editorial);
				
				if(editorial.equals(ed))
				{
					//albums = albums + album + "\n";
					vectorLibros.add(libro);
				}
			}
			//Cerra el archivo
			archivoIn.close();
			
			//Generar la lista de imagenes a partir del vector de albums 
			imagenesLibros = new ImageIcon[vectorLibros.size()];
			String strImagen="";
			
			for(int i=0;i<vectorLibros.size();i++)
			{
				strImagen = "images/"+(String)vectorLibros.get(i).toString()+".jpg";
				imagenesLibros[i] = new ImageIcon(getClass().getResource(strImagen));
				
				System.out.println(strImagen);
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: "+ e);
		}
		catch(IOException io)
		{
			System.out.println("Error:"+io);
		}
		return imagenesLibros;
	}
	
	public String getLibro(int libroSelected)
	{
		return vectorLibros.get(libroSelected).toString();
	}
	
	
	public String capturar(String datos)
	{
		String resultado="",respuesta="";
		
		try
		{
			//Abrir el archivo Libros.txt para capturar datos
			 archivoOut = new PrintWriter(new FileWriter("Libros.txt",true));
			 
			//Capturar los datos 
			archivoOut.println(datos);
			
			//Cerrar el archivo '
			archivoOut.close();
			
			resultado = "Captura exitosa del libro: " + datos;
			
			//Checa si el editorial ya existe en el archivo Editoriales.txt
			respuesta = capturaEditorial(datos);
			
			resultado = resultado + respuesta + "\n";
		
		}
		catch(IOException ioe)
		{
			resultado = "Error en capturar datos....";
			System.out.println("Error: " + ioe);	
		}
		
		//Entregar resultado de la transaccion
		return resultado;
	}
	
	private String capturaEditorial(String datos)
	{
		String resultado="";
		
		//Obtener la editorial
		
		//Abrir el archivo Editoriales.txt
		
		//Buscar la editorial
		
		//Cerrar el archivo
		
		//Si el editorial no exixte capturarlo
		
		//Abrir el archivo Editoriales.txt
		
		//	Escribir o capturar la nueva editorial 
		
		//Cerrar el archivo
		
		//Entregar el resultado
		
		return resultado;
	}
  
}