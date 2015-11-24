import java.io.File;
import java.util.Scanner;

public class fileManagement{
    String selectedFileName;
    // File structure: Name of object (string name) + Number of said object (int quantity).
    public static void makeFile(String newFileName)
    {

        try {
            Scanner fileMaker = new Scanner(new File(newFileName));
            newFileName = newFileName + ".txt";
        }
        catch (Exception e)
        {
            System.out.println("Please enter a valid file name.");
              /* Android stuff
                Toast errorToast = Toast.makeText(getApplicationContext(),"Please enter a valid file name.",Toast.LENGTH_LONG);
             errorToast.show();

                 */
        }
    }

    /*
             public void populateListFromFile(List k)
            {
                try{
                    Scanner fileOpener = new Scanner(new File(selectedFileName));
                    do {
                       // Requires integration of ListManagement functions.

                    } while(fileOpener.nextLine() != null);
                }
                catch(Exception e)
                {
                    System.out.println("File is corrupt or invalid. Select another.");
                    // Android stuff
                    //Toast errorToast = Toast.makeText(getApplicationContext(),"File is corrupt or invalid. Select another.,Toast.LENGTH_LONG);
                 //errorToast.show();


                }
            }  */
    public static void deleteFile(File f)
    {

        if (f.exists())
        {
            f.delete();
        }
    }

}// Handles the writing of the files. Handled by Eric.