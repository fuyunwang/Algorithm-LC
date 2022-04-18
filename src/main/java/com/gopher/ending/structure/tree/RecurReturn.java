package com.gopher.ending.structure.tree;

import com.gopher.leetcode.types.structure.tree.TreeNode;

import java.util.*;

/**
 * @Title RecurReturn
 * @Author fyw
 * @Date 2022/4/17 1:46
 * @Description: 带有返回值的
 */
public class RecurReturn {
    static class Code1022{
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root,0);
        }
        int dfs(TreeNode root,int x){
            if(root==null){
                return 0;
            }
            x=x*2+root.val;
            if(root.left==null&&root.right==null){
                return x;
            }
            int res=0;
            res+=dfs(root.left,x);
            res+=dfs(root.right,x);
            return res;
        }
    }

    static class Code37{
        boolean[][] row;
        boolean[][] col;
        boolean[][][] cell;
        public void solveSudoku(char[][] board) {
            row=new boolean[9][9]; // 标记行中哪一个值被填了，当前行不能再填
            col=new boolean[9][9]; // 标记列中哪一个值被填了，当前列不能再填
            cell=new boolean[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j]!='.'){
                        int t=board[i][j]-'1';
                        row[i][t]=col[j][t]=cell[i/3][j/3][t]=true;
                    }
                }
            }
            dfs(board,0,0);
        }
        // 填数，遍历通过递归和终止条件共同接管
        boolean dfs(char[][] board,int x,int y){
            if (y==9){
                x++;
                y=0;
                if (x==9) // 正确填完
                    return true;
            }
            // 如果当前已经有数直接进行下一轮
            if (board[x][y]!='.')
                return dfs(board,x,y+1);
            // 正式填数
            for (int i = 0; i < 9; i++) {
                if (!row[x][i]&&!col[y][i]&&!cell[x/3][y/3][i]){
                    char t= (char) (i+'1');
                    board[x][y]=t;
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=true;
                    if (dfs(board,x,y+1))
                        return true;
                    board[x][y]='.';
                    row[x][i]=col[y][i]=cell[x/3][y/3][i]=false;
                }
            }
            return false;
        }
    }

    static class Code79{
        boolean[][] visited;
        char[][] g;
        int m,n;
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        String word;
        public boolean exist(char[][] board, String word) {
            g=board;
            this.word=word;
            m=g.length;
            n=g[0].length;
            visited=new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0)){
                        if(backtrack(i,j,0)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        boolean backtrack(int x,int y,int index){
            if(word.charAt(index)!=g[x][y]){
                return false;
            }
            if(index==word.length()-1){
                return true;
            }
            visited[x][y]=true;
            for(int i=0;i<4;i++){
                int a=dx[i]+x;
                int b=dy[i]+y;
                if(a>=m||a<0||b>=n||b<0||visited[a][b]){
                    continue;
                }
                if(backtrack(a,b,index+1)){
                    return true;
                }
            }
            visited[x][y]=false;
            return false;
        }
    }

    static class Code543{
        int res=0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){ // 返回以当前节点的向下走最长的路径
            if (root==null){
                return 0;
            }
            int left=dfs(root.left);
            int right=dfs(root.right);
            res=Math.max(res,left+right);
            return Math.max(left,right)+1;
        }
    }

    static class Code938{
        public int rangeSumBST(TreeNode root, int low, int high) {
            return dfs(root,low,high);
        }
        int dfs(TreeNode root,int l,int high){
            if(root==null){
                return 0;
            }
            if(root.val<l||root.val>high){
                return dfs(root.left,l,high)+dfs(root.right,l,high);
            }
            int res=0;
            res+=root.val;
            res+=dfs(root.left,l,high);
            res+=dfs(root.right,l,high);
            return res;
        }
    }

    static class Code1026{
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root,root.val,root.val);
        }
        int dfs(TreeNode root,int maxVal,int minVal){
            if (root==null)
                return 0;
            int val=root.val;
            int res=Math.max(Math.abs(val-maxVal),Math.abs(val-minVal));    // 在遍历到每一个点时更新结果
            minVal=Math.min(minVal,val);    // 在遍历到每一个点时更新最值
            maxVal=Math.max(maxVal,val);
            res=Math.max(res,dfs(root.left,maxVal,minVal));
            res=Math.max(res,dfs(root.right,maxVal,minVal));
            return res;
        }
    }


    static class Code687{
        // 类似863
        Map<TreeNode, List<TreeNode>> graph=new HashMap<>();
        int ans=0;
        int curMax=0;
        public int longestUnivaluePath(TreeNode root) {
            if (root==null)
                return 0;
            construction(root);
            dfs1(root);
            return curMax-1;
        }

        void dfs1(TreeNode root){
            if (root==null)
                return;
            ans=Math.max(ans,dfs(root,null,root.val));
            dfs1(root.left);
            dfs1(root.right);
        }

        void construction(TreeNode root){
            if (root==null){
                return;
            }
            if (root.left!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.left);
                graph.computeIfAbsent(root.left,l->new ArrayList<>()).add(root);
                construction(root.left);
            }
            if (root.right!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.right);
                graph.computeIfAbsent(root.right,l->new ArrayList<>()).add(root);
                construction(root.right);
            }
        }

        int dfs(TreeNode root,TreeNode father,int val){
            int res=0;
            if (root==null||root.val!=val){
                return res;
            }

            res=res+1;

            int temp=0;
            int tempMax=0;
            for (TreeNode node:graph.getOrDefault(root,new ArrayList<>())){
                if (node!=father){
                    temp=dfs(node,root,val);
                }
                tempMax=Math.max(tempMax,temp);
            }
            curMax=Math.max(curMax,tempMax+res);
            return tempMax+res;
        }
    }

    static class Code863{
        Map<TreeNode,List<TreeNode>> graph=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
            if (root==null){
                return Collections.emptyList();
            }
            construction(root);
            dfs(target,null,k);
            return res;
        }
        void construction(TreeNode root){
            if (root==null){
                return;
            }
            if (root.left!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.left);
                graph.computeIfAbsent(root.left,l->new ArrayList<>()).add(root);
                construction(root.left);
            }
            if (root.right!=null){
                graph.computeIfAbsent(root,l->new ArrayList<>()).add(root.right);
                graph.computeIfAbsent(root.right,l->new ArrayList<>()).add(root);
                construction(root.right);
            }
        }
        void dfs(TreeNode root,TreeNode father,int k){
            if (k==0){
                res.add(root.val);
                return;
            }
            for (TreeNode node:graph.getOrDefault(root,new ArrayList<>())){
                if (node!=father){
                    dfs(node,root,k-1);
                }
            }
        }
    }


}
