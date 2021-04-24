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
        BCD zeroBCD = new BCD(0);
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
        int sum1 = 0;
        for(int i = 0; i< answerBCD.numberOfDigits(); i++){
            sum1 += answerBCD.nthDigit(i);
            if(sum1 >0){
                break;
            }
        }
        if(sum1 == 0){
            return zeroBCD;
        }
        return answerBCD;
    }
    public static BCD factorial(int num){
        BCD factorial1 = new BCD(num);
        BCD one = new BCD(1);
        if(num == 0){
            return one;
        }
        return factorial1.multiplyBCDs(factorial(num-1));
    }
    public BCD pow(int num){
        BCD base = new BCD(digits);
        BCD number = new BCD(digits);
        for(int i = 1; i<num; i++){
            base = base.multiplyBCDs(number);
        }
        return base;
    }
    public static void main(String[] args){

    }
}
