import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exponencial extends JFrame implements ActionListener{
    private JTextField  tfBase, tfExponencial;
    private JButton     bCalcular, bSalir;
    private JPanel      panel1, panel2;
    private JTextArea   taDatos;
    private CalculosDP  calculos = new CalculosDP();

    public Exponencial(){
        super("Calculo de Exponencial");
        tfBase          = new JTextField();
        tfExponencial   = new JTextField();
        bCalcular       = new JButton("Calcular");
        bSalir          = new JButton("Salir");
        panel1          = new JPanel();
        panel2          = new JPanel();
        taDatos         = new JTextArea(10,20);
        taDatos.setEditable(false);

        bCalcular.addActionListener(this);
        bSalir.addActionListener(this);

        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(new JLabel("Valor de la base: "));
        panel1.add(tfBase);
        panel1.add(new JLabel("Valor del exponente: "));
        panel1.add(tfExponencial);
        panel1.add(bCalcular);


        panel2.add(panel1);
        panel2.add(taDatos);
        panel2.add(bSalir);

        add(panel2);
        //setVisible(true);
        setSize(400,400);

        
    }
    public JPanel getPanel2(){
        return panel2;
	}
    public void actionPerformed (ActionEvent event){

        if(event.getSource() == bCalcular){
            int base = Integer.parseInt(tfBase.getText());
            int exp = Integer.parseInt(tfExponencial.getText());
            float result= calculos.exponencial(base, exp);
            taDatos.setText(base+ " elevado a la " + exp+ " es: "+ result);
        }
        if(event.getSource()== bSalir){
            System.exit(0);
        }
    }

    public static void main(String args[]){
       new Exponencial();
    }
}