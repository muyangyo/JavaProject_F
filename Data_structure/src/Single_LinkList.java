import java.util.Scanner;

/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-12-01
 * Time: 10:30
 */
class Single_Node {
    int data;//数据
    Single_Node next;//指针

    public Single_Node(int x) {
        this.data = x;
    }
}

public class Single_LinkList {
    Single_Node phead;//链表的头

    public void addFirst(int data) //头插法
    {
        Single_Node pos = phead;
        Single_Node temp = new Single_Node(data);
        temp.next = pos;
        phead = temp;
    }

    public void addLast(int data) //尾插法
    {
        Single_Node pos = phead;
        if (pos == null) {
            addFirst(data);
        } else {
            while (pos.next != null) {
                pos = pos.next;
            }
            pos.next = new Single_Node(data);
        }
    }

    public boolean addIndex(int index, int data) //任意位置插入,第一个数据节点为0号下标
    {
        Single_Node pd = phead;
        Single_Node pos = phead;
        int size = size();
        if (index > size || index < 0) {
            System.out.printf("非法位置!请重新输入位置:");
            Scanner sc = new Scanner(System.in);
            int new_index = sc.nextInt();
            System.out.println();
            addIndex(new_index, data);
        } else if (index == size) {
            addLast(data);
        } else if (index == 0) {
            addFirst(data);
        } else {
            Single_Node prev = null;
            //寻址,pos位置即为index所指向位置
            for (int i = 0; i < index; i++) {
                prev = pos;
                pos = pos.next;
            }
            Single_Node temp = new Single_Node(data);
            temp.next = prev.next;
            prev.next = temp;
        }
        return true;
    }

    public boolean contains(int key) //查找是否包含关键字key是否在单链表当中
    {
        Single_Node pos = phead;
        while (pos != null) {
            if (pos.data == key) {
                System.out.println("存在该数:" + key);
                return true;
            }
            pos = pos.next;
        }
        System.out.println("不存在该数:" + key);
        return false;
    }

    public void remove(int key) //删除第一次出现关键字为key的节点
    {
        Single_Node pos = phead;
        Single_Node prev = null;
        while (pos != null) {
            if (pos.data == key) {
                if (prev == null) {
                    phead = pos.next;
                    System.out.println("已删除该数据:" + key);
                    return;
                }
                prev.next = pos.next;
                System.out.println("已删除该数据:" + key);
                return;
            }
            prev = pos;
            pos = pos.next;
        }
        System.out.println("不存在该数据,无法删除!");
        return;
    }

    public void removeAllKey(int key)  //删除所有值为key的节点
    {
        Single_Node pos = phead;
        Single_Node prev = null;
        int flag = 0;
        while (pos != null) {
            if (pos.data == key) {
                if (prev == null) //头就是该数值时
                {
                    phead = pos.next;
                    pos = pos.next;
                    flag = 1;
                    continue;
                }
                prev.next = pos.next;
                pos = pos.next;
                flag = 1;
                continue;
            }
            prev = pos;
            pos = pos.next;
        }
        if (flag == 1) {
            System.out.println("该元素:" + key + " 已经全部删除");
            return;
        }
        if (flag == 0) {
            System.out.println("不存在该数据,无法删除!");
            return;
        }
    }

    public int size() //得到单链表的长度
    {
        Single_Node pos = phead;
        int size = 0;
        while (pos != null) {
            pos = pos.next;
            size++;
        }
        return size;
    }

    public void display() //打印全部数据
    {
        Single_Node pd = phead;
        Single_Node pos = phead;
        System.out.printf("链表数据:");
        while (pos != null) {
            System.out.printf("%d  ", pos.data);
            pos = pos.next;
        }
        System.out.println();
    }

    public static void static_display(Single_Node phead) //打印全部数据
    {
        Single_Node pd = phead;
        Single_Node pos = phead;
        System.out.printf("链表数据:");
        while (pos != null) {
            System.out.printf("%d  ", pos.data);
            pos = pos.next;
        }
        System.out.println();
    }

    public void clear() //清空链表
    {
        phead = null;
    }

    public void reverseList() //翻转链表
    {
        if (phead == null) {
            System.out.println("错误:空链表");
            return;
        }
        Single_Node prev = null;
        Single_Node cur = phead;
        while (cur != null) {

            Single_Node next = cur.next;
            cur.next = prev; //由于prev初始化为NULL,正好解决了头结点逆置后需要将this.next置空
            prev = cur;
            cur = next;
        }
        phead = prev;
    }

    public static Single_Node static_reverseList(Single_Node phead) //翻转链表(静态)
    {
        if (phead == null) {
            System.out.println("错误:空链表");
            return null;
        }
        Single_Node prev = null;
        Single_Node cur = phead;
        while (cur != null) {

            Single_Node next = cur.next;
            cur.next = prev; //由于prev初始化为NULL,正好解决了头结点逆置后需要将this.next置空
            prev = cur;
            cur = next;
        }
        Single_Node newhead = prev;
        return newhead;
    }

    public Single_Node middleNode()     //给返回链表的中间结点
    {
        Single_Node slow = phead;
        Single_Node fast = phead;
        if (phead == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Single_Node FindKthToTail(int k)     //查找倒数第k个结点的数据
    {
        Single_Node slow = phead;
        Single_Node fast = phead;
        if (phead == null) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null && i < k - 1)
                return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Single_Node mergeTwoLists(Single_Node list1, Single_Node list2)
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    {
        Single_Node pos1 = list1;
        Single_Node pos1_prev = null;
        Single_Node pos2 = list2;
        Single_Node pos2_prev = null;
        Single_Node temphead = new Single_Node(-1);
        Single_Node index = temphead;
        Single_Node newhead = null;
        if (pos1 == null && pos2 == null) {
            return null;
        } else if (pos1 == null) {
            return pos2;
        } else if (pos2 == null) {
            return pos1;
        }
        int flag = 0;
        while (pos1 != null && pos2 != null) //之前已经判断完了开始就是空的情况,现在是每次循坏后产生的
        {
            if (pos2.data > pos1.data) {
                index.next = pos1;
                index = index.next;
                pos1_prev = pos1;
                pos1 = pos1.next;
                pos1_prev.next = null;
            } else {
                index.next = pos2;
                index = index.next;
                pos2_prev = pos2;
                pos2 = pos2.next;
                pos2_prev.next = null;
            }
            if (flag == 0) {
                newhead = index;
                flag = 1;
            }

        }
        if (pos1 == null && pos2 == null) {
            return newhead;
        } else if (pos1 == null) {
            index.next = pos2;
        } else {
            index.next = pos1;
        }
        return newhead;
    }

    public Single_Node partition(int x)
    //将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
    {
        Single_Node pos = phead;
        if (pos == null) {
            return null;
        }
        Single_Node newheadS = new Single_Node(-1);
        Single_Node S_pos = newheadS;
        Single_Node newheadB = new Single_Node(-1);
        Single_Node B_pos = newheadB;
        while (pos != null) {
            if (pos.data >= x) {
                B_pos.next = pos;
                B_pos = B_pos.next;
            } else {
                S_pos.next = pos;
                S_pos = S_pos.next;
            }
            pos = pos.next;
        }
        S_pos.next = newheadB.next;
        B_pos.next = null;
        return newheadS.next;
    }

    public static Single_Node deleteDuplication(Single_Node phead) //不是最优解,效率较低
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    {
        //滞留指针解决问题
        Single_Node pos = phead;
        Single_Node index = null;
        Single_Node newhead = null;
        if (pos == null) {
            return null;
        } else if (pos.next == null) {
            return phead;//一个数据的链表,并不会进入循环,如果返回newhead会导致空指针问题
        }

        int flag = 0;//利用flag来判断是否处于重复区
        int frist = 1;//有没有头
        while (pos.next != null) {
            if (pos.data != pos.next.data && flag != 1 && frist == 1) {
                index = pos;
                pos = pos.next;
                frist = 0;
                newhead = index;
            } else if (pos.data == pos.next.data) {
                flag = 1;
                pos = pos.next;
            } else if (pos.data != pos.next.data && flag == 1) {
                pos = pos.next;
                flag = 0;
            } else {
                index.next = pos;
                index = pos;
                pos = pos.next;
            }
        }
        if (newhead == null && flag == 1) {
            return null;//避免全被删了
        } else if (flag == 0)//判断最后一个是否为重复的
        {
            if (index != null) {
                index.next = pos;//追加最后一个不重复的结点
            } else if (frist == 1) //追加最后的为头
            {
                index = pos;
                newhead = index;
                frist = 0;
            }
        } else //最后一个也是重复的,所以直接置为空
        {
            index.next = null;
        }
        return newhead;
    }

    public boolean chkPalindrome()        //判断链表是否为回文结构
    {
        Single_Node midNode = this.middleNode();
        Single_Node pos1 = phead;
        Single_Node pos2 = static_reverseList(midNode);
        static_display(pos2);
        while (pos1 != null && pos2 != null) {
            if (pos1.data != pos2.data) {
                return false;
            }
            pos1 = pos1.next;
            pos2 = pos2.next;
        }
        return true;
    }

    public static Single_Node getIntersectionNode(Single_LinkList A, Single_LinkList B)
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
    {
        Single_Node posA = A.phead;
        Single_Node posB = B.phead;
        if (posA == null || posB == null) {
            return null;
        }
        int Alongth = A.size();
        int Blongth = B.size();
        int k = Alongth - Blongth;//测算长度
        if (k > 0) {
            while (k != 0) {
                posA = posA.next;
                k--;
            }
        } else if (k < 0) {
            k = -k;
            while (k != 0) {
                posB = posB.next;
                k--;
            }
        }
        while (posA != null && posB != null) {
            if(posA == posB)  //本身就可能是相同的元素或者输入的是同一个链表
            {
                return posA;
            }
            else if (posA.next != null && posA.next == posB.next) {
                return posA.next;
            }
            posA =posA.next;
            posB =posB.next;
        }
        return null;
    }

    //内部测试接口
    public static void main(String[] args) {
        Single_LinkList ls1 = new Single_LinkList();
        ls1.addLast(1);
        ls1.addLast(2);
        ls1.addLast(3);
        ls1.addLast(4);
        ls1.addLast(5);
        ls1.addLast(6);
        ls1.display();
        //测试函数区
        System.out.println(ls1.size());

        //打印函数
        ls1.display();
        ls1.clear();
    }
}
