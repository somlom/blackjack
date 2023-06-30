public class Field {

    public static void init(int height, int width){
        int[][] playground = new int[height][width];
        for (int i = 0; i < height; i++){
            for(int j = 0;i < width; j++){
                playground[i][j] = ' ';
                System.out.print(playground[i][j] + " ");
            }
        }
    }
    public static void main(String[] args){
        init(32, 32);
    }
}