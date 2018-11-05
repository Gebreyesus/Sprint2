import java.net.URL;
import java.net.URLConnection;
import java.io.OutputStreamWriter;

public class URLGrabber {
	public static void main(String[] args) throws Exception
	{
        
		//Stores in the URL
		URL testURL = new URL("https://www.free-ocr.com/");
		//System.out.println(testURL.getFile()); //test
		
		//opens the connection
		URLConnection connection = testURL.openConnection();
		//set dooutput to true 
		/*(Output stream = writing data to)
		  (Input stream = reading data from*/
		connection.setDoOutput(true);
		
		//getOutputStream = grab the stream to write into
		//OutputStreamWriter = the stream objec(will be inserted into the outputStream)
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		
		out.write("");
		
		//https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
		//http://journals.ecs.soton.ac.uk/java/tutorial/networking/urls/readingWriting.html
		//https://www.free-ocr.com/
		//https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
		
	}
}
