/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.line.interpreter;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ticky
 */
public class readFile {
    
    private Scanner scan;
    
    public void openFile(String fileName)
    {
        try
        {
        scan = new Scanner (new File(fileName));
        }
        catch (Exception e)
        {
            
        }
        
    }
    public void readfile()
    {
        String contents="";
        while(scan.hasNextLine())
        {
            contents=scan.nextLine();
            System.out.println(contents);
        }
     }
    public void search(String word)
    {
        String contents="";
        ArrayList <String>  lines = new ArrayList<>();
        while(scan.hasNextLine())
        {
            contents=scan.nextLine();
            System.out.println(contents);
            lines.add(contents);
            contents="";
        }
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(word))
            {
                int x = i+1;
                System.out.println(word+" at index "+x);
            }
        }
     
    }
    public void closeFile()
    {
        scan.close();
    }
}
