package newpson.bullshit;

public enum Column
{
	ID(0),
	NAME(1),
	GENDER(2),
	DATE(3),
	DEPNAME(4),
	SALARY(5);

	public final int index;

	Column(int index) { this.index = index; }
}
