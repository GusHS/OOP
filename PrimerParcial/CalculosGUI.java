import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculosGUI extends JFrame implements ActionListener{
    
    private JMenuBar    mbPrincipal;
    private JMenu       menuCalculos, menuGrados;
    private JMenuItem   miFactorial, miGradosCF, miGradosFC, miExponencial, miSalir;
    
    public CalculosGUI(){
        super("Java App: Calculos Varios");

        //1.    Colocar Objetos de los atributos.
        mbPrincipal     = new JMenuBar();
        menuCalculos    = new JMenu("Calculos Varios");
        menuGrados      = new JMenu("Conversion de Grados ");
        miFactorial     = new JMenuItem("Factorial de N");
        miExponencial   = new JMenuItem("Exponencial: Y ^ B");
        miGradosCF      = new JMenuItem("G. Celsius a Farenheit");
        miGradosFC      = new JMenuItem("G. Farenheit a Celsius");
        miSalir         = new JMenuItem("Salir");
        
        //1.1 Colocar el metodo addActionLsitener.
        miSalir.addActionListener(this);
        miFactorial.addActionListener(this);
        miExponencial.addActionListener(this);
        miGradosCF.addActionListener(this);
        miGradosFC.addActionListener(this);
        
        //2.    Colocar los JMenuItems en los JMenus correspondientes.
        menuGrados.add(miGradosCF);
        menuGrados.add(miGradosFC);
        menuCalculos.add(miFactorial);
        menuCalculos.add(miExponencial);
        menuCalculos.add(menuGrados);
        menuCalculos.add(miSalir);

        //3.    Colocar en JMenuBar los Menús
        mbPrincipal.add(menuCalculos);

        //4.    Colocar el JMenuBar en el  JFrame y hacerlo visible
        setJMenuBar(mbPrincipal);
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent event) {
        if(event.getSource()== miSalir)         System.exit(0);
        if(event.getSource()== miFactorial)     new FactorialGUI2();
        if(event.getSource()== miExponencial)   new Exponencial();
        if(event.getSource()== miGradosCF)      new GradosGUI4();
        if(event.getSource()== miGradosFC)      new GradosGUI4();

    }
    public static void main(String args[]){
        new CalculosGUI();
    }

}