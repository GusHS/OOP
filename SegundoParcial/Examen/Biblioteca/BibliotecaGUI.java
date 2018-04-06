import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.util.Vector;

public class BibliotecaGUI extends JFrame implements ActionListener, ListSelectionListener
{
    // Atributos de la aplicacion
    private JPanel panelUsuario, panelEditoriales, panelLibros, panelPrincipal;
    
    private JButton bEditorial;
    private JTextArea taEditorial, taLibros;
    private BibliotecaAD bibliotecaad = new BibliotecaAD();
    private Vector vectorEditoriales, vectorLibros;
    private JList  listaEditoriales, listaLibros;
    
    public BibliotecaGUI()
    {
        super("BIBLIOTECA TEC");
        
        // 1. Crear objetos de los atributos
        
        bEditorial = new JButton("Editoriales");
        
        taEditorial = new JTextArea("EDITORIALES",20,20);
        taLibros    = new JTextArea("LIBROS DE UNA EDITORIAL",20,20);
        
        panelUsuario     = new JPanel();
        panelEditoriales = new JPanel();
        panelLibros      = new JPanel();
        panelPrincipal   = new JPanel();
        
        // Adionar actionListener a los JButtons
        bEditorial.addActionListener(this);
        
        // 2. Definir Layouts de los JPanels
        panelUsuario.setLayout(new FlowLayout());
        panelEditoriales.setLayout(new GridLayout(1,2));
        panelLibros.setLayout(new GridLayout(1,1));
        panelPrincipal.setLayout(new FlowLayout());
        
        // 3. Colocar los objetos de los atributos en los panels correspondientes
        panelUsuario.add(bEditorial);
        
        panelEditoriales.add(new JScrollPane(taEditorial));
        panelLibros.add(new JScrollPane(taLibros));
        
        panelPrincipal.add(panelUsuario);
        panelPrincipal.add(panelEditoriales);
        panelPrincipal.add(panelLibros);
        
        // 4. Adicionar el panelPrincipal al JFrame
        add(panelPrincipal);
        setSize(700,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == bEditorial)
        {
            vectorEditoriales = bibliotecaad.getEditorial();
            listaEditoriales = new JList(vectorEditoriales);
            panelEditoriales.setVisible(false);
            panelEditoriales.removeAll();
            panelEditoriales.add(listaEditoriales);
            listaEditoriales.addListSelectionListener(this);
            panelEditoriales.setVisible(true);
        }
    }
    
    public void valueChanged(ListSelectionEvent lse)
    {
        String cEditorial, librosString;
        if(lse.getValueIsAdjusting()==true){
            if(lse.getSource()==listaEditoriales)
	    	{
	    		cEditorial = (String) listaEditoriales.getSelectedValue();
                librosString = bibliotecaad.getLibros(cEditorial);
                taLibros.setText(librosString);
	    	}
        }
    }
    
    public static void main(String args[])
    {
        new BibliotecaGUI();
    }
}











