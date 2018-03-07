import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Proyecto extends JFrame implements ActionListener{
    private JMenuBar        mbPrincipal;
    private JMenu           menuOpciones, menuCalculos, menuGrados;
    private JMenuItem       miGradosCF, miGradosFC, miExponencial, miFactorial;
    private JMenuItem       miAudio, miEcuacion, miSalir, miCalculadora, miTabla;
    private JPanel          panel;
    private FactorialGUI2   factorial;
    private Exponencial     exponencial;
    private GradosGUI4      grados;
    private EcuacionGUI     ecuacion;
    private Tabla           tabla;
    private Audio4          audio;
    private Calculadora     calculadora;
    private CalculosDP      calculos;

    public Proyecto() throws Exception{
        super("App: Audio y Calculos");
        mbPrincipal     = new JMenuBar();
        menuOpciones    = new JMenu("Opciones");
        menuCalculos    = new JMenu("Calculos Varios");
        menuGrados      = new JMenu("Grados");
        miGradosCF      = new JMenuItem("G. Celsius a Farenheit");
        miGradosFC      = new JMenuItem("G. Farenheit a Celsius");
        miExponencial   = new JMenuItem("Exponencial");
        miFactorial     = new JMenuItem("Factorial");
        miAudio         = new JMenuItem("Audio");
        miEcuacion      = new JMenuItem("Ecuacion");
        miCalculadora   = new JMenuItem("Calculadora");
        miTabla         = new JMenuItem("Tabla");
        miSalir         = new JMenuItem("Salir");
        panel           = new JPanel();
        factorial       = new FactorialGUI2();
        exponencial     = new Exponencial();
        grados          = new GradosGUI4();
        ecuacion        = new EcuacionGUI();
        audio           = new Audio4();
        calculos        = new CalculosDP();
        calculadora     = new Calculadora();
        tabla           = new Tabla();

        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);
        miExponencial.addActionListener(this);
        miFactorial.addActionListener(this);
        miEcuacion.addActionListener(this);
        miAudio.addActionListener(this);
        miSalir.addActionListener(this);
        miCalculadora.addActionListener(this);
        miTabla.addActionListener(this);
        
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miExponencial);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miEcuacion);
        menuCalculos.add(miCalculadora);
        menuCalculos.add(miTabla);
        menuCalculos.add(menuGrados);
        menuOpciones.add(menuCalculos);
        menuOpciones.add(miAudio);
        menuOpciones.add(miSalir);
        mbPrincipal.add(menuOpciones);
        setJMenuBar(mbPrincipal);
        add(panel);
        setSize(400,400);
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
        if(e.getSource() == miAudio){
            panel.setVisible(false);
            panel = audio.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miCalculadora){
            panel.setVisible(false);
            panel = calculadora.getPanel2();
            panel.setVisible(true);
            add(panel);
        }
        if(e.getSource() == miTabla){
            panel.setVisible(false);
            panel = tabla.getPanel2();
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