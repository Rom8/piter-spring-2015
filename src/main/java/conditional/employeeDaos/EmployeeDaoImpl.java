package conditional.employeeDaos;

import conditional.annotations.Prod;
import conditional.employeeDaos.EmployeeDao;
import org.springframework.stereotype.Component;

/**
 * Created by Jeka on 15/10/2015.
 */
@Component
@Prod
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public String getEmployeeName() {
        return "Sergey";
    }
}
