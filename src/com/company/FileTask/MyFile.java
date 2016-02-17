package com.company.FileTask;

import com.company.MyCollection.ArrayListM;
import java.io.*;

/**
 * @author Lego on 17.02.2016.
 * @version 1.0
 */
public class MyFile implements Connect{

    public void write(String fileName) {
        //указываем путь файла
        File file = new File(fileName);
        StringBuilder temp = new StringBuilder();
        try {
            //check if the file does not exist, create it
            if(!file.exists()){
                file.createNewFile();
            }
            //PrintWriter provides logging features
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            int a=0;
            try {
                for(int i = 0; i < 23; i++){			//save as text file
                    for(int j = 0; j < 3; j++){
                        temp.append(MassShips[a] + ", ");	//inserting space between the values
                        a++;
                    }
                    temp.append("\r\n");      // inserting line break
                }
                temp.append("------------------------");
                temp.append("\r\n");

                a=0;
                for(int i = 0; i < 9; i++){
                    for(int j = 0; j < 6; j++){
                        temp.append(MassClasses[a] + ", ");	//inserting space between the values
                        a++;
                    }
                    temp.append("\r\n");      // inserting line break
                }
                out.print(temp);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Well Done");
        System.out.println("------------------------");
    }

    public void writeChanges(String fileName, ArrayListM<String> arrayListM) {
        //указываем путь файла
        File file = new File(fileName);

            //PrintWriter provides logging features
        PrintWriter out = null;
        try {
            out = new PrintWriter(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int a=0;
            try {
                while(a!= arrayListM.size()){
                    out.print(arrayListM.get(a));
                    a++;
                }
            } finally {
                out.close();
            }

        System.out.println("Well Done");
        System.out.println("------------------------");
    }

    public ArrayListM<String> read(String fileName) throws FileNotFoundException, IOException {
        //create an object to store information from a file

        File file = new File(fileName);

        exists(fileName);
        ArrayListM<String> arrayListM = new ArrayListM<>();
        try {
            //read information from a file into a buffer
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //read the file in cycle
                String s;
                while ((s = in.readLine()) != null) {
                    arrayListM.add(s);
                }
            } finally {
                //close the file
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        //Returns the text from file
        return arrayListM;
    }
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }


    public void print(String fileName) throws FileNotFoundException, IOException {
        //create an object to store information from a file
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        exists(fileName);
        try {
            //read information from a file into a buffer
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                //read the file in cycle
                String s;
                while ((s = in.readLine()) != null) {
                    System.out.println(s);
                }
            } finally {
                //close the file
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
