# 21. Merge Two Sorted Lists
[link](https://leetcode.com/problems/merge-two-sorted-lists/)

## Solutions

### 1 Iteration

1. define a head node and a cur node first
2. find the minimal head node from l1 and l2 and then add it to cur
3. cur move to the next and continue to iterate
4. At last, when either l1 or l2 is NULL, add the other to the cur

#### code
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
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l1 && !l2) return 0;
        ListNode* cur = new ListNode(0);
        ListNode* head = cur;

        while(l1 && l2){
            cur->next = new ListNode(0);
            cur=cur->next;  
            cur->val = l1->val>l2->val?l2->val:l1->val;
            if(l1->val<=l2->val) l1=l1->next;
            else l2=l2->next;
        }
        cur->next = l1?l1:l2;
        return head->next;
    }
};
```


### 2 Recursive

1. the recursive func is to find the minimal node from l1 and l2 at each time regardless of next nodes after it.
2. after finding one, say l1, let l1 point to the next, and call the func to find the min between the next and l2.
2. when either l1 or l2 is NULL, return the other

#### code

```
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// 用递归：mergeTwoLists:返回两个参数链表的头结点中，函数值较小的头结点，不用管头结点后面的链表
class Solution {
public:
    
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        
        if(!l1) return l2;
        if(!l2) return l1;
        
        if(l1->val < l2->val){
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
        
        l2->next = mergeTwoLists(l2->next, l1);
        return l2;

    }
};
```
