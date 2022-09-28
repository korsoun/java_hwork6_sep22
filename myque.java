package projectQueue;
public class myque {
    public static void main(String[] args) {
        que exemp_que = new que();
        exemp_que.offer(3);
        System.out.println("Добавлен элемент 3.");
        System.out.println("Добавлен элемент 0.");
        exemp_que.offer(0);
        System.out.printf("Размер очереди %d. \n", exemp_que.size());
        exemp_que.print();
        System.out.printf("exemp_que[0] + 3 = %d\n", 3 + Integer.parseInt(exemp_que.remove()));
        System.out.println("Удален элемент");
        System.out.printf("Новый первый элемент - %s\n", exemp_que.remove());
        System.out.println("Удален элемент");
        System.out.println(exemp_que.remove());
        System.out.printf("Размер очереди %d. \n", exemp_que.size());
    }
}

class que {
    private int size = -1;
    private int[]  qarr = new int[100];

    Boolean can_remove () {   // Проверка возможности вывести элемент.
        if (size != -1) {
            return true;
        } else return false;
    }
    void offer(int num) {    // Добавление элемента в очередь.
        if(size + 1 >= (qarr.length / 10) * 9) {
            int[] temp = new int[qarr.length * 2];
            for(int i = 0; i < size; i++) {
                temp[i] = qarr[i];
            }
            qarr = temp;
        }
        qarr[size + 1] = num;
        size++;
    }

    /**
     * @return
     */
    String remove() {      // Удаление первого значения и его вывод (в строке).
        String res = "";
        if(can_remove()) {
            res = Integer.toString(qarr[0]);
            for(int i = 0; i <= size; i++) {
                qarr[i] = qarr[i + 1];
                size--;
            }
        } else {
            res = "Нет элементов для возвращения!";
        }
        return res;
    }

    void print() {
        System.out.print("[ ");
        for(int i = 0; i <= size; i++) {
            System.out.printf("%d ", qarr[i]);
        }
        System.out.println("]");
    }

    int size() {
        return size + 1;
    }
}