/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.line.interpreter;

/**
 *
 * @author ticky
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

/**
 *
 * @author Eslam Ibrahim
 */
public class writeFile {
    
    private Formatter format;
    
    public void openFile(String fileName)
    {
        try
        {
         format = new Formatter(fileName);
        }
        catch (Exception e)
        {
            
        }
        
    }
    public void writeString(String str)
    {
        format.format("%s%n", str,"\n");
    }
    public void append(String str , String fileName)
    {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
    out.println(str);
    out.close();
    
}catch (IOException e) {
    //exception handling left as an exercise for the reader
}
    }
   
    public void closeFile()
    {
      format.close();
    }
    
}