public class LinkedList {

    Node start;

    public void insert_first(int value){
        //첫번째에 노드를 삽입
        Node x = new Node(value);
        if(start == null){//리스트가 비어있을 경우
            start = x;
        }
        else {//리스트가 비어있지 않을 경우
            x.next = start;
            start = x;
        }
    }

    public void print_all(){
        Node p = new Node();//노드 객체 생성
        p = start;//걸어나가는 참조변수 p를 사용한다.
        while(p.next != null){//p가 리스트의 마지막 노드를 가리키고 있지 않을 경우 p를 한칸씩 옮겨가면서 출력한다.
            System.out.print(p.value + " -> ");
            p = p.next;
        }
        if(p != null) {
            System.out.print(p.value);//while문을 빠져나왔을때 p는 마지막 원소이다. 이 원소가 비어있는 경우는 리스트에 아무 노드도 있지 않을 경우이다.
        }
        System.out.println();
    }

    public boolean search(int value){
        /*
        만약 리스트의 끝까지 전부 탐색했는데 없으면 false, 있으면 true리턴
         */
        Node p = new Node();
        p = start;
        while(p != null){
            if(p.value == value){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public Node delete_first(){
        /*
        리스트의 첫번째 원소 지우기.
        리스트가 비어있는지 확인하고 비어있으면 에러메세지 출력.
        리스트가 비어있지 않다면 리스트의 가장 첫번째에 있는 원소를 지운다.
        서순에 주의해야 뒤에 연결되어있는 노드들을 날려먹지 않을 것이다.
        지우면 지운 노드 리턴
        */
        Node p = new Node();
        p = start;
        Node ret = p;
        if(p == null){
            System.out.println("리스트가 비어있습니다.");
        }
        else{
            p = start.next;
            start = p;
        }
        return ret;
    }

    public Node delete(int value){
        /*
        매개변수로 받은 value값을 가지는 노드를 찾아 삭제한다.
        걸어나가는 참조변수 p를 사용하여 해당 노드를 찾는다
        리스트의 처음부터 끝까지 탐색했는데 해당 노드가 없다면 에러메세지 출력
        있다면 해당 노드를 삭제하는데 이때 서순 잘못되면 마찬가지로 뒤에꺼 다 날아감 ㅅㄱ
        */
        Node p = new Node();
        p = start;
        if(p.value == value){
            start = p.next;
            return p;
        }
        while(p.next.value != value){
            p = p.next;
            if(p.next == null){
                System.out.println("지우려는 노드가 없습니다.");
                break;
            }
        }
        p.next = p.next.next;
        return p;
    }

    public void insert_last(int value){
        /*
        리스트의 마지막에 해당 원소를 삽입한다.
        p를 사용해서 끝까지 가보셈
         */
        Node p = new Node();
        p = start;
        Node x = new Node(value);
        while(p.next != null){
            p = p.next;
        }
        p.next = x;
    }
}
