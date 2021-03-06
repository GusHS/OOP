import javax.swing.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class AudioTunesADVL{
	private BufferedReader archivoIn;
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
	private ImageIcon imagenesAlbums[];
	public Vector obtenerArtistas()
	{
		String artistas="", str;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Artistas.txt"));
			
			//2.Leer los datos del archivo
			vectorArtistas = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				//artistas = artistas + str + "\n";
				vectorArtistas.add(str);
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
		return vectorArtistas;
	}
	public Vector obtenerAlbums(String artista)
	{
		String str, albums="",grupo, album;
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Albums.txt"));
			
			//2.Leer los datos del archivo
			vectorAlbums = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				grupo = st.nextToken();
				album = st.nextToken();
				if(artista.equals(grupo))
				{
					vectorAlbums.add(album);
					//albums = albums+album+"\n";
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

		return vectorAlbums;
	}
	public Vector obtenerSongs(String albumes)
	{
		String str, songs="",album, song;
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Songs.txt"));
			
			//2.Leer los datos del archivo
			vectorSongs = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				album = st.nextToken();
				song = st.nextToken();
				if(albumes.equals(album))
				{
					vectorSongs.add(song);
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

		return vectorSongs;
	}
	public ImageIcon[] getImagenesAlbums(String artista){
		String str,grupo, album;
		String albums="";
		String strImagen="";
		StringTokenizer st;
		try
		{
			//1.Abrir el archivo de datos
			archivoIn = new BufferedReader(new FileReader("Albums.txt"));
			
			//2.Leer los datos del archivo
			vectorAlbums = new Vector();
			while(archivoIn.ready())
			{
				str=archivoIn.readLine();
				st=new StringTokenizer(str, "_");
				grupo = st.nextToken();
				album = st.nextToken();
				if(artista.equals(grupo))
				{
					vectorAlbums.add(album);
					//albums = albums+album+"\n";
				}
			}
			//3.Cerrar archivo
			archivoIn.close();
			
			//4.Generar la lista de imagenes a partir del vector de albums
			imagenesAlbums = new ImageIcon[vectorAlbums.size()];
			for (int i = 0; i < vectorAlbums.size(); i++) {
				strImagen = "images/"+vectorAlbums.get(i).toString()+".jpg";
				imagenesAlbums[i] = new ImageIcon(((new ImageIcon(strImagen)).getImage()).getScaledInstance(218, 218, java.awt.Image.SCALE_SMOOTH));
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
		return imagenesAlbums;
	}
	public String getAlbum(int albumSelected){
		return vectorAlbums.get(albumSelected).toString();
	}
}