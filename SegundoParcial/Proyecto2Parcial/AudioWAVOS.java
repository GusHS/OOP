import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioWAVOS {
    private File songFile;    
    private AudioInputStream audioIn;
    private Clip clip;
    private String song;
    
    public AudioWAVOS(String cancion){
        song = cancion;
    }

    public void reproducir() throws Exception
    {
        // 1. Especificar el nombre de la cancion a reproducir        
        // 2. Abrir el archivo .wav de la cancion usando File
        songFile = new File(song+".wav");
        
        // 3. Preparar el Audio Stream relacionado con la cancion
        audioIn = AudioSystem.getAudioInputStream(songFile);
        
        // 4. Reproducir la cancion con los metodos de la clase Clip
        clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
    public void stop() {
        clip.stop();
    }


    public static void main(String args[]) throws Exception
    {
    
    }
}
