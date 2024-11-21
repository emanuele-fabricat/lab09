package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private static int PROPORTION = 5;

    private SimpleGUI(SimpleController controller) {
        final JPanel canva = new JPanel();
        final JPanel innerCanva = new JPanel();
        final JTextField latestString = new JTextField("Waiting first string");
        final JTextArea text = new JTextArea();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");

        canva.setLayout(new BorderLayout());
        innerCanva.setLayout(new BoxLayout(innerCanva, BoxLayout.X_AXIS));
        canva.add(latestString, BorderLayout.NORTH);
        canva.add(text, BorderLayout.CENTER);
        canva.add(innerCanva, BorderLayout.SOUTH);
        innerCanva.add(showHistory, BorderLayout.SOUTH);
        innerCanva.add(print, BorderLayout.SOUTH);
        latestString.setEditable(false);
        /**
         * handlers
         */
        print.addActionListener(e -> stamp(controller, text.getText()));
        showHistory.addActionListener(e -> stampChronology(controller, latestString));

        this.frame.add(canva);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Simple pinter to standard output");
    }
    private static void stampChronology(SimpleController controller, JTextField text) {
        text.setText(controller.getHistory().toString());
    }
    private static void stamp(SimpleController controller, String text) {
        controller.setString(text);
        controller.stamp();
    }
    /**
     * Prepare the frame to be shown
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Play the application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
