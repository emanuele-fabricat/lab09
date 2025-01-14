package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private static final int PROPORTION = 5;

    /**
     * Create a frame with the required specifications.
     * 
     * @param controller The controller to save the text.
     */
    public SimpleGUI(final Controller controller) {
        final JPanel canva = new JPanel();
        final JButton save = new JButton("Save");
        final TextArea text = new TextArea();
        canva.setLayout(new BorderLayout());
        canva.add(text, BorderLayout.CENTER);
        canva.add(save, BorderLayout.SOUTH);
        /**
         * Handlers
         */
        save.addActionListener(new ActionListener() {
            /**
             * Set the Listener policy.
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int choice = JOptionPane.showConfirmDialog(frame,
                     "Are you sure to save?", 
                     "Saving", 
                     JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    controller.write(text.getText());
                }
            }
        });
        this.frame.setContentPane(canva);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("My first simply text editor");
    }
    /** 
     *Prepare the frame to be shown.
    */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Launch application.
     * 
     * @param args ignored.
     */
    public static void main(final String... args) {
        /**
         * Starts the interface.
         */
        new SimpleGUI(new Controller()).display();
    }
}
