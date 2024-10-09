package presentation;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LibraryGUI extends JFrame  {
	
	JButton ajouter = new JButton( "Add new book" ,new ImageIcon("img/addbook.png"));
	JButton ajouteretudiant = new JButton( "Add new Student" ,new ImageIcon("img/adduser.png"));
	JButton afficheretudiants = new JButton( "Show all Students" ,new ImageIcon("img/allusers.png"));

	JButton rechercher = new JButton( "Search book" ,new ImageIcon("img/searchbook.png"));
	JButton afficher = new JButton( "Show all books" ,new ImageIcon("img/showbooks.png"));
	
	JButton issue = new JButton( "Issue Book" ,new ImageIcon("img/issuedbook.png"));
	JButton returned = new JButton( "Return Book" ,new ImageIcon("img/returnbook.png"));
	
	JButton quitter = new JButton( "     Exit" ,new ImageIcon("img/exit.png"));

	JPanel p = new JPanel(new BorderLayout());
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel contentPane = new JPanel();
	JLabel lblibrary = new JLabel("GHAZOUA'S LIBRARY");

	public LibraryGUI() {
		
		
		
		contentPane.setBackground(SystemColor.PINK);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblibrary.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblibrary.setBounds(0, 40, 613, 59);
		contentPane.add(lblibrary);
		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("LIBRARY");
		this.setBounds(100, 200, 649, 474);
		
		ajouter.setBounds(217, 120, 194, 33);
		contentPane.add(ajouter);
		
		afficher.setBounds(217, 160, 194, 32);
		contentPane.add(afficher);
		
		ajouteretudiant.setBounds(217, 200, 194, 33);
		contentPane.add(ajouteretudiant);
		
		afficheretudiants.setBounds(217, 240, 194, 32);
		contentPane.add(afficheretudiants);
		
		issue.setBounds(217, 280, 194, 33);
		contentPane.add(issue);
		
		returned.setBounds(217, 320, 194, 32);
		contentPane.add(returned);
		
		quitter.setBounds(217, 360, 194, 33);
		contentPane.add(quitter);
		
		
		
		
		
		
		
		
		
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBookPresentation();
			}
		});
		
		ajouteretudiant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudent();
			}
		});
		
		
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BooksPresentation();
			}
		});
		
		
		
		
		afficheretudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentsPresentation();
			}
		});
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getComponent(0), "Thanks For Using") ;
				System.exit(0);
			}
		});
		
		
		issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new issuebookPresentation();
			}
		});
		returned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnBook();
			}
		});
		
		
		
	}
	public static void main (String[] args) {
		new LibraryGUI();
	}
}
