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
		
		buildTutoriel();//On initialise notre fen�tre
	}
	
	protected void buildTutoriel(){
		setTitle("T3 INF111 Partie 1"); //On donne un titre � l'application
		setSize(300,100); //On donne une taille � notre fen�tre
		setLocationRelativeTo(null); //On centre la fen�tre sur l'ecran
		setResizable(false); //On interdit la redimensionnement de la fen�tre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de se fermer lors du clic sur la croix
		setContentPane(buildContentPane());
	}
	
	protected JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		//Le fond est blanc
		panel.setBackground(Color.white);
		
		//La premi�re zone que l'ont cree
		field1 = new JTextField();
		field1.setColumns(10);
		
		//Ont l'ajoute
		panel.add(field1);
		
		return panel;	
	}
	
}