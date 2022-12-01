import java.util.Scanner;

/**
 * 创建于 IntelliJ IDEA.
 * 描述：
 * User: DR
 * Date: 2022-12-01
 * Time: 10:30
 */
class Single_Node{
    int data;//数据
    Single_Node next;//指针
    public Single_Node(int x)
    {
        this.data =x;
    }
}
public class Single_LinkList {
    Single_Node phead;//链表的头

    public void addFirst(int data) //头插法
    {
        Single_Node pos = phead;
        Single_Node temp = new Single_Node(data);
        temp.next = pos;
        phead=temp;
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
            Scanner sc =new Scanner(System.in);
            int new_index = sc.nextInt();
            System.out.println();
            addIndex(new_index,data);
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
        return true;
    }

    public void remove(int key) //删除第一次出现关键字为key的节点
    {

    }

    public void removeAllKey(int key)  //删除所有值为key的节点
    {

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

    }

    //内部测试接口
    public static void main(String[] args) {
        Single_LinkList ls1 = new Single_LinkList();
        ls1.addFirst(1);
        ls1.addIndex(0,2);
        ls1.addLast(3);
        System.out.println(ls1.size());
        ls1.display();
    }
}
