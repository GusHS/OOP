import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
public class AudioTunesGUIVL extends JFrame implements ActionListener, ListSelectionListener
{
	//Atributos de la aplicacion
	private JPanel panelUsuario, panelArtistas, panelAlbums, panelSongs, panelAudio, panelPrincipal;
	String song, respuesta;
	private JLabel lbSong;
	private File songFile;
    private AudioInputStream audioIn;
    private Clip clip;
	private JButton bCatalogo, bArtista, bAlbums, bSongs;
	private JButton bPlay, bStop;
	private JTextField tfArtista, tfAlbum, tfSong;
	private JTextArea taArtistas, taAlbums, taSongs;
	
	private AudioTunesADVL audiotunesad = new AudioTunesADVL();
	
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
	private JList listaArtistas, listaAlbums, listaSongs;
	
	public AudioTunesGUIVL()
	{
		super("Audio Tunes Tec");
		
		//1.Crear objetos de los atributos
		tfArtista = new JTextField(10);
		tfAlbum   = new JTextField(10);
		tfSong     = new JTextField(10);
		bCatalogo= new JButton("Catalogo");
		bAlbums   = new JButton("Albums");
		bSongs   = new JButton("Songs");
		bPlay   = new JButton("Play");
		bStop   = new JButton("Stop");
		taArtistas   = new JTextArea("Artistas",20, 20);
		taAlbums   = new JTextArea("Albums",20, 20);
		taSongs   = new JTextArea("Songs",20, 20);
		panelUsuario = new JPanel();
		panelArtistas = new JPanel();
		panelAlbums = new JPanel();
		panelSongs = new JPanel();
		panelAudio = new JPanel();
		panelPrincipal = new JPanel();
		
		// Adicionar actionListener a los JButtons
		bPlay.addActionListener(this);
		bStop.addActionListener(this);
		bCatalogo.addActionListener(this);
		bAlbums.addActionListener(this);
		bSongs.addActionListener(this);
		
		
		//2. Definir Layouts de los JPanels
		panelUsuario.setLayout(new FlowLayout());
		panelArtistas.setLayout(new GridLayout(1,1));
		panelAlbums.setLayout(new GridLayout(1,1));
		panelSongs.setLayout(new GridLayout(1,1));
		panelAudio.setLayout(new FlowLayout());
		panelPrincipal.setLayout(new BorderLayout(5,5));
		
		//3. Colocar los objetos de losa tributos en los paneles correspondientes
		panelUsuario.add(bCatalogo);
		panelUsuario.add(new JLabel("Artista: "));
		panelUsuario.add(tfArtista);
		panelUsuario.add(bAlbums);
		panelUsuario.add(new JLabel("Album: "));
		panelUsuario.add(tfAlbum);
		panelUsuario.add(new JLabel("Songs: "));
		panelUsuario.add(bSongs);
		
		panelArtistas.add(new JScrollPane(taArtistas));
		panelAlbums.add(new JScrollPane(taAlbums));
		panelSongs.add(new JScrollPane(taSongs));
		
		panelAudio.add(new JLabel("Song: "));
		panelAudio.add(tfSong);
		panelAudio.add(bPlay);
		panelAudio.add(bStop);
		
		panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
		panelPrincipal.add(panelArtistas, BorderLayout.WEST);
		panelPrincipal.add(panelAlbums, BorderLayout.CENTER);
		panelPrincipal.add(panelSongs, BorderLayout.EAST);
		panelPrincipal.add(panelAudio, BorderLayout.SOUTH);
		
		//4. Adicionar el panelPrincipal al JFrame
		add(panelPrincipal);
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String artistas, artista, albums, albumes, songs;
		if(e.getSource() == bPlay)
        {
            song = tfSong.getText();
            
            respuesta = reproducir(song);
            
            lbSong.setText(respuesta);
        }
        
        if(e.getSource() == bStop)
        {
            clip.stop();
        }
		if (e.getSource()==bCatalogo)
		{
			//1.- Obtener los artistas del archivo
			vectorArtistas=audiotunesad.obtenerArtistas();
			//2. Desplegar los datos en el panel  
			//taArtistas.setText(artistas);
			//2. Crear un JList del vector artistas
			listaArtistas = new JList(vectorArtistas);
			listaArtistas.addListSelectionListener(this);
			//3. Desplegar JList en el panel Artistas
			panelArtistas.setVisible(false);
			panelArtistas.removeAll();
			panelArtistas.add(listaArtistas);
			panelArtistas.setVisible(true);
		}
		if (e.getSource()==bAlbums)
		{
			//1.- Leer el artista de tfArtista
			artista=tfArtista.getText();
			//2. Obtener los albums del artista
			vectorAlbums = audiotunesad.obtenerAlbums(artista);
			//2. Crear un JList del vector artistas
			listaAlbums = new JList(vectorAlbums);
			listaAlbums.addListSelectionListener(this);
			//3. Desplegar JList en el panel Artistas
			panelAlbums.setVisible(false);
			panelAlbums.removeAll();
			panelAlbums.add(listaAlbums	);
			panelAlbums.setVisible(true);
			//3. Desplegar datos
			//taAlbums.setText(albums);
		}
		if (e.getSource()==bSongs)
		{
			//1.- Leer el artista de tfArtista
			albumes=tfAlbum.getText();
			//2. Obtener los albums del artista
			vectorSongs = audiotunesad.obtenerSongs(albumes);
			//2. Crear un JList del vector artistas
			listaSongs = new JList(vectorSongs);
			listaSongs.addListSelectionListener(this);
			//3. Desplegar JList en el panel Artistas
			panelSongs.setVisible(false);
			panelSongs.removeAll();
			panelSongs.add(listaSongs);
			panelSongs.setVisible(true);
			//3. Desplegar datos
			//taSongs.setText(songs);
		}
	}
	public String reproducir(String song) //throws Exception
    {
        String respuesta="";
        
        try
        {
            // 1. Especificar el nobre de la cancion a reproducir
            //song = new File("Lazarus.wav");
            songFile = new File(song+".wav");
            
            // 2. Preparar los streams de audio
            audioIn = AudioSystem.getAudioInputStream(songFile);
            
            // 3. Preparar el AudioStream (audioIn) y reproducirlo
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            
            respuesta = "Now Playing: "+song;
        }
        catch(Exception e)
        {
            respuesta = "Now Playing: Error NO SONG";
            System.out.println("Error: "+e);
        }
        
        return respuesta;
    }
    public void valueChanged(ListSelectionEvent lse)
    {
    	String artistaElegido, albumElegido, songElegido;
    	if(lse.getValueIsAdjusting()==true)
		{
	    	if(lse.getSource()==listaArtistas)
	    	{
	    		artistaElegido = (String)listaArtistas.getSelectedValue();
	    		tfArtista.setText(artistaElegido);
	    		System.out.println(artistaElegido);
	    	}
	    	if(lse.getSource()==listaAlbums)
	    	{
	    		albumElegido = (String)listaAlbums.getSelectedValue();
	    		tfAlbum.setText(albumElegido);
	    		System.out.println(albumElegido);
	    	}
	    	if(lse.getSource()==listaSongs)
	    	{
	    		songElegido = (String)listaSongs.getSelectedValue();
	    		tfSong.setText(songElegido);
				System.out.println(songElegido);
	    	}
    	}
    }
	public static void main(String args[])
	{
		AudioTunesGUIVL aud = new AudioTunesGUIVL();
	}
}