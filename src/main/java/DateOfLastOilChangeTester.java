import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.DateOfLastOilChangeHelper;
import model.DateOfLastOilChange;
import model.ListItem;


public class DateOfLastOilChangeTester {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebCarLot");
		EntityManager em = emfactory.createEntityManager();
	
		DateOfLastOilChange oilChangeDate = new DateOfLastOilChange(LocalDate.now());
		DateOfLastOilChangeHelper oilChangeHelper = new DateOfLastOilChangeHelper();
		ListItem car = new ListItem("Aston", "Martin", 1969);		
		oilChangeDate.setCar(car);
		em.getTransaction().begin();
		em.persist(oilChangeDate);
		em.getTransaction().commit();
		em.close();
		
		List<DateOfLastOilChange> allDates = oilChangeHelper.showAllOilChanges();
		for (DateOfLastOilChange d: allDates) {
			System.out.println(d.toString());
		}
		
	}
}
