import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorialGUI2 extends JFrame implements ActionListener{
	
	private JTextField 	tfNumero;
	private JButton 	bCalcular, bSalir;
	private JTextArea 	taDatos;
	private JPanel 		panel1,panel2;
	private CalculosDP calculos = new CalculosDP();
	
	public FactorialGUI2(){
		super("Calculo de Factoriales");
		tfNumero 	= new JTextField();
		bCalcular 	= new JButton("Calcular");
		bSalir 		= new JButton("Exit");
		panel1 		= new JPanel();
		panel2 		= new JPanel();
		taDatos 	= new JTextArea(10,20);
		taDatos.setEditable(false);
		
		bCalcular.addActionListener(this);
		bSalir.addActionListener(this);
		panel1.setLayout(new GridLayout(1,2));
		panel2.setLayout(new FlowLayout());
		
		panel1.add(new JLabel("Calcular el factorial de: "));
		panel1.add(tfNumero);
		panel1.add(bCalcular);
		
		panel2.add(panel1);
		panel2.add(taDatos);
		panel2.add(bSalir);
		
		add(panel2);
		setSize(600,400);
		//setVisible(true);
			
		
	}
	public JPanel getPanel2(){
        return panel2;
	}
	
	public void actionPerformed(ActionEvent event){
		String strNumero;
		int input, result;
		if (event.getSource() == bCalcular){
			strNumero = tfNumero.getText();
			input = Integer.parseInt(strNumero);
			result = calculos.factorial(input);
			taDatos.setText("El factorial de "+ strNumero+" es: "+result);
		}
		if (event.getSource() == bSalir){
			System.exit(0);
		}
	}
	public static void main (String args []){
		new FactorialGUI2();
	}
}