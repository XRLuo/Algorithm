# 反转链表 II
[leetcode #92](https://leetcode-cn.com/problems/reverse-linked-list)

## 基础知识
[ReverseLinkedList](https://github.com/XRLuo/Algorithm/blob/master/ReverseLinkedList.md)



## 代码1
```Java
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
      ListNode Start = head;
      ListNode First=null;
      ListNode Last=null;
      ListNode A=null;
      ListNode B=null;

      int step = m-1-1; // m-1移动的次数，再-1是为了找到开始位置前一个结点
      for(int i=0; i<step; i++)
        head=head.next;

      First=head;
      if(m!=1)
      head=head.next;
      A=head;

      ListNode pre = null;
      ListNode cur = head;
      int t = n-m+1;//总共要反转的结点数，也是反转的次数，+1方便计数

      while(t-->0 && cur!=null){

        ListNode nextTemp = cur.next;
        if(t==0){
            B=cur;
            Last = cur.next;
        }
        cur.next=pre;
        pre=cur;
        cur=nextTemp;
      }

      First.next = B;
      if(A!=null)
      A.next = Last;

      if(m==1)
          if(B!=null)
              Start=B;
          else if(Last!=null)
              Start=Last;

      return Start;
    }

}

```
最后AC了，尽管自己都不太相信。

## 本人思路
既然是在中间进行部分的反转，那么对应的反转链表内部的起始点，终点以及反转部分以外的两侧的端点需要被标记下来，便于之后的穿针引线。

在此基础上，能ac掉大部分的样例，但还有部分情况过不了，需要进行相应调整
1. 只反转一个结点
2. 反转整个链表
3. 反转起始位置为1

在一一进行解决以后，得到上面的代码

## 代码2
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr =  head;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;            
        }
        return pre;
    }
}
```
这是网上的代码，大致思路一致，具体操作中有顺序的不同，避免了next带来的困扰
1. 先把pre，curr初始化
2. 在循环中初始化next（循环条件判断了curr是否空，省去了代码1中的的判断）
3. 反转curr引用的结点的引用
4. pre后移
5. cur后移
6. 循环未结束则再次初始化next
6. 当cur已经空了，说明到头，循环结束
7. 返回pre

## 特别注意

这里第二个代码抓住了两个问题

next的问题，就是它是根据curr来的，curr不能是NULL。

同时整个反转过程的结束也是curr指向NULL时。

因此curr作为循环判断条件最为合适。Next也没必要刚开始就设置好，可以在curr确定不为NULL后再进行赋值。它处于pre，curr之后，可以在前两者移动好以后直接重新生成，不需要也进行初始化，并进行“移动”。而前两者没法在每次循环中直接生成，因为链表是单向的，因此需要进行“移动”

三个引用存在的意义

1. 这里pre的存在用来当作反转的”目标”

2. curr的存在用来操控结点连接的目标，以及作为pre后移的目标

3. next的存在用来作为curr后移的目标
