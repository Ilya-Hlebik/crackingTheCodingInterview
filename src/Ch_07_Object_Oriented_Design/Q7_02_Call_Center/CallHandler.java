package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CallHandler {
    private List<Employee> employeeList = new ArrayList<>();
    private Manager manager;
    private Director director;

    private boolean dispatchCall(Call call) {
        Optional<Employee> first = employeeList
                .stream()
                .filter(Employee::isAvailable)
                .findFirst();
        boolean present = first.isPresent();
        if (present) {
            first.get().setAvailable(false);
            first.get().setCall(call);
        }
        return present;
    }
    private void transferCall(Employee employee, Rank rank){

    }

    public void fillEmployees(Employee employee) {
        employeeList.add(employee);
    }
    public void releaseEmployee(Employee employee){
        employee.setCall(null);
        employee.setAvailable(true);
    }
}
