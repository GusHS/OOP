
import java.io.File;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioOS{
    
    private AudioInputStream audioIn;
    private File songFile;
    private Clip clip;
    
    public void reproducir(String song) throws Exception
    {
        System.out.println("[ENTERED REPRODUCIR FUNCTION]");
        // 2. Abrir el archivo .wav de la cancion usando File
        songFile = new File("C:/OOP/PeriodoFinal/AudioConsulta/songs/"+song);
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

    public Vector getSongs(){
        Vector vectorSongs = new Vector<>();
        File path = new File("C:/OOP/PeriodoFinal/AudioConsulta/songs");
        String directorio[] = path.list();
        for(int i=0; i<directorio.length; i++){
            vectorSongs.add(directorio[i]);
        }
        System.out.println("Vector:"+vectorSongs);
        return vectorSongs;
    }
}
