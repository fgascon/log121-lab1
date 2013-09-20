import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.LinkedList;

public class ConnectionFenetre extends JFrame{
	
	//Les 2 zone de texte pour la calculatrice Tutoriel
	private JTextField field1;
	public ConnectionFenetre(){
		super();
		
		buildTutoriel();//On initialise notre fenêtre
	}
	
	protected void buildTutoriel(){
		setTitle("T3 INF111 Partie 1"); //On donne un titre à l'application
		setSize(300,100); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'ecran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	protected JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		//Le fond est blanc
		panel.setBackground(Color.white);
		
		//La première zone que l'ont cree
		field1 = new JTextField();
		field1.setColumns(10);
		
		//Ont l'ajoute
		panel.add(field1);
		
		return panel;	
	}
	
}