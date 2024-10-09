package Dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import metier.entity.Book;
import metier.entity.Issue;
import metier.entity.Student;


public class LibraryImpl implements ILibrary{
	Connection connection;
	public LibraryImpl() {
		// TODO Auto-generated constructor stub
		connection=SingletonConnection.getConnection();
	}

	private List<Book> liste = new ArrayList<>();
	private List<Student> listestudents = new ArrayList<>();

	
	
	@Override
	public void AddStudent(Student s) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("insert into student(id,name,firstname,gender,grade,id_book) values(?,?,?,?,?,?)");
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getFirstname());
			ps.setString(4, s.getGender());
			ps.setString(5, s.getGrade());
			ps.setInt(6, s.getId_book());


			ps.executeUpdate();
			ps.close();
			System.out.println("Ajouter avec succés");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void AddBook(Book b) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("insert into book(id,name,genre,price) values(?,?,?,?)");
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setString(3, b.getGenre());
			ps.setInt(4, b.getPrice());

			ps.executeUpdate();
			ps.close();
			System.out.println("Ajouter avec succés");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void AddIssue(Issue i) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("insert into issue(student,book,returndate) values(?,?,?)");
			ps.setInt(1, i.getStudent());
			ps.setInt(2, i.getBook());
			ps.setString(3, i.getReturndate());

			ps.executeUpdate();
			ps.close();
			System.out.println("Ajouter avec succés");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Override
	public List<Issue> getAllIssued() {
		// TODO Auto-generated method stub
		List<Issue> liste = new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from issue");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Issue i=new Issue();
				i.setStudent(rs.getInt(1));
				i.setBook(rs.getInt(2));
				i.setReturndate(rs.getString(3));
				


				liste.add(i);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> listestudent = new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from student");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setGrade(rs.getString(5));
				s.setId_book(rs.getInt(6));


				listestudent.add(s);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listestudent;
	}
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> liste = new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from book");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setGenre(rs.getString(3));
				b.setPrice(rs.getInt(4));
				liste.add(b);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	


	

	@Override
	public Book DeleteBook(int id) {
		try {
			PreparedStatement ps=connection.prepareStatement("delete from book where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	
	
	@Override
	public void UpdateStudent(Student s) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("update student set  id_book = ? where id = ?");
			
			ps.setInt(1, s.getId_book());
			ps.setInt(2, s.getId());

			ps.executeUpdate();
			ps.close();
			System.out.println("Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void UpdateStudent1(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=connection.prepareStatement("update student set  id_book = ? where id = ?");
			
			ps.setInt(1, 0);
			ps.setInt(2, id);

			ps.executeUpdate();
			ps.close();
			System.out.println("Updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Issue DeleteIssue(int student) {
		try {
			PreparedStatement ps=connection.prepareStatement("delete from issue where student=?");
			ps.setInt(1, student);
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Book DeleteStudent(int id) {
		try {
			PreparedStatement ps=connection.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		List<Book> liste = new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from book where nom like ?");
			ps.setString(1,"%" + mc + "%");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book p=new Book();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setGenre(rs.getString(3));
				p.setPrice(rs.getInt(4));
				liste.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(liste);
		return liste;
	}

	@Override
	public void trierListeBooksParNom() {
		// TODO Auto-generated method stub
		Collections.sort(liste);
	}

	@Override
	public List<Book> BookList() {
		// TODO Auto-generated method stub
		return this.liste;
	}



	@Override
	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	




	


}

