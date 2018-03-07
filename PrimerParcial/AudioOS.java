import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.io.File;

public class AudioOS{
	AudioInputStream audioStream;
	File fileSong;
	String song;
	Clip clip;

	public void reproducir(JTextField tfSong, JLabel lTitle) throws Exception{
		song 		= tfSong.getText();
		fileSong 	= new File(song);
		audioStream = AudioSystem.getAudioInputStream(fileSong);
		clip 		= AudioSystem.getClip();

        lTitle.setText("Now Playing: "+ song);
		clip.open(audioStream);
		clip.start();
	}

	public void pause(){
		clip.stop();
	}
}