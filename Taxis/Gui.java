package Taxis;

// Classes java
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

// Mes classes
import Taxis.saisie;
import Taxis.taxi;
import Taxis.Calculer;
import Taxis.modulesGui;


public class Gui extends JFrame {

	private JPanel contentPane;
	private final JTextField textDep = new JTextField();
	private JTextField textKm;
	private JTextField textDuree;
	private JLabel departement;
	private JButton btnRechercher;
	private JLabel duree;
	private JLabel km;
	private JLabel momentJournee;
	private JRadioButton radioJour;
	private JRadioButton radioNuit;
	private ButtonGroup jourNuit;
	private JLabel momentSemaine;
	private JRadioButton radioSemaine;
	private JRadioButton radioWE;
	private ButtonGroup semaineWE;
	private JLabel typeTrajet;
	private JRadioButton allerSimple;
	private JRadioButton allerRetour;
	private ButtonGroup monTrajet;
	private JLabel lblTa;
	private JButton btnRinitialiserDep;
	private JButton btnRinitialiserKm;
	private JButton btnRinitialiserDuree;
	private JButton btnCalculer;
	private JSeparator separator;
	private JLabel prix;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				// On accede au données dans le fichier
				try{
		    		//Ouverture d'un flux d'entrée à partir du fichier "docTarif.txt"
		        	BufferedReader monBuffer = new BufferedReader(new FileReader("/home/fx/Documents/java/cours/src/Taxis/doc_tarif.txt"));
		        	String line = null;					//Variable qui contiendra chaque ligne du fichier
		        	
		        	//Tant qu'il reste une ligne au fichier
		        	while ((line = monBuffer.readLine()) != null)
		        	{
		        		//On découpe la ligne gràce au caractère ","
		        		String[] part = line.split(",");
		        		
		        		//On ajoute un objet de la classe Tarif à la brochure, à partir de la ligne du fichier découpée
		        		taxi.mesTarifs.add(new Tarifs(Integer.parseInt(part[0]),Double.parseDouble(part[1]),Double.parseDouble(part[2]),Double.parseDouble(part[3]),
		        							Double.parseDouble(part[4]),Double.parseDouble(part[5]),Double.parseDouble(part[6]),Double.parseDouble(part[7])));
		        		
		        	}
		        	//Fermeture du buffer
		        	monBuffer.close();
				} catch (Exception e) {
				    System.out.println("Fichier contenant les tarifs introuvable !!!");
				  }
				
				
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static int Recherche()
	{
		int indice = -1;
		for (int i = 0; i < taxi.mesTarifs.size(); i++) { // Pour toutes les lignes du tableau,
			if (taxi.mesTarifs.get(i).getDep() == taxi.saisir.getDep()){ // Si un detarifement correspond à celui saisie
				indice = i; // Stockage de l'indice de la ligne dans le tableau
				break;
			}
		}
		return indice;
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		departement = new JLabel("Veuillez saisir un département :");
		departement.setBounds(33, 56, 321, 15);
		departement.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(departement);
		
		textDep.setBounds(382, 56, 59, 19);
		contentPane.add(textDep);
		textDep.setColumns(10);
		
		textDep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int verif = textDep.getText().length();
				
				if (verif != 0) {
					textDep.setEnabled(true);
					String oldString = textDep.getText();
					char lastChar = textDep.getText().charAt(verif - 1);
					if (Character.isDigit(lastChar) == true)
						textDep.setText(oldString);
					else
						textDep.setText(oldString.substring(0, verif - 1));
					if (textDep.getText().length() > 2)
						textDep.setText(oldString.substring(0, verif - 1));
				}
			}
		});
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(617, 51, 117, 25);
		contentPane.add(btnRechercher);
		
		
		
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textDep.isEditable() == true) {
					taxi.saisir.setDep(Integer.parseInt(textDep.getText()));

					if (Recherche() != -1) {
						btnRechercher.setText("Modifier");
						textDep.setEditable(false);
						allerSimple.setEnabled(true);
						allerRetour.setEnabled(true);
						radioSemaine.setEnabled(true);
						radioWE.setEnabled(true);
						radioJour.setEnabled(true);
						radioNuit.setEnabled(true);
						textDuree.setEnabled(true);
						textKm.setEnabled(true);
					} else
						JOptionPane.showMessageDialog(null, "Département inconnu !", "Erreur !", JOptionPane.ERROR_MESSAGE);
				} else {
					btnRechercher.setText("Rechercher");
					textDep.setEditable(true);
					allerSimple.setEnabled(false);
					allerRetour.setEnabled(false);
					radioSemaine.setEnabled(false);
					radioWE.setEnabled(false);
					radioJour.setEnabled(false);
					radioNuit.setEnabled(false);
					textDuree.setEnabled(false);
					textKm.setEnabled(false);
				}
			}
		});
		
		duree = new JLabel("Veuillez saisir la durée du trajet (en minutes) : ");
		duree.setVerticalAlignment(SwingConstants.TOP);
		duree.setBounds(43, 82, 334, 19);
		contentPane.add(duree);
		
		textKm = new JTextField();
		textKm.setColumns(10);
		textKm.setBounds(382, 80, 59, 19);
		contentPane.add(textKm);
		
		textKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int verifKm = textKm.getText().length();
				
				if (verifKm != 0) {
					textKm.setEnabled(true);
					String oldString = textKm.getText();
					char lastChar = textKm.getText().charAt(verifKm - 1);
					if (Character.isDigit(lastChar) == true)
						textKm.setText(oldString);
					else
						textKm.setText(oldString.substring(0, verifKm - 1));
					if (textKm.getText().length() > 4)
						textKm.setText(oldString.substring(0, verifKm - 1));
					
					taxi.saisir.setKil(Integer.parseInt(textKm.getText()));
					
					if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getHeure() != null && taxi.saisir.getMinutes() != 0){
						btnCalculer.setEnabled(true);
					}
				}
			}
		});
		
		textDuree = new JTextField();
		textDuree.setColumns(10);
		textDuree.setBounds(382, 109, 59, 19);
		contentPane.add(textDuree);
		
		textDuree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int verifDuree = textDuree.getText().length();
				
				if (verifDuree != 0) {
					textDuree.setEnabled(true);
					String oldString = textDuree.getText();
					char lastChar = textDuree.getText().charAt(verifDuree - 1);
					if (Character.isDigit(lastChar) == true)
						textDuree.setText(oldString);
					else
						textDuree.setText(oldString.substring(0, verifDuree - 1));
					if (textDuree.getText().length() > 4)
						textDuree.setText(oldString.substring(0, verifDuree - 1));
					
					taxi.saisir.setMinutes(Integer.parseInt(textDuree.getText()));
					
					if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getHeure() != null && taxi.saisir.getKil() != 0){
						btnCalculer.setEnabled(true);
					}
				}
			}
		});
		
		km = new JLabel("Veuillez saisir un nombre de kilomètre : ");
		km.setVerticalAlignment(SwingConstants.TOP);
		km.setBounds(33, 111, 321, 15);
		contentPane.add(km);
		
		momentJournee = new JLabel("Définir le moment de la journée : ");
		momentJournee.setBounds(33, 140, 254, 15);
		contentPane.add(momentJournee);
		
		radioJour = new JRadioButton("Jour");
		radioJour.setBounds(276, 136, 66, 23);
		contentPane.add(radioJour);
		
		radioJour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setHeure("jour");
				
				if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		radioNuit = new JRadioButton("Nuit");
		radioNuit.setBounds(350, 136, 66, 23);
		contentPane.add(radioNuit);
		
		radioNuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setHeure("nuit");
				
				if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		jourNuit = new ButtonGroup();
		jourNuit.add(radioJour);
		jourNuit.add(radioNuit);
		
		momentSemaine = new JLabel("Définir le moment de la semaine : ");
		momentSemaine.setBounds(33, 167, 248, 15);
		contentPane.add(momentSemaine);
		
		radioSemaine = new JRadioButton("Semaine");
		radioSemaine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setJour("Lundi");
				
				if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		radioSemaine.setBounds(276, 163, 86, 23);
		contentPane.add(radioSemaine);
		
		radioWE = new JRadioButton("Week end");
		radioWE.setBounds(385, 163, 102, 23);
		contentPane.add(radioWE);
		
		radioWE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setJour("Dimanche");
				
				if(taxi.saisir.getTypeParcour() != 0 && taxi.saisir.getJour() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		semaineWE = new ButtonGroup();
		semaineWE.add(radioSemaine);
		semaineWE.add(radioWE);
		
		typeTrajet = new JLabel("Définir le tye du trajet : ");
		typeTrajet.setBounds(33, 194, 254, 15);
		contentPane.add(typeTrajet);
		
		allerSimple = new JRadioButton("Aller Simple");
		allerSimple.setBounds(276, 190, 121, 23);
		contentPane.add(allerSimple);
		
		allerSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setTypeParcour('S');
				
				if(taxi.saisir.getJour() != null && taxi.saisir.getHeure() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		allerRetour = new JRadioButton("Aller retour");
		allerRetour.setBounds(401, 190, 121, 23);
		contentPane.add(allerRetour);
		
		allerRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taxi.saisir.setTypeParcour('R');
				
				if(taxi.saisir.getJour() != null && taxi.saisir.getHeure() != null && taxi.saisir.getMinutes() != 0 && taxi.saisir.getKil() != 0){
					btnCalculer.setEnabled(true);
				}
			}
		});
		
		monTrajet = new ButtonGroup();
		monTrajet.add(allerSimple);
		monTrajet.add(allerRetour);
		
		lblTa = new JLabel("Taxis");
		lblTa.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblTa.setBounds(317, 8, 176, 30);
		contentPane.add(lblTa);
		
		btnRinitialiserDep = new JButton("Réinitialiser");
		btnRinitialiserDep.setBounds(477, 51, 128, 25);
		contentPane.add(btnRinitialiserDep);
		
		btnRinitialiserDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textDep.setText("");
				textDep.setFocusable(true);
			}
		});
		
		
		btnRinitialiserKm = new JButton("Réinitialiser");
		btnRinitialiserKm.setBounds(477, 77, 128, 25);
		contentPane.add(btnRinitialiserKm);
		
		btnRinitialiserKm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textKm.setText("");
				textKm.setFocusable(true);
			}
		});
		
		btnRinitialiserDuree = new JButton("Réinitialiser");
		btnRinitialiserDuree.setBounds(477, 104, 128, 25);
		contentPane.add(btnRinitialiserDuree);
		
		btnRinitialiserDuree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textDuree.setText("");
				textDuree.setFocusable(true);
			}
		});
		
		btnCalculer = new JButton("Calculer");
		btnCalculer.setBounds(312, 236, 117, 25);
		contentPane.add(btnCalculer);
		
		separator = new JSeparator();
		separator.setBounds(34, 273, 686, 23);
		contentPane.add(separator);
		
		prix = new JLabel("labelPrix");
		prix.setFont(new Font("Dialog", Font.BOLD, 14));
		prix.setBounds(150, 290, 130, 19);
		prix.setVisible(false);
		contentPane.add(prix);
		
		prix = new JLabel("Prix : ");
		prix.setBounds(33, 310, 70, 15);
		contentPane.add(prix);
		
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//labelPrix.setVisible(true);
				prix.setVisible(true);
				prix.setText(Double.toString(Calculer.Calcul(Recherche(), taxi.saisir)) + " €");
			}
		});
	}
}
