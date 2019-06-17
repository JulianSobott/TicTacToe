import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private MainPanel mainPanel;
    private StartPanel startPanel;
    private Controller controller;


    public GUI(){
        this.controller = new Controller(this);
        this.setTitle("TicTacToe");
        this.setSize(750, 750);
        this.startPanel = new StartPanel(this.controller);
        this.mainPanel = new MainPanel(this.controller);
        this.add(startPanel);

        this.setVisible(true);
    }

    public void showWin(String spieler){
        this.mainPanel.showWin(spieler);
    }

    public void setFieldText(int x, int y, String text){
        this.mainPanel.setFieldText(x, y, text);
    }

    public void showError(String text) {
        this.mainPanel.showError(text);
    }

    public void clearError(){
        this.mainPanel.clearError();
    }

    public void showMainPanel(String name1, String name2){
        this.remove(this.startPanel);
        this.add(mainPanel);
        this.mainPanel.setNames(name1, name2);
    }

    public void clearField(){
        this.mainPanel.clearField();
    }
}
