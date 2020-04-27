# 153.Find Minimum in Rotated Sorted Array

# Solution
```
class Solution {
public:
    /**
    由于不重复，先判断落到哪个区域上，左侧区域l+1,右侧区域，要考虑如果刚好就落在最小点的情况，直接r=m即可
    **/
    int findMin(vector<int>& nums) {
        int l = 0, r = nums.size()-1;
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m]>nums[r])
                l=m+1;
            else
                r=m;
        }
        return nums[l];
    }
};
```
