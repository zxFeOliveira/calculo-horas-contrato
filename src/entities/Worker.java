package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	String name;
	Double baseSalary;
	
	WorkerLevel level;
	List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker(String name, Double baseSalary, WorkerLevel level) {
		super();
		this.name = name;
		this.baseSalary = baseSalary;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income (Integer year, Integer month) {
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			
			if ((c_year == year && c_month == month)) {
				sum += c.totalValue(); 
			}
		}	
		
		return sum;
	}
	
	
	
	
	
}
