import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnField extends JButton {

    Controller controller;
    int x;
    int y;

    public BtnField(Controller controller, int x, int y){
        this.controller = controller;
        this.setFont(new Font(this.getFont().getName(), Font.PLAIN, 64));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clickField(x, y);
            }
        });
    }


}
