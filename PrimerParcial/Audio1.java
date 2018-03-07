import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio1{
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;
    private void reproducir() throws Exception{
        //1. Obtener el nombre de la cancion a reproducir.
        String song = "Lazarus.wav";
        //2. Relacionar el nombre de la cancion con un Archivo (File) .wav
        fileSong = new File(song);
        //3. Preparar el Audio Stream del Archivo de la cancion.
        audioStream = AudioSystem.getAudioInputStream(fileSong);
        //4. Reproducir la cancion
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        while(true) clip.start();
    }
    public static void main(String[] args) throws Exception {
        Audio1 audio1 = new Audio1();  
        audio1.reproducir(); 
    }
}