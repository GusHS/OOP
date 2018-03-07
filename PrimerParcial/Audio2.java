import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio2 extends JFrame{
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;

    public Audio2() throws Exception{
        super("EscuchaTEC");
        reproducir();
        setSize(300,300);
        setVisible(true);
    }
    private void reproducir() throws Exception{
        //1. Obtener el nombre de la cancion a reproducir.
        String song = "takeOnMe.wav";
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
        Audio2 audio2 = new Audio1();  
        audio2.reproducir(); 
    }
}