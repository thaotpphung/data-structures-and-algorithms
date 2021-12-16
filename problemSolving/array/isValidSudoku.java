package array;

public class isValidSudoku {
  /**
  #1: check rows, cols, 3x3 grid
    use HashSet or Array  for checking duplicates

  #2: more compact syntax, code

  #3: hashset of string

   */
  

  public boolean isValidSudoku(char[][] board) {
        
    // check rows
    for (int i = 0; i < 9; i++) {
        Set set = new HashSet();
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') {
                if (!set.add(board[i][j])) {  
                    return false;
                }
            }
        }
    }
    
    // check columns
    for (int j = 0; j < 9; j++) {
        Set set = new HashSet();
        for (int i = 0; i < 9; i++) {
            if (board[i][j] != '.') {
                if (!set.add(board[i][j])) { 
                    return false;
                }
            }
        }
    }
    
    // check 3x3 grid
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (!checkValid(i * 3, j * 3, board)) {
                return false;
            }
        }
    }
    
    return true;
    
}

private boolean checkValid (int rowStart, int colStart, char[][] board) {
    Set set = new HashSet();
    for (int i = rowStart; i <= rowStart + 2; i++) {
        for (int j = colStart; j <= colStart + 2; j++) {
            if (board[i][j] != '.') {
                if (!set.add(board[i][j])) {
                    return false;
                }
            }
        }
    }
    return true;
}

   // #2
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            if (
                // check rows 
                !checkValid(i, i, 0, 8, board) 
                ||
                // check columns
                !checkValid(0, 8, i, i, board)
                ||
                // check 3x3 grid
                // 9 grids, each time check a 3x3 grid by computing start and end coordinates
                /* for each i = 0..9
                i = 0,1,2 -> 3 grids on first row
                i = 3,4,5 -> 3 grids on second row
                ...
                */
                !checkValid(i / 3 * 3, i / 3 * 3 + 2, i % 3 * 3, i % 3 * 3 + 2, board)
            )
                return false;
           
        }
        
        return true;
        
    }
    
    private boolean checkValid (int rowStart, int rowEnd, int colStart, int colEnd, char[][] board) {
        Set set = new HashSet();
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    
public boolean isValidSudoku(char[][] board) {
         
  Set seen = new HashSet();
  
  for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
          char number = board[i][j];
          if (number != '.') {
              if (
                  !seen.add(number + " at row " + i)
                  ||
                  !seen.add(number + " at column " + j)
                  ||
                  !seen.add(number + " at grid " + i/3 + "-" + j/3)
              )
                  return false;
          }
              
      }
  }
  
  return true;
  
}

//#3

public boolean isValidSudoku(char[][] board) {
         
  Set seen = new HashSet();
  
  for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
          char number = board[i][j];
          if (number != '.') {
              if (
                  !seen.add(number + " at row " + i)
                  ||
                  !seen.add(number + " at column " + j)
                  ||
                  !seen.add(number + " at grid " + i/3 + "-" + j/3)
              )
                  return false;
          }
              
      }
  }
  
  return true;
  
}


}
