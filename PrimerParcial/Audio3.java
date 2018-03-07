import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Audio3 extends JFrame implements ActionListener{
	
	private AudioInputStream 	audioStream;
	private JPanel	panel1, panel2;
	private JButton bPlay, bPause;
	private File 	fileSong;
	private Clip 	clip;
		
	public Audio3(String song) throws Exception{
		super("EscuchaTec");
		panel1 = new JPanel();
		panel2 = new JPanel();
		bPause = new JButton("Pause");
		bPlay  = new JButton("Play");
		
		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new GridLayout());
		bPause.addActionListener(this);
		bPlay.addActionListener(this);
		panel1.setLayout(new FlowLayout());
		panel1.add(bPlay);
		panel1.add(bPause);
		panel2.add(new JLabel("Now Playing: "+ song));
		panel2.add(panel1);
		add(panel2);
		setSize(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void reproducir(String song) throws Exception{
		fileSong 	= new File(song);
		audioStream = AudioSystem.getAudioInputStream(fileSong);
		clip 		= AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void stop(){
		clip.stop();
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bPlay) {
			try{
				reproducir("takeOnMe.wav");
			}
			catch(Exception ex){
			}
		}
		if(e.getSource()==bPause){
			stop();
		}
	}
	public static void main(String args[]) throws Exception {
		Audio3 audio = new Audio3("takeOnMe.wav");
	}
}