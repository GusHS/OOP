import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioGUI extends JFrame implements ActionListener{
    
    private JTextField  tfSong;
    private JTextArea    taDatos;
    private JButton     bPlay, bStop,bCatalog;
    private JPanel      panel1, panel2;
    private JLabel      lbSong;
    private AudioOS     audioOS;
    
    public AudioGUI(){
        super("Audio Reproductor de WAV");
        // 1. Crear los objetos de los atributos
        tfSong  = new JTextField();
        taDatos = new JTextArea("Now Playing: ",20, 20);
        bPlay   = new JButton("Play");
        bStop   = new JButton("Stop");
        bCatalog= new JButton("Catalog");
        lbSong  = new JLabel("Now Playing: ");
        panel1  = new JPanel();
        panel2  = new JPanel();
        audioOS = new AudioOS();
        
        // Adicionar a los JButtons addActionListener
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        bCatalog.addActionListener(this);
        
        // 2. Definir los Layouts para los JPanels
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        
        // 3. Adicionar los objetos a los JPanels correspondientes
        panel1.add(new JLabel("Cancion a reproducir: "));
        panel1.add(tfSong);
        panel1.add(bPlay);
        panel1.add(bStop);
        panel1.add(bCatalog);
        
        panel2.add(panel1);
        panel2.add(taDatos);
        
        
        // 4. Adicionar panel2 al JFrame y hacerlo visible
        add(panel2);
        setSize(350,250);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
        String song;
        if(e.getSource() == bPlay){
            try {
                song = tfSong.getText();
                audioOS.reproducir(song);
                taDatos.setText("Now Playing: "+song); 
            } catch (Exception ex) {
                System.out.println("Exception: "+ex);
            }
        }
        
        if(e.getSource() == bStop){
            audioOS.stop();
        }
    }
    
    public static void main(String args[]){
        new AudioGUI();
    }
}
