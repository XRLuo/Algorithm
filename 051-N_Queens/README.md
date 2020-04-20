# [51. N-Queens](https://leetcode.com/problems/n-queens/)

```
class Solution {
public:
    /**
    1. 路径：也就是已经做出的选择。
    2. 选择列表：也就是你当前可以做的选择。
    3. 结束条件：也就是到达决策树底层，无法再做选择的条件。
    **/
    vector<vector<string>> mat;
    
    vector<vector<string>> solveNQueens(int n) {
        
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return mat;
    }
    
    void backtrack(vector<string> &board , int row){
        if(row==board.size()){
            mat.push_back(board);
            return ;
        }
        int size=board[row].size();
        for(int i=0; i<size; i++){
            if(!isvalid(board, row, i)) continue;
            board[row][i]='Q';
            backtrack(board, row+1);
            board[row][i]='.';
        }
        return ;
    }
    
    bool isvalid(vector<string> &board, int row, int col){
        int n = board.size();
        //up
        for(int i=0; i<row; i++){
            if(board[i][col]=='Q') return false;
        }
        //up-left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q') return false;
        }
        //up-right
         for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j]=='Q') return false;
        }

        return true;
    }
};
```
