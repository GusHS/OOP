import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class DirectorioGUI extends JFrame implements ActionListener, ListSelectionListener
{
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelPersonas, panelDatos, panelPrincipal;
    
    private JButton bDirectorio;
    private JTextArea taDirectorio, taDatos;
    
    private DirectorioAD directorioad = new DirectorioAD();
    
    private Vector vectorPersonas;
    private JList  listaPersonas;
    
    public DirectorioGUI()
    {
        super("Directorio Personal");
        
        // 1. Crear objetos d elos atributos
        
        bDirectorio = new JButton("Directorio"); 
        taDirectorio= new JTextArea("Familiares y Amigos",20,20);
        taDatos= new JTextArea("Datos de Familiares y Amigos",20,20);
        
        panelUsuario  = new JPanel();
        panelPersonas = new JPanel();
        panelDatos    = new JPanel();
        panelPrincipal= new JPanel();
        
        // Adionar actionListener a los JButtons
        bDirectorio.addActionListener(this);
        
        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new FlowLayout());
        panelPersonas.setLayout(new GridLayout(1,2));
        panelDatos.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new FlowLayout());
        
        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bDirectorio);
        
        panelPersonas.add(new JScrollPane(taDirectorio));
        panelDatos.add(new JScrollPane(taDatos));
        
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(panelPersonas);
        panelPrincipal.add(panelDatos);
        
        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(700,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {        
        if(e.getSource() == bDirectorio)
        {
            vectorPersonas = directorioad.getPersonas();
            listaPersonas = new JList(vectorPersonas);
            panelPersonas.setVisible(false);
            panelPersonas.removeAll();
            panelPersonas.add(listaPersonas);
            listaPersonas.addListSelectionListener(this);
            panelPersonas.setVisible(true);
        }
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
        String cDatos, datosString;
        if(lse.getValueIsAdjusting()==true){
            if(lse.getSource()==listaPersonas)
	    	{
                cDatos = (String) listaPersonas.getSelectedValue();
                datosString = directorioad.getDatos(cDatos);
                taDatos.setText(datosString);
	    	}
        }
    }
    
    public static void main(String args[])
    {
        new DirectorioGUI();
    }
}











