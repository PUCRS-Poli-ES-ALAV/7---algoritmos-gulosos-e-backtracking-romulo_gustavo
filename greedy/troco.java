public class troco {
    static int countItr = 0;
    public static void main(String[] args) {
        //int teste1 = 289;
        int teste1 = 3982;
        int[] moedas = trocoG(teste1);

        System.out.println("Valor = "+teste1);
        System.out.println("Cem = "+moedas[0]+"\nVinte e Cinco = "+moedas[1]+"\nDez = "+moedas[2]+"\nCinco = "+moedas[3]+"\nUm = "+moedas[4]);
        System.out.println("Iterações: "+countItr);

    }

    public static int[] trocoG(int valor) {
        int[] vetor = { 0, 0, 0, 0, 0 };
        return trocoRec(valor, vetor);
    }

    public static int[] trocoRec(int valor, int[] vetor) {
        if (valor <= 0) {
            countItr++;
            return vetor;
        }
        while (true) {
            //countItr++;
            if (valor >= 100) {
                valor -= 100;
                vetor[0] += 1;
                break;
            }
            if (valor >= 25) {
                valor -= 25;
                vetor[1] += 1;
                break;
            }
            if (valor >= 10) {
                valor -= 10;
                vetor[2] += 1;
                break;
            }
            if (valor >= 5) {
                valor -= 5;
                vetor[3] += 1;
                break;
            }
            if (valor >= 1) {
                valor -= 1;
                vetor[4] += 1;
                break;
            } else {
                break;
            }
        }
        countItr++;
        return trocoRec(valor, vetor);
    }
}
