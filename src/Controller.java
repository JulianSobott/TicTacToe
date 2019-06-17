/**
 * TODO: checkWin()
 * TODO: btn Hilfe
 *
 * TODO: debug no names in StartPanel
 * TODO: beautify Start panel (fix size)
 * TODO: Adjust sizes in main panel
 *
 */

public class Controller {

    enum Result{
        WIN, DRAW, NONE

    }

    GUI gui;

    String[][] field = new String[3][3];

    private String currentPlayer = "O";
    private String nextPlayer = "X";

    public Controller(GUI gui){
        this.gui = gui;
    }


    public void clickField(int x, int y){
        this.gui.clearError();
        if(this.field[y][x] != null){
            this.gui.showError("Schon besetzt");
        }else{
            this.gui.setFieldText(x, y, this.currentPlayer);
            this.field[y][x] = this.currentPlayer;
            this.nextTurn();
        }
    }

    public void nextTurn(){
        Result res = this.checkWin();
        if(res == Result.NONE){
            String temp = this.nextPlayer;
            this.nextPlayer = this.currentPlayer;
            this.currentPlayer = temp;
        }else if(res == Result.WIN){
            this.gui.showWin(this.currentPlayer);
            this.newGame();
        }else if(res == Result.DRAW){
            this.gui.showError("Unentschieden ihr Opfer");
            this.newGame();
        }
    }

    private Result checkWin(){
        // TODO
        if(this.field[0][0] != null && this.field[0][0].equals("O")){
            return Result.WIN;
        }else if(false){
            return Result.DRAW;
        }else{
            return Result.NONE;
        }
    }

    public void nextStart(String nameO, String nameX){
        this.gui.showMainPanel(nameO, nameX);
    }

    public void newGame(){
        this.gui.clearField();
        this.field = new String[3][3];
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

}
