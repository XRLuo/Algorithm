# [154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)

## Solution

```
class Solution {
public:
    /**
    先判断落到哪个区域上，左侧区域l+1,右侧区域，要考虑如果刚好就落在最小点的情况，故直接r=m而非r=m-1即可
    考虑重复带来的影响:如下面两种情况，在判断区间的时候注意如果重复的话，缩小区间。
    如果
    [3,3,1,3] 

    [1,3,3] 
    
    if(nums[m]>nums[r]) 那么左边的区间如果重复就缩小 即 if(nums[r]==nums[m] ) {r--; continue;}
     if(nums[m]>=nums[r]) 那么右边的区间如果重复就缩小 即 if(nums[l]==nums[m] ) {l++; continue;}

    **/
    int findMin(vector<int>& nums) {
        int l = 0, r = nums.size()-1;
        
        while(l<r){
            int m = l + (r-l)/2;
            // if(nums[l]==nums[m] && l!=m) {l++; continue;}
            // if(nums[r]==nums[m] && r!=m) {r--; continue;}
            // if(nums[l]==nums[m] ) {l++; continue;}
            if(nums[r]==nums[m] ) {r--; continue;}
            if(nums[m]>=nums[r])
                l=m+1;
            else
                r=m;
        }
        return nums[l];
    }
};
```
