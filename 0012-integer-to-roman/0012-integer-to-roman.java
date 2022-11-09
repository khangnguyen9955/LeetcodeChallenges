class Solution {
    public String intToRoman(int num) {
       // if(num < 1 || num > 3999){
         //  return "";
        // }
        // actually we do not to check because the constraint
        // we have to take care about the case with number "4*" and "9*"
        // so I think we should add some more symbol
        // IV, IX, XL, XC, CD, CM
        String[] symbols = { "M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder str = new StringBuilder();
        int i=0; // iterate variable
        while(num > 0){ // check if done
            while(num >= values[i]){
                num -= values[i]; 
                str.append(symbols[i]);
                // for example: num=2400 => num=1400 => num = 400 
                // then we have 2 M
                // now num is less than M (1000) => increase i by 1;
            }
            i++;
        }
        return str.toString();
    }
}