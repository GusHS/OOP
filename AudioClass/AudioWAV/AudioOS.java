
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioOS{
    
    private AudioInputStream audioIn;
    private String song;
    private File songFile;
    private Clip clip;
    
    public void reproducir(String song) throws Exception
    {
        // 2. Abrir el archivo .wav de la cancion usando File
        songFile = new File(song);
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
}
