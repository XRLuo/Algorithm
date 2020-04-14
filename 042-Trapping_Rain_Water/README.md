# 42. Trapping Rain Water

# Solution 1 - stack

* 可以画几个找找灵感


* 可将全部的水池分成一个个小水池进行计算。
* 对于每个小水池，可以按层，进行一层一层的计算
* 从左边开始，将左墙入栈，然后依次遍历后面的墙，如果比前面低或一样高就继续入栈，因为这说明还没有构成水池
* 当遇到比前一个高的墙时，表明可以存水了，开始进行计算
* 把前一个取出来，当作底，删除掉。再跟它的前一个求最低高度减去底*(距离差-1)
* 不断让前面的出栈进行计算，直到算到左墙，结束

```
class Solution {
public:
    int trap(vector<int>& height) {
        stack<int> wall;
        int s = 0;
        int i = 0;
        int size = height.size();
        while(i<size){
            if(wall.empty() || height[wall.top()]>=height[i]){
                wall.push(i++);
            }else{
                int bottom = height[wall.top()];
                wall.pop();
                if(wall.empty()) continue;
                s+=(min(height[wall.top()], height[i])-bottom)*(i-wall.top()-1);
            }
        }
        return s;
    }
};
```

# Solution 2 - two pointers

```
class Solution {
public:
    int trap(int A[], int n) {
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft) maxleft=A[left];
                else res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright) maxright= A[right];
                else res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }
};
```
