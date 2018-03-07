import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.Panel;

public class Calculadora extends JFrame implements ActionListener{
    private JTextField tfNumero = new JTextField(8);
    
    private JButton bSuma, bResta, bMultiplica, bDivide, bIgual, bClear, bPunto;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bFactorial, bExpo, bRaiz, bCuadrado;
    private Panel   panel1, panel2;
    private JPanel  panel3;
    private float n1, n2;
    private int op;
    private String strNumero = "";
    private float base, x;
    private boolean pointPressed = false;
    
    public Calculadora()
    {
        super("Calculadora");
        
        panel1 = new Panel();
        panel2 = new Panel();
        panel3 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(5,4));
        
        
        panel1.add(tfNumero);
        
        bClear = new JButton("clear");
        panel1.add(bClear);
        
        
        b7 = new JButton("7");
        panel2.add(b7);
        
        b8 = new JButton("8");
        panel2.add(b8);
        
        b9 = new JButton("9");
        panel2.add(b9);
        
        bSuma = new JButton("+");
        panel2.add(bSuma);
        
        b4 = new JButton("4");
        panel2.add(b4);
        
        b5 = new JButton("5");
        panel2.add(b5);
        
        b6 = new JButton("6");
        panel2.add(b6);
        
        bResta = new JButton("-");
        panel2.add(bResta);
        
        b1 = new JButton("1");
        panel2.add(b1);
        
        b2 = new JButton("2");
        panel2.add(b2);
        
        b3 = new JButton("3");
        panel2.add(b3);
        
        bMultiplica = new JButton("x");
        panel2.add(bMultiplica);
        
        b0 = new JButton("0");
        panel2.add(b0);
        
        bPunto = new JButton(".");
        panel2.add(bPunto);
        
        bIgual = new JButton("=");
        panel2.add(bIgual);
        
        bDivide = new JButton("/");
        panel2.add(bDivide);
        
        bFactorial = new JButton("x!");
        panel2.add(bFactorial);
        
        bRaiz = new JButton("sqrt(x)");
        panel2.add(bRaiz);
        
        bCuadrado = new JButton("x^2");
        panel2.add(bCuadrado);
        
        bExpo = new JButton("y^x");
        panel2.add(bExpo);
        
        
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bPunto.addActionListener(this);
        bSuma.addActionListener(this);
        bResta.addActionListener(this);
        bMultiplica.addActionListener(this);
        bDivide.addActionListener(this);
        bClear.addActionListener(this);
        bExpo.addActionListener(this);
        bFactorial.addActionListener(this);
        bIgual.addActionListener(this);
        bRaiz.addActionListener(this);
        bCuadrado.addActionListener(this);

        panel3.setLayout(new FlowLayout());
        panel3.add(panel1);
        panel3.add(panel2);
        setSize(350,220);
    }
    public JPanel getPanel2(){
        return panel3;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bClear){
            pointPressed = false;
            tfNumero.setText("");
        }

        if(e.getSource() == bIgual){
            float x;
            float n2 = Float.parseFloat(tfNumero.getText());
            pointPressed = false;
            
            if(op == 0){
                x = n1 + n2;
                String result = Float.toString(x);
                tfNumero.setText(result);
            }
            if(op == 1){
                x = n1 - n2;
                String result = Float.toString(x);
                tfNumero.setText(result);
            }
            if(op == 2){
                float y = (float) n1/n2;
                String result = Float.toString(y);
                tfNumero.setText(result);
            }
            if(op == 3){
                x = n1 * n2;
                String result = Float.toString(x);
                tfNumero.setText(result);
            }
            if(op == 4){
                x = 1;
        
                for(int i=1; i<=n2; i++){
                    x = x * n1;
                }
                String result = Float.toString(x);
                tfNumero.setText(result);
            }
        }


        if(e.getSource() == bFactorial){
            pointPressed = false;
            float x = Float.parseFloat(tfNumero.getText());
            float f=1;
            for(int i=1;i<=x;i++)
            {
                f=f*i;
            }
            String result = Float.toString(f);
            tfNumero.setText(result);
        }
        if(e.getSource() == bRaiz){
            pointPressed = false;
            float x = Float.parseFloat(tfNumero.getText());
            float f = (float)(Math.sqrt(x));
            
            String result = Double.toString(f);
            tfNumero.setText(result);
        }

        if(e.getSource() == bCuadrado){
            pointPressed = false;
            Float x = Float.parseFloat(tfNumero.getText());
            x= x*x;  
            String result = Float.toString(x);
            tfNumero.setText(result);
        }

        if(e.getSource() == bSuma){
            pointPressed = false;
            n1 = Float.parseFloat(tfNumero.getText()); 
            op = 0;
            tfNumero.setText("");
        }

        if(e.getSource() == bResta){
            pointPressed = false;
            n1 = Float.parseFloat(tfNumero.getText()); 
            op = 1;
            tfNumero.setText("");
        }

        if(e.getSource() == bDivide){
            pointPressed = false;
            n1 = Float.parseFloat(tfNumero.getText()); 
            op = 2;
            tfNumero.setText("");
        }

        if(e.getSource() == bMultiplica){
            pointPressed = false;
            n1 = Float.parseFloat(tfNumero.getText()); 
            op = 3;
            tfNumero.setText("");
        }
        if(e.getSource() == bExpo){
            pointPressed = false;
            n1 = Float.parseFloat(tfNumero.getText()); 
            op = 4;
            tfNumero.setText("");
        }

        if(e.getSource() == bPunto){
            if(pointPressed == false){
                tfNumero.setText(tfNumero.getText()+".");
                pointPressed = true;
            }
        }

        if(e.getSource() == b0){
            tfNumero.setText(tfNumero.getText()+"0");
        }

        if(e.getSource() == b1){
            tfNumero.setText(tfNumero.getText()+"1");
        }

        if(e.getSource() == b2){
            tfNumero.setText(tfNumero.getText()+"2");
        }

        if(e.getSource() == b3){
            tfNumero.setText(tfNumero.getText()+"3");
        }

        if(e.getSource() == b4){
            tfNumero.setText(tfNumero.getText()+"4");
        }

        if(e.getSource() == b5){
            tfNumero.setText(tfNumero.getText()+"5");
        }

        if(e.getSource() == b6){
            tfNumero.setText(tfNumero.getText()+"6");
        }

        if(e.getSource() == b7){
            tfNumero.setText(tfNumero.getText()+"7");
        }

        if(e.getSource() == b8){
            tfNumero.setText(tfNumero.getText()+"8");
        }

        if(e.getSource() == b9){
            tfNumero.setText(tfNumero.getText()+"9");
        }
        
        


    }
    
    public static void main(String args[])
    {
        Calculadora calculadora = new Calculadora();
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
