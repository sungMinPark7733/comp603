/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */
package part_B;

public class Film extends DigitalContent{
	private String cast;

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}	
	public Film(String title, String publisher, String release, String cast) {
		super(title, publisher, release);
		
		this.cast = cast;
	}

	@Override
	public String toString() {
		return super.toString() + " cast: " + cast;
	}

	@Override
	public boolean match(String query) {
		return super.match(query) || this.cast.contains(query);
	}
	
	
}
