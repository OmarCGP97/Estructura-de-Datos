/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividaded7;

/**
 *
 * @author OmarAlejandro
 */
public class ActividadED7 {

    /**
     * @Problems on Recursion
     */
    
    //1)Factorial
    public int factorial(int n) {
        if (n == 0) 
            return 1;
        return n * factorial(n-1);
    }

    //2) BunnyEars
    public int bunnyEars(int bunnies) {
        if (bunnies == 0) 
            return 0;
        return 2 + bunnyEars(bunnies-1);
    }

    //3) Fibonacci
    public int fibonacci(int n) {
        if (n == 0) 
            return 0;
        else if (n == 1) 
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //4) BunnyEars2
    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) 
            return 0;
        if (bunnies % 2 == 0) 
            return 3 + bunnyEars2(bunnies-1);
        else 
            return 2 + bunnyEars2(bunnies-1);
    }

    //5) Triangle
    public int triangle(int rows) {
        if (rows == 0) 
            return 0;
        return rows + triangle(rows-1);
    }

    //6) SumDigits
    public int sumDigits(int n) {
        if (n < 10) 
            return n;
        return (n % 10) + sumDigits(n/10);
    }

    //7) Count7
    public int count7(int n) {
        if (n < 1) 
            return 0;
        if (n % 10 == 7) 
            return 1 + count7(n/10);
        else 
            return count7(n/10);
    }

    //8) Count8
    public int count8(int n) {
        if (n < 1) 
            return 0;
        if (n % 10 == 8 && (n / 10) % 10 == 8) 
            return 2 + count8(n/10);
        else if (n % 10 == 8) 
            return 1 + count8(n/10);
        else 
            return count8(n/10);
    }

    //9) PowerN
    public int powerN(int base, int n) {
        if (n == 0) 
            return 1;
        return base * powerN(base, n-1);
    }

    //10) CountX
    public int countX(String str) {
        if (str.equals("")) 
            return 0;
        if (str.charAt(0) == 'x') 
            return 1 + countX(str.substring(1));
        else 
            return countX(str.substring(1));
    }

    //11) ChangeXY
    public String changeXY(String str) {
        if (str.equals("")) 
            return str;
        if (str.charAt(0) == 'x') 
            return "y" + changeXY(str.substring(1));
        return str.charAt(0) + changeXY(str.substring(1));
    }

    //12) Array6
    public boolean array6(int[] nums, int index) {
        if (index >= nums.length) 
            return false;
        if (nums[index] == 6) 
            return true;
        else 
            return array6(nums, index+1);
    }

    //13) Array11
    public int array11(int[] nums, int index) {
        if (index >= nums.length) 
            return 0;
        if (nums[index] == 11) 
            return 1 + array11(nums,index+1);
        else 
            return array11(nums,index+1);
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
