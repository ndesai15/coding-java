package datastrucutres.arrays;

public class ArrayDS {
    public static void main(String[] args) {
        int[] myArray = new int[7];

        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 80;
        myArray[3] = 30;
        myArray[4] = 40;
        myArray[5] = 50;
        myArray[6] = 60;

        int index = -1;
        int count = 0;
        for (int i: myArray){
            if (i == 80) {
                index = count;
                break;
            }
            count++;
        }
        System.out.println(index);

    }
}
