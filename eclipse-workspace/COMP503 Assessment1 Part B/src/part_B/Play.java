/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */

package part_B;

public interface Play {
	public DigitalContent getCurrentStream();
	public void stream(String query);
	public void stop();
}
