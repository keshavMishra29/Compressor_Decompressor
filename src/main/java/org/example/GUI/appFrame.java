package org.example.GUI;

import org.example.comp_decomp.compressor;
import org.example.comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class appFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    appFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("Select file to compress");
        compressButton.setBounds(20, 100, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select file to decompress");
        decompressButton.setBounds(250, 100, 200, 30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.green);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            try {
                compressor.method(file);
            }
            catch (Exception ee){
                JOptionPane.showMessageDialog(null, ee.toString());
            }
        }
        if (e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            try {
                decompressor.method(file);
            }
            catch (Exception ee){
                JOptionPane.showMessageDialog(null, ee.toString());
            }
        }
    }
}
