import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	private PrintWriter archivoOut, archivoOut2;
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
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			while(archivoIn.ready())
			{
				str = archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				titulo= st.nextToken();
				autor= st.nextToken();
				editorial= st.nextToken();
				datos = datos+"TITULO:"+titulo+"\n"+"AUTOR: "+autor+"\n"+"EDITORIAL: "+editorial+"\n\n";
			}
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
		int newEditorial= 0;
		int newEntry= 0;
		String resultado="",respuesta="";
		String autor,titulo,editorial,str;
		StringTokenizer st;
		//Separacion de Datos.
		String[] data= datos.split("\\_");
				//data[0] = titulo.
				//data[1] = autor.
				//data[2] = editorial
		//Comparación de Informacion
		try {
			archivoIn = new BufferedReader(new FileReader("Libros.txt"));
			archivoOut = new PrintWriter(new FileWriter("Libros.txt",true));
			archivoOut2 = new PrintWriter(new FileWriter("Editoriales.txt",true));
			while (archivoIn.ready()) {
				str = archivoIn.readLine();
				st = new StringTokenizer(str,"_");
				titulo = st.nextToken();
				autor = st.nextToken();
				editorial = st.nextToken();
					if (data[2].equals(editorial)) {
						newEditorial++;
					}
					if (data[0].equals(titulo)&&data[1].equals(autor)&&data[2].equals(editorial)) {
						newEntry++;
					}	
			}
			if(newEditorial==0){
				archivoOut2.println(data[2]);
			}
			if(newEntry==0){
				archivoOut.print(datos+"\n");
			}
			archivoIn.close();
			archivoOut.close();	
			archivoOut2.close();
		}
		catch (Exception e) {
			//TODO: handle exception
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