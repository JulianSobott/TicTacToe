import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JButton[][] field = new JButton[3][3];
    private GridLayout fieldLayout = new GridLayout(3, 3);
    private BorderLayout mainBorderLayout = new BorderLayout();
    private JLabel lblErrors;
    private JLabel lblPlayerX;
    private JLabel lblPlayerO;
    private JLabel lblCurrent;


    private Controller controller;


    MainPanel(Controller controller){
        this.controller = controller;
        this.setLayout(this.mainBorderLayout);

        // TOP
        JPanel topPanel= new JPanel();
        topPanel.setLayout(new GridLayout(3, 1));

        lblPlayerX = new JLabel("Player X: ");
        topPanel.add(lblPlayerX);

        lblPlayerO = new JLabel("Player O: ");
        topPanel.add(lblPlayerO);

        lblCurrent = new JLabel("Current player");
        topPanel.add(lblCurrent);

        this.add(topPanel, BorderLayout.NORTH);


        // Center field

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(this.fieldLayout);
        this.add(gridPanel, BorderLayout.CENTER);

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                BtnField btnField = new BtnField(controller, x, y);
                this.field[y][x] = btnField;
                gridPanel.add(btnField);
            }
        }

        //Bottom
        JPanel botPanel= new JPanel();
        botPanel.setLayout(new GridLayout(1, 3));

        lblErrors = new JLabel();
        botPanel.add(lblErrors);

        JButton btnNewGame = new JButton("Neues Spiel");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
            }
        });
        botPanel.add(btnNewGame);

        JButton btnHelp = new JButton("Hiiiilfeeee!!!");
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        botPanel.add(btnHelp);

        this.add(botPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void showWin(String spieler){
        this.lblErrors.setText("Player: " + spieler + " hat gewonnen");
    }

    public void setFieldText(int x, int y, String text){
        this.field[y][x].setText(text);
    }

    public void showError(String text) {
        this.lblErrors.setText(text);
    }

    public void clearError(){
        this.lblErrors.setText("");
    }

    public void setNames(String nameO, String nameX) {
        this.lblPlayerO.setText("Player O: " + nameO);
        this.lblPlayerX.setText("Player X: " + nameX);
    }

    public void clearField() {
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                this.field[y][x].setText("");
            }
        }
    }
}
