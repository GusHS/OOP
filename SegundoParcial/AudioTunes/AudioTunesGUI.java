import java.awt.*;
import javax.swing.*;

public class AudioTunesGUI extends JFrame {
    //Atributos de la aplicación
    private JTextField  tfArtista, tfAlbum, tfSong;
    private JTextArea   taArtistas, taAlbums, taSongs;
    private JButton     bCatalogo, bArtista, bAlbums, bSongs;
    private JButton     bPlay, bStop;
    private JPanel      panelUsuario, panelArtistas, panelAlbums;
    private JPanel      panelSongs, panelAudio, panelPrincipal;
    
    public AudioTunesGUI(){
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
    public static void main(String[] args) {
        new AudioTunesGUI();
    }
}