/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
