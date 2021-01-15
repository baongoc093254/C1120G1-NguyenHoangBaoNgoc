    package bai10_stack_queue.baitap;

    import java.util.Scanner;
    import java.util.Stack;

    public class BreakedChecking {
        public static boolean checkingBreaked(String str) {
            Stack<Character> characterStack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    characterStack.push(str.charAt(i));
                }
                for (int j = 0; j < str.length(); j++)
                    if (str.charAt(i) == ')') {
                        if (characterStack.isEmpty()) {
                            return false;
                        } else {
                            characterStack.pop();
                        }
                    }
                if (characterStack.size() != 0) {
                    return false;
                }

            }
            return true;
    }
        public static void main (String[]args){
            System.out.println("Nhập biểu thức muốn kiểm tra");
            Scanner scanner = new Scanner(System.in);
            String exPression = scanner.nextLine();
            if (checkingBreaked(exPression)) {
                System.out.println("Right !");
            } else {
                System.out.println("Wrong !");
            }

        }
    }