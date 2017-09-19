import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {

    public static void main(String[] args){
        try{
            Socket s = new Socket("127.0.0.1", 8001);

            while(true){
                //socket streams
                InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream();
                ObjectInputStream ois = new ObjectInputStream(input);

                //input scanner
                Scanner scan = new Scanner(input);

                PrintWriter out = new PrintWriter(output, true);

                //scanner starts, modtag velkomst
                String welcome = scan.nextLine();
                System.out.println(welcome);



                out.println("Første besked");
                System.out.println(ois.readObject().toString());
                // System.out.println(scan.nextLine());

                //modtag velkomst


                out.println("Anden besked");
                System.out.println(ois.readObject().toString());
                //System.out.println(scan.nextLine());


                out.println("Tredie besked");
                System.out.println(ois.readObject().toString());
                //System.out.println(scan.nextLine());

                s.close();
                System.out.println("Forbindelsen lukket.");
            }
        }   catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
