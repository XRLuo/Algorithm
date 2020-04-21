# [34. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## Note

1.  判断越界用哪个变量和找左右边界两种情况有关
2.  找左边界，left是>=0的，如果有一个比所有元素都大的值，最后left会越界=size。用right的话，right<=size，但是如果有一个比所有元素都小的值，right会<0，表示越界。两者情况都不能漏，但是可以根据情况巧妙组合。比如：找左边界，那么left>=0,只考虑left越界情况和nums[left]就行；找右边界，right<=nums.size()，只考虑right>0和nums[right]即可

## Exp

1. 分析二分查找代码时，不要出现 else，全部展开成 else if 方便理解。
2. 注意「搜索区间」和 while 的终止条件，如果存在漏掉的元素，记得在最后检查。
3. 如需定义左闭右开的「搜索区间」搜索左右边界，只要在 nums[mid] == target 时做修改即可，搜索右侧时需要减一。
4. 如果将「搜索区间」全都统一成两端都闭，好记，只要稍改 nums[mid] == target 条件处的代码和返回的逻辑即可，推荐拿小本本记下，作为二分搜索模板。


## Solution 1

```
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(!nums.size()){
            vector<int> pt(2,-1);
            return pt;
        }
		vector<int> pt;

        int left = 0, right = nums.size()-1;
        // find first pos
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                right = mid - 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
        }
         if( left>=nums.size()||nums[left]!=target){
            pt.push_back(-1);
            pt.push_back(-1);
            return pt;
        }
        pt.push_back(left);
        left = 0, right = nums.size()-1;
        //find last pos
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                left = mid + 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        pt.push_back(right);
        return pt;
    }
};
```

## Solution 2

```
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(!nums.size()){
            vector<int> pt(2,-1);
            return pt;
        }
        vector<int> pt;
        int left = 0, right = nums.size()-1;
        //find last pos
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                left = mid + 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        if( right<0||nums[right]!=target){
            pt.push_back(-1);
            pt.push_back(-1);
            return pt;
        }
        pt.push_back(right);
        left = 0, right = nums.size()-1;
        // find first pos
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                right = mid - 1;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
        }
        pt.push_back(left);
        vector<int> npt = {pt[1],pt[0]};
        return npt;
    }
};
```
