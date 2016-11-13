import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// alpha beta algorithm with only slight pruning.. Todo in competitional play.. must  prune more.
public class MinimaxGame {
    
    // helpers...
    public static class GameMove { 
        public int x; 
        public int y; 
        public double score;
  public GameMove(int x, int y) { 
    this.x = x; 
    this.y = y; 
  } 
    } 
    
      public static String replaceCharAt(String s, int pos, char c) {
    return s.substring(0, pos) + c + s.substring(pos + 1);
  }
    
    // generate all the moves given board for the current player..
    static List<GameMove> NextMoves(String player, String[] board)
    {
        List<GameMove> listz = new ArrayList<GameMove>();
        
        for (int cuRow = 0; cuRow < board.length; cuRow++)
        {
            String cuColS = board[cuRow];
            
            for (int cuCol = 0; cuCol < 3; cuCol++)
            {
                if (cuColS.charAt(cuCol) == '_')// ascii 95 use constants...
                {
                    listz.add(new GameMove(cuRow,cuCol));
                }
            }
        }
        return listz;
    }
    
    // check if move is winning or losing 
    public static int IsWinner(String player, String[] board)
    {
        int row[] = new int[3];
        int column[] = new int[3];
        int diag[] = new int[2];
        
        
        for (int cuRow = 0; cuRow < board.length; cuRow++)
        {
            String cuColS = board[cuRow];
            
            for (int cuCol = 0; cuCol < 3; cuCol++)
            {
                if (cuColS.charAt(cuCol) == player.charAt(0))
                {
                    row[cuRow]++;
                    column[cuCol]++;
                    
                    
                    if ((cuCol == 2 && cuRow == 0) ||
                        (cuCol == 0 && cuRow == 1) ||
                        (cuCol == cuRow && cuCol == 1)
                       )
                    {
                        diag[1]++;
                    }
                    
                    if (cuCol == cuRow)
                    {
                        diag[0]++;
                    }
                    
                    if (row[cuRow]==3)return 1;
                    else if (column[cuCol]==3) return 1;
                    else if (diag[0] == 3 || diag[1] == 3) return 1;
                        
                        
                }
            }
        }
        return 0;
    }
    
  static GameMove alphabeta(String player, String [] board,boolean isalpha, int prevX, int prevY){
  
      // isalpha indicates the other guy
      if (IsWinner((isalpha ? (player.equals("X")? "O": "X") : player) , board) == 1)
      {
          GameMove newScore = new GameMove(prevX, prevY);
          newScore.score = isalpha? 0.0 : 1.0;
          return newScore;
      }
      
      
      // generate moves...
      List<GameMove> move = NextMoves(player, board);
      
      if (move.size() <= 0){// stalemate
          GameMove newScore = new GameMove(prevX, prevY);
          newScore.score = 0.1;
          return newScore;
      }
      
      double maxMove = isalpha? 0.0 : Integer.MAX_VALUE;
      GameMove chosedMove = null;
      for(GameMove moveOn : move)
      {
          int xCord = moveOn.x;
          int yCord = moveOn.y;
              
          board[xCord] = replaceCharAt(board[xCord], yCord, isalpha ? player.charAt(0) : (player.equals("X")? 
            'O': 'X'));
          
          GameMove newScore = alphabeta(player, board, !isalpha, xCord,yCord); 
          if (isalpha)
          {
              if (newScore.score >= maxMove)
              {
                  chosedMove = newScore;
                  chosedMove.x = xCord;
                  chosedMove.y = yCord;
              } maxMove = Math.max(newScore.score, maxMove + 0.0);
          }
          else
          {
             
              if (newScore.score <= maxMove)
              {
                  chosedMove = newScore;
                                    chosedMove.x = xCord;
                  chosedMove.y = yCord;
              }  maxMove = Math.min(newScore.score, maxMove + 0.0);
              
             
          }
          board[xCord] = replaceCharAt(board[xCord], yCord,'_');
          
          if (isalpha && maxMove >= 1.0)
          { return chosedMove;}
      }
      
 /*     if (chosedMove == null){// stalemate
          
          System.out.println("suckmove" + prevX + " " + prevY);
          GameMove newScore = new GameMove(prevX, prevY);
          newScore.score = 0;
          return newScore;
      }*/
      return chosedMove;
  }
    
/* Complete the function below to print 2 integers separated by a single space which will be your next move */
  static void nextMove(String player, String [] board)
      {
  
      // return the next best move... -1 -1 if non possible or winn right away
      // assume I start..
      GameMove newScore = alphabeta(player, board, true, -1,-1);
      
      System.out.println(newScore.x + " " + newScore.y);
  }
  
  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player;
        String board[] = new String[3];

        //If player is X, I'm the first player.
        //If player is O, I'm the second playe r.
        player = in.next();

        //Read the board now. The board is a 3x3 array filled with X, O or _.
        for(int i = 0; i < 3; i++) {
            board[i] = in.next();
        }

        nextMove(player,board);   
    
    }
}
