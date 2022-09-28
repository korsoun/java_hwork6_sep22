package projectTree;

public class tree {
    public static void main(String[] args) {
        Node root = new Node("5");    // Формирование дерева через инициацию значений и указание отношений.
        Node l1 = new Node("2");
        Node l11 = new Node("1");
        Node r12 = new Node("3");
        Node r2 = new Node("7");
        Node l21 = new Node("6");
        Node r22 = new Node("11");
        Node l221 = new Node("10");

        root.left = l1;
        root.rigth = r2;
        l1.left = l11;
        l1.rigth = r12;
        r2.left = l21;
        r2.rigth = r22;
        r22.left = l221;

        System.out.println("Представление дерева в странном виде.");
        Iter.View(root, "  ");
        System.out.println("Обратный обход дерева");
        Iter.leftRigthCenter(root);
        System.out.printf("\nЦентрированный обход дерева.\n");
        Iter.leftCenterRigth(root);
        System.out.printf("\nПрямой обход дерева.\n");
        Iter.centerLeftRigth(root);
        System.out.printf("\nСкобочная запись.\n");
        Iter.bracesView(root);
    }
}

class Node {
    public Node(String val) {
        value = val;
    }
    String value;
    Node left;
    Node rigth;
}

class Iter {
    public static void View(Node n, String space) {  // Для обычной записи дерева.
        if(n != null) {
            System.out.printf("%s%s\n", space, n.value);
            if(n.left != null) {
                View(n.left, space + "  ");  // При записи узлов на каждом уровне копятся отступы, чтобы каждый уровень был отдельно от предыдущих.
            }
            if(n.rigth != null) {
                View(n.rigth, space + "  ");
            }
        }
    }

    public static void leftRigthCenter(Node n){      // Обратный обход.
        if (n.left!=null) {
            leftRigthCenter(n.left);     // Если левый потомок есть, спуск в него.
        }
        if (n.rigth!=null) {
            leftRigthCenter(n.rigth);    // Если правый потомок есть, спуск в него.
        }
        System.out.print(n.value + " "); // Если потомки учтены или их нет, печать печать значения узла.
    }

    public static void leftCenterRigth(Node n){  // Центрированный обход.
        if (n.left!=null) {
            leftCenterRigth(n.left);  // Переход к левому потомку при наличии.
        }
        System.out.print(n.value + " ");   // Печать значения текущего узла, если обход левых потомков завершен или их нет.
        if (n.rigth!=null) {
            leftCenterRigth(n.rigth);  // Переход к правому потомку.
        }
    }

    public static void centerLeftRigth(Node n){  // Центрированный обход.
        System.out.print(n.value + " ");   // Печать значения текущего узла.
        if (n.left!=null) {
            centerLeftRigth(n.left);  // Переход к левому потомку при наличии.
        }
        
        if (n.rigth!=null) {
            centerLeftRigth(n.rigth);  // Переход к правому потомку при наличии.
        }
    }

    public static void bracesView(Node n) {  // Для скобочной записи.
        System.out.print(n.value + "");
        
        if(n.left != null) {    // Если есть левый потомок, открывается скобка, и осуществляется переход на его уровень.
            System.out.print("(");
            bracesView(n.left);
            System.out.print(" ");
        }
        if(n.left == null && n.rigth != null) {  // Если левого потомка нет, но правый при этом имеется, вместо левого потомка надпись 'null'.
            System.out.print("(null ");
        }
        
        if(n.rigth == null && n.left != null) {  // Если правого потомка нет, но при этом имеется левый, вставка надписи 'null'.
            System.out.print("null)");
        }
        if(n.rigth != null) {  // Переход к правому потомку при наличии и закрытие скобки.
            bracesView(n.rigth);
            System.out.print(")");
        }
        
    }
}
