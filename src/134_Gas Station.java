public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int tank=0;
        int total=0;
        for(int station=0,count=gas.length;station<count;++station){
            int fuel=gas[station]-cost[station];
            tank+=fuel;
            total+=fuel;
            if(tank<0){
                tank=0;
                start=station+1;
            }
        }
        return total>=0?start:-1;
    }
}
