import javax.swing.JOptionPane;

public class Primero{

	public static void main(String args[]){
				
		JOptionPane.showMessageDialog(null,"Hello Java World...");
		String nombre = JOptionPane.showInputDialog("Cu�l es tu nombre?");
		JOptionPane.showMessageDialog(null, "Hello "+nombre+"\nWelcome and goodbye..");	
	}
}