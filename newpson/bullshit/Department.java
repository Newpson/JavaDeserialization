package newpson.bullshit;

public class Department
{
	private int id;
	private static int currId = 0;
	private String name;

	public Department(String name)
	{
		this.id = currId++;
		this.name = name;
	}

	@Override
	public String toString()
	{
		return String.format("(%d, %s)", id, name);
	}
}
