package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller control = new Controller();

    private SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canva = new JPanel();
        final JPanel innerCanva = new JPanel();
        final JButton broswe = new JButton("Browse..");
        final JButton save = new JButton("Save");
        final JTextField pathFile = new JTextField(control.getFileName());
        final JTextField text  = new JTextField();
        canva.setLayout(new BorderLayout());
        canva.add(save, BorderLayout.SOUTH);
        innerCanva.setLayout(new BorderLayout());
        pathFile.setEditable(false);
        canva.add(innerCanva, BorderLayout.NORTH);
        canva.add(text, BorderLayout.CENTER);
        innerCanva.add(pathFile, BorderLayout.CENTER);
        innerCanva.add(broswe, BorderLayout.LINE_END);
        /**
         * Handler
         */
        broswe.addActionListener(new ActionListener() {
            /**
             * Set the Listener policy.
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    control.setFile(fileChooser.getSelectedFile().getName());
                    pathFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
                } else if (fileChooser.showSaveDialog(frame) == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "No file has been choosen", "Choice", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Occured an error", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
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
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setContentPane(canva);
        this.frame.setTitle("Second first frame");
    }

    /**
     * Prepare the frame to be showen.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Play the application.
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller()).display();
    }


}
