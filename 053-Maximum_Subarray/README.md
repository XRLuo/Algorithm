# 53. Maximum Subarray

## DP思路

1. 状态：总和
2. dp function: dp[i]=a 表示以i为终点时的最大和
3. select： dp[i] = max(dp[i-1]+nums[i], nums[i])
4. base case: dp[0]=nums[0]
5. optimizaton：这里没有



## Code
```
class Solution {
public:/**

状态：总和，
dp fun:dp[i]=a 表示以i为终点时的最大sum。
select:dp[i]=max(dp[i-1]+nums[i], nums[i]) , 0
base case: dp[0] = nums[0];
optimization:
**/
    int maxSubArray(vector<int>& nums) {
        // if(!nums.size()) return 0;
        // if(nums.size()==1) return nums[0];
        vector<int> dp(nums.size()+1, 0);
        dp[0]=nums[0];
        int maxvalue=nums[0];

        for(int i=1; i<nums.size(); i++){
            dp[i] = max(dp[i-1]+nums[i], nums[i]);
            maxvalue=max(maxvalue, dp[i]);
        }
        return maxvalue;
    }
};
```
