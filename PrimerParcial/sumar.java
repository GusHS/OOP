import javax.swing.JOptionPane;

public class sumar{

    public static void main(String args[]) {
        String strNumero;
        int a,b,c;
        
        JOptionPane.showMessageDialog(null, "Suma de dos números");
        
        //Pedir el valor a
        strNumero = JOptionPane.showInputDialog("Valor de 'a': ");
        a = Integer.parseInt(strNumero);
        
        //Pedir el valor de b
        strNumero = JOptionPane.showInputDialog("Valor de 'b': ");
        b = Integer.parseInt(strNumero);
        //Suma, resultado reflejado en c
        c=a+b;
        JOptionPane.showMessageDialog(null,"La suma es igual a "+ c);
        
        //Desplegar resultado
        
        
    }
}