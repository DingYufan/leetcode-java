
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * ----
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * ---
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode(int x) { val = x; }
 * }
 * ---
 * Created by dingyufan on 2018/11/21.
 */
public class AddTwoNumbers {

    // 有点繁琐
    public ListNode addTwoNumbersA(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int sum = l1.val + l2.val;
        int flag = 0;
        if (sum > 9) {
            sum = sum % 10;
            flag = 1;
        }
        ListNode ln = new ListNode(sum);
        ListNode ptr = ln;

        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + flag;
            if (sum > 9) {
                sum = sum % 10;
                flag = 1;
            } else {
                flag = 0;
            }
            ln.next = new ListNode(sum);

            ln = ln.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (flag > 0) {
                ln.next = new ListNode(flag);
            }
            return ptr;
        }

        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {
            sum = l.val + flag;
            if (sum > 9) {
                sum = sum % 10;
                flag = 1;
            } else {
                flag = 0;
            }
            ln.next = new ListNode(sum);
            ln = ln.next;
            l = l.next;
        }

        if (flag > 0) {
            ln.next = new ListNode(flag);
        }
        return ptr;
    }

    public ListNode addTwoNumbersB(ListNode l1, ListNode l2) {
        // 这三个检查去掉，执行时间从64ms -> 29ms, 变成超越97%的提交
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode ln = new ListNode(-1);
        ListNode ptr = ln;

        int sum = 0;
        int flag = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
            flag = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum % 10 : sum;

            ln.next = new ListNode(sum);
            ln = ln.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (flag == 1) {
            ln.next = new ListNode(flag);
        }
        return ptr.next;
    }
}

