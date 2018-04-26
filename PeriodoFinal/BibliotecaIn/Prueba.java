import java.io.BufferedReader;

import javax.swing.JOptionPane;

import jdk.internal.jline.internal.InputStreamReader;

//Runtime.exec("ls")
public class Prueba{
    private BufferedReader sdtIn = new BufferedReader(new InputStreamReader(System.in));
    private String titulo, autor;
    
    public void pedirDatos(){
        try {
            titulo = JOptionPane.showInputDialog("Titulo del Libro: ");
            System.out.println();
            autor = sdtIn.readLine();
        } catch (IOException ioe) {
            System.out.println("Error: "+ioe);
        }
    }
    private void mostrarDatos(){
        JOptionPane.showMessageDialog(null, titulo);
        System.out.println(autor);
    }
    public static void main(String[] args) {
        Prueba pr =new Prueba();
        pr.pedirDatos();
        pr.mostrarDatos();
    }
}