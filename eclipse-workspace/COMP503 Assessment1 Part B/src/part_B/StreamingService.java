/**
 * 
 * @author kyk1386
 *SUNG MIN PARK
 *22166034
 *COMP503
 */

package part_B;

import java.util.ArrayList;
import java.util.Collections;

public class StreamingService {
	private ArrayList<DigitalContent> contentList;
	private ArrayList<DigitalContent> playList;

	public StreamingService() {
		this.contentList = new ArrayList<DigitalContent>();
		this.playList = new ArrayList<DigitalContent>();
	}
	
	public void addContent(DigitalContent digitalContent)
	{
		if(digitalContent != null){
			this.contentList.add(digitalContent);
		}
	}
	public ArrayList<DigitalContent> match(String query)
	{
		return playList;
	}
	@Override
	public String toString() {
		Collections.sort(contentList);
		String output = "";
		for(int i = 0; i < contentList.size(); i++)
		{
			output += contentList.get(i) + "\n";
		}
		return output;
	}
	
}
