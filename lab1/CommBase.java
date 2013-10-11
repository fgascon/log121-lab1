package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date cr��: 2013-05-03
 *******************************************************
Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************/

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Communication avec le serveur via un fil d'ex�cution parall�le.
 */
public class CommBase {

	private final int DELAI = 1000;
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean actif = false;
	private String host = "localhost";
	private int port = 0;
	private Socket socket;
	private BufferedReader entre;
	private PrintWriter sortie;

	/**
	 * Constructeur
	 */
	public CommBase() {
	}

	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le
	 * serveur
	 * 
	 * @param listener sera alert� lors de l'appel de "firePropertyChanger" par
	 * 				le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}

	/**
	 * Demande � l'utilisateur � quel h�te et port se connecter, puis
	 * d�marre la communication.
	 */
	public void start(int nbdeformes) {
		String hostbrute = JOptionPane.showInputDialog(
				"Quel est le nom d'h�te et le port du serveur de formes?",
				"localhost:10000");
		String str[] = hostbrute.split(":");
		port = Integer.parseInt(str[1]);
		host = str[0];
		creerCommunication(nbdeformes);
	}

	/**
	 * Arr�te la communication si elle est active.
	 */
	public void stop() {
		if (!actif) {
			return;
		}
		try {
			sortie.println("END");
			sortie.flush();
			socket.close();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (threadComm != null)
			threadComm.cancel(true);
		actif = false;
	}

	/**
	 * Cr�er le n�cessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(final int nbdeformes) {
		// Cr�e un fil d'ex�cusion parall�le au fil courant,
		threadComm = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

				try {
					socket = new Socket(host, port);
					entre = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));

					sortie = new PrintWriter(socket.getOutputStream());

				} catch (UnknownHostException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				int i=0;
				while (i != nbdeformes) {
					Thread.sleep(DELAI);
					sortie.println("GET");
					sortie.flush();
					String messagedistant = entre.readLine();
					messagedistant = entre.readLine();
					if (listener != null)
						firePropertyChange("SERVER-MSG", null, messagedistant);
					i++;
				}
				stop();
				return null;
			}
		};
		if (listener != null)
			threadComm.addPropertyChangeListener(listener);

		threadComm.execute(); // Lance le fil d'ex�cution parall�le.
		actif = true;
	}

	/**
	 * @return si le fil d'ex�cution parall�le est actif
	 */
	public boolean isActif() {
		return actif;
	}
}
