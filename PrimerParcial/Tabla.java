import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tabla extends JFrame implements ActionListener{
    private JButton     bCalcular, bSalir;
    private JTextField  tfNumero;
    private JTextArea   taDatos;
    private JPanel      panel1, panel2;
    private CalculosDP calculos;
    
    public Tabla(){
        super("Tabla de N");
        bCalcular   = new JButton("Tabla de N");
        bSalir      = new JButton("Exit");
        tfNumero    = new JTextField();
        taDatos     = new JTextArea(10,20);
        panel1      = new JPanel();
        panel2      = new JPanel();
        calculos    = new CalculosDP();

        bCalcular.addActionListener(this);
        bSalir.addActionListener(this);


        panel1.setLayout(new GridLayout(2,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(new JLabel("Numero de la Tabla = "));
        panel1.add(tfNumero);
        panel1.add(bCalcular);
        panel1.add(bSalir);
        panel2.add(panel1);
        panel2.add(taDatos);
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JPanel getPanel2(){
        return panel2;   
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bSalir){
            System.exit(0);
        }
        if(e.getSource()==bCalcular){
            int x= Integer.parseInt(tfNumero.getText()); 
            String result = calculos.tabla(x);
            taDatos.setText(result);
        }
    }
    public static void main(String args[]){
        new Tabla();
    }
}