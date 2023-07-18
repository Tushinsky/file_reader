/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author Сергей
 */
public class FrameReader extends JFrame {
    private String fileName;// имя файла HTML
    private JPanel panel;
    private JLabel label;
    
    public FrameReader() throws HeadlessException {
        
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e); //To change body of generated methods, choose Tools | Templates.
                setTitle("FileReader");
                initCompponents();
            }
            
        });
    }
    
    private void initCompponents() {
        label = new JLabel();// метка, куда быдет выводиться текст html
        panel = new JPanel();// панель, на которой будет располагаться метка
        panel.setBorder(new LineBorder(Color.DARK_GRAY, 1));// границы панели
        panel.setBackground(Color.WHITE);// фон панели
        Dimension dmnsn = new Dimension(595, 842);
        panel.setPreferredSize(dmnsn);// предпочтительный размет панели
        panel.setSize(dmnsn);
        panel.setMinimumSize(dmnsn);
        panel.setMaximumSize(dmnsn);
        
        panel.add(label);
        JScrollPane pane = new JScrollPane(panel);// панель прокрутки
        getContentPane().add(pane);// добавляем панель прокрутки на панель содержимого
    }
    
    private String getContent() {
        FileInputStream fis = null;
        try {
            // читаем файл, содержащий текст HTML
            fis = new FileInputStream(fileName);
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrameReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FrameReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
