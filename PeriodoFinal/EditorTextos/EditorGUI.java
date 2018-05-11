import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EditorGUI extends JFrame implements ActionListener
{
    private JMenuItem menuItemNew, menuItemAbrir, menuItemGuardar, menuItemGuardarAs, menuItemSalir;
    private JTextArea taEditor= new JTextArea(20,40);
    private String    nombreArchivo="", datos="";
    private JMenuBar  menuBar;
    private JMenu     menu;
    private JPanel	  panel;
    private EditorAD  editorAD = new EditorAD();
    
    
    public EditorGUI()
    {
        super("Editor Basico");
        
        menuBar = new JMenuBar();
        menu    = new JMenu("File");
        panel   = new JPanel();
        panel.setLayout(new FlowLayout());
        
        menuItemNew = new JMenuItem("New");
        menuItemNew.addActionListener(this);
        menu.add(menuItemNew);
        
        menuItemAbrir = new JMenuItem("Open");
        menuItemAbrir.addActionListener(this);
        menu.add(menuItemAbrir);
        
        menuItemGuardar = new JMenuItem("Save");
        menuItemGuardar.addActionListener(this);
        menu.add(menuItemGuardar);
        
        menuItemGuardarAs = new JMenuItem("Save As");
        menuItemGuardarAs.addActionListener(this);
        menu.add(menuItemGuardarAs);
        
        menuItemSalir    = new JMenuItem("Exit");
        menuItemSalir.addActionListener(this);
        menu.add(menuItemSalir);
        
        menuBar.add(menu);
        
        panel.add(new JScrollPane(taEditor));
        
        setJMenuBar(menuBar);
        
        add(panel);
        panel.setVisible(false);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == menuItemNew)
        {
            nombreArchivo=JOptionPane.showInputDialog(null,"Nuevo Archivo Creado");
            panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemAbrir)
        {
           nombreArchivo=JOptionPane.showInputDialog(null,"Abrir Archivo: ");
           taEditor.append(editorAD.openFile(nombreArchivo));
           panel.setVisible(true);
        }
        
        if(e.getSource() == menuItemGuardar)
        {
            JOptionPane.showMessageDialog(null,"Archivo Guardado");
            datos = taEditor.getText();
            editorAD.saveFile(nombreArchivo, datos);
        }
        
        if(e.getSource() == menuItemGuardarAs)
        {
            nombreArchivo=JOptionPane.showInputDialog(null,"Guardar Archivo Como: ");
            datos = taEditor.getText();
            editorAD.saveFile(nombreArchivo, datos);
        }
        
        if(e.getSource() == menuItemSalir)
            System.exit(0);
    }
    
    public static void main(String args[])
    {
        new EditorGUI();
    }
}
