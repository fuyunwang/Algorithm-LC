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
    static class Code404{
        // 左叶子之和，判断一个节点是不是左叶子必须保证左儿子存在且没有叶子结点
        public int sumOfLeftLeaves(TreeNode root) {
            if (root==null){
                return 0;
            }
            int res=0;
            if (root.left!=null){
                if (root.left.left==null&&root.left.right==null){
                    res+=root.left.val;
                }
            }
            res+=sumOfLeftLeaves(root.left);
            res+=sumOfLeftLeaves(root.right);
            return res;
        }
    }
    static class Code1022 {// 类似129 404  |||| 带有求总和要求的，返回值具备两种性质。计算路径之和仍然保持前序遍历
        public int sumRootToLeaf(TreeNode root) {
            return dfs(root, 0);
        }
        int dfs(TreeNode root, int x) {
            if (root == null) {
                return 0;
            }
            x = x * 2 + root.val;
            if (root.left == null && root.right == null) {
                return x;
            }
            int res = 0;
            res += dfs(root.left, x);
            res += dfs(root.right, x);
            return res;
        }
    }
    static class Code543{
        int res=0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root){
            if (root==null)
                return 0;
            int l=dfs(root.left);
            int r=dfs(root.right);
            res=Math.max(res,l+r);
            return Math.max(l,r)+1;
        }
    }

    static class CodePath{
        /***
         * 最大路径和、最多次数和 都是确定一个值，所以不需要双重递归
         * 路径总和III确定多个值需要双重递归
         */
        // 与129、1022不同在于可以从任意节点开始到任意节点结束且不一定自上到下计算
        // 一般采用后序遍历
        static class Code124{
            int res=Integer.MIN_VALUE;
            public int maxPathSum(TreeNode root) {
                dfs(root);
                return res;
            }
            int dfs(TreeNode root){
                if (root==null){
                    return 0;
                }
                int l=Math.max(dfs(root.left),0);
                int r=Math.max(dfs(root.right),0);
                // 这里更新值可以保证在枚举每一个点时都能更新结果，避免了多次递归。类似的题目Code508
                res=Math.max(res,l+r+root.val);  // 注意必须包含当前节点
                return Math.max(l,r)+root.val;  // +1 实现了路径更长，+root.val 实现了路径更大
            }
        }
        static class Code508{
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            int maxCount = 0;
            public int[] findFrequentTreeSum(TreeNode root) {
                dfs(root);
                return list.stream().mapToInt(Integer::intValue).toArray();
            }
            int dfs(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                int sum = root.val + dfs(root.left) + dfs(root.right);//得到子树和
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                if (map.get(sum) > maxCount) {
                    list = new ArrayList<>();     // trick
                    list.add(sum);
                    maxCount = map.get(sum);
                } else if (maxCount == map.get(sum)) {
                    list.add(sum);
                }
                return sum;
            }
        }
        static class Code437{
            // 这里更新值可以保证在枚举每一个点时都能更新结果，采用多次递归
            public int pathSum(TreeNode root, int targetSum) {
                if (root==null){
                    return 0;
                }
                int res=dfs(root,targetSum);
                res+=pathSum(root.left,targetSum);
                res+=pathSum(root.right,targetSum);
                return res;
            }
            int dfs(TreeNode root,int targetSum){   // 返回以root为根时所有的可能结果
                if (root==null){
                    return 0;
                }
                int res=0;
                targetSum-=root.val;
                if (targetSum==0){
                    res++;
                }
                res+=dfs(root.left,targetSum);
                res+=dfs(root.right,targetSum);
                return res;
            }
        }
    }

    static class CodeCal{
        // 普通计数
        static class Code222{
            // 统计节点个数
            public int countNodes(TreeNode root) {
                return dfs(root);
            }
            int dfs(TreeNode root){
                if (root==null)
                    return 0;
                int l=1;
                int r=1;
                TreeNode left=root.left;
                TreeNode right=root.right;
                while (left!=null){
                    l++;
                    left=left.left;
                }
                while (right!=null){
                    r++;
                    right=right.right;
                }
                if (l==r){
                    return (1<<l)-1;
                }
                return dfs(root.left)+1+dfs(root.right);
            }
        }
    }


    static class Code37 {
        boolean[][] row;
        boolean[][] col;
        boolean[][][] cell;

        public void solveSudoku(char[][] board) {
            row = new boolean[9][9]; // 标记行中哪一个值被填了，当前行不能再填
            col = new boolean[9][9]; // 标记列中哪一个值被填了，当前列不能再填
            cell = new boolean[3][3][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int t = board[i][j] - '1';
                        row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                    }
                }
            }
            dfs(board, 0, 0);
        }

        // 填数，遍历通过递归和终止条件共同接管
        boolean dfs(char[][] board, int x, int y) {
            if (y == 9) {
                x++;
                y = 0;
                if (x == 9) // 正确填完
                    return true;
            }
            // 如果当前已经有数直接进行下一轮
            if (board[x][y] != '.')
                return dfs(board, x, y + 1);
            // 正式填数
            for (int i = 0; i < 9; i++) {
                if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                    char t = (char) (i + '1');
                    board[x][y] = t;
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                    if (dfs(board, x, y + 1))
                        return true;
                    board[x][y] = '.';
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                }
            }
            return false;
        }
    }
    static class Code79 {
        boolean[][] visited;
        char[][] g;
        int m, n;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        String word;

        public boolean exist(char[][] board, String word) {
            g = board;
            this.word = word;
            m = g.length;
            n = g[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (backtrack(i, j, 0)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean backtrack(int x, int y, int index) {
            if (word.charAt(index) != g[x][y]) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int a = dx[i] + x;
                int b = dy[i] + y;
                if (a >= m || a < 0 || b >= n || b < 0 || visited[a][b]) {
                    continue;
                }
                if (backtrack(a, b, index + 1)) {
                    return true;
                }
            }
            visited[x][y] = false;
            return false;
        }
    }

    static class Code938 {   // 二叉树的范围和，累加求和的典型
        public int rangeSumBST(TreeNode root, int low, int high) {
            return dfs(root, low, high);
        }

        int dfs(TreeNode root, int l, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val < l || root.val > high) {
                return dfs(root.left, l, high) + dfs(root.right, l, high);
            }
            int res = 0;
            res += root.val;
            res += dfs(root.left, l, high);
            res += dfs(root.right, l, high);
            return res;
        }
    }

    static class Code1026 {
        public int maxAncestorDiff(TreeNode root) {
            return dfs(root, root.val, root.val);
        }

        int dfs(TreeNode root, int maxVal, int minVal) {
            if (root == null)
                return 0;
            int val = root.val;
            int res = Math.max(Math.abs(val - maxVal), Math.abs(val - minVal));    // 在遍历到每一个点时更新结果
            minVal = Math.min(minVal, val);    // 在遍历到每一个点时更新最值
            maxVal = Math.max(maxVal, val);
            res = Math.max(res, dfs(root.left, maxVal, minVal));
            res = Math.max(res, dfs(root.right, maxVal, minVal));
            return res;
        }
    }

    static class Code437{
        // 路径总和
        public int pathSum(TreeNode root, int targetSum) {
            if (root==null){
                return 0;
            }
            int res=0;
            res+=dfs(root,targetSum);
            res+=pathSum(root.left,targetSum);
            res+=pathSum(root.right,targetSum);
            return res;
        }
        int dfs(TreeNode root,int targetSum){
            if (root==null)
                return 0;
            int res=0;
            if (root.val==targetSum)
                res++;
            res+=dfs(root.left,targetSum-root.val);
            res+=dfs(root.right,targetSum-root.val);
            return res;
        }
    }




    static class Code687_1 {// 类似Code437
        int res = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return res;
        }
        int dfs(TreeNode root) {
            if (root == null)
                return 0;
            int l = dfs(root.left), r = dfs(root.right);
            if (root.left == null || root.left.val != root.val) {
                l = 0;
            }
            if (root.right == null || root.right.val != root.val) {
                r = 0;
            }
            res = Math.max(res, r + l);
            return Math.max(l, r) + 1;
        }
    }
    static class Code687 {
        // 类似863
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        int ans = 0;
        int curMax = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null)
                return 0;
            construction(root);
            dfs1(root);
            return curMax - 1;
        }

        void dfs1(TreeNode root) {
            if (root == null)
                return;
            ans = Math.max(ans, dfs(root, null, root.val));
            dfs1(root.left);
            dfs1(root.right);
        }

        void construction(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                graph.computeIfAbsent(root, l -> new ArrayList<>()).add(root.left);
                graph.computeIfAbsent(root.left, l -> new ArrayList<>()).add(root);
                construction(root.left);
            }
            if (root.right != null) {
                graph.computeIfAbsent(root, l -> new ArrayList<>()).add(root.right);
                graph.computeIfAbsent(root.right, l -> new ArrayList<>()).add(root);
                construction(root.right);
            }
        }

        int dfs(TreeNode root, TreeNode father, int val) {
            int res = 0;
            if (root == null || root.val != val) {
                return res;
            }

            res = res + 1;

            int temp = 0;
            int tempMax = 0;
            for (TreeNode node : graph.getOrDefault(root, new ArrayList<>())) {
                if (node != father) {
                    temp = dfs(node, root, val);
                }
                tempMax = Math.max(tempMax, temp);
            }
            curMax = Math.max(curMax, tempMax + res);
            return tempMax + res;
        }
    }
    static class Code863 {       // 从树中找到到目标节点指定距离的周围节点，构图
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (root == null) {
                return Collections.emptyList();
            }
            construction(root);
            dfs(target, null, k);
            return res;
        }

        void construction(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                graph.computeIfAbsent(root, l -> new ArrayList<>()).add(root.left);
                graph.computeIfAbsent(root.left, l -> new ArrayList<>()).add(root);
                construction(root.left);
            }
            if (root.right != null) {
                graph.computeIfAbsent(root, l -> new ArrayList<>()).add(root.right);
                graph.computeIfAbsent(root.right, l -> new ArrayList<>()).add(root);
                construction(root.right);
            }
        }

        void dfs(TreeNode root, TreeNode father, int k) {
            if (k == 0) {
                res.add(root.val);
                return;
            }
            for (TreeNode node : graph.getOrDefault(root, new ArrayList<>())) {
                if (node != father) {
                    dfs(node, root, k - 1);
                }
            }
        }
    }
}
