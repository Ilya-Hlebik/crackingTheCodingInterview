package Ch_15_Threads_and_Locks.Q15_02_Context_Switch;

public class Solution {
    public static void main(String[] args) {
        /*
        *  Basically we need to isolate system to just 2 processes P1 and P2
        *  One process should send token and another one receive.
        *  Then we can check time between this 2 processes.
        *  However this is dependent on task scheduler, kernel type etc.
        *  We cannot guarantee, that task scheduler will select P2 immediately after finish work of P1.
        * */
    }
}
