package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private String fileName;

    private static final String DEFOULT_FILE = "output.txt";
    private static final String PATH = System.getProperty("user.home") + File.separator;

    public Controller() {
        this.fileName = DEFOULT_FILE;
    }
    
    /**
     * 
     * @return The file name
     */
    public String getFileName() {
        return this.fileName;
    }
    private void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * @param  fileName New file, that must be in the home directory, and it must be passed by only name,
     *if the file doesn't exist the metod return False
     * @return True if the file exist, False instead
     */
    public boolean setFile(String fileName) {
        if(new File(PATH + fileName).exists()) {
            setFileName(fileName);
            return true;
        }else{
            return false;
        }
    }
    /**
     * 
     * @return The string of the file path
     */
    public String getFilePAth() {
        return PATH + this.fileName;
    }
    /**
     * 
     * @param text The string to write in the file
     */
    public void write(String text) {
        try (PrintStream ps = new PrintStream(this.getFilePAth(), StandardCharsets.UTF_8)){
            ps.print(text);
        } catch (IOException e1) {
            System.out.println("The file is impossible to open or doesn't exist");// NOPMD: allowed as this is just an exercise
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
