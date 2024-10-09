package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Dao.ILibrary;
import Dao.LibraryImpl;
import metier.entity.Book;

public class AddBookPresentation extends JFrame implements ActionListener {
	
	
	Object donnees[][]= {};
	String colonne[] = {"id","name","price","genre"};
	ILibrary lib = new LibraryImpl();
	
	
	JPanel  contentPane= new JPanel();
	JLabel name = new JLabel("Book Name");
	JTextField tname = new JTextField();
	JLabel price = new JLabel("Book Price");
	JTextField tprice = new JTextField();
	JLabel genre = new JLabel("Book Genre");
	JPanel pbutton= new JPanel(new GridLayout(1,2));

	JButton add = new JButton("Add Book");

	JButton btnReset = new JButton("Reset");
	JLabel addnewbook = new JLabel("Add New Book ");
	
	JComboBox<String> genres = new JComboBox(new String[] {"Fantasy","Science Fiction","Action & Adventure","Horror","Historical Fiction","Thriller & Suspense","Romance","Children’s","Autobiography"});
public AddBookPresentation() {
	
	
	this.setTitle("Add new book");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(100, 100, 450, 300);
	this.setVisible(true);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	


	addnewbook.setFont(new Font("Tahoma", Font.BOLD, 16));
	addnewbook.setHorizontalAlignment(SwingConstants.CENTER);
	addnewbook.setBounds(10, 11, 414, 34);
	contentPane.add(addnewbook);
	
	name.setFont(new Font("Tahoma", Font.PLAIN, 11));
	name.setBounds(10, 72, 124, 14);
	contentPane.add(name);
	
	tname.setBounds(144, 69, 254, 20);
	contentPane.add(tname);
	tname.setColumns(10);
	
	price.setFont(new Font("Tahoma", Font.PLAIN, 11));
	price.setBounds(10, 118, 124, 14);
	contentPane.add(price);
	
	tprice.setColumns(10);
	tprice.setBounds(144, 115, 254, 20);
	contentPane.add(tprice);
	
	genre.setFont(new Font("Tahoma", Font.PLAIN, 11));
	genre.setBounds(10, 163, 135, 14);
	contentPane.add(genre);
	
	genres.setBounds(144, 160, 254, 20);
	contentPane.add(genres);
	
	add.setBounds(86, 209, 89, 23);
	contentPane.add(add);
	
	btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tname.setText(null);
			tprice.setText(null);
		
		}
	});
	btnReset.setBounds(309, 209, 89, 23);
	contentPane.add(btnReset);
	
	
	
	

	


		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
	
	
	try {
		String name = tname.getText() ;
		String genre = (String)genres.getSelectedItem();
		int price = Integer.parseInt(tprice.getText()) ; 
		Book b = new Book(name,genre,price); 
		try {
		lib.AddBook(b);
		tname.setText("");
		tprice.setText("");
		
		JOptionPane.showMessageDialog(null,"Book added Successfully!");
		}
		catch(Exception ee) {
			System.out.println("Error");
		}
	}
	catch(Exception e1) {
		JOptionPane.showMessageDialog(null,"Error in typing ");
	}
	
			}
		});
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

}
		


	
	
	

	


