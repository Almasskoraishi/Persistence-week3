package controller;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import model.EmployeeList;

public class EmployeeListHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleEmployeeApp");
	
	public void insertEmp(EmployeeList El) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(El);
		em.getTransaction().commit();
		em.close();
		
	}
	public List<EmployeeList> showAllEmp(){
		EntityManager em = emfactory.createEntityManager();
		List<EmployeeList> allEmps = em.createQuery("SELECT i from EmployeeList i").getResultList();
		return allEmps;
		
	}
	
	public void deleteEmpployee(EmployeeList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeList> typedQuery = em.createQuery("select el from EmployeeList el where li.store = :selectedStore and el.item = :selectedEmps", EmployeeList.class);
		
		typedQuery.setParameter("selectedEmpFirstName", toDelete.getEmpFirstName());
		typedQuery.setParameter("selectedEmpLastName", toDelete.getEmpLastName());
		
		typedQuery.setMaxResults(1);
		
		EmployeeList result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public EmployeeList searchForEmpFirstNameById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		EmployeeList found = em.find(EmployeeList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEmpFirstName(EmployeeList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<EmployeeList> searchForEmpFirstNameByEmpFirstName(String empFirstName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeList> typedQuery = em.createQuery("select el from EmployeeList el where el.empFirstName = :selectedEmpFirstName", EmployeeList.class);
		
		typedQuery.setParameter("selectedEmpFirstName", empFirstName);
		
		List<EmployeeList> foundEmpFirstName = typedQuery.getResultList();
		em.close();
		return foundEmpFirstName;
	}
	
	public List<EmployeeList> searchForEmpLastNameByEmpLastName(String EmpLastName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<EmployeeList> typedQuery = em.createQuery("select el from EmployeeList el where el.empLastName = :selectedEmpLastName", EmployeeList.class);
		
		typedQuery.setParameter("selectedEmpLastName", EmpLastName);
		
		List<EmployeeList> foundEmpLastName = typedQuery.getResultList();
		em.close();
		return foundEmpLastName;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}