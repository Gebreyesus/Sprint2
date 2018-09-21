/**
 * @author Jackson Nelson
 * File to handle transcript uploading
 */
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;

public class TranscriptUpload {

	public static void uploadFile()
	{
		String filename = null;
	
		Frame window = null;
		FileDialog dialog = new FileDialog(window, "Choose a File", FileDialog.LOAD);
		dialog.setVisible(true);
		filename = dialog.getFile();
		
		System.out.println(filename);
	}
}
