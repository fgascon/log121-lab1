package lab1;
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
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
 * Communication avec le serveur via un fil d'exécution parallèle.
 */
public class CommBase {

	private final int DELAI = 1000;
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private String host = "localhost";
	private int port = 0;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	/**
	 * Constructeur
	 */
	public CommBase() {
	}

	/**
	 * Définir le récepteur de l'information reçue dans la communication avec le
	 * serveur
	 * 
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par
	 * 				le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}

	/**
	 * Demande à l'utilisateur à quel hôte et port se connecter, puis
	 * démarre la communication.
	 */
	public void start() {
		String hostbrute = JOptionPane.showInputDialog(
				"Quel est le nom d'hôte et le port du serveur de formes?",
				"localhost:10000");
		String str[] = hostbrute.split(":");
		port = Integer.parseInt(str[1]);
		host = str[0];
		creerCommunication();
	}

	/**
	 * Arrête la communication si elle est active.
	 */
	public void stop() {
		if (!isActif) {
			return;
		}
		try {
			out.println("END");
			out.flush();
			socket.close();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (threadComm != null)
			threadComm.cancel(true);
		isActif = false;
	}

	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication() {
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

				try {
					socket = new Socket(host, port);
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));

					out = new PrintWriter(socket.getOutputStream());

				} catch (UnknownHostException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
				while (true) {
					Thread.sleep(DELAI);
					out.println("GET");
					out.flush();
					String message_distant = in.readLine();
					message_distant = in.readLine();
					if (listener != null)
						firePropertyChange("SERVER-MSG", null, message_distant);
				}
			}
		};
		if (listener != null)
			threadComm.addPropertyChangeListener(listener);

		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}

	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif() {
		return isActif;
	}
}
