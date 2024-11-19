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
    private SimpleGUIWithFileChooser() {
        final JPanel canva = new JPanel();
        final JPanel innerCanva = new JPanel();
        final JButton broswe = new JButton("Browse..");
        final JButton save = new JButton("Save");
        final JTextField pathFile = new JTextField(control.getFileName());
        canva.setLayout(new BorderLayout());
        canva.add(save, BorderLayout.SOUTH);
        innerCanva.setLayout(new BorderLayout());
        pathFile.setEditable(false);
        canva.add(innerCanva, BorderLayout.NORTH);
        innerCanva.add(pathFile, BorderLayout.CENTER);
        innerCanva.add(broswe, BorderLayout.LINE_END);
        /**
         * Handler
         */
        broswe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION){
                    control.setFile(fileChooser.getSelectedFile().getName());
                    pathFile.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }else if(fileChooser.showSaveDialog(frame) == JFileChooser.CANCEL_OPTION){

                }else{
                    JOptionPane.showMessageDialog(frame, "Occured an error", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        /**
         * Handlers
         */
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                JOptionPane.showConfirmDialog(frame, "Are you sure to save?", "Saving", JOptionPane.YES_NO_OPTION);
            }
            
        });
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setContentPane(canva);
        this.frame.setTitle("Second first frame");
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }


}
