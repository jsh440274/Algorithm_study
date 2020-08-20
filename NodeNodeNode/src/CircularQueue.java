public class CircularQueue {

    private int MAX_SIZE = 10;//최대 사이즈를 10으로 정해준다.
    private Object CQ[] = new Object[MAX_SIZE];//원형큐로 사용할 배열
    private int front=0, rear=0;//front, rear값을 0으로 초기화해준다.
    private int size = 0;

    public void add(int value){
        /*
        배열의 마지막에 원소를 삽입한다. 삽입하고 나서 rear의 값을 바꿔줘야함.
        삽입하려는 큐의 index가 큐의 크기를 넘을 경우 MAX_SIZE를 이용하여 배열의 첫번째 index부터 front전까지 채울수 있도록 한다.
        꽉차면 더 못들어가도록 해야함
        */
    }

    public Object first() {
        /*
        배열의 첫번째에 있는 원소를 리턴한다. 스택의 peek와 같은 개념 - 다음에 제거할 녀석을 보여줌.
        */
        return ;
    }

    public Object remove(){
        /*
        배열의 첫번째 원소를 지운다.
        지우고 나서 front의 값을 바꿔줘야함.
        아무것도 없는데 지울려고 하면 에러 메세지 출력.
         */
        return ;
    }

    public int size(){
        return ;
    }

    public boolean isEmpty(){
        /*
        초기에 설정했던대로 front의 값과 rear의 값이 모두 0일때만 비어있다고 가정한다.
         */
        return ;
    }

    public boolean isFull(){
        /*
        꽉찼는지 알아본것. 환상큐는 front와 rear의 값이 하나 차이날때 꽉찼다고 가정한다.
         */
        return ;
    }

    private void resize(){//배열이 꽉찼을 때 배열의 크기를 두배로 늘려준다.
        /*
        배열의 크기를 두배로 늘려주면서 MAX_SIZE를 바꿔야함
        하고싶으면 하셈
         */
    }
}
