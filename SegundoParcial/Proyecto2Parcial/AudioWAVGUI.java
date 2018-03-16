import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioWAVGUI extends JFrame implements ActionListener
{
    private JTextField tfSong;
    private JButton    bPlay, bStop;
    private JPanel panel1, panel2;
    private JLabel lbSong;
    private File songFile;
    private AudioInputStream audioIn;
    private Clip clip;
    private AudioWAVOS audioWAVOS;
    
    public AudioWAVGUI()
    {
        super("Audio Reproductor de WAV");
        
        // 1. Crear los objetos de los atributos
        tfSong = new JTextField();
        bPlay  = new JButton("Play");
        bStop  = new JButton("Stop");
        lbSong = new JLabel("Now Playing: ");
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        // Adicionar a los JButtons addActionListener
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        
        // 2. Definir los Layouts para los JPanels
        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos a los JPanels correspondientes
        panel1.add(new JLabel("Cancion WAV a reproducir: "));
        panel1.add(tfSong);
        panel1.add(bPlay);
        panel1.add(bStop);
        
        panel2.add(panel1);
        panel2.add(lbSong);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        String song, respuesta;
        
        if(e.getSource() == bPlay)
        {   
            try {
                song = tfSong.getText();
                audioWAVOS = new AudioWAVOS(song);
                audioWAVOS.reproducir();
                lbSong.setText(song +".wav");
            } 
            catch (Exception eWav) {
                System.out.println("Error:"+ eWav);
            }
           
        }
        
        if(e.getSource() == bStop)
        {
            song = tfSong.getText();
            audioWAVOS = new AudioWAVOS(song);
            audioWAVOS.stop();
        }
    }

    public JPanel getPanel2(){
        return panel2;
    }

}
