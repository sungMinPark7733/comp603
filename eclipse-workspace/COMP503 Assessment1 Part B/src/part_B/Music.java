/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */
package part_B;

public class Music extends DigitalContent{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Music(String title, String publisher, String release, String name) {
		super(title, publisher, release);

		this.name = name;
	}
	@Override
	public String toString() {
		return super.toString() + " name: " + name;
	}
	@Override
	public boolean match(String query) {
		return super.match(query) || this.name.contains(query);
	}
}
