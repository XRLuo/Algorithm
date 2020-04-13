# 19. Remove Nth Node From End of List

## notes

* 牵涉到删除操作时，务必注意:
	* 删除头结点，中间结点，尾结点间的区别和联系
	* delete掉要删除结点的指针，否则造成内存泄漏


## Solution 1

```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:// 记size，再重新找点，交换
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head) return 0;
        
        ListNode* a = head;
        int size=1;
        while(a->next){
            a=a->next;
            size++;
        }
        
        if(size==n) 
        {
            // if(size==1)return 0;
			a=head;
			head = head->next;
			del a;
            return head->next; 
        }
        a = head;
        int k = size - n;
        while(k>1){
            k--;
            a=a->next;
        }
       
	   	ListNode del = a->next;
        a->next= a->next->next;
		delete del;
        return head;
    }
};
```

## Solution 2

**only one pass!**
```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:// Solution1 记size，再重新找点，交换 删除队首和队尾队间不一样
        // Soliution2双指针，一个跑得快一个跑得慢，中间的间隔刚好是n，快的到终点了，慢的就刚好在那个要删的点上
    // 注意删除头结点和删除尾结点，这里尾结点可以不用太在意，头结点需要单独拿出来考虑。因为，在删除链表中间的结点时，先要有一个指针指向删除结点的前一个结点，而在删除头结点时，没有前一个结点
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(!head) return 0;
        ListNode* fast = head;
        ListNode* slow = head;
        int step=0;
        while(step<n){
            step++;
            fast=fast->next;
        }
        if(!fast) {
           
            ListNode* ans=head->next;
            delete(head);
            delete(fast);
            return ans;
        }
        while(fast->next){
            fast=fast->next;
            slow=slow->next;
        }
       
        ListNode* del=slow->next;
        slow->next=del->next;
        delete(del);
        return head;
  
    }
};
```
