Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max=1,count=1;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                count++;
                max=Math.max(count,max);
            }
            else if(nums[i+1]==nums[i])continue;
            else count=1;
        }
        return max;
    }
}
APPROACH 2 :USING SET 
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int count =0;
        for(int i :nums){//filling set
            set.add(i);
        }
        for(int i=0;i<nums.length;i++){//itrating over the given array
            if (set.contains(nums[i]-1))continue;// if smaller no. exist then me itrate forward so that we can go upto the smallest value from which the sequnce start . it helps to reduce cases and the time complexity
            else{// now when we got the lowest value of the sub sequence
                int curr = nums[i];
                count=1;
                while(set.contains(curr+1)){//we add the value till we get upto the last element of the sequence while increasing the count along with it 
                    curr++;
                    count++;
                }
                max = Math.max(max,count);// updating the max value
            }
        }
        return max;
    }
}