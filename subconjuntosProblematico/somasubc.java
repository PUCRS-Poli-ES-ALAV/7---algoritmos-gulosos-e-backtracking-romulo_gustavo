import java.util.ArrayList;

public class somasubc {

    public static void main(String[] args) {
        int[] conjunto = {-7, -3, -2, 5, 8};

    }

    public static int[] somaUm (int[] c){
        int[] resposta = {}; //n encontrado

        ArrayList<Integer> teste = new ArrayList<>();
        ArrayList<Integer> restante = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            restante.add(c[i]);
        }
        somaRec(teste, restante, 0);


        

        return resposta;
    }

    public static ArrayList<Integer> somaRec (ArrayList<Integer> teste, ArrayList<Integer> restante, int idx){
        while(j)
        teste.add(restante.get(idx));
        while(idx < restante.size()){
            ArrayList<Integer> testado = somaRec(teste, restante, idx);
            if(testeZero(testado)){
                return testado;
            }
            idx++;
        }
        teste.remove(teste.size()-1);

        ArrayList<Integer> naoDeu = new ArrayList<>();
        return naoDeu;

    }

    public static boolean testeZero (ArrayList<Integer> a){
        int soma = 0;
        for(int i = 0; i < a.size(); i++){
            soma+=a.get(i);
        }

        return soma == 0;
    }
}
/*
 * {}
 * -7
 *      -3
 *          -2
 *              5
 *                  8       -colocar tudo n funciona
 *           -2
 *              8
 *       -3
 *           5
 *               8
 *       -3
 *           8
 * -7
 *     -2
 *         -3
 *              5
 * -7
 *      -2
 *           
 *                  
 */