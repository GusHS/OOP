import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AudioTunesAD {
    private BufferedReader archivoIn;
    
    public String getArtistas(){
       String artistas= "", str; 
        try {
            //1. Abrir el archivo
            archivoIn = new BufferedReader(new FileReader("Artistas.txt"));
            //2. Leer todos los archivos
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                artistas = artistas + str + "\n";
            }
            //3. Cerrar el archivo
            archivoIn.close();

        } 
        catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        }
        catch(IOException ioe){
            System.out.println("Error: " + ioe);
        }
        return artistas;
    }

    public String getAlbums(String artista){
        String str, album, grupo, albums="";
        StringTokenizer st;

       try {
           //1. Abrir el archivo de datos
            archivoIn = new BufferedReader(new FileReader("Albums.txt"));
            //2. Leer los datos del archivo
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                st = new StringTokenizer(str,"_");
                grupo = st.nextToken();
                album = st.nextToken();

                if(artista.equals(grupo)){
                    albums = albums + album + "\n";
                }
            }

            //3. Cerrar el archivo
            archivoIn.close();
       }
       catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        }
        catch(IOException ioe){
            System.out.println("Error: " + ioe);
        }
        return albums;
    }

    public String getSongs(String album){
        StringTokenizer st;
        String str, albums, song, songs="";
        try {
            archivoIn= new BufferedReader(new FileReader("Songs.txt"));
            while (archivoIn.ready()) {
                str = archivoIn.readLine();
                st= new StringTokenizer(str, "_");
                
                albums = st.nextToken();
                song = st.nextToken();
                
                if(albums.equals(album)){
                    songs = songs + song + "\n";
                }
            }
        } 
        catch (FileNotFoundException fnfe) {
            System.out.println("Error: " + fnfe);
        }
        catch(IOException ioe){
            System.out.println("Error: " + ioe);
        }
        return songs;
    }

    
}