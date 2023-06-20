class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // for(int i = 0 ; i< n; i++){
        //     int totalFuel = 0;
        //     int count = 0;
        //     int j = i; 
        //     // use j as pointer to loop
        //     // BRUTE FORCE
        //     // we will check at every i gas station 
        //     while(count < n){
        //         // while count still not full
        //         totalFuel += gas[j%n] - cost[j%n];
        //         // totalFuel += gas at that pos - cost to move
        //         // if totalFuel < 0 => not valid
        //         if(totalFuel < 0) break;
        //         count++;
        //         j++;
        //     }
        //     if (count == n && totalFuel >= 0){
        //         // can reach, and valid cost
        //         return i;
        //     }
        // }
        int totalGas = 0, totalCost = 0, curGas = 0, start = 0;
        for(int i = start ; i <n ;i++){
            totalGas += gas[i];
            totalCost += cost[i];

            curGas += gas[i]-cost[i];
            if(curGas < 0){
                // this means this i gas station not work
                start = i+1;
                curGas = 0; // reset gas 
            }
        }
        // if after all total cost still > totalGas => we dont have a valid path
        return (totalGas < totalCost) ? -1 : start;
    }
}