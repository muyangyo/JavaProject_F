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
           if(pos.data ==key)
           {
               if(prev ==null) //头就是该数值时
               {
                   phead=pos.next;
                   pos =pos.next;
                   flag=1;
                   continue;
               }
               prev.next =pos.next;
               pos = pos.next;
               flag =1;
               continue;
           }
           prev =pos;
           pos =pos.next;
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

    public void clear() //清空链表
    {
        phead = null;
    }

    public void reverseList() {
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

    //内部测试接口
    public static void main(String[] args) {
        Single_LinkList ls1 = new Single_LinkList();
        ls1.addFirst(1);
        ls1.addLast(1);
        ls1.addLast(1);
        ls1.addLast(2);
        ls1.addLast(1);
        ls1.addLast(3);
        ls1.addLast(4);
        ls1.addLast(1);
        ls1.addLast(1);
        ls1.display();
        ls1.removeAllKey(1);
        ls1.display();
        ls1.clear();
    }
}
