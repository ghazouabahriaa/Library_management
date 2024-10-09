package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import metier.entity.Student;

public class AddStudent extends JFrame implements ActionListener {
	
	
	Object donnees[][]= {};
	String colonne[] = {"id","name","firstname","gendre","grade","id_book"};
	ILibrary lib = new LibraryImpl();
	
	
	JPanel  contentPane= new JPanel();
	JLabel name = new JLabel("Name");
	JTextField tname = new JTextField();
	JLabel firstname = new JLabel("Firstname");
	JTextField tfirstname = new JTextField();
	
	JLabel gender = new JLabel("Gender");

	JLabel grade = new JLabel("Grade");
	JPanel pbutton= new JPanel(new GridLayout(1,2));

	JButton add = new JButton("Add");

	JButton btnReset = new JButton("Reset");
	JLabel addnewstudent = new JLabel("Add New Student ");

	JRadioButton JRB1 = new JRadioButton("M");
	JRadioButton JRB2 = new JRadioButton("F");
	
	JComboBox<String> grades = new JComboBox(new String[] {"First","Second","Third"});
	public AddStudent() {
	
	
	this.setTitle("Add new Student");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setBounds(200, 100, 450, 300);
	this.setVisible(true);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	ButtonGroup bg = new ButtonGroup();
	bg.add(JRB1);
	bg.add(JRB2);

	addnewstudent.setFont(new Font("Tahoma", Font.BOLD, 16));
	addnewstudent.setHorizontalAlignment(SwingConstants.CENTER);
	addnewstudent.setBounds(10, 11, 414, 34);
	contentPane.add(addnewstudent);
	
	name.setFont(new Font("Tahoma", Font.PLAIN, 11));
	name.setBounds(10, 72, 124, 14);
	contentPane.add(name);
	
	tname.setBounds(144, 69, 254, 20);
	contentPane.add(tname);
	tname.setColumns(10);
	
	
	firstname.setFont(new Font("Tahoma", Font.PLAIN, 11));
	firstname.setBounds(10, 118, 124, 14);
	contentPane.add(firstname);
	
	tfirstname.setBounds(144, 115, 254, 20);
	contentPane.add(tfirstname);
	tfirstname.setColumns(10);
	
	gender.setFont(new Font("Tahoma", Font.PLAIN, 11));
	gender.setBounds(10, 158, 124, 14);
	contentPane.add(gender);
	
	
	JRB1.setFont(new Font("Tahoma", Font.PLAIN, 11));
	JRB1.setBounds(150, 158, 124, 14);
	JRB2.setFont(new Font("Tahoma", Font.PLAIN, 11));
	JRB2.setBounds(250, 158, 124, 14);
	contentPane.add(JRB1);
	contentPane.add(JRB2);

	
	grade.setFont(new Font("Tahoma", Font.PLAIN, 11));
	grade.setBounds(10, 200, 124, 14);
	contentPane.add(grade);
	
	grades.setBounds(144, 200, 254, 20);
	contentPane.add(grades);
	
	add.setBounds(30, 230, 89, 23);
	contentPane.add(add);
	
	btnReset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tname.setText(null);
			tfirstname.setText(null);
		
		}
	});
	btnReset.setBounds(130, 230, 89, 23);
	contentPane.add(btnReset);
	
	
	add.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub



try {
	String name = tname.getText() ;
	String firstname = tfirstname.getText() ;
	String gender ="";
	if(JRB1.isSelected())
		gender="M";
	else if (JRB2.isSelected())
		gender="F";

	String grade = (String)grades.getSelectedItem();
	int Id_book=0;
	Student s = new Student(name,firstname,gender,grade,Id_book); 
	try {
	lib.AddStudent(s);
	tname.setText("");
	tfirstname.setText("");
	JOptionPane.showMessageDialog(null,"Student added Successfully!");
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
		


	
	
	

	
