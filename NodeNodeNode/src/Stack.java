
public class Stack {

    private Node top;//스택의 맨 위에 있는 노드를 가리킴.
    private int size;//스택의 크기

    public boolean isEmpty(){
        /*
        스택이 비어있는지 확인하는 메소드
        비어있으면 true, 안비어있으면 false 리턴
         */
        return (size == 0);
    }

    public int size(){
        /*
        현재 스택의 크기를 반환. push나 pop을 하면서 사이즈를 조절하여 전역변수를 만지기 때문에
        그냥 size를 리턴해도 됨
         */
        return size;
    }

    public int peek(){
        /*
        스택의 맨 위에 있는 노드의 value값을 리턴한다.
        top을 이용하면 편리함여. 다만 top을 잘 만져서 움직여줘야 정신건강에 좋음
        비어있으면 오류메세지를 띄운다
        예외처리하는 여러가지 방법이 있지만 그냥 프린트 해도 무방. 이건 맘대로 하셈
         */
        return ;
    }

    public void push(int value){
        /*
        스택의 맨 위에 매개변수로 받은 value를 value값으로 받는 노드를 삽입한다.
        리스트의 앞쪽에 삽입하는것이 멘탈을 지키는 지름길이다.
        LinkedList의 insert_first처럼 할것
        추가하고 나서는 top의 값을 바꿔줘야 한다.
         */
        return ;
    }

    public int pop(){
        return ;
    }

}
