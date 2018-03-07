import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Segundo extends JFrame{
	public Segundo(){
			
		super ("Prueba de Frames");
		add(new JLabel ("Hello World!"));
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String args[]){
		Segundo objeto = new Segundo();
	}
}