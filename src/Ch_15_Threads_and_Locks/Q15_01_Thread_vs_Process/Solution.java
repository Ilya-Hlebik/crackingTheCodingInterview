package Ch_15_Threads_and_Locks.Q15_01_Thread_vs_Process;

public class Solution {
    public static void main(String[] args) {
        /*
        * Process is an independent entity to which system resources allocated
        * Each process is executed in separate address space and one process cannot read variables
        * and data of another one. But processes can share data between each other if needed.
        * Using files, sockets, pipes and etc.
        *
        * A thread exist withing a process and shares the process resources with other threads, such a heap space.
        * We can create multiple threads under one process. This is different from process, which cannot directly
        * access memory of another process. But threads still have their own spaces, such as stack
        * */
    }
}
