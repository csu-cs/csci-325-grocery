package csu.csci325.GroceryApp;


import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;

import java.io.File;
import java.util.Scanner;

public class fileManagement {

    public static boolean populateListFromFile(String path)
    {
        List generatedList = new List(path);
        try {
            Scanner fileReader = new Scanner(new File(path));
        }
        catch(Exception e)
        {
           return false; // File error. Will result in producing a toast.
        }
    return true; // Meaning it worked.
    }
}
