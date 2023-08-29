public class Task2 {
    public static void main(String[] args){
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int pos){
        if(pos<=1) return pos;
    
        return fibonacci(pos-1)+fibonacci(pos-2);
    }

}
