import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {

    private Controller controller;

    Checkbox cbEnableKi;

    public StartPanel(Controller controller){
        this.controller = controller;

        this.setLayout(new GridLayout(4, 2));

        JLabel lblPlayerX = new JLabel("Player X");
        this.add(lblPlayerX);

        JTextField tfPlayerX = new JTextField();
        this.add(tfPlayerX);

        JLabel lblPlayerO = new JLabel("Player O");
        this.add(lblPlayerO);

        JTextField tfPlayerO = new JTextField();
        this.add(tfPlayerO);

        Button btnHelp = new Button("Help");
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        this.add(btnHelp);

        Button btnNext = new Button("Continue");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameX = tfPlayerX.getText().length() > 0 ? tfPlayerX.getText() : "Player X";
                String nameO = tfPlayerO.getText().length() > 0 ? tfPlayerO.getText() : "Player O";
                controller.nextStart(nameO, nameX, cbEnableKi.getState());
            }
        });
        this.add(btnNext);

        JLabel lblEnableKi = new JLabel("Enable KI");
        this.add(lblEnableKi);

        cbEnableKi = new Checkbox();
        this.add(cbEnableKi);
    }
}
