package src.controller;

public class Field {
    public static void main(String[] args)
    {
        int fieldWidth = 10;
        int fieldHight = 10;
        char[][] playground = new char[fieldHight][fieldWidth];
        for (int i=0; i< fieldHight; i++)
        {
            for(int j = 0 ;i < fieldWidth; j++){
                playground[i][j] = ' ';
            }
        }
        for (int i = 0; i < fieldHight; i++) 
        {
            for (int j = 0; j < fieldWidth; j++) {
                System.out.print(playground[i][j] + " ");
            }
                System.out.println();
        }

    };
}