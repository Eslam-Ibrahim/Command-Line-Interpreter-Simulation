/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.line.interpreter;

import java.util.Scanner;

/**
 *
 * @author ticky
 */
public class CommandLineInterpreter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Commands newCommands = new Commands ();
        
        while(true)
        {
            System.out.println(newCommands.pwd()+"$$");
            String input = scan.nextLine();
            if(input.equals("exit"))
            {
                break;
            }
            newCommands.Interpret(input);
           
        }
        
    }
    
}
