# 007-Reverse Integer
[link](https://leetcode.com/problems/reverse-integer/)

## 方法1

### 思路
依次取出对应的数，保存起来，再构成新的数

### 本人代码
```java
class Solution{
    public int reverse(int x) {
       if(x>Integer.MAX_VALUE || x< Integer.MIN_VALUE) return 0;
        double flag;
        long xx=x>0?x:-(long)x;
        double a[]=new double[100];
        int n=0;
        double s=0;
        while(xx>0){
            a[n] = xx % 10;
            xx/=10;
            n+=1;
        }
        n--;
        int k=1;
        for(int i=n; i>=0; i--){
            s+=a[n-i]*Math.pow(10,i);
        }
        s=x<0?-s:s;
        if(s>Integer.MAX_VALUE || s< Integer.MIN_VALUE) return 0;
        int q=(int)s;

        return q;
    }
}
```
### 官方代码
```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
```

## 方法2

将数值变为字符串，那么就只需要将字符串逆序即可，要注意的是符号问题

## 代码

```java
class Solution {
    public int reverse(int x) {
        if(x>Integer.MAX_VALUE || x <Integer.MIN_VALUE) return 0;
        int flag = -1;
        long xx = (x<0)?-(long)x:(long)x;
        String s = String.valueOf(xx);
        String s2=new String();
        int len = s.length();
        for (int i = len - 1; i > -1; i--)
            s2 += s.charAt(i);
        double x2 = Long.parseLong(s2);
        if(x2>Integer.MAX_VALUE || x2 <Integer.MIN_VALUE) return 0;
        if(x<0) x2=-x2;
        return (int)x2;
    }
}
```

## 方法3

充分利用了Java的API StringBuilder
```Java
class Solution {
    public int reverse(int x) {
      String reversed = new
      StringBuilder().append(Math.abs(x)).reverse().toString();
    try {
        return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
    } catch (NumberFormatException e) {
        return 0;
    }
    }
}
```

## Highlights

### 1 找对应数据类型的最大数/最小数
直接
```java
Integer.MAX_VALUE
```

### 2 -2147483648变正数

int类型的范围：-2147483648～2147483647,因此变正数需要强制类型转换
```java
x = -2147483648;

long y = -(long)x;
```

### 3 StringBuilder及它和String，StringBuffer的区别

[来源](https://blog.csdn.net/rmn190/article/details/1492013)

1、用来处理字符串常用的类有3种：String、StringBuffer和StringBuilder2、

三者之间的区别：都是final类，都不允许被继承；String类长度是不可变的，StringBuffer和StringBuilder类长度是可以改变的；

StringBuffer类是线程安全的，StringBuilder不是线程安全的；
