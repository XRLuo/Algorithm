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
      ListNode start=head;
      ListNode first=null;
      ListNode last=null;
      ListNode A=null;
      ListNode B=null;

      int step = m-1-1; // m-1移动的次数，再-1是为了找到开始位置前一个结点
      for(int i=0; i<step; i++)
        head=head.next;

      First=head;
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

      B = First.next;
      A.next = Last;

      return Start;
    }

}
