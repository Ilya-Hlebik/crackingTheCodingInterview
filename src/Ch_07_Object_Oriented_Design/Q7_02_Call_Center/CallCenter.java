package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

import java.util.Random;

public class CallCenter {

    public static void main(String[] args) {
        CallHandlerService callHandlerService = new CallHandlerServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl(callHandlerService);
        Random random = new Random();
        Thread newCallsThread = new Thread(() -> {
            while (true){
                Call call = new Call();
                callHandlerService.addCallToQueue(call);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread dispatchCallThread = new Thread(() -> {
            while (true){
                callHandlerService.dispatchCall();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        newCallsThread.start();
        while (true){
            Call call = new Call();
            callHandlerService.addCallToQueue(call);
            callHandlerService.dispatchCall();
            if (random.nextBoolean()){
                callHandlerService.escalateCall(call);
            }
            else {
                employeeService.finishCall(call);
                continue;
            }
            callHandlerService.transferCall(call);
            continue;
        }
    }
}
class NewCalls implements Runnable{

    @Override
    public void run() {
        while (true){

        }
    }
}
