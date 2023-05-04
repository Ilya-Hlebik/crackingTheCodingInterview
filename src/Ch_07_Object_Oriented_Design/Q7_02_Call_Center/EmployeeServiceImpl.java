package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

public class EmployeeServiceImpl implements EmployeeService {
    private final CallHandlerService callHandlerService;

    public EmployeeServiceImpl(CallHandlerService callHandlerService) {
        this.callHandlerService = callHandlerService;
    }

    @Override
    public void finishCall(Call call) {
        System.out.println("finishCall " + call);
        callHandlerService.getAllEmployees()
                .stream()
                .filter(emp -> emp.equals(call.getHandler()))
                .findFirst()
                .ifPresent(emp -> {
                    emp.setCall(null);
                    emp.setAvailable(true);
                });
        callHandlerService.currentCalls().remove(call);
    }
}
