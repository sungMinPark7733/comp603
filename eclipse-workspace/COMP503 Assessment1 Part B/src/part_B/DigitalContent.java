/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */

package part_B;

public abstract class DigitalContent implements Comparable<DigitalContent>{
	private String title;
	private String publisher;
	private String release;
	
	public DigitalContent(String title, String publisher, String release)
	{
		this.setTitle(title);
		this.setPublisher(publisher);
		this.setRelease(release);
	}
	
	@Override
	public String toString() {
		return "title : " + title + " publisher: " + publisher + " release: " + release;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getRelease() {
		return release;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}
	
	public boolean match(String query)
	{
		boolean result = this.title.contains(query) || this.publisher.contains(query) || this.release.contains(query);
		return result;
	}
	
	
//	Am I allowed to return int instaed of boolean or string
	public int compareTo(DigitalContent o)
	{
		return this.title.compareToIgnoreCase(o.title);
	}



}
