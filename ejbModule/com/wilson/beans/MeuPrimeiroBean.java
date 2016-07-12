package com.wilson.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.wilson.dao.PersonDAO;
import com.wilson.dao.PersonDAOImpl;
import com.wilson.model.Person;

/**
 * Session Bean implementation class MeuPrimeiroBean
 */
@Stateless
public class MeuPrimeiroBean implements MeuPrimeiroBeanLocal {

	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;
	
	private PersonDAO personDAO = new PersonDAOImpl();

	/**
	 * Default constructor.
	 */
	public MeuPrimeiroBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void helloWorld() {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

	@Override
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT e FROM Person e");
	    return (List<Person>) query.getResultList();
	}

}
