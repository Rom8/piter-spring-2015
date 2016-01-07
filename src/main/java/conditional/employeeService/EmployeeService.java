package conditional.employeeService;

import conditional.employeeDaos.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 15/10/2015.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @PostConstruct
    public void work() {
        System.out.println("employee name: " + employeeDao.getEmployeeName());
    }

}
