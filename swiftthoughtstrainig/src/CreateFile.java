import java.io.File;
import java.io.IOException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.io.FileNotFoundException;

public class CreateFile {
    public static void main(String[] args) {
//read the pasted value
        StringBuilder sb = new StringBuilder();
        try {
            File myObj = new File(args[2]);
            Scanner myReader = new Scanner(myObj);
            boolean initial = true;
            while (myReader.hasNextLine()) {
                if(!initial)
                    sb.append(System.lineSeparator());
                initial = false;
                String data = myReader.nextLine();
                sb.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

//read the template value
        StringBuilder sbt = new StringBuilder();
        try {
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            boolean initial = true;
            while (myReader.hasNextLine()) {
                if(!initial)
                    sbt.append(System.lineSeparator());
                initial = false;
                String data = myReader.nextLine();
                if(data.contains(args[1]))
                    data=data.substring(0,data.indexOf(args[1]))+sb.toString()+data.substring(data.indexOf(args[1])+args[1].length());
                sbt.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(args[3]);
            myWriter.write(sbt.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
} 