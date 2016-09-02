package zadaci_31_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Suppose you have Java source files under the directories chapter1, chapter2, . . . , chapter34. Write a program to insert 
	 * the statement package chapteri; as the first line for each Java source file under the directory chapteri. Suppose chapter1, 
	 * chapter2, . . . , chapter34 are under the root directory srcRootDirectory. The root directory and chapteri directory may contain 
	 * other folders and files. Use the following command to run the program: java Exercise12_18 srcRootDirectory
	 * 
	 * 
	 * Thanks to Luiz Arantes for his example code!
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Zadatak_2 {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {		//ako argument nije jedan string, ispisi gresku
            System.out.println("Invalid argument.");
            System.out.println("Usage: java Exercise12_18 srcRootDirectory");
            System.exit(1);
        }
        //kreiranje objekata
        File root = new File(args[0]);
        File[] chapter = root.listFiles();
        ArrayList<File> dir = new ArrayList<>();
        
        for (int i = 0; i < chapter.length; i++) {
            if (chapter[i].isDirectory() && chapter[i].getName().contains("Chapter")) {		//ako je chapter direktorij i sadrzi dati string
                dir.add(chapter[i]);														//dodaj chapter
            }
        }
        for (File ex : dir) {
            File[] files = ex.listFiles();
            if (files == null) 
            	continue;
            for (File file : files) {
                if (file.getName().contains(".java")) {		//ako file sadrzi .java, pozivamo metodu
                    newPackage(file, ex.getName());
                }
            }
        }
    }
    //metoda koja ubacuje odredjen string u fajl
    private static void newPackage(File file, String name) throws FileNotFoundException {
        String lineSeparator = System.getProperty("line.separator");
        String pack = "package " + name + ";";
        Scanner read = new Scanner(file);	//kreiranje objekta
        while (read.hasNext()) {
        	String s = read.nextLine();
            if (s.equals(pack)) {		//ako je linija jednaka stringu, zaustavi
            	System.out.println("File: " + file + " already has package " + name);
                return; 
            }
            pack += lineSeparator + s;		
        }
        read.close();
        PrintWriter output = new PrintWriter(file);
        output.write(pack);		//pisemo string u fajl
        output.close();
    }
}
