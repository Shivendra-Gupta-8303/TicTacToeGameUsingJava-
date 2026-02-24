import java.util.Scanner;
import java.util.concurrent.TransferQueue;

class tictactoe{
  static char board [][] ;
   public tictactoe(){
       board = new char[3][3] ;
       printspace();
   }

   void printspace(){
       for (int i= 0; i<board.length ; i++){
           for (int j= 0; j<board.length ; j++){
               board [i][j]= ' ' ;
           }
       }
   }

   static void Displayboard(){
       System.out.println("_________________");
       for (int i= 0; i<board.length ; i++){
           System.out.print(" | ");
           for (int j= 0; j<board.length ; j++){
               System.out.print(board[i][j]+ " | ");
           }System.out.println();
           System.out.println("_________________");
       }
   }


    static void placemark(int row,int col, char mark){
       if (row>=0 && row<=2 && col>=0 && col<=2){
           board[row][col]= mark ;
       }
   }

   static boolean colwin(){
       for (int j=0 ; j<=2 ; j++){
       if (board[0][j] != ' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
           return true;
       }
   }
       return false;
}
   static boolean rowwin(){
        for (int i=0 ; i<=2 ; i++){
            if (board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
                return true;
            }
        }
        return false;
    }
   static boolean digonalwin() {
       if (board[0][0] != ' ' && board[0][0]==board[1][1] &&  board[1][1]==board[2][2] ||
               board[0][2] != ' ' && board[0][2]==board[1][1] &&  board[1][1]==board[2][0]){
           return true;
       }
       return false ;
    }
}
class Humanplayer{
    String name;
    char Mark ;

    Humanplayer(String name , char mark){

        this.name = name ;
        this.Mark=mark;
    }
    void makemove(){
        Scanner s = new Scanner(System.in);

        int row ; int col ;

        do {
            System.out.println("Enter the row and column ");
            row = s.nextInt();
            col=s.nextInt();

        }while (!isvaidmove(row,col));

        tictactoe.placemark(row,col,Mark);

    }

     boolean  isvaidmove(int row , int col){
        if (row>=0 && row<=2 && col>=0 && col<=2){
            if (tictactoe.board[row][col]== ' '){
                return true;
            }
        }
        return false ;

     }
}

public class Main {
    public static void main(String[] args) {
        tictactoe t =new tictactoe();

        Humanplayer p1 = new Humanplayer("ROHAN",'x');
        Humanplayer p2 = new Humanplayer("Shivendra",'o');

        Humanplayer cp ;

        cp = p1 ;

        while (true){
            System.out.println(cp.name + " turn ");

            cp.makemove();
            tictactoe.Displayboard();

            if (tictactoe.rowwin() || tictactoe.colwin() || tictactoe.digonalwin()){
                System.out.println(cp.name + " has won");
                break;
            }
            else {
                if (cp==p1){
                    cp = p2;
                }else {
                    cp = p1 ;
                }
            }

        }

    }
}