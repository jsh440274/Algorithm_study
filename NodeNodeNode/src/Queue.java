import java.util.NoSuchElementException;

public class Queue {
    private int MAX_SIZE = 10;
    private Object[]Q = new Object[MAX_SIZE];//10칸짜리 배열 선언. 이걸로 큐를 구현할거다.
    private int front = 0, rear = 0;//처음과 끝을 나타내는 front와 rear변수를 선언한다.
                                    // 비어있는 큐의 front와 rear값은 0으로 초기화한다. front는 다음에 삭제할 곳, rear는 다음에 삽입할곳이라고 생각
    private int size = 0;

    public void add(int value){
        /*
        배열의 마지막에 원소를 삽입한다. 삽입하고 나서 rear의 값을 바꿔줘야함.
        만약 큐가 꽉찬 상황이라면 resize를 해주고 다시 삽입해야함
        */
        if(rear == MAX_SIZE){
            resize();
        }
        Q[rear] = value;
        rear++;
        size++;
    }

    public Object first() {
        /*
        배열의 첫번째에 있는 원소를 리턴한다. 스택의 peek와 같은 개념 - 다음에 제거할 녀석을 보여줌.
        */
        return Q[front];
    }

    public Object remove(){
        /*
        배열의 첫번째 원소를 지운다.
        지우고 나서 front의 값을 바꿔줘야함.
        아무것도 없는데 지울려고 하면 에러 메세지 출력.
         */
        if(size == 0){
            throw new IllegalStateException("Queue is Empty");
        }//큐가 비어있을 때 예외처리
        Object ret = Q[front];
        Q[front] = null;
        front++;
        size--;
        return ret;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    private void resize(){//배열이 꽉찼을 때 배열의 크기를 두배로 늘려준다.
        Object[]temp = new Object[Q.length * 2];
        System.arraycopy(Q,front,temp,0,size);
        Q = temp;
        front = 0;
        rear = size;
        MAX_SIZE = MAX_SIZE*2;
    }
}
