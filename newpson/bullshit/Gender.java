package newpson.bullshit;

public enum Gender
{
	MALE("Male"),
	FEMALE("Female"),
	UNKNOWN("Unknown");

	public final String title;

	Gender(String title) { this.title = title; }
}
