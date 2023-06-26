class Solution {
        public static int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int uniqueElements = 1;
        int [] uniqueNums = new int[nums.length];
        for (int i = 1; i<nums.length; i++){
            int previousNum = nums[i-1];
            int currentNum = nums[i];
            if (previousNum!=currentNum){
                nums[uniqueElements] = currentNum;
                uniqueElements++;
            }
        }
        return uniqueElements;
    }
}