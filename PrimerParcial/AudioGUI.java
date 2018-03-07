import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AudioGUI extends JFrame implements ActionListener{
    private JTextField  tfSong;
    private JPanel      panel1,  panel2;
    private JButton     bPlay, bPause;
    private JLabel      lTitle;
    private AudioOS     audioOS;
    
    public AudioGUI(){
        super("Song Player");
        tfSong  = new JTextField(2);
        panel1  = new JPanel();
        panel2  = new JPanel();
        bPlay   = new JButton("Play");
        bPause  = new JButton("Pause");
        lTitle  = new JLabel("Now Playing:");
        audioOS = new AudioOS();
        
        bPause.addActionListener(this);
		bPlay.addActionListener(this);
        
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new GridLayout(3,1));
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
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bPlay){
            try{
                audioOS.reproducir(tfSong, lTitle);
            }
            catch(Exception ex){

            }
        }
        if(e.getSource() == bPause){
            audioOS.pause();
        }
    }
    public static void main(String[] args) {
        new AudioGUI();
    }
}