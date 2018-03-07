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
import java.io.FileInputStream;
import java.io.BufferedInputStream;

//import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio1 extends JFrame implements ActionListener
{
    // Atributos de Audio1
    private JTextField tfSong;
    private JButton    bPlay, bStop;
    private JPanel     panel1, panel2;
    private JLabel     lbSong;
    
    private File songFile;
    private FileInputStream fileInputStream;
    private BufferedInputStream buffInputStream;
    private Player player;
    
    public Audio1()
    {
        super("Audio Reproductor MP3");
        
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
        panel1.add(new JLabel("Cancion a reproducir: "));
        panel1.add(tfSong);
        panel1.add(bPlay);
        panel1.add(bStop);
        
        panel2.add(panel1);
        panel2.add(lbSong);
        
        
        // 4. Adicionar panel3 al JFrame y hacerlo visible
        add(panel2);
        setSize(350,250);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public String reproducir(String song) //throws Exception
    {
        String respuesta="";
        
        try
        {
            // 1. Especificar el nobre de la cancion a reproducir
            //song = new File("Lazarus.wav");
            songFile = new File("/JesusGG/Music_JGG/music_mp3/"+song+".mp3");
            
            // 2. Preparar los streams de audio
            fileInputStream = new FileInputStream(songFile);
            buffInputStream = new BufferedInputStream(fileInputStream);
            
            // 3. Preparar el AudioStream (audioIn) y reproducirlo
            player = new Player(buffInputStream);
            player.play();
            
            respuesta = "Now Playing: "+song;
        }
        catch(Exception e)
        {
            respuesta = "Now Playing: Error NO SONG";
            System.out.println("Error: "+e);
        }
        
        return respuesta;
    }
    
    public void actionPerformed(ActionEvent e) //throws Exception
    {
        String song, respuesta;
        
        if(e.getSource() == bPlay)
        {
            song = tfSong.getText();
            
            respuesta = reproducir(song);
            
            lbSong.setText(respuesta);
        }
        
        if(e.getSource() == bStop)
        {
            player.close();
        }
    }
    
    public static void main(String args[]) //throws Exception
    {
        new Audio1();
    }
}
