package com.company.FileTask;

import com.company.MyCollection.ArrayListM;

import java.io.IOException;

/**
 * @author Lego on 17.02.2016.
 * @version 1.0
 */
public class FileMain {
    private static final String fileName = "Test.txt";

    public void start(){
        MyFile myFile = new MyFile();
        myFile.write(fileName);
        try {
            myFile.print(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        myFile.writeChanges(fileName, change(myFile.read(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myFile.print(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ArrayListM<String> change(ArrayListM<String> arrayListM){
        StringBuilder temp = new StringBuilder();
        int a = 0;
        while (a < arrayListM.size()){
            if (arrayListM.get(a).contains("USA")){
                String[] split = arrayListM.get(a).split(", ");
                int i = 0;
                while(i < arrayListM.size()){
                    if (arrayListM.get(i).contains(split[0])) {
                        arrayListM.set(i, "USA_"+arrayListM.get(i));
                    }
                    i++;
                }
            }
            arrayListM.set(a, arrayListM.get(a)+"\r\n");
            a++;
        }
        return arrayListM;
    }

}
