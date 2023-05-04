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
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callHandlerService.dispatchCall();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (random.nextBoolean()){
                    Call call = callHandlerService.currentCalls().get(0);
                    callHandlerService.escalateCall(call);
                    callHandlerService.transferCall(call);
                }
                else {
                    employeeService.finishCall(callHandlerService.currentCalls().get(0));
                    continue;
                }
            }
        });
        newCallsThread.start();
        dispatchCallThread.start();
    }
}
