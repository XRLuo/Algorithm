# [81. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

## Solution

```
class Solution {
public:
    /**
    和33那道题差不多，先判断在那个区间，然后判断mid的值与端点target比较，从而知道下一个区间的left或right在哪
    值得注意的是数组是非递减顺序的，存在311 1131这种情况，因此需要进行改变，方法就是left，right如果和mid相等，那么就进一步缩小区间
    **/
    bool search(vector<int>& nums, int target) {

        int l= 0, r = nums.size()-1;
        
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[l]==nums[mid]) {++l; continue;}
            if(nums[r]==nums[mid]) {--r; continue;}
            if(nums[mid]>=nums[r] ){
                if(nums[mid]>target && nums[l]<=target)
                    r=mid-1;
                else
                    l=mid+1;
            }
            else{
                if(nums[mid]<target && nums[r]>=target)
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return false;
    }
};
```

