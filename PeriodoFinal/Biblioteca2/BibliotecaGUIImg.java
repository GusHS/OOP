import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
public class BibliotecaGUIImg extends JFrame implements ActionListener, ListSelectionListener{
	//Atributos de la aplicacion
	private JPanel 		panelUsuario, panelEditorial, panelTitulo, panelAutor,panelPrincipal;
	private JButton 	bEditoriales,bTitulo;
	private JButton 	bAutor;
	private JTextField 	tfTitulo, tfAlbum;
	private JTextArea 	taEditorial, taTitulo, taAutor;
	private Vector 		vectorEditoriales, vectorAutor;
	private JList 		listaEditorial, listaTitulo, listaAutor;
	private ImageIcon 	imagenesTitulo[];
	private ImageIcon[]	 vectorTituloImg;
	private BibliotecaADImg bibliotecaAD;
	
	public BibliotecaGUIImg(){
		super("Audio Tunes Tec");
		
		//1.Crear objetos de los atributos
		tfTitulo = new JTextField(10);
		tfAlbum   = new JTextField(10);
		bEditoriales= new JButton("Editoriales");
		bTitulo   	= new JButton("Search Titulo");
		bAutor   	= new JButton("Search Autor");
		taEditorial		= new JTextArea("EDITORIALES",20, 20);
		taTitulo   		= new JTextArea("IMAGENES LIBROS",20, 10);
		taAutor   		= new JTextArea("DATOS DE UN LIBRO",20, 20);
		panelUsuario 	= new JPanel();
		panelEditorial 	= new JPanel();
		panelTitulo 	= new JPanel();
		panelAutor 		= new JPanel();
		panelPrincipal 	= new JPanel();
		bibliotecaAD 	= new BibliotecaADImg();
		// Adicionar actionListener a los JButtons
		bEditoriales.addActionListener(this);
		bTitulo.addActionListener(this);
		bAutor.addActionListener(this);
		
		
		//2. Definir Layouts de los JPanels
		panelUsuario.setLayout(new FlowLayout());
		panelEditorial.setLayout(new GridLayout(1,1));
		panelTitulo.setLayout(new GridLayout(1,1));
		panelAutor.setLayout(new GridLayout(1,1));
		panelPrincipal.setLayout(new BorderLayout(5,5));
		
		//3. Colocar los objetos de losa tributos en los paneles correspondientes
		panelUsuario.add(bEditoriales);
		panelUsuario.add(new JLabel("Titulo: "));
		panelUsuario.add(tfTitulo);
		panelUsuario.add(bTitulo);
		panelUsuario.add(new JLabel("Autor: "));
		panelUsuario.add(tfAlbum);
		panelUsuario.add(bAutor);
		
		panelEditorial.add(new JScrollPane(taEditorial));
		panelTitulo.add(new JScrollPane(taTitulo));
		panelAutor.add(new JScrollPane(taAutor));

		panelPrincipal.add(panelUsuario, BorderLayout.NORTH);
		panelPrincipal.add(panelEditorial, BorderLayout.WEST);
		panelPrincipal.add(panelTitulo, BorderLayout.CENTER);
		panelPrincipal.add(panelAutor, BorderLayout.EAST);
		
		
		//4. Adicionar el panelPrincipal al JFrame
		add(panelPrincipal);
        setSize(700,500);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JPanel getPanel2(){
		return panelPrincipal;
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == bEditoriales) {
			vectorEditoriales = bibliotecaAD.getEditoriales();
			listaEditorial = new JList(vectorEditoriales);
			listaEditorial.addListSelectionListener(this);
			panelEditorial.setVisible(false);
			panelEditorial.removeAll();
			panelEditorial.add(listaEditorial);
			panelEditorial.setVisible(true);
		}
		if (e.getSource()==bTitulo) {
			String sTitle = tfTitulo.getText();
			vectorTituloImg = bibliotecaAD.getCoversByTitle(sTitle);
			listaTitulo = new JList(vectorTituloImg);
			listaTitulo.addListSelectionListener(this);
			panelTitulo.setVisible(false);
			panelTitulo.removeAll();
			panelTitulo.add(listaTitulo);
			panelTitulo.add(new JScrollPane(listaTitulo));
			panelTitulo.setVisible(true);
		}
	}
	
    public void valueChanged(ListSelectionEvent lse){
		String libroElegido, info;
    	if (lse.getSource()== listaEditorial){
			String sEdit = (String) listaEditorial.getSelectedValue();
			vectorTituloImg = bibliotecaAD.getCoversByEditorial(sEdit);
			listaTitulo =  new JList(vectorTituloImg);
			listaTitulo.addListSelectionListener(this);
			panelTitulo.setVisible(false);
			panelTitulo.removeAll();
			panelTitulo.add(listaTitulo);
			panelTitulo.setVisible(true);
		}
		if (lse.getSource()==listaTitulo) {
			int sLibro = listaTitulo.getSelectedIndex();
			libroElegido = bibliotecaAD.getInfo(sLibro);
			System.out.println(libroElegido);
			info = bibliotecaAD.getData(libroElegido);
			taAutor.setText(info);
		}
	}
	public static void main(String args[]){
		new BibliotecaGUIImg();
	}
}