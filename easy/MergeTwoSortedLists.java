public class MergeTwoSortedLists{

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedLists.mergeTwoLists(l1, l2);



    }

    public static ListNode mergeTwoListsC(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }
        // a -> b -> c -> d
        // y -> v -> w ->x
        // TODO 

    }


    public static ListNode mergeTwoListsB(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }
        ListNode list = new ListNode(0);
        ListNode ptr = list;
        while(l1 != null && l2 != null){
            boolean flag =l1.val < l2.val;
            list.next = new ListNode(flag ? l1.val : l2.val);
            list = list.next;
            l1 = flag ? l1.next : l1;
            l2 = flag ? l2 : l2.next;
        }

        list.next = (l1 == null) ? l2 : l1;
        return ptr.next;
    }

    // 暴力法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode list = new ListNode(0);
        ListNode ptr = list;
        while(l1 !=null || l2 != null){
            if(l1 == null || l2 == null){
                boolean flag = l1 == null;
                list.next = new ListNode(flag ? l2.val : l1.val);
                list = list.next;
                l1 = flag ? null : l1.next;
                l2 = flag ? l2.next : null;
                continue;
            }

            boolean flag =l1.val < l2.val;
            list.next = new ListNode(flag ? l1.val : l2.val);
            list = list.next;
            l1 = flag ? l1.next : l1;
            l2 = flag ? l2 : l2.next;
        }
        return ptr.next;
    }
}