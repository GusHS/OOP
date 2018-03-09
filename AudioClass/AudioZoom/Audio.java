import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

//import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio
{
    private String song;
    private File songFile;
    
    private FileInputStream fileInputStream;
    private BufferedInputStream buffInputStream;
    private Player player;
    
    public void reproducir() throws Exception
    {
        // 1. Especificar el nombre de la cancion a reproducir
        //song = "SOS.mp3";
        song = "Take On Me";
        
        // 2. Abrir el archivo .mp3 de la cancion usando File
        songFile = new File(song);
        
        // 3. Preparar el Audio Stream relacionado con la cancion
        fileInputStream = new FileInputStream(songFile);
        buffInputStream = new BufferedInputStream(fileInputStream);
        
        // 4. Reproducir la cancion con el metodo de la clase Player
        player = new Player(buffInputStream);
        player.play();
    }
    
    public static void main(String args[]) throws Exception
    {
        Audio audio = new Audio();
        audio.reproducir();
    }
}
