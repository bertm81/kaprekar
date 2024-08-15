/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.fionnco.kaprekar;

/**
 *
 * @author robbie
 */
public class Challenge {

    public static void main(String[] args) {
        int testNumber = 76 ;
        int count = kaprekar(testNumber);
        System.out.println(count);
    }

    public static int kaprekar(int num){
        int run = 0 ;
        run = kaprekar(num, run);
        return run;
    }

    public static int kaprekar(int num, int run){
        int[] arr = int_to_array(num); 
        int[] newArr = pad(arr,4);

        if (validateNumber(newArr)) {
            int[] orderedNumber = bubbleSort(newArr, newArr.length).clone();
            int[] reveresedNumber = reverseArray(newArr);
            int result = array_to_int(orderedNumber)- array_to_int(reveresedNumber);       
            if (result!=6174){
                run = kaprekar(result, run);
            }
        }
        run++;
        return run;
    }

    private static boolean validateNumber(int[] num) {
        boolean valid = false;
        for(int x=0; x<num.length-1; x++){
            if(num[x]!=num[x+1]){
                valid=true;
                break;
            }
        } 
        if (num.length < 4){
            return true;
        } 
        return valid;
    }

    private static int[] int_to_array(int num) 
    { 
	    int j = 0; 
	    int len = Integer.toString(num).length(); 
	    int[] arr = new int[len]; 
	    while(num!=0) 
	    { 
    		arr[len-j-1] = num%10; 
		    num=num/10; 
		    j++; 
	    } 
	    return arr; 
    } 

    private static int array_to_int(int[] arr){
        int retVal = 0;
        int j = 1;
        for (int x = 0; x < arr.length; x++){
            retVal=retVal+(arr[x]*j);
            j=j*10;
        }
        return retVal;
    }

    static int[] bubbleSort(int[] arr, int n)
    {
        if (n == 1)
            return arr;
      
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        arr=bubbleSort(arr, n-1);
        return arr;
    }

    static int[] reverseArray(int arr[])
    {
        int[] retVal = new int[4];
        retVal[0] = arr[3];
        retVal[1] = arr[2];
        retVal[2] = arr[1];
        retVal[3] = arr[0];

        return retVal;
    }

    private static int[] pad(int[] arr, int i) {

        if (arr.length==4){
            return arr;
        }

        int[] retVal = new int[arr.length+1];
        retVal[0]=0;
        for(int x=0; x<arr.length; x++){
            retVal[x+1]=arr[x];
        }

        retVal = pad(retVal, i);
        return retVal;
    }
}
