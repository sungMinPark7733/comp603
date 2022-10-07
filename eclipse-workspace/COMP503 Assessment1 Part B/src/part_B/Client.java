/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */

package part_B;

import java.util.Scanner;

public class Client implements Play {
	private DigitalContent currentlyStreamed;
	private StreamingService object;

	public Client(StreamingService object) {
		this.currentlyStreamed = null;
		this.object = object;
	}

	@Override
	public DigitalContent getCurrentStream() {
		return this.currentlyStreamed;
	}

	@Override
	public void stream(String query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		this.currentlyStreamed = null;
		System.out.println("Streaming stopped");
	}

	public StreamingService getObject() {
		return object;
	}

	public static void main(String[] args) {

		StreamingService ss = new StreamingService();
		Client cc = new Client(ss);

		Film film1 = new Film("Doctor Strange", "Marvel", "c", "d");
		Film film2 = new Film("Hulk", "Marvel", "c", "d");
		Film film3 = new Film("Thor", "Marvel", "c", "d");
		Film film4 = new Film("Ironman", "Marvel", "c", "d");
		Film film5 = new Film("Spiderman", "Marvel", "c", "d");
		Music m1 = new Music("Someone to you", "f", "g", "h");
		Music m2 = new Music("Stronger", "f", "g", "h");
		Music m3 = new Music("Stay", "f", "g", "h");
		Music m4 = new Music("abcdefu", "f", "g", "h");
		Music m5 = new Music("Youngblood", "f", "g", "h");

		ss.addContent(m1);
		ss.addContent(m2);
		ss.addContent(m3);
		ss.addContent(m4);
		ss.addContent(m5);

		ss.addContent(film1);
		ss.addContent(film2);
		ss.addContent(film3);
		ss.addContent(film4);
		ss.addContent(film5);
//		System.out.println(ss);
		cc.currentlyStreamed = new Film("Iron Man", "Marvel", "2008", "Robert Downey Jr");
//		System.out.println(cc.currentlyStreamed);
//		System.out.println(ss.match("Stay"));
//		cc.stop();
//		System.out.println(cc.currentlyStreamed);

		Scanner scanner = new Scanner(System.in);

		boolean run = true;
		while(run = true)
		{			
			System.out.println("A. Display Digital Content library\r\n"
					+ "B. Display currently streaming DigitalContent\r\n" + "C. Match Digital Content to Stream\r\n"
					+ "D. Stop streaming\r\n" + "E. Quit Client Application");
			String selection = scanner.nextLine();

			if(selection.equalsIgnoreCase("a"))
			{
				System.out.println(ss);
			}
			else if (selection.equalsIgnoreCase("b"))
			{
				System.out.println(cc.currentlyStreamed);
			}
			else if (selection.equalsIgnoreCase("c"))
			{
				ss.match(selection);
			}
			else if (selection.equalsIgnoreCase("d"))
			{
				cc.stop();
			}
			else if (selection.equalsIgnoreCase("e")) {
				System.out.println("Quitting Client Application...");
				run = false;
			}
			else
			{
				System.out.println("Please enter valid input");
			}
		}
//
//		
//		Client c = new Client(new StreamingService());
//		
//		System.out.println(c.currentlyStreamed);
//		c.currentlyStreamed = new Film("Iron Man", "Marvel", "2008", "Robert Downey Jr");
//		System.out.println(c.currentlyStreamed);
//		c.currentlyStreamed = new Music("Circles", "Post Malone", "2020", "Sony");
//		System.out.println(c.currentlyStreamed);
	}

}
