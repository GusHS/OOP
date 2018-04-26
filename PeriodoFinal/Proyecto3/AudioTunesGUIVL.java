import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
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
	private JButton bCatalogo, bArtista, bAlbums, bSongs;
	private JButton bPlay, bStop;
	private JTextField tfArtista, tfAlbum, tfSong;
	private JTextArea taArtistas, taAlbums, taSongs;
	private AudioTunesADVL audiotunesad = new AudioTunesADVL();
	private Vector vectorArtistas, vectorAlbums, vectorSongs;
	private JList listaArtistas, listaAlbums, listaSongs;
	private AudioWAVOS audioWAVOS;
	private AudioFXOS audioPlayer;
	private Boolean wavChosen = false;
	
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
		taAlbums   = new JTextArea("Albums",20, 10);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel getPanel2(){
		return panelPrincipal;
	}
	public void actionPerformed(ActionEvent e)
	{
		String artistas, artista, albums, albumes, songs;
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
			panelAlbums.add(listaAlbums);
			panelAlbums.setVisible(true);
		
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
		}
		if (e.getSource()==bPlay){
			String song,termination,songName;
			String wavTerm="wav";
			String mp3Term="mp3";
			
			song = tfSong.getText();
			String[]parts = song.split("\\.");
			songName = parts[0];
			termination = parts[1];
			System.out.println(termination);
			if(termination.equals(wavTerm)){
				wavChosen = true;
				try {
					audioWAVOS = new AudioWAVOS(songName);
                	audioWAVOS.reproducir();
                	lbSong.setText(songName +".wav");
				} catch (Exception ex) {
					System.out.println("Exception: "+ex);
				}
			}
			if (termination.equals(mp3Term)) {
				wavChosen = false;
            	try {
					audioPlayer = new AudioFXOS(songName);
                	audioPlayer.reproducir();   
            	} 
            	catch (Exception ex) {
                	System.out.println("Exception" + ex);
            	}
			}
		}

		if(e.getSource()==bStop){
			if(wavChosen == true){
				audioWAVOS.stop();
			}
			if(wavChosen == false){
				audioPlayer.stop();
			}
		}

	}
	
    public void valueChanged(ListSelectionEvent lse)
    {
		String artistaElegido, albumElegido, songElegido;
    	if(lse.getValueIsAdjusting()==true)
		{
	    	if(lse.getSource()==listaArtistas)
	    	{
	    		artistaElegido = (String)listaArtistas.getSelectedValue();
				vectorAlbums = audiotunesad.obtenerAlbums(artistaElegido);
				listaAlbums = new JList(vectorAlbums);
				listaAlbums.addListSelectionListener(this);
				panelAlbums.setVisible(false);
				panelAlbums.removeAll();
				panelAlbums.add(listaAlbums);
				panelAlbums.setVisible(true);
	    	}
	    	if(lse.getSource()==listaAlbums)
	    	{
	    		albumElegido = (String)listaAlbums.getSelectedValue();
	    		vectorSongs = audiotunesad.obtenerSongs(albumElegido);
				listaSongs = new JList(vectorSongs);
				listaSongs.addListSelectionListener(this);
				panelSongs.setVisible(false);
				panelSongs.removeAll();
				panelSongs.add(listaSongs);
				panelSongs.setVisible(true);
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