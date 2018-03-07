import javax.swing.*;
import java.awt.*;
public class FactorialGUI extends JFrame{
	
	JTextField 	tfFactorial;
	JButton		bCalcular, bSalir;
	
	public FactorialGUI(){
		super("Calculo Factorial");
		tfFactorial = new JTextField();
		bCalcular 	= new JButton("Calcular");
		bSalir 		= new JButton("Salir");
		setLayout(new GridLayout(2,2));
		add(new JLabel("Calcular el Factorial de:"));
		add(tfFactorial);
		add(bCalcular);
		add(bSalir);
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String args[]){
		FactorialGUI factorial = new FactorialGUI();
	}
}