import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Audio4 extends JFrame implements ActionListener{
	
	private AudioInputStream 	audioStream;
	private JPanel	panel1, panel2;
	private JButton bPlay, bPause;
	private File 	fileSong;
    private Clip 	clip;
    private JTextField tfSong;
    private String song;
    private JLabel lTitle;
		
	public Audio4() throws Exception{
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
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void reproducir() throws Exception{
        song = tfSong.getText();
        lTitle.setText("Now Playing: "+ song);
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
				reproducir();
			}
			catch(Exception ex){
			}
		}
		if(e.getSource()==bPause){
			stop();
		}
	}
	public JPanel getPanel2(){
		return panel2;
	}
	public static void main(String args[]) throws Exception {
		new Audio4 ();
	}
}