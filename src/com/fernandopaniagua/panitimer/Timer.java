package com.fernandopaniagua.panitimer;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Timer extends Thread{
    private int h;
    private int m;
    private int s;
    private JLabel jlTimeToGoal;
    private boolean running=true;
    public Timer(int h, int m, JLabel jlTimeToGoal){
        this.h = h;
        this.m = m;
        this.s = 0;
        this.jlTimeToGoal = jlTimeToGoal;
    }

    @Override
    public void run() {
        while(running){
            try {
                if (s==0){
                    s=60;
                    if (m==0){
                        m=60;
                        if (h==0){
                            showNotification();
                            break;
                        }
                        h--;
                    } 
                    m--;
                }
                s-=1;
                jlTimeToGoal.setText(h+":"+m+":"+s);
                sleep(1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "PaniTimer Error",
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void stopTimer(){
        this.running = false;
    }
    
    private void showNotification(){
        try {
            SystemTray tray = SystemTray.getSystemTray();
            
            Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/images/clock.png"));
            
            TrayIcon trayIcon = new TrayIcon(image, "PaniTimer");
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Time Over!");
            tray.add(trayIcon);
            
            trayIcon.displayMessage("Time Over!", "PaniTimer", MessageType.INFO);
        } catch (AWTException ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "PaniTimer Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
