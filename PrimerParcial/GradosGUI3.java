import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradosGUI3 extends JFrame implements ActionListener{
	
	private JTextField 	tfGrados;
	private JButton 	bCalcular,bCalcular1, bSalir;
	private JPanel 		panel1, panel2;
	private JTextArea 	taDatos;
	
	public GradosGUI3(){
		super("Conversión de Grados");
		//1. Crear objetos de los atributos o variables de la clase.
		tfGrados  	= new JTextField();
		bCalcular 	= new JButton("G. Centígrados a G.Farenheit");
		bCalcular1	= new JButton("G. Farenheit a Centígrados");
		bSalir 	  	= new JButton("Exit");
		panel1 		= new JPanel();
		panel2 		= new JPanel();
		taDatos 	= new JTextArea(10,30);
		taDatos.setEditable(false);
		
		//1.1 Adicionar addActionListener a los JButtons
		bCalcular.addActionListener(this);
		bCalcular1.addActionListener(this);
		bSalir.addActionListener(this);
		
		//2. Definir el Layout de los JPanels.
		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());
		
		//3. Poner los objetos de los atributos en el JFrame.
		panel1.add(new JLabel("Grados a convertir:"));
		panel1.add(tfGrados);
		panel1.add(bCalcular);
		panel1.add(bCalcular1);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		panel2.add(bSalir);
		
		//4.Añadir panel2 en el JFame y Hacer Visible el JFrame.		
		add(panel2);
		setSize(600,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == bCalcular){
			//1. Leer Valores del textField los grados a convertir.
			String strGrados = tfGrados.getText();
			
			//2. Conversión.
			float gc = Float.parseFloat(strGrados);
			float gf = (float)9/5*gc+32;
			//3.Desplegar el resultado.
			taDatos.setText(gc+" grados Centígrados = "+gf+" grados Farenheit");
		}		
		
		if (event.getSource() == bCalcular1){
			//1. Leer Valores del textField los grados a convertir.
			String strGrados = tfGrados.getText();
			
			//2. Conversión.
			float gf = Float.parseFloat(strGrados);
			float gc = (float)5/9*(gf-32);
			//3.Desplegar el resultado.
			taDatos.setText(gf+" grados Farenheit = "+gc+" grados Centígrados");
	
		}
		
		if (event.getSource() == bSalir){
			System.exit(0);
		}
	}
	public static void main(String args[]){
		GradosGUI3 grados = new GradosGUI3();
	}	
}