import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class AudioGUI extends JFrame implements ActionListener, ListSelectionListener{
    
    private JTextField  tfSong;
    private JTextArea   taDatos;
    private JButton     bPlay, bStop,bCatalog;
    private JPanel      panel1, panel2, panel3;
    private AudioOS     audioOS;
    private JList       songList;
    private Boolean     isPlaying = false ;
    
    public AudioGUI(){
        super("Audio Reproductor de WAV");
        // 1. Crear los objetos de los atributos
        tfSong  = new JTextField();
        taDatos = new JTextArea("Now Playing: ",20, 20);
        bPlay   = new JButton("Play");
        bStop   = new JButton("Stop");
        bCatalog= new JButton("Catalog");
        panel1  = new JPanel();
        panel2  = new JPanel();
        panel3  = new JPanel();
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
        panel3.add(taDatos);
        panel2.add(panel1);
        panel2.add(panel3);
    
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
                System.out.println("[ENTERED BPLAY FUNCTION]");
                song = tfSong.getText();
                audioOS.reproducir(song);
                taDatos.setText("Now Playing: "+song); 
            } catch (Exception ex) {
                System.out.println("Exception: "+ex);
            }
        }
        
        if(e.getSource() == bStop){
            audioOS.stop();
            isPlaying = false;
        }

        if (e.getSource()==bCatalog) {
            songList = new JList(audioOS.getSongs());
            songList.addListSelectionListener(this);
            panel3.setVisible(false);
            panel3.removeAll();
            panel3.add(new JScrollPane(songList));
            panel3.setVisible(true);
        }
    }
    public void valueChanged(ListSelectionEvent lse){
        if (lse.getSource() == songList) {
            
            System.out.println("[ENTERED VALUE CHANGED FUNCTION]");
            String song = songList.getSelectedValue().toString();
            try {
                if (isPlaying==false) {
                    audioOS.reproducir(song); 
                    isPlaying = true;
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            tfSong.setText(song);
        }
    }
    
    public static void main(String args[]){
        new AudioGUI();
    }
}
