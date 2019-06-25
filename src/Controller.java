import java.util.Random;

/**
 * TODO: btn Hilfe
 * <p>
 * TODO: beautify Start panel (fix size)
 * TODO: Adjust sizes in main panel
 */

public class Controller {

    enum Result {
        WIN, DRAW, NONE

    }

    GUI gui;

    String[][] field = new String[3][3];

    private String currentPlayer = "O";
    private String nextPlayer = "X";
    private boolean ki_game = true;
    private int numFilled = 0;

    public Controller(GUI gui) {
        this.gui = gui;
    }


    public void clickField(int x, int y) {
        this.gui.clearError();
        if (this.field[y][x] != null) {
            this.gui.showError("Schon besetzt");
        } else {
            this.gui.setFieldText(x, y, this.currentPlayer);
            this.field[y][x] = this.currentPlayer;
            this.numFilled++;
            this.nextTurn();
        }
    }

    public void nextTurn() {
        Result res = this.checkWin();
        if (res == Result.NONE) {
            String temp = this.nextPlayer;
            this.nextPlayer = this.currentPlayer;
            this.currentPlayer = temp;
            if (this.ki_game && this.currentPlayer.equals("X") && this.numFilled < 9) {
                this.ki_turn();
            }
        } else if (res == Result.WIN) {
            this.gui.showWin(this.currentPlayer);
            this.newGame();
        } else if (res == Result.DRAW) {
            this.gui.showError("Unentschieden ihr Opfer");
            this.newGame();
        }
    }

    private Result checkWin() {
        if (this.numFilled == 9) {
            return Result.DRAW;
        }

        // All possible fields to win
        int[][][] checkFields = {
                // Horizontal
                {{0, 0}, {0, 1}, {0, 2}},
                {{1, 0}, {1, 1}, {1, 2}},
                {{2, 0}, {2, 1}, {2, 2}},

                // Vertical
                {{0, 0}, {1, 0}, {2, 0}},
                {{0, 1}, {1, 1}, {2, 1}},
                {{0, 2}, {1, 2}, {2, 2}},

                // Across
                {{0, 0}, {1, 1}, {2, 2}},
                {{0, 2}, {1, 1}, {2, 0}},
        };

        // Check every option to win, by adding the content of the fields to one line.
        for (int[][] indices : checkFields) {
            String line =
                    this.field[indices[0][0]][indices[0][1]] +
                    this.field[indices[1][0]][indices[1][1]] +
                    this.field[indices[2][0]][indices[2][1]];

            if (line.equals("OOO") || line.equals("XXX")) {
                return Result.WIN;
            }
        }
        return Result.NONE;
    }

    public void nextStart(String nameO, String nameX, boolean enableKi) {
        this.ki_game = enableKi;
        this.gui.showMainPanel(nameO, nameX);
    }

    public void newGame() {
        this.gui.clearField();
        this.field = new String[3][3];
        this.numFilled = 0;
    }

    private void ki_turn() {
        while (true) {
            int x = this.rand_field();
            int y = this.rand_field();
            if (this.field[y][x] == null) {
                this.clickField(x, y);
                break;
            }
        }
    }

    private int rand_field() {
        Random rand = new Random();
        return rand.nextInt((2) + 1);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

}
