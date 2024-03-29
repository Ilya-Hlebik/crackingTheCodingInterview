package Ch_07_Object_Oriented_Design.Q7_02_Call_Center;

import java.util.*;

/**
 * Assign call to first Represent using addCallToQueue(), then dispatchCall()
 * If call need to escalate - use escalateCall(), then transferCall()
 * If during transfer - no available manager - try to assign to director
 * If director also not available - add call to priorityCalls
 * if employee finished call - use finishCall;
 */
public class CallHandlerServiceImpl implements CallHandlerService {
    private final List<Employee> employeeList = new ArrayList<>();
    private final Queue<Call> callsQueue = new LinkedList<>();
    private final Queue<Call> priorityCalls = new LinkedList<>();
    private final List<Call> currentCalls = new ArrayList<>();

    public CallHandlerServiceImpl() {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Respondent();
            employeeList.add(employee);
        }
        for (int i = 0; i < 2; i++) {
            Employee manager = new Manager();
            Employee director = new Director();
            employeeList.add(manager);
            employeeList.add(director);
        }
    }

    @Override
    public void addCallToQueue(Call call) {
        System.out.println("addCallToQueue" + call);
        callsQueue.add(call);
    }

    @Override
    public void dispatchCall() {
        if (callsQueue.isEmpty() && priorityCalls.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("dispatchCall");
        Call call;
        boolean isPriority = false;
        if (!priorityCalls.isEmpty()) {
            call = priorityCalls.peek();
            isPriority = true;
        } else {
            call = callsQueue.peek();
        }
        Optional<Employee> first = getEmployeeByRank(call.getRank());
        boolean present = first.isPresent();
        if (present) {
            first.get().setAvailable(false);
            first.get().setCall(call);
            call.setHandler(first.get());
            currentCalls.add(call);
            if (isPriority) {
                priorityCalls.poll();
            } else {
                callsQueue.poll();
            }
        }
    }

    @Override
    public void transferCall(Call call) {
        System.out.println("transferCall " + call);
        releaseEmployee(call.getHandler());
        if (Rank.Manager.equals(call.getRank())) {
            getEmployeeByRank(Rank.Manager)
                    .ifPresentOrElse(emp -> {
                        emp.setAvailable(false);
                        emp.setCall(call);
                        call.setHandler(emp);
                    }, () -> assignToDirector(call));
        } else if (Rank.Director.equals(call.getRank())) {
            assignToDirector(call);
        }
    }

    @Override
    public void escalateCall(Call call) {
        System.out.println("escalateCall " + call);
        if (Rank.Respondent.equals(call.getRank())) {
            call.setRank(Rank.Manager);
        } else if (Rank.Manager.equals(call.getRank())) {
            call.setRank(Rank.Director);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public List<Call> currentCalls() {
        return currentCalls;
    }

    private void assignToDirector(Call call) {
        System.out.println("assignToDirector " + call);
        getEmployeeByRank(Rank.Director)
                .ifPresentOrElse(emp -> {
                    emp.setAvailable(false);
                    emp.setCall(call);
                    call.setHandler(emp);
                }, () -> priorityCalls.add(call));
    }

    private Optional<Employee> getEmployeeByRank(Rank rank) {
        return employeeList
                .stream()
                .filter(emp -> rank.equals(emp.getRank()))
                .filter(Employee::isAvailable)
                .findFirst();
    }

    public void releaseEmployee(Employee employee) {
        employee.setCall(null);
        employee.setAvailable(true);
    }
}
