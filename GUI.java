import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

// By: Olson Thao
// pulls up the gui and  able to select files by no additional functionality is added to it. still need to
// figure out other methods.

public class GUI extends JFrame{

    JButton transcript = new JButton("Upload Transcript");
    JButton major = new JButton("Upload Degree Checklist");
    JButton confirm = new JButton("Confirm");
    JLabel userOutput = new JLabel("You haven't uploaded a Transcript "
            + "or a Degree Checklist");

    File file1 = null;
    File file2 = null;
    //Checks for which file has been inputted
    Boolean buttonT = false;
    Boolean buttonD = false;

    public GUI()
    {
        this.setTitle("Read Transcript");
        this.setBounds(300,100,450,600);
        //contentPane is on default
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //put in the buttons
        this.transcript.setBounds(10, 10, 150, 40);
        this.getContentPane().add(transcript);
        this.transcript.addActionListener(new TranscriptButtonListener());

        this.major.setBounds(180, 10, 170, 40);
        this.getContentPane().add(major);
        this.major.addActionListener(new DegreeButtonListener());

        this.confirm.setBounds(110, 50, 130, 40);
        this.getContentPane().add(confirm);
        this.confirm.addActionListener(new ConfirmButtonListener());

        this.userOutput.setBounds(50, 100, 100, 10);
        this.getContentPane().add(userOutput);

    }

    private class TranscriptButtonListener implements ActionListener
    {
        //Overrides the method from ActionListener
        public void actionPerformed(ActionEvent a)
        {
            JFileChooser transcriptFile = new JFileChooser();
            transcriptFile.setFileFilter( new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
            int chooserSuccess = transcriptFile.showOpenDialog(null);
            if( chooserSuccess == JFileChooser.APPROVE_OPTION) {
                file1 = transcriptFile.getSelectedFile();
                buttonT = true;
                //need method to set transcript file (args[0]) to file.getAbsolutePath()
                //example... setFile(file.getAbsolutePath());
                //will need a global variable in case checklist is added before transcript -- vice versa
                if(buttonD.equals(false))
                {
                    userOutput.setText("You have uploaded a Transcript " +
                            "but not a Degree Checklist");
                }
                else
                {
                    userOutput.setText("You have uploaded a Transcript " +
                            "and a Degree Checklist");
                }

            }
            else {
                userOutput.setText(userOutput.getText() + "\nUploading transcript file has been cancelled.");
            }

        }
    }

    private class DegreeButtonListener implements ActionListener
    {
        //Overrides the method from ActionListener
        public void actionPerformed(ActionEvent b)
        {
            JFileChooser degreeFile = new JFileChooser();
            degreeFile.setFileFilter( new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
            int chooserSuccess = degreeFile.showOpenDialog(null);
            if( chooserSuccess == JFileChooser.APPROVE_OPTION) {
                file2 = degreeFile.getSelectedFile();
                buttonD = true;
                //need method to set transcript file (args[0]) to file.getAbsolutePath()
                //example... setFile(file.getAbsolutePath());
                //will need a global variable in case checklist is added before transcript -- vice versa
                if(buttonT.equals(false))
                {
                    userOutput.setText("You have not uploaded a Transcript " +
                            "but have uploaded a Degree Checklist");
                }
                else
                {
                    userOutput.setText("You have uploaded a Transcript " +
                            "and a Degree Checklist");
                }

            }
            else {
                System.out.println("Cancelled file chooser.");
            }
			/*
			 Call the method to grab a text file and put it in as args[0]
			 */
        }
    }

    private class ConfirmButtonListener implements ActionListener
    {
        //Overrides
        public void actionPerformed(ActionEvent c)
        {

        }
    }

}