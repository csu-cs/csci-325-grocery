import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class fileManagement{
    String selectedFileName;
    // File structure: Name of object (string name) + Number of said object (int quantity).
    public static void makeFile(String newFileName)
    {

        try {

            newFileName = newFileName + ".txt";
            final Formatter x;
            x = new Formatter("ListsFile\\" + newFileName);

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
            public void populateListTest(List aList)
             {
                 try{
                     Formatter formatting;
                     formatting = new Formatter(selectedFileName);
                 }
                 catch(Exception e)
                 {
                     System.out.println("File is corrupt or invalid. Select another.");
                     // Android stuff
                     //Toast errorToast = Toast.makeText(getApplicationContext(),"File is corrupt or invalid. Select another.,Toast.LENGTH_LONG);
                     //errorToast.show();

                 }
             }
*/
   /* public void populateFileFromList(List k)
    {



    }
*/
         public static List populateListFromFile(String path)
            {
               List generatedList = new List(path);
             try{
                 Scanner fileReader = new Scanner(new File(path));
                do {
                    int i = 0;
                    String nameOfItem;
                    int quantity;
                    nameOfItem = fileReader.next();
                    quantity = Integer.parseInt(fileReader.next());

                    Items currentItem = null;
                    currentItem.nameOfObject = nameOfItem;
                    currentItem.amountOfObjects = quantity;
                   generatedList.itemsInList[i].nameOfObject = currentItem.nameOfObject;
                   generatedList.itemsInList[i].amountOfObjects = currentItem.amountOfObjects;
                   i++;
                } while(fileReader.hasNextLine());

             }
                catch(Exception e)
                {
                    System.out.println("File is corrupt or invalid. Select another.");
                    // Android stuff
                    //Toast errorToast = Toast.makeText(getApplicationContext(),"File is corrupt or invalid. Select another.,Toast.LENGTH_LONG);
                 //errorToast.show();


                }
                return generatedList;
            }
    public static void deleteFile(String path)
    {
 File aFile = new File("ListsFile\\" + path + ".txt");
        if (aFile.exists())
        {
            aFile.delete();
            System.out.println("The file " + aFile.getName() + " has been deleted.");
        }
    }
public static void readFile(String selectedFileName){




}
public static boolean fileExists(String path)
{
    File aFile = new File("ListsFile\\" + path + ".txt");
    if(aFile.exists())
    {
        System.out.println("The file: " + aFile.getName() + " does exist.");
        return true;
    }
else
  return false;
};




}// Handles the writing of the files. Handled by Eric.