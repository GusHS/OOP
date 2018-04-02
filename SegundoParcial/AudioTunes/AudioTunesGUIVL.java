import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.Vector;
public class AudioTunesGUIVL extends JFrame implements ActionListener, ListSelectionListener{
    //Atributos de la aplicación
    private JTextField  tfArtista, tfAlbum, tfSong;
    private JTextArea   taArtistas, taAlbums, taSongs;
    private JButton     bCatalogo, bArtista, bAlbums, bSongs;
    private JButton     bPlay, bStop;
    private JPanel      panelUsuario, panelArtistas, panelAlbums;
    private JPanel      panelSongs, panelAudio, panelPrincipal;
    private JList       listaArtistas, listaAlbums, listaSongs;
    private Vector      vectorArtistas, vectorAlbums, vectorSongs;

    private AudioOSWAV  audioOSWAV;
    private AudioTunesADVL audioTunesAD;
    
    public AudioTunesGUIVL(){
        super("Audio Tunes");

        //1. Crear Objetos de los Atributos.
        tfArtista   = new JTextField(10);
        tfAlbum     = new JTextField(10);
        tfSong      = new JTextField(10);
        taArtistas = new JTextArea("Artistas",20,20);
        taAlbums   = new JTextArea("Albums");
        taSongs    = new JTextArea("Songs",20,20);
        bCatalogo = new JButton("Catalogo");
        bArtista  = new JButton("Artista");
        bAlbums   = new JButton("Albums");
        bSongs    = new JButton("Songs");
        bPlay     = new JButton("Play");
        bStop     = new JButton("Stop");
        panelUsuario   = new JPanel();
        panelArtistas  = new JPanel();
        panelAlbums    = new JPanel();
        panelSongs     = new JPanel();
        panelAudio     = new JPanel();
        panelPrincipal = new JPanel();
        audioTunesAD = new AudioTunesADVL();
        audioOSWAV   = new AudioOSWAV();

        //Adicionar actionListener a los JButtons.
        bPlay.addActionListener(this);
        bStop.addActionListener(this);
        bCatalogo.addActionListener(this);
        bAlbums.addActionListener(this);
        bSongs.addActionListener(this);
        
        //2. Definir Layouts de los JPanels.
        panelUsuario.setLayout(new FlowLayout());
        panelArtistas.setLayout(new GridLayout(1,1));
        panelAlbums.setLayout(new GridLayout(1,1));
        panelSongs.setLayout(new GridLayout(1,1));
        panelAudio.setLayout(new FlowLayout());
        panelPrincipal.setLayout(new BorderLayout());

        //3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bCatalogo);
        panelUsuario.add(new JLabel("Artista: "));
        panelUsuario.add(tfArtista);
        panelUsuario.add(bAlbums);
        panelUsuario.add(new JLabel("Albums: "));
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

        //4. Adicionar panel principal al JFrame.
        add(panelPrincipal);
        setSize(700,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String song, respuesta, artistas, artista, albums, songs, album;
      if (e.getSource() == bAlbums) {
        // 1. Leer el Artista
        artista = tfArtista.getText();
        // 2. Obtener los albums
        albums = audioTunesAD.getAlbums(artista);
        // 3. Desplegar los albums en el panel correspondiente.
        taAlbums.setText(albums);
      }
      if(e.getSource() == bCatalogo){
          //1.Obtener los artistas del archivo
          vectorArtistas = audioTunesAD.getArtistas();
          
          //2. SetText
          //taArtistas.setText(artistas);

          //Crear un Jlist del vector artistas
          listaArtistas = new JList(vectorArtistas);
          listaArtistas.addListSelectionListener(this);
          //Desplegar el JList.
          panelArtistas.setVisible(false);
          panelArtistas.removeAll();
          panelArtistas.add(listaArtistas);
      }
      if (e.getSource() == bSongs) {
          album = tfAlbum.getText();
          songs = audioTunesAD.getSongs(album);
          taSongs.setText(songs);
      }


      if (e.getSource()== bPlay) {
          try {
            song = tfSong.getText();
            audioOSWAV.reproducir(song);     
          } 
          catch (Exception ex) {
              System.out.println("Error" + ex);
          }
      }
      if (e.getSource()==bStop) {
          audioOSWAV.stop();
      }
    
    }

    public void valueChanged(ListSelectionEvent lse){
        String artistaElegido;
        if(lse.getValueIsAdjusting()){
            if(lse.getSource()==listaArtistas){
                artistaElegido=(String)listaArtistas.getSelectedValue();
                tfArtista.setText(artistaElegido);
                System.out.println(artistaElegido);            
            }
        }
    }
    public static void main(String[] args) {
        new AudioTunesGUIVL();
    }
}