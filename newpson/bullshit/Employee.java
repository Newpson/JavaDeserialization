package newpson.bullshit;

import java.util.Date;

public class Employee
{
	int id;
	String name;
	Gender gender;
	Date bdate;
	int salary;
	Department department;

	public Employee(int id, String name, Gender gender, Date bdate, int salary, Department department)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.bdate = bdate;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String toString()
	{
		return String.format("(%d, %s, %s, %s, %d, %s)",
			id, name, gender.title, bdate.toString(), salary, department.toString());
	}
}

