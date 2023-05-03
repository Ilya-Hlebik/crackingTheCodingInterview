package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

import java.util.List;

public interface CallHandlerService {
    void addCallToQueue(Call call);
    void dispatchCall();
    void transferCall(Call call);
    void escalateCall(Call call);
    List<Employee> getAllEmployees();
}
