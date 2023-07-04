public class Sudoku{
    public static boolean isSafe(char[][] board, int row, int col, int number){
        for(int i=0;i<board.length;i++){
            // checking for number in current column
            if(board[i][col]==(char)(number+'0')){
                return false;
            }
            // checking for number in current row
            if(board[row][i]==(char)(number+'0')){
                return false;
            }
        }

        // finding starting cell of inner 3x3 grid
        // ex for row=5,col=2, sr=3,sc=0
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        // check if number exists in the 3x3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(number+'0')){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean helper(char[][] board, int row, int col){
        if(row==board.length){
            return true;
        }

        int nrow=0;
        int ncol=0;
        if(col!=board[0].length-1){
            nrow=row;
            ncol=col+1;
        }else{
            nrow=row+1;
            ncol=0;
        }

        if(board[row][col]!='.'){
            if(helper(board, nrow, ncol)){
                return true;
            }
        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=(char)(i+'0');
                    if(helper(board, nrow, ncol)){
                        return true;
                    }else{
                        board[row][col]='.';
                    }
                }
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board){
        helper(board, 0, 0);
    }
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Unsolved sudoku: ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(" "+board[i][j]+" ");
                if((j+1)%3==0) System.out.print("|");
            }
            if((i+1)%3==0){
                System.out.println();
                for(int j=0;j<board.length;j++){
                System.out.print(" = ");
                if((j+1)%3==0) System.out.print(" ");
            }
            }
            System.out.println();
        }

        solveSudoku(board);

        System.out.println("Solved sudoku: ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(" "+board[i][j]+" ");
                if((j+1)%3==0) System.out.print("|");
            }
            if((i+1)%3==0){
                System.out.println();
                for(int j=0;j<board.length;j++){
                System.out.print(" = ");
                if((j+1)%3==0) System.out.print(" ");
            }
            }
            System.out.println();
        }
    }
}