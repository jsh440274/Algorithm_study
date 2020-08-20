import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Main {
    public static void main(String[] args) {
        //LinkedList
        LinkedList LL = new LinkedList();
        LL.insert_first(1);//1
        LL.insert_first(2);//2->1
        LL.insert_first(3);//3->2->1
        LL.print_all();
        LL.delete_first();//2->1
        LL.delete_first();//1
        LL.print_all();
        LL.insert_last(2);//1->2
        LL.insert_last(3);//1->2->3
        LL.print_all();
        System.out.println(LL.search(2));//true
        LL.delete(2);//1->3
        System.out.println(LL.search(2));//false
        LL.print_all();
        //Stack
        Stack S = new Stack();
        S.push(1);//1
        S.push(2);//2->1
        S.push(3);//3->2->1
        System.out.println(S.peek());//3
        S.push(4);//4->3->2->1
        S.push(5);//5->4->3->2->1
        System.out.println(S.peek());//5
        S.pop();//4->3->2->1
        S.pop();//3->2->1
        S.pop();//2->1
        System.out.println(S.peek());//2
        System.out.println(S.size());//2

        //Queue
        Queue Q = new Queue();
        Q.add(1);//(1)
        Q.add(2);//(1,2)
        Q.add(3);//(1,2,3)
        Q.add(4);//(1,2,3,4)
        Q.add(5);//(1,2,3,4,5)
        Q.add(6);//(1,2,3,4,5,6)
        Q.add(7);//(1,2,3,4,5,6,7)
        Q.add(8);//(1,2,3,4,5,6,7,8)
        Q.add(9);//(1,2,3,4,5,6,7,8,9)
        Q.add(10);//(1,2,3,4,5,6,7,8,9,10) FULL
        Q.add(11);//여기서 resize됨 (1,2,3,4,5,6,7,8,9,10,11)
        System.out.println(Q.first());//1
        Q.remove();//(2,3,4,5,6,7,8,9,10,11)
        Q.remove();//(3,4,5,6,7,8,9,10,11)
        Q.remove();//(4,5,6,7,8,9,10,11)
        Q.remove();//(5,6,7,8,9,10,11)
        System.out.println(Q.isEmpty());//false
        Q.remove();//(6,7,8,9,10,11)
        System.out.println(Q.size());//6
        Q.remove();//(7,8,9,10,11)
        Q.remove();//(8,9,10,11)
        Q.remove();//(9,10,11)
        Q.remove();//(10,11)
        System.out.println(Q.first());//10
        Q.remove();//(11)
        Q.remove();//EMPTY
        System.out.println(Q.isEmpty());//ture

        //Circular Queue
        CircularQueue CQ = new CircularQueue();
        CQ.add(1);//(1,,,,,,,,,)
        CQ.add(2);//(1,2,,,,,,,,)
        CQ.add(3);//(1,2,3,,,,,,,)
        CQ.add(4);//(1,2,3,4,,,,,,)
        System.out.println(CQ.first());//1
        CQ.add(5);//(1,2,3,4,5,,,,,)
        CQ.add(6);//(1,2,3,4,5,6,,,,)
        CQ.add(7);//(1,2,3,4,5,6,7,,,)
        CQ.add(8);//(1,2,3,4,5,6,7,8,,)
        CQ.add(9);//(1,2,3,4,5,6,7,8,9,) FULL
        System.out.println(CQ.isFull());//true
        CQ.remove();//(,2,3,4,5,6,7,8,9,)
        CQ.remove();//(,,3,4,5,6,7,8,9,)
        System.out.println(CQ.size());//9
        CQ.add(10);//,,3,4,5,6,7,8,9,10)
        CQ.add(11);//(11,,3,4,5,6,7,8,9,10) FULL
        System.out.println(CQ.size());//9
        System.out.println(CQ.isFull());//true
        CQ.remove();//(11,,,4,5,6,7,8,9,10)
        System.out.println(CQ.first());//4
        CQ.remove();//(11,,,,5,6,7,8,9,0)
        CQ.remove();//(11,,,,,6,7,8,9,10)
        CQ.remove();//(11,,,,,,7,8,9,10)
        CQ.remove();//(11,,,,,,,8,9,10)
        CQ.remove();//(11,,,,,,,,9,10)
        CQ.remove();//(11,,,,,,,,,,10)
        CQ.remove();//(11,,,,,,,,,)
        CQ.remove();//EMPTY
        System.out.println(CQ.isEmpty());//true
    }
}