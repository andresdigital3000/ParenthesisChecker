import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ParenthesisChecker {

    public static void main(String[] args) {
        List<Character> lstCharacter;
        String strToEvaluate;
        String respuesta;
        Scanner myObj = new Scanner(System.in);
        int i = 0;
        Integer testCase = Integer.valueOf(myObj.nextLine());
        List<String> arrayResultado = new ArrayList<>();

        while (i < testCase) {
            strToEvaluate = myObj.nextLine();
            lstCharacter = strToEvaluate.chars().mapToObj(exp -> (char) exp).collect(Collectors.toList());
            respuesta = isBalanced((ArrayList<Character>) lstCharacter);
            arrayResultado.add(respuesta);
            //System.out.println(respuesta);
            i++;
        }

        for (String itemRespuesta : arrayResultado) {
            System.out.println(itemRespuesta);
        }



       /* strToEvaluate ="(()";
        lstCharacter = strToEvaluate.chars().mapToObj(exp -> (char) exp).collect(Collectors.toList());
        respuesta = isBalanced((ArrayList<Character>) lstCharacter);
        System.out.println(respuesta);

        strToEvaluate ="{([])}";
        lstCharacter = strToEvaluate.chars().mapToObj(exp -> (char) exp).collect(Collectors.toList());
        respuesta = isBalanced((ArrayList<Character>) lstCharacter);
        System.out.println(respuesta);

        strToEvaluate = "()";
        lstCharacter = strToEvaluate.chars().mapToObj(exp -> (char) exp).collect(Collectors.toList());
        respuesta = isBalanced((ArrayList<Character>) lstCharacter);
        System.out.println(respuesta);

        strToEvaluate = "()[]";
        lstCharacter = strToEvaluate.chars().mapToObj(exp -> (char) exp).collect(Collectors.toList());
        respuesta = isBalanced((ArrayList<Character>) lstCharacter);
        System.out.println(respuesta);*/
    }

    public static String isBalanced(ArrayList<Character> alBalanced) {
        String balanced = "not balanced";
        if (alBalanced.size() == 0) {
            balanced = "balanced";
        } else {
            Iterator iterator = alBalanced.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Character itemActual = (Character) iterator.next();
                char closingItem = getClosingItem(itemActual);
                int indexClosing = alBalanced.indexOf(closingItem);
                if (indexClosing > 0) {
                    alBalanced.remove(indexClosing);
                    if (alBalanced.size() == 1) {
                        balanced = "balanced";
                        //alBalanced.remove(i);
                        return balanced;
                        //break;
                    } else {
                        alBalanced.remove(i);
                    }
                    balanced = isBalanced(alBalanced);
                } else {
                    balanced = "not balanced";
                    return balanced;
                }
            }
        }
        return balanced;
    }

    public static char getClosingItem(Character openingItem) {
        char closingItem = 0;
        if (openingItem.equals('{')) {
            closingItem = '}';
        }
        if (openingItem.equals('(')) {
            closingItem = ')';
        }
        if (openingItem.equals('[')) {
            closingItem = ']';
        }
        return closingItem;
    }
}
