class Main{
    static int numInstrucoes = 0;
    static int countItr = 0;
    public static void main(String[] args) {
        int a=7;
        solveQ(a);
        System.out.println("Num de Instrucoes:"+numInstrucoes+" para "+a);
        System.out.println("Num de Iteracoes:"+countItr+" para "+a);
        clearCount();
        a=8;
        solveQ(a);
        System.out.println("Num de Instrucoes:"+numInstrucoes+" para "+a);
        System.out.println("Num de Iteracoes:"+countItr+" para "+a);
        clearCount();
        a=9;
        solveQ(a);
        System.out.println("Num de Instrucoes:"+numInstrucoes+" para "+a);
        System.out.println("Num de Iteracoes:"+countItr+" para "+a);
        clearCount();
    }

    public static void clearCount() {
        numInstrucoes = 0;
        countItr = 0;
    }
    //n queen problem
    public static boolean isSafe(int[][] placeQ, int row, int col){
        countItr++;
        //checking the current row for conflicts in the column
        for (int i = 0; i < col; i++) {
            numInstrucoes++;
            if (placeQ[row][i] == 1) {
                return false;
            }
        }
        //checking for conflicts on the left diagonal 
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (placeQ[i][j] == 1) {
                numInstrucoes++;
                //System.out.println(row +","+ col +" collides at"+" [" + i + "," + j + "]" + " left diagonal");
                return false;
            }
        }
        //checking for conflicts on the right diagonal
        for (int i = row, j = col; j >= 0 && i < placeQ.length; i++, j--) {
            numInstrucoes++;
            if (placeQ[i][j] == 1) {
                //System.out.println(row+","+col+" collides at"+" [" + i + "," + j + "]" + " right diagonal");
                return false;
            }
        }
        return true;
    }
    public static boolean placeQ(int[][] placeQ, int col) {
        countItr++;
        //all queens are placed
        if (col >= placeQ.length) {
            return true;
        }
        for (int i = 0; i < placeQ.length; i++) {
            numInstrucoes++;
            //check if placing a queen at (i, col) is safe
            if (isSafe(placeQ, i, col)) {
                //safe position found, place the queen
                placeQ[i][col] = 1;
                numInstrucoes++;
                //recursively attempt to place the next queen
                if (placeQ(placeQ, col + 1)) {
                    return true;
                }
                //backtrack, remove the queen from (i, col), if placeQ fails
                placeQ[i][col] = 0;
                numInstrucoes++;
            }
        }
        return false;
    }
    public static boolean solveQ(int n) {
        countItr++;
        int[][] placeQ = new int[n][n];
        //no place to put queen
        if (placeQ(placeQ, 0) == false) {
            System.out.println("no solution");
            return false;
        }
        printSolution(placeQ);
        return true;
    }
    public static void printSolution(int[][] placeQ) {
        //print matrix queens positon indexes
        //System.out.print("\nIDXs:{");
        for (int i = 0; i < placeQ.length; i++) {
            for (int j = 0; j < placeQ.length; j++) {
                if (placeQ[i][j] == 1) {
                    //System.out.print("[" + i + "," + j + "]");
                }
            }
        }
        //System.out.print("}");

        System.out.println("\n");
        for (int i = 0; i < placeQ.length; i++) {
            for (int j = 0; j < placeQ.length; j++) {
                System.out.print(" " + placeQ[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] initBoard(int n){
        int [][] placeQ= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                placeQ[i][j]=0;
            }
        }
        return placeQ;
    }
}