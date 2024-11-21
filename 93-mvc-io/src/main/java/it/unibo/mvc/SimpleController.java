package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private final List<String> chronology = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setString(final String text) {
        chronology.add(Objects.requireNonNull(text)); 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getString() {
        return chronology.getLast();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistory() {
        final List<String> copyOfChronology = new ArrayList<>();
        copyOfChronology.addAll(this.chronology);
        return copyOfChronology;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void stamp() {
        final String  text = this.chronology.getLast();
        if (text == null) {
            throw new IllegalArgumentException("It's impossible to print a empty string");
        } else {
            System.out.println(text); // NOPMD: allowed as this is just an exercise
        }
    }

}
