package ConnectFour;
public class AIMove extends GamePanel {

    public AIMove(boolean isHardMode, boolean isHuman) {
        super(isHardMode,isHuman);
    }
    public int getAI(boolean isHardMode){
        //Easy mode AI done in java
        if (!isHardMode){
            int rand = (int) (Math.random() * 7);
            //if full then do back throuhg getAI()
            while (board[0][rand] == 1 || board[0][rand] == 2){
                rand = (int) (Math.random() * 7);
                if (board[0][rand] == 1 || board[0][rand] == 2){
                    continue;
                }
                return rand;
            }

            return rand;

            
        }
        else{
            //filer for hard for now
            return 2;
        }
    }

}
