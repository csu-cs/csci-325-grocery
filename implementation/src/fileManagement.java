import java.io.File;
import java.util.Formatter;

import java.util.Scanner;

public class fileManagement{
   // String selectedFileName;
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
                String nameOfItem = null;
                int quantity;

                Items genericItem = null;

             try{
                 Scanner fileReader = new Scanner(new File(path));
                 int i = 0;
                do {


                    nameOfItem = fileReader.next();
                    //System.out.println(nameOfItem);
                    quantity = Integer.parseInt(fileReader.next());
                    //System.out.println(quantity);
                 genericItem = new Items(nameOfItem, quantity);
                    generatedList.itemsInList[i] = genericItem;
                   System.out.println("List object name " +  " " + generatedList.itemsInList[i].nameOfObject);
                    System.out.println("Amount of that object: " +  " " + generatedList.itemsInList[i].amountOfObjects);
                   i++;
                    //System.out.println(i);
                } while(fileReader.hasNext());
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