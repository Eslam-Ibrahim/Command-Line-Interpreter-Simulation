/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.line.interpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ticky
 */
public class Commands {

    public Commands() {

    }

    public String pwd() {
        String pwd = System.getProperty("user.dir"); //pwd //my path right now
        return pwd;

    }

    private void ls(String command) {

        File dir = new File(System.getProperty("user.dir"));
        String childs[] = dir.list();
        for (String child : childs) {
            System.out.println(child);
        }

        if (command.indexOf(">") == command.lastIndexOf(">") && command.contains(">")) {
            // operation >
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.indexOf(">") + 2);
            writeFile file = new writeFile();
            file.openFile(fileName);
            for (String child : childs) {
                file.writeString(child);
            }
            file.closeFile();
        }
        if (command.indexOf(">") != command.lastIndexOf(">")) {
            // operation >>
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.lastIndexOf(">") + 2);
            writeFile file = new writeFile();
            for (String child : childs) {
                file.append(child, fileName);
            }

        }
    }

    private void date(String command) {
        DateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date newDate = new Date();
        System.out.println(newDateFormat.format(newDate));
        if (command.indexOf(">") == command.lastIndexOf(">") && command.contains(">")) {
            // operation >
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.indexOf(">") + 2);
            String strDate = newDateFormat.format(newDate);
            writeFile file = new writeFile();
            file.openFile(fileName);
            file.writeString(strDate);
            file.closeFile();
        }
        if (command.indexOf(">") != command.lastIndexOf(">")) {
            // operation >>
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.lastIndexOf(">") + 2);
            writeFile file = new writeFile();
            String strDate = newDateFormat.format(newDate);
            file.append(strDate, fileName);
        }

    }

    private void args(String input) {
        if (input.equals("args")) {
            System.out.println("you have to Enter a Command");
        } else {
            String newInput = input.substring(5);
            switch (newInput) {
                case "ls":
                    System.out.println("/");
                    System.out.println("–lt /");
                    System.out.println("s*");
                    System.out.println("n*f");
                    System.out.println("-al");
                    System.out.println("> out");
                    break;
                case "mkdir":
                    System.out.println("dir");
                    break;
                case "help":
                    System.out.println("nothing");
                    break;
                case "pwd":
                    System.out.println("nothing");
                    break;
                case "cd":
                    System.out.println("nothing");
                    System.out.println("dir");
                    break;
                case "cp":
                    System.out.println("f1  f2");
                    break;
                case "rm":
                    System.out.println("–r NEWDIR");
                    break;
                case "rmdir":
                    System.out.println("dir");
                    break;
                case "mv":
                    System.out.println("f1  f2");
                    break;
                case "less":
                    System.out.println("file name");
                    break;
                case "more":
                    System.out.println("file name");
                    System.out.println("nothing");
                    break;
            }
        }
    }

    private void help(String command) {
        System.out.println("Clear	:	to clear the current terminal screen.");
        System.out.println("cd	:	This command changes the current directory to another one");
        System.out.println("ls	:	These programs list each given file or directory name");
        System.out.println("cp	:	copies given file into a file with the same name in the given directory");
        System.out.println("mv	:	moves given file into a file with the same name in given directory. ");
        System.out.println("rm	:	removes each specified file. By default, it does not remove directories.");
        System.out.println("mkdir	:	creates a directory with the given name.");
        System.out.println("rmdir	:	removes the given directory if it is empty.");
        System.out.println("date	:	To display the date and time of the system.");
        System.out.println("cat	:	Concatenate files and print on the standard output.");
        System.out.println("more	:	Let us display and scroll down the output in one direction only. You can scroll page by page or line by line.");
        System.out.println("less	:	Like more but more enhanced. It support scroll forward and backward.");
        System.out.println(">	:	Redirect the output to be written to a file using the redirect > create/replace file operator.");
        System.out.println(">>	:	Redirect the output to be written to a file using the redirect >> create/append to file operator.");
        if (command.indexOf(">") == command.lastIndexOf(">") && command.contains(">")) {
            // operation >
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.indexOf(">") + 2);
            String strHelp = "Clear:to clear the current terminal screen." + "|"
                    + "cd:This command changes the current directory to another one" + "|"
                    + "ls:These programs list each given file or directory name" + "|"
                    + "cp:copies given file into a file with the same name in the given directory" + "|"
                    + "mv:moves given file into a file with the same name in given directory. " + "|"
                    + "rm:removes each specified file. By default, it does not remove directories." + "|"
                    + "mkdir:creates a directory with the given name." + "|"
                    + "rmdir:removes the given directory if it is empty." + "|"
                    + "date:To display the date and time of the system." + "|"
                    + ">:Redirect the output to be written to a file using the redirect > create/replace file operator." + "|"
                    + ">>:Redirect the output to be written to a file using the redirect >> create/append to file operator." + "|";
            writeFile file = new writeFile();
            file.openFile(fileName);
            file.writeString(strHelp);
            file.closeFile();
        }
        if (command.indexOf(">") != command.lastIndexOf(">")) {
            // operation >>
            String str = "\\";
            String direction = System.getProperty("user.dir");
            String fileName = direction + str + command.substring(command.lastIndexOf(">") + 2);
            writeFile file = new writeFile();
            String strHelp = "Clear:to clear the current terminal screen." + "|"
                    + "cd:This command changes the current directory to another one" + "|"
                    + "ls:These programs list each given file or directory name" + "|"
                    + "cp:copies given file into a file with the same name in the given directory" + "|"
                    + "mv:moves given file into a file with the same name in given directory. " + "|"
                    + "rm:removes each specified file. By default, it does not remove directories." + "|"
                    + "mkdir:creates a directory with the given name." + "|"
                    + "rmdir:removes the given directory if it is empty." + "|"
                    + "date:To display the date and time of the system." + "|"
                    + ">:Redirect the output to be written to a file using the redirect > create/replace file operator." + "|"
                    + ">>:Redirect the output to be written to a file using the redirect >> create/append to file operator." + "|";
            file.append(strHelp, fileName);
        }
    }

    private String removeQ(String s) {
        String edited = "";
        if (s.charAt(0) == '\"' && s.charAt(s.length() - 1) == '\"') {
            edited = s.substring(1, s.length() - 1);
            //System.out.println("edited si "+edited);
            return edited;
        } else {
            return s;
        }
    }

    private void cd(String command) {
        if (command.equals("cd")) {
            System.out.println("Missing directory");
        } else {
            String directory = command.substring(3);
            directory = removeQ(directory);
            if (new File(directory).isDirectory()) {
                System.setProperty("user.dir", directory);
            } else {
                System.out.println("Wrong Directory");
            }
        }

    }

    private void mkdir(String command) {
        if (command.equals("mkdir")) {
            System.out.println("Missing directory Name");
        } else {
            String directory = command.substring(6);
            directory = removeQ(directory);
            String pwd = System.getProperty("user.dir"); //pwd //my path right now
            File files = new File(pwd + "\\" + directory);
            files.mkdir();
        }
    }

    private void rmdir(String command) {
        if (command.equals("rmdir")) {
            System.out.println("Missing directory Name");
        } else {
            String directory = command.substring(6);
            directory = removeQ(directory);
            String pwd = System.getProperty("user.dir"); //pwd //my path right now
            File files = new File(pwd + "\\" + directory);
            if (!files.exists()) {
                System.out.println("File doesn't exist.");
            } else {
                try {

                    delete(files);
                } catch (IOException e) {
                }
            }
        }
    }

    private void delete(File f)
            throws IOException {

        if (f.isDirectory()) {
            if (f.list().length == 0) {

                f.delete();

            } else {
                System.out.println("the file is not empty");
            }
        } else {
            System.out.println("this is not a directory");
        }
    }

    private void rm(String command) {
        if (command.equals("rm")) {
            System.out.println("missing fileName");
        } else {

            String directory = command.substring(3);
            directory = removeQ(directory);
            String pwd = System.getProperty("user.dir"); //pwd //my path right now
            File files = new File(pwd + "\\" + directory);
            if (!files.exists()) {
                System.out.println("File doesn't exist.");
            } else {
                try {

                    deleteFile(files);
                } catch (IOException e) {
                }
            }
        }
    }

    private void deleteFile(File f) throws IOException {

        if (f.isDirectory()) {
            System.out.println("rm removes only files (you entered a directory)");

        } else {
            f.delete();
        }
    }

    private void mv(String command) //lazm aktb mv ...txt ...txt
    {
        if (command.equals("mv")) {
            System.out.println("missing source and distenation");
        } else {
            InputStream inStream = null;
            OutputStream outStream = null;

            try {
                String src = removeQ(command.substring(3, command.indexOf("|")));
                String dest = removeQ(command.substring(command.indexOf("|") + 1));
                File afile = new File(src);
                File bfile = new File(dest);

                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);

                byte[] buffer = new byte[1024];

                int length;
                //copy the file content in bytes 
                while ((length = inStream.read(buffer)) > 0) {

                    outStream.write(buffer, 0, length);

                }

                inStream.close();
                outStream.close();

                //delete the original file
                afile.delete();

            } catch (IOException e) {
            }
        }

    }

    private void cp(String command) //lazm aktb mv ...txt ...txt
    {
        if (command.equals("cp")) {
            System.out.println("missing source and distenation");
        } else {
            InputStream inStream = null;
            OutputStream outStream = null;

            try {
                String src = removeQ(command.substring(3, command.indexOf("|")));
                String dest = removeQ(command.substring(command.indexOf("|") + 1));
                File afile = new File(src);
                File bfile = new File(dest);

                inStream = new FileInputStream(afile);
                outStream = new FileOutputStream(bfile);

                byte[] buffer = new byte[1024];

                int length;
                //copy the file content in bytes 
                while ((length = inStream.read(buffer)) > 0) {

                    outStream.write(buffer, 0, length);

                }

                inStream.close();
                outStream.close();

            } catch (IOException e) {
            }
        }

    }

    private void cat(String command) {
        if (command.equals("cat")) {
            System.out.println("missing fileName");
        } else {
            try{
            String directory = command.substring(4,command.indexOf("|"));
            directory = removeQ(directory);
            String pwd = System.getProperty("user.dir");
            readFile newFile = new readFile();
            newFile.openFile(pwd + "\\" + directory);
            newFile.readfile();
            newFile.closeFile();
            }
             catch (Exception ex) {
                System.out.println("file not found.");
            }
            try{
            String secondDir = command.substring((command.indexOf("|")+1),command.length());
            secondDir = removeQ(secondDir);
            String pwd = System.getProperty("user.dir");
            readFile newFile = new readFile();
            newFile.openFile(pwd + "\\" + secondDir);
            newFile.readfile();
            newFile.closeFile();
            }
             catch (Exception ex) {
                System.out.println("file not found.");
            }
             
        
        }

    }
    private void grep (String command)
    {
        if (command.equals("grep"))
        {
            System.out.println("error");
        }
        else
        {
            String Word = removeQ(command.substring(5,command.indexOf("|")));
            String fileName = removeQ(command.substring(command.indexOf("|")+1));
             try{
           
           
            String pwd = System.getProperty("user.dir");
            readFile newFile = new readFile();
            newFile.openFile(pwd + "\\" + fileName);
            newFile.search(Word);
            newFile.closeFile();
            }
             catch (Exception ex) {
                System.out.println("file not found.");
            }
        }
    }

    private void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }

    }
    
    private void find (String command)
    {
        if (command.equals("find"))
        {
            System.out.println("Missing fileName");
        }
        else
        {
          String fileName = command.substring(5,command.indexOf("|"));
          String dir = command.substring(command.indexOf("|")+1);
          ArrayList <String> files = new ArrayList <>();
          files = listF(dir,files);
            for (int i = 0; i < files.size(); i++) {
                if (files.get(i).contains(fileName))
                {
                    System.out.println(files.get(i));
                    break;
                }
            }
        }
    }
    private ArrayList <String> listF(String dir , ArrayList <String>files)
    {
        File direct = new File(dir);
        File [] fList = direct.listFiles();
        for (File file : fList) {
            if (file.isFile())
            {
                files.add(file.getAbsolutePath());
            }
            else if (file.isDirectory())
            {
                listF(file.getAbsolutePath(),files);
            }
        }
        return files;
    }
    public void Interpret(String command) {
        // Check if i have 2 commands
        boolean flag = false;
        int indexOfSemiColon = 0;
        for (int i = 0; i < command.length(); ++i) {

            if (command.charAt(i) == ';') {
                flag = true;
                indexOfSemiColon = i;
                break;
            }

        }
        if (flag) {
            String secondCommand = command.substring(indexOfSemiColon + 1);
            command = command.substring(0, indexOfSemiColon);
            Interpret(command);
            Interpret(secondCommand);
        } else {
            // Interpret the command
            if (command.contains("date")) {
                date(command);
            } else if (command.contains("args")) {
                args(command);
            } else if (command.contains("help")) {
                help(command);
            } else if (command.contains("pwd")) {
                System.out.println(pwd());

            } else if (command.contains("ls")) {
                ls(command);
            } else if (command.contains("cd")) {
                cd(command);
            } else if (command.contains("mkdir")) {
                mkdir(command);
            } else if (command.contains("rmdir")) {
                rmdir(command);
            } else if (command.contains("rm")) {
                rm(command);
            } else if (command.contains("mv")) {
                mv(command);
            } else if (command.contains("cp")) {
                cp(command);
            } else if (command.contains("cat")) {
                cat(command);
            } else if (command.equals("clear")) {
                clear();
                 } else if (command.contains("find")) {
                find(command);
                 } else if (command.contains("grep")) {
                grep(command);
            } else {
                System.out.println("There is no command " + command);

            }

        }

    }
}
