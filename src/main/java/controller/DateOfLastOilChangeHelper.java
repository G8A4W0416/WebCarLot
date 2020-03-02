package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.DateOfLastOilChange;
import model.ListItem;

public class DateOfLastOilChangeHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarLot");
	
	public void insertDate(DateOfLastOilChange d, int id) {
		EntityManager em = emfactory.createEntityManager();
		ListItem car = em.find(ListItem.class, id);
		d.setCar(car);
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	
	public DateOfLastOilChange searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		DateOfLastOilChange found = em.find(DateOfLastOilChange.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(DateOfLastOilChange toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<DateOfLastOilChange> showAllOilChanges() {
		EntityManager em = emfactory.createEntityManager();
		List<DateOfLastOilChange> allOilChanges = em.createQuery("select d from DateOfLastOilChange d").getResultList();
		return allOilChanges;
	}
}
