package teast.example;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        com.main.devOps.test.Log log = null;
        try {
            log = new com.main.devOps.test.Log("log.txt");
            File myObj = new File("input.txt");
            OutputStream os = Files.newOutputStream(new File("output.txt").toPath());

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                int value = Integer.parseInt(data);
                boolean c = isPrime(value);
                System.out.println(value+ " "+c);
                if(c) {
                    os.write((data+ " is a prime number\n").getBytes());
                } else {
                    os.write((data+ " is not a prime number\n").getBytes());
                }

            }
//		     myWriter.close();
            myReader.close();


        } catch (Exception e) {
            e.printStackTrace();
            Objects.requireNonNull(log).logger.severe("exception:"+ e);

        }

    }

    static  boolean isPrime(int num){
        if(num<=1)
        {
            return false;
        }
        for(int i=2;i<=num/2;i++)
        {
            if((num%i)==0)
                return  false;
        }
        return true;
    }

}
