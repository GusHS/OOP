import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EcuacionGUI extends JFrame implements ActionListener{
    private JTextField   tfCoeficienteA, tfCoeficienteB ,tfCoeficienteC;
    private JTextArea    taDatos;
    private JButton      bCalcular, bSalir;
    private JPanel       panel1, panel2;
    private CalculosDP   calculos = new CalculosDP();
    public EcuacionGUI(){
        super("Ecuacion Cuadratica");
        tfCoeficienteA = new JTextField();
        tfCoeficienteB = new JTextField();
        tfCoeficienteC = new JTextField();
        taDatos        = new JTextArea(10,20);
        bCalcular      = new JButton("Calcular Raiz");
        bSalir         = new JButton("Exit");
        panel1         = new JPanel();
        panel2         = new JPanel();

        bCalcular.addActionListener(this);
        bSalir.addActionListener(this);

        panel1.setLayout(new GridLayout(4,4));
        panel2.setLayout(new FlowLayout());
        taDatos.setEditable(false);
        panel1.add(new JLabel("Coeficiente de A: "));
        panel1.add(tfCoeficienteA);
        panel1.add(new JLabel("Coeficiente de B: "));
        panel1.add(tfCoeficienteB);
        panel1.add(new JLabel("Coeficiente de C: "));
        panel1.add(tfCoeficienteC);
        panel1.add(bCalcular);
        panel1.add(bSalir);
        panel2.add(panel1);
        panel2.add(taDatos);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JPanel getPanel2(){
        return panel2;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bCalcular){
            calculos.ecuacion(tfCoeficienteA,tfCoeficienteB,tfCoeficienteC,taDatos);
        }
        if(e.getSource()==bSalir){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new EcuacionGUI();
    }
}