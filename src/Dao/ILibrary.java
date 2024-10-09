package Dao;

import java.util.List;

import metier.entity.Book;
import metier.entity.Issue;
import metier.entity.Student;

public interface ILibrary {

	
	
	List<Book> rechercherParMC(String mc);
	List<Book> BookList();
	Book DeleteBook(int id);
	void AddBook(Book b);
	void trierListeBooksParNom();

	List<Book> getAllBooks();
	Book getBook(int id);
	void AddStudent(Student s);
	List<Student> getAllStudents();
	Book DeleteStudent(int id);
	void AddIssue(Issue i);
	List<Issue> getAllIssued();
	Issue DeleteIssue(int id);
	void UpdateStudent(Student s);
	void UpdateStudent1(int id);
	
}
