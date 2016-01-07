package conditional.employeeDaos;

import conditional.annotations.Dev;
import conditional.employeeDaos.EmployeeDao;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component
@Dev
public class MockEmployeeDao implements EmployeeDao {
    @Override
    public String getEmployeeName() {
        return "Gendalf";
    }
}
