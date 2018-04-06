import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Proyecto extends JFrame implements ActionListener{
    private JMenuBar        mbPrincipal;
    private JMenu           menuOpciones, menuCalculos, menuGrados, menuAudio;
    private JMenuItem       miGradosCF, miGradosFC, miExponencial, miFactorial;
    private JMenuItem       miAudioWAV, miAudioFX, miAudioZoom, miAudioTunes; 
    private JMenuItem       miEcuacion, miSalir;
    private JPanel          panel;
    private FactorialGUI2   factorial;
    private Exponencial     exponencial;
    private GradosGUI4      grados;
    private EcuacionGUI     ecuacion;
    private CalculosDP      calculos;
    private AudioWAVGUI     audioWAV;
    private AudioFXGUI      audioFX;
    private AudioZoomGUI    audioZoom;
    private AudioTunesGUIVL audioTunes;


    public Proyecto() throws Exception{
        super("App: Audio y Calculos");
        mbPrincipal     = new JMenuBar();
        menuAudio       = new JMenu("Audio");
        menuOpciones    = new JMenu("Opciones");
        menuCalculos    = new JMenu("Calculos Varios");
        menuGrados      = new JMenu("Grados");
        miGradosCF      = new JMenuItem("G. Celsius a Farenheit");
        miGradosFC      = new JMenuItem("G. Farenheit a Celsius");
        miExponencial   = new JMenuItem("Exponencial");
        miFactorial     = new JMenuItem("Factorial");
        miAudioWAV      = new JMenuItem("Audio WAV");
        miAudioFX       = new JMenuItem("Audio FX");
        miAudioZoom     = new JMenuItem("Audio Zoom");
        miAudioTunes    = new JMenuItem("Audio Tunes");
        miEcuacion      = new JMenuItem("Ecuacion");
        miSalir         = new JMenuItem("Salir");
        panel           = new JPanel();
        factorial       = new FactorialGUI2();
        exponencial     = new Exponencial();
        grados          = new GradosGUI4();
        ecuacion        = new EcuacionGUI();
        calculos        = new CalculosDP();
        audioWAV        = new AudioWAVGUI();
        audioFX         = new AudioFXGUI();
        audioZoom       = new AudioZoomGUI();
        audioTunes      = new AudioTunesGUIVL();
       

        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);
        miExponencial.addActionListener(this);
        miFactorial.addActionListener(this);
        miEcuacion.addActionListener(this);
        miAudioWAV.addActionListener(this);
        miSalir.addActionListener(this);
        miAudioFX.addActionListener(this);
        miAudioZoom.addActionListener(this);
        miAudioTunes.addActionListener(this);
        
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miExponencial);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miEcuacion);
        menuCalculos.add(menuGrados);
        menuOpciones.add(menuCalculos);
        menuAudio.add(miAudioWAV);
        menuAudio.add(miAudioFX);
        menuAudio.add(miAudioZoom);
        menuAudio.add(miAudioTunes);
        menuOpciones.add(miSalir);
        mbPrincipal.add(menuOpciones);
        mbPrincipal.add(menuAudio);
        setJMenuBar(mbPrincipal);
        add(panel);
        setSize(800,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == miGradosCF || e.getSource()== miGradosFC){
            panel.setVisible(false);
            panel = grados.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miExponencial){
            panel.setVisible(false);
            panel = exponencial.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miFactorial){
            panel.setVisible(false);
            panel = factorial.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miEcuacion){
            panel.setVisible(false);
            panel = ecuacion.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miAudioWAV){
            panel.setVisible(false);
            panel = audioWAV.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if (e.getSource() == miAudioFX) {
            panel.setVisible(false);
            panel = audioFX.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if (e.getSource() == miAudioZoom) {
            panel.setVisible(false);
            panel = audioZoom.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if (e.getSource() == miAudioTunes) {
            panel.setVisible(false);
            panel = audioTunes.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miSalir){
            System.exit(0);
        }
    }
    public static void main(String args[]) throws Exception {
        new Proyecto();
    }
}