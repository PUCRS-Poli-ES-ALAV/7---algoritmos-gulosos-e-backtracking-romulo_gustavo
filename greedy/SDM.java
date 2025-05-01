

import java.util.ArrayList;

public class SDM {

    public static void main(String[] args) {
        ArrayList<Integer[]> colecao = new ArrayList<>();
        Integer[] um = {2,4};
        Integer[] dois = {4,5};
        Integer[] tres = {1,6};
        Integer[] quatro = {6,7};
        colecao.add(um);
        colecao.add(dois);
        colecao.add(tres);
        colecao.add(quatro);

        ArrayList<Integer[]> teste = SDMGuloso(colecao);
        int resultado = teste.size();
        System.out.println(resultado);
    }
/*SDM-Guloso (s, f, n)
1   X ← { }
2   i ← 1
3   enquanto i ≤ n faça
4        X ← X ∪ {i}
5        k ← i + 1
6        enqunto k ≤ n e sk < fi faça
7              k ← k + 1
8        i ← k
9   devolva X*/
    public static ArrayList<Integer[]> SDMGuloso (ArrayList<Integer[]> colecao){
        ArrayList<Integer[]> X = new ArrayList<>();
        int i = 0;
        while(i < colecao.size()){
            X.add(colecao.get(i));
            int k = i + 1;
            while(k < colecao.size() && colecao.get(k)[0] < colecao.get(i)[1]){
                k++;
            }
            i = k;
        }
        return X;

    }



}
