class Solution {
    class TrieNode {
        TrieNode left;
        TrieNode right;
        public TrieNode() {
            left = null;
            right = null;
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int answer = 0;
        
        for (int num: nums) {
            insert(root, num);
        }
        
        for (int num: nums) {
            answer = Math.max(answer, getMaxXor(root, num));
        }
        
        return answer;
    }
    
    public void insert(TrieNode root, int num) {
        TrieNode curr = root;
        //Iterate through all possible bits
        for (int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1; //Flip the bit
            //If 0 then traverse left
            //Otherwise traverse right
            if (bit == 0) {
                if (curr.left == null) {
                    curr.left = new TrieNode();
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TrieNode(); 
                }
                curr = curr.right;
            }
        }
    }
    
    public int getMaxXor(TrieNode root, int num) {
        TrieNode curr = root;
        int maxXor = 0;
        
        for(int i = 31; i >= 0; i--) {
            int bit = (num>>i) & 1;
            if(bit == 0) {
                if(curr.right != null) {
                    curr =  curr.right;
                    maxXor += (1<<i);
                } else {
                    curr = curr.left;
                }
            } else {
                if(curr.left != null) {
                    curr = curr.left;
                    maxXor += (1<<i);   //pow(2,i)
                } else {
                    curr = curr.right;
                }
            }
        }
        
        return maxXor;
    }
}