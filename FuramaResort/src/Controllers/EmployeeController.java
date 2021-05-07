package Controllers;

import Commons.FuncReadAndWriteFile;
import Commons.FuncReadWriteCustomer;
import Commons.InputService;
import Models.Customer;
import Models.Employee;
import Models.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeController {
public static void addEmployee(){
        //: Họ tên Employee , Ngày sinh, Số CMND, Số ĐT, Email, Trình độ, Vị trí, lương
        String ten = InputService.inputCustomerName();
        String ngaySinh = InputService.inputDay();
        String soCMND = InputService.inputIdCard();
        String soDt = InputService.inputPhone();
        String email = InputService.inputEmail();
        String trinhDo = InputService.inputLevel();
        String viTri = InputService.inputPosition();
        String luong = InputService.inputSalary();

        Employee employees = new Employee(ten, ngaySinh, soCMND, soDt, email, trinhDo, viTri, luong);
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employees);

    }
    public static void showEmployee() {


    }

}
