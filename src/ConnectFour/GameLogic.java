package ConnectFour;
public class GameLogic extends GamePanel{
    //First helper method that checks if someone won by stacking pieces
    public GameLogic(boolean isHardMode, boolean isHu){
        super(isHardMode, isHuman);
        
        checkHorizontalWin();
        checkVerticalWin();
        checkUpDiagonalWin();
        checkDownDiagonalWin();
    }
    
    public void checkVerticalWin(){
        //Gonna be 7 and 3 for i and j
        //int[6][7]
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 3; j++){
                if (board[j][i] == 1 && board[j+1][i] == 1 && board[j+2][i] == 1 && board[j+3][i] == 1||
                    board[j][i] == 2 && board[j+1][i] == 2 && board[j+2][i] == 2 && board[j+3][i] == 2){
                        System.out.println("You win!!!!!");
                        winCondition = true;
                        return;
                }
            }
        }
    }

    //Second helper method that checks if someone won by lining pieces together, horizontally
    public void checkHorizontalWin(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 6; j++){
                if (board[j][i] == 1 && board[j][i+1] == 1 && board[j][i+2] == 1 && board[j][i+3] == 1||
                    board[j][i] == 2 && board[j][i+1] == 2 && board[j][i+2] == 2 && board[j][i+3] == 2){
                        System.out.println("You win!!!!!");
                        winCondition = true;
                        return;
                }

            }
        }
    }
    //Third helper method, starts at top left then goes down right looking for pieces that won diagonally down
    public void checkDownDiagonalWin(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                if (board[j][i] == 1 && board[j+1][i+1] == 1 && board[j+2][i+2] == 1 && board[j+3][i+3] == 1||
                    board[j][i] == 2 && board[j+1][i+1] == 2 && board[j+2][i+2] == 2 && board[j+3][i+3] == 2){
                        System.out.println("WON");
                        winCondition = true;
                        return;
                }
            }
            
        }
    }

    //Last helper method, begins at bottome left that iterates to see if its possible that someone won diagonally up
    public void checkUpDiagonalWin(){
        for (int i = 0; i < 4; i++){
            for (int k = 5; k > 2; k--){
                if (board[k][i] == 1 && board[k-1][i+1] == 1 && board[k-2][i+2] == 1 && board[k-3][i+3] == 1||
                        board[k][i] == 2 && board[k-1][i+1] == 2 && board[k-2][i+2] == 2 && board[k-3][i+3] == 2){
                            winCondition = true;
                            return;
                    }
                }
        }
    }


}
