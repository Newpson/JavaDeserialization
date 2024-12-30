package newpson.bullshit;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;

public class Demo
{
	public static void main(String[] args) throws Exception
	{
		HashMap<String, Department> depList = new HashMap<>();
		List<Employee> empList = new ArrayList<>();

		InputStream input = Demo.class.getClassLoader().getResourceAsStream("res/foreign_names.csv");
		if (input == null)
			throw new Exception("Shit happens");

		CSVReader reader = new CSVReaderBuilder(new InputStreamReader(input))
			.withCSVParser(new CSVParserBuilder()
				.withSeparator(';')
				.build()
			).build();

		String[] line;
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		reader.readNext();
		while ((line = reader.readNext()) != null)
		{
			String depname = line[Column.DEPNAME.index];
			if (!depList.containsKey(depname))
				depList.put(depname, new Department(depname));
			empList.add(new Employee(
				Integer.valueOf(line[Column.ID.index]),
				line[Column.NAME.index],
				line[Column.GENDER.index].equals(Gender.MALE.title) ? Gender.MALE :
				line[Column.GENDER.index].equals(Gender.FEMALE.title) ? Gender.FEMALE : Gender.UNKNOWN,
				dateFormat.parse(line[Column.DATE.index]),
				Integer.valueOf(line[Column.SALARY.index]),
				depList.get(depname)
			));
		}

		for (int i = 0; i < 10; ++i)
			System.out.println(empList.get(i));
	}
}
