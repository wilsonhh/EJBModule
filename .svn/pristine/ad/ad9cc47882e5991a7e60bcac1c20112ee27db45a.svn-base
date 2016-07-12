package com.wilson.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.wilson.model.Person;

public class PersonDAOImpl implements PersonDAO {
	
	@PersistenceContext(unitName="JPADB")
	private EntityManager entityManager;
	
	//private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	@Override
	public Person addPerson(Person p) {
		entityManager.persist(p);
		//logger.info("Person saved successfully, Person Details=" + p);
		return p;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Person getPerson(int id) {
		Person person = (Person)entityManager.find(Person.class, id);

		return person;
	}

	@Override
	public List<Person> listPersons() {
		Query query = entityManager.createQuery("SELECT e FROM Person e");
	    return (List<Person>) query.getResultList();
	}

	@Override
	public List<Person> listPersons(String name) {
		 CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		    CriteriaQuery<Person> c = cb.createQuery(Person.class);
		    Root<Person> emp = c.from(Person.class);
		    c.select(emp);
		    List<Predicate> criteria = new ArrayList<Predicate>();

		    if (name != null) {
		        ParameterExpression<String> p = cb.parameter(String.class, "name");
		        criteria.add(cb.equal(emp.get("name"), p));
		    }

		    /* ... */

		    if (criteria.size() == 0) {
		        throw new RuntimeException("no criteria");
		    } else if (criteria.size() == 1) {
		        c.where(criteria.get(0));
		    } else {
		        c.where(cb.and(criteria.toArray(new Predicate[0])));
		    }

		    TypedQuery<Person> q = entityManager.createQuery(c);

		    if (name != null) {
		        q.setParameter("name", name);
		    }

		    /* ... */

		    return q.getResultList();	
	}

	@Override
	public void removePerson(Person p) {
		entityManager.remove(p);
		//logger.info("Person removed successfully, Person Details=" + p);
	}

}
