

import java.util.ArrayList;

public class SDMtesteDois {
    static int countItr = 0;

    public static void main(String[] args) {
        ArrayList<Integer[]> colecao = new ArrayList<>();
        
        Integer[] um = {2,4};
        Integer[] dois = {4,5};
        Integer[] tres = {1,6};
        Integer[] quatro = {6,7};
        Integer[] cinco = {4,8};
        Integer[] seis = {6,9};
        Integer[] sete = {7,10};
        Integer[] oito = {9,11};
        Integer[] nove = {9,12};
        Integer[] dez = {3,13};
        Integer[] onze = {13,14};
        colecao.add(um);
        colecao.add(dois);
        colecao.add(tres);
        colecao.add(quatro);
        colecao.add(cinco);
        colecao.add(seis);
        colecao.add(sete);
        colecao.add(oito);
        colecao.add(nove);
        colecao.add(dez);
        colecao.add(onze);

        ArrayList<Integer[]> teste = SDMGuloso(colecao);
        int resultado = teste.size();
        System.out.println(resultado);
        System.out.println(("countItr: "+countItr));

        //System.out.println("array um: ["+teste.get(0)[0]+","+teste.get(0)[1]+"]");
        //System.out.println("array dois: ["+teste.get(1)[0]+","+teste.get(1)[1]+"]");
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
            countItr++;
            X.add(colecao.get(i));
            int k = i + 1;
            while(k < colecao.size() && colecao.get(k)[0] <= colecao.get(i)[1]){
                //System.out.println("nao deu! no indice: "+k);
                countItr++;
                k++;
            }
            i = k;
        }
        return X;

    }



}
