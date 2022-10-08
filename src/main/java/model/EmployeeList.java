package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="Employees")
public class EmployeeList {

		@Id
		@GeneratedValue
		@Column(name="EmpID")
		private int empId;
		@Column(name="EMPFIRSTNAME")
		private String empFirstName;
		@Column(name="EMPLASTNAME")
		private String empLastName;
		
		// default contractor
		public EmployeeList() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		//helper method
		public EmployeeList(String empFirstName, String empLastName) {
			this.empFirstName = empFirstName;
			this.empLastName = empLastName;
		}
		public String empDetails() {
			return this.empFirstName + this.empLastName;
		}

		// getters and setters
		
		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpFirstName() {
			return empFirstName;
		}

		public void setEmpFirstName(String empFirstName) {
			this.empFirstName = empFirstName;
		}

		public String getEmpLastName() {
			return empLastName;
		}

		public void setEmpLastName(String empLastName) {
			this.empLastName = empLastName;
		}
		
		
		
	}
