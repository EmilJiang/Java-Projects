class BCD {
    private int[] digits;
    BCD(int[] bcdDigits){
        digits = new int[bcdDigits.length];
        for(int i =0; i<digits.length; i++){
            digits[i] = bcdDigits[i];
        }
    }
    BCD(int num){
       int digit = num%10;
       num/=10;
       digits = new int[]{digit};
       while (num>0){
           digit = num%10;
           addADigit(digit);
           num/=10;
        }
       
    }
    public int numberOfDigits(){
        return digits.length;
    }
    public int nthDigit(int n){
        if(n>=digits.length){
            return 0;
        }
        else{
            return digits[n];
        }
    }
    public void addADigit(int newdigit){
        int[] newArray = new int[digits.length + 1];
        newArray[digits.length] = newdigit;
        for(int i = 0; i<digits.length;i++){
            newArray[i] = digits[i];
        }
        digits = newArray;
    }
    public String toString(){
        String number = "";
        for(int i = digits.length-1; i>=0; i--){
            if((i+1)%3==0 && (i+1)!=digits.length){
                number+=',';
            }
            number+=digits[i];
        }
        return number;
    }
    private int diagonalSum (int[][] lattice, int column, int row){
        int sum = 0;
        for(int i =0; row-i>=0 && column + i < lattice[0].length; i++){
            sum+= lattice[row-i][column+i];
        }
        return sum;
    }
    private int[] addDiagonals(int[][] lattice){
        int height = lattice.length;
        int width = lattice[0].length;
        int diagonals = width+height-1;
        int[] result = new int[diagonals];
        int diag=diagonals-1;
        //Add the diagonals that end at the bottom
        for (int col=width-1;col>=0;col--){
            result[diag]=diagonalSum(lattice,col,height-1);
            diag--;          }
        //Add the diagonals that end at the left side
        for (int row = height-2; row>=0; row--){
            result[diag]=diagonalSum(lattice,0,row);
            diag--;
        }
        return result;
    }
    public BCD addBCDs(BCD other){
        int[] a = new int[]{};
        BCD sum = new BCD(a);
        int numberFromAddition = 0;
        int maxSpaces = Math.max(other.numberOfDigits(),numberOfDigits());
        for(int i =0; i<maxSpaces; i++){
            numberFromAddition = nthDigit(i) + other.nthDigit(i) + numberFromAddition;
            if(numberFromAddition>=10){
                sum.addADigit(numberFromAddition-10);
                numberFromAddition = 1;
                if(i == maxSpaces-1){
                    sum.addADigit(1);
                }
            }
            else{
                sum.addADigit(numberFromAddition);
                numberFromAddition = 0;
            }
        }
        return sum;
    }
    public BCD multiplyBCDs(BCD other){
        int[] a = new int[]{};
        BCD answerBCD = new BCD(a);
        int [][] matrix = new int[other.numberOfDigits()][numberOfDigits()];
        for(int i =0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                matrix[i][j] = nthDigit((numberOfDigits()-1)-j) * other.nthDigit((other.numberOfDigits()-1)-i);
            }
        }
        int[] b = addDiagonals(matrix);
        int remaining = 0;
        int ones;
        int sum;
        for(int i = b.length-1; i>=0; i--){
            sum = b[i] + remaining;
            ones = sum%10;
            remaining = sum/10;
            answerBCD.addADigit(ones);
        }
        while(remaining>0){
            ones = remaining%10;
            remaining = remaining/10;
            answerBCD.addADigit(ones);
        }
        return answerBCD;
    }
    public static void main(String[] args){
        //Section 5 Testcase 1
        int[] number1 = new int[]{7,5,8,4};
        int[] number2 = new int[]{9,2,3};
        BCD f = new BCD(number1);
        BCD f1 = new BCD(number2);
        System.out.println("First number is " + f);
        System.out.println("Second number is " + f1);
        System.out.println(f + " times " + f1 + " = " + f.multiplyBCDs(f1));
        System.out.println();
        //Section 5 Testcase 2
        BCD f3 = new BCD(4583);
        BCD f4 = new BCD(8293);
        System.out.println("First number is " + f3);
        System.out.println("Second number is " + f4);
        System.out.println(f3 + " times " + f4 + " = " + f3.multiplyBCDs(f4));
        System.out.println();
        //Section 5 Testcase 3
        BCD f5 = new BCD(4);
        BCD f6 = new BCD(67);
        System.out.println("First number is " + f5);
        System.out.println("Second number is " + f6);
        System.out.println(f5 + " times " + f6 + " = " + f5.multiplyBCDs(f6));
        System.out.println();
        //Section 5 Testcase 4
        BCD f7 = new BCD(5);
        BCD f8 = new BCD(2);
        System.out.println("First number is " + f7);
        System.out.println("Second number is " + f8);
        System.out.println(f7 + " times " + f8 + " = " + f7.multiplyBCDs(f8));
        System.out.println();
        //Section 5 Testcase 5
        BCD f9 = new BCD(0);
        BCD f10 = new BCD(920);
        System.out.println("First number is " + f9);
        System.out.println("Second number is " + f10);
        System.out.println(f9 + " times " + f10 + " = " + f9.multiplyBCDs(f10));
        System.out.println();
        //Section 5 Testcase 6
        number1 = new int[]{1,2,3,4,2,0,4,2,4,5};
        number2 = new int[]{5,3,2,8,4,2,5,8,8,5};
        BCD f11 = new BCD(number1);
        BCD f12 = new BCD(number2);
        System.out.println("First number is " + f11);
        System.out.println("Second number is " + f12);
        System.out.println(f11 + " times " + f12 + " = " + f11.multiplyBCDs(f12));
        System.out.println();
        //Section 5 Testcase 7
        number1 = new int[]{3,3,5,3,4,1,4,5};
        number2 = new int[]{0,3,4,5,2,3};
        BCD f13 = new BCD(number1);
        BCD f14 = new BCD(number2);
        System.out.println("First number is " + f13);
        System.out.println("Second number is " + f14);
        System.out.println(f13 + " times " + f14 + " = " + f13.multiplyBCDs(f14));
        System.out.println();
    }
}
