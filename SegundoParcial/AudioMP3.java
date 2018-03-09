import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.media.MediaPlayer;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AudioMP3 extends JFrame implements ActionListener{
    private MediaPlayer player;
    private File        fileSong;
    private JPanel	    panel1, panel2;
	private JButton     bPlay, bPause;
    private JTextField  tfSong;
    private String      song;
    private JLabel      lTitle;
		
	public AudioMP3(){
		super("EscuchaTec");
		panel1 = new JPanel();
		panel2 = new JPanel();
		bPause = new JButton("Pause");
        bPlay  = new JButton("Play");
        tfSong = new JTextField();
        lTitle = new JLabel("Now Playing: ");

        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(3,1));
		bPause.addActionListener(this);
		bPlay.addActionListener(this);
		panel1.setLayout(new FlowLayout());
		panel1.add(bPlay);
		panel1.add(bPause);
		panel2.add(lTitle);
        panel2.add(panel1);
        panel2.add(tfSong);
        add(panel2);
        setSize(400,400);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void reproducir(){


	}
	public void stop(){

	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bPlay) {
			try{
				reproducir();
			}
			catch(Exception ex){
                System.out.println("Exception... play.");
			}
		}
		if(e.getSource()==bPause){
			stop();
		}
	}
	public static void main(String args[]) throws Exception {
		new AudioMP3();
	}
}