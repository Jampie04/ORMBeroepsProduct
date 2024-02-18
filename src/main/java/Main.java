import Menu.Menu;
import Request.DirectorRequest;
import Request.HRRequest;
import Request.ManagerRequest;
import Request.RequestType;
import entity.*;
import repository.EmployeeRepository;
import service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true){
            Menu.showMenu();
            Menu.menuInput();
        }
    }
}
