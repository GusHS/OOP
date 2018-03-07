import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradosGUI4 extends JFrame implements ActionListener{
	
	private JTextField 	tfGrados;
	private JButton 	bCalcular,bCalcular1, bSalir;
	private JPanel 		panel1, panel2;
	private JTextArea 	taDatos;
	private CalculosDP 	calculos = new CalculosDP(); 
	
	public GradosGUI4(){
		super("Conversion de Grados");
		//1. Crear objetos de los atributos o variables de la clase.
		tfGrados  	= new JTextField();
		bCalcular 	= new JButton("G. Centigrados a G.Farenheit");
		bCalcular1	= new JButton("G. Farenheit a Centigrados");
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
		
		//4.A�adir panel2 en el JFame y Hacer Visible el JFrame.		
		setSize(600,400);
	}
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == bCalcular){
			//1. Leer Valores del textField los grados a convertir.
			String strGrados = tfGrados.getText();
			
			//2. Conversi�n.
			float gc = Float.parseFloat(strGrados);
			float gf =  calculos.gradosCF(gc);
			//3.Desplegar el resultado.
			taDatos.setText(gc+" grados Centigrados = "+gf+" grados Farenheit");
		}		
		
		if (event.getSource() == bCalcular1){
			//1. Leer Valores del textField los grados a convertir.
			String strGrados = tfGrados.getText();
			
			//2. Conversi�n.
			float gf = Float.parseFloat(strGrados);
			float gc = calculos.gradosFC(gf);
			//3.Desplegar el resultado.
			taDatos.setText(gf+" grados Farenheit = "+gc+" grados Centigrados");
	
		}
		
		if (event.getSource() == bSalir){
			System.exit(0);
		}
	}
	public JPanel getPanel2(){
        return panel2;
	}
	public static void main(String args[]){
		GradosGUI4 grados = new GradosGUI4();
	}	
}