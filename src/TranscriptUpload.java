/**
 * @author Jackson Nelson
 * File to handle transcript uploading
 */
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;

public class TranscriptUpload {

	public void uploadFile()
	{
		String filename = null;
		try
		{
			Frame window = null;
			FileDialog dialog = new FileDialog(window, "Choose a File", FileDialog.LOAD);
			dialog.setVisible(true);
			filename = dialog.getName();
		}
		finally
		{
			System.out.println(filename);
		}
	}
	
	public static void main(String[] args)
	{
		uploadFile()
	}

}


