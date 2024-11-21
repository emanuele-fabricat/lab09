package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced.
     * 
     * @param text The next string to print
     */
    public void setString(String text);
    /**
     * A method for getting the next string to print
     * 
     * @return The last String to print
     */
    public String getString();
    /**
     * A method for getting the history of the printed strings (in form of a {@link List#of(String)})
     */
    public List<String> getHistory();
    /**
     * A method that prints the current string. 
     * If the current string is unset, an {@link IllegalStateException} should be thrown.
     */
    public void stamp();    
}
