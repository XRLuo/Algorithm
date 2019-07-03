# 005 Longest Palindromic Substring
[5](https://leetcode-cn.com/problems/longest-palindromic-substring/)


## 1 中心扩展 Expand Around Center
以某一个点为中心，如果左右两边一样，就向外扩展

具体思路：

这个中心点有两种情况，一种是单个的，一种是两个一样的，需要分开讨论

优劣：

这个方法理解起来很容易，但是属于特题特解，不具有一般性，第二个动归可能更有一般性，可以套用在别的题上


```java
public class Solution {

    public String centerexpand(String s, int len, int l, int r) {
        int ll = l + 1, rr = r - 1;
        while (ll - 1 >= 0 && rr+1 < len && s.charAt(ll - 1) == s.charAt(rr + 1)) {
            ll--;
            rr++;
        }
        return s.substring(ll, rr + 1);
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        String str1, str2, maxstr, resstr = "";
        for (int i = 0; i < len; i++) {
            str1 = centerexpand(s, len, i, i);
            str2 = centerexpand(s, len, i, i + 1);
            maxstr = str1.length() > str2.length() ? str1 : str2;
            resstr = maxstr.length() > resstr.length() ? maxstr : resstr;

        }
        return resstr;

    }
}
```
## 2 动态规划 DP

这个方法有助于举一反三

解决这类 “最优子结构” 问题，可以考虑使用 “动态规划”：

1. 定义 “状态”；
2. 找到 “状态转移方程”。

### 1 定义 “状态”，这里 “状态”数组是二维数组。

dp[l][r] 表示子串 s[l, r]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。即如果子串 s[l, r] 是回文串，那么 dp[l][r] = true。

### 2 找到状态转移方程

给出一个子串s[l][r] 如果s[l] ！= s[r]，那么肯定不是回文串，如果s[l]==s[r]，那么我们才会下一步考虑它的子串 s[l+1][r-1] 是不是回文串。 子串为true，则母串是回文串，子串false，母串则不是

s[l+1][r-1] 如果只有一个元素，则肯定是回文串，如果没有元素，也是回文串，这两个条件满足就是 r-1-(l+1)<=0 即 r-l <= 2

dp[l][r] = s.charAt(l) == s.charAt(r) && (dp[l+1][r-1] || r-l<=2)


### 代码
```java
public class Solution {

    public String longestPalindrome(String s) {

        if(s.equals("")) return "";
        int len = s.length();

        Boolean [][] dp = new Boolean[len][len];

        String maxstr = s.substring(0,1);

        for (int r = 1; r < len; r++)
            for (int l = 0 ; l < r; l++) {
               dp[l][r] = s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1]);
                if(dp[l][r]==true)
                    maxstr = maxstr.length() > s.substring(l, r + 1).length()?maxstr:s.substring(l,r+1);
            }
        return  maxstr;

    }
}
```

**Highlights**

dp的循环设计很值得一看

可以记作:
r[1, len-1]
l[0, l-1]

我用笔在纸上依次跑了几轮，发现它能够保证每次的字符串区间s[l][r]的子串s[l+1][r-1]都是已经判断过的

而自己一开始习惯写得区间：l[0,len-2], r[l+1, len-1]
用笔在纸上跑了后发现，有大量子串是没有被优先赋值的

因此，下次碰到动归的题，对于循环体的控制，为了“区间由小及大”，可以考虑r从1开始，放在外循环，内循环终点是r-1
