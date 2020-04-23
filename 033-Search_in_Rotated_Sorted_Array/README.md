# [33.Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

* [类似问题81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
* [类似问题153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Solution

```
class Solution {
public:
    // 四种情况
    /**
    1. mid落在哪个区间 2种 
    2. 每一种中，target是否可以在区间中搜到？比较端点值和target以及中间数和target
    **/
    int search(vector<int>& nums, int target) {
        int left = 0, right = nums.size()-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[right]){
                if(target<nums[mid] && target>=nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            else{
                if(target>nums[mid] && target <= nums[right]){
                    left = mid +1;
                }
                else{
                    right = mid - 1;
                }
            }
            
        }
        return -1;
    }
};
```

