# 88. Merge Sorted Array

## Solution 1

```
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if(!m && !n) return ;
       
        int p1=0; // nums1 当前位置
        int p2=0; // nums2 当前位置
        vector<int> s;
        
        while(p1<m && p2<n ){
            s.push_back(nums1[p1]<nums2[p2]?nums1[p1]:nums2[p2]);
            if(nums1[p1]<nums2[p2]) p1++; else p2++;
        }
        if(p1<m){
            for(int i=p1; i<m; i++)
                s.push_back(nums1[i]);
            
        }
        else{
            for(int i=p2; i<n; i++)
                s.push_back(nums2[i]);
        }
        nums1 = s;
    }
};
```

## Solution 2

```
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        // vector<int> s;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j])
                nums1[k--]=nums1[i--];
            else
                nums1[k--]=nums2[j--];
        }
        while(j>=0)
            nums1[k--]=nums2[j--];
    }
};
```
