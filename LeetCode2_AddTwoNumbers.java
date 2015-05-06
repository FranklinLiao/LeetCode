/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultListNode = new ListNode(0); //用来存放结果的ListNode
        ListNode resultListNodeTail = resultListNode;
        int carry = 0;
        while(l1!=null&&l2!=null) { //判断ListNode是否都还没到头了
            int result = (l1.val + l2.val + carry) % 10;
            carry = (l1.val+l2.val+carry) / 10;
            ListNode tmpListNode = new ListNode(0); //用来存放结果的ListNode
            tmpListNode.val = result;
            tmpListNode.next = null;
            l1 = l1.next;
            l2 = l2.next;
            resultListNodeTail.next = tmpListNode; //将当前节点接到resultListNode中
            resultListNodeTail = tmpListNode;  //把尾巴设置为tmpListNode
        } 
        ListNode oneListNodeHead = getOneListNode(l1,l2,carry); //对单个listNode进行处理，另一个已经为到头（null）了
        resultListNodeTail.next = oneListNodeHead; //将当前节点接到resultListNode中
        return resultListNode.next;  //第一个节点不是真正的listNode，只是一个头指针  实际的节点为.next
    }
    ListNode getOneListNode(ListNode l1,ListNode l2,int carry) { //当某一个listNode还有效时，继续拼接listNode
        if(l1==null&&l2==null) { //两个listNode都结束了    单独处理有进位时，也就是node已经结束，但是有一个进位 多产生了一个节点
            if(carry>0) {    
                ListNode tmpListNode = new ListNode(carry); 
                return tmpListNode;
            }
            return null;
        }
        if(l2 != null) {    //当l1为空时，调用自身    但参数变了  这样就可以下面的代码中只处理l1!=null的情况
            return getOneListNode(l2,l1,carry);
        }
        ListNode oneListNodeResult = new ListNode(0);
        ListNode oneListNodeResultTail = oneListNodeResult; //用来保存尾部节点
        while(l1!=null) {
            int result = (l1.val + carry) % 10;
            carry = (l1.val+carry) / 10;
            ListNode tmpListNode = new ListNode(0); //用来存放结果的ListNode
            tmpListNode.val = result;
            tmpListNode.next = null;
            l1 = l1.next;
            oneListNodeResultTail.next = tmpListNode; //将当前节点接到resultListNode中
            oneListNodeResultTail = tmpListNode;  //把尾巴设置为tmpListNode
        }
        if(carry>0) { //判断是否有进位  有进位就多了一个listNode
            ListNode tempListNode = new ListNode(carry);
            oneListNodeResultTail.next = tempListNode; //将当前节点接到resultListNode中
        }
        return oneListNodeResult.next; //第一个节点不是真正的listNode，只是一个头指针  实际的节点为.next
    }
      
}