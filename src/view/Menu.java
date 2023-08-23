package view;

import entities.Customer;
import entities.Phone;
import service.CustomerManager;
import service.PhoneStore;
import service.SaleReportService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public void menu(Scanner scanner){
        System.out.println("1--Quản lý điện thoại");
        System.out.println("2--Quản lý khách hàng");
        System.out.println("3--Quản lý doanh thu");
    }
    public int index(Scanner scanner){
        int choose =0;
        try{
            System.out.println("Nhập lựa chọn của bạn: ");
            choose = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return choose;
    }
    public void displayMenu(Scanner scanner){
        PhoneStore phoneStore = new PhoneStore();
        Map<String, Phone> phones = new HashMap<>();
        CustomerManager customerManager = new CustomerManager();
        Map<String, Customer> customers = new HashMap<>();
        SaleReportService saleReportService = new SaleReportService();

        menu(scanner);
        switch (index(scanner)) {
            case 1:
                System.out.println("1--Thêm dòng điện thoại");
                System.out.println("2--Xóa  điện thoại");
                System.out.println("3--tìm kiếm điện thoại theo tên hoặc hãng");
                switch (index(scanner)) {
                    case 1:
                        phoneStore.addPhone(scanner, phones);
                        break;
                    case 2:
                        phoneStore.removePhone(scanner, phones);
                        break;
                    case 3:
                        phoneStore.SearchPhone(scanner, phones);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");

                }
            case 2:
                System.out.println("1--Thêm khách hàng");
                System.out.println("2--Xóa khách hàng");
                System.out.println("3--Tìm kiếm khách hàng theo tên và số điện thoại");
                switch (index(scanner)) {
                    case 1:
                        customerManager.addCustomer(scanner, customers, phones);
                        break;
                    case 2:
                        customerManager.remove(scanner, customers);
                        break;
                    case 3:
                        customerManager.search(scanner, customers);
                        break;
                    default:
                        System.out.println("Lựa chọn không phù hợp!");
                        break;
                }
            case 3:
                System.out.println("1-- tạo bill");
                System.out.println("2-- Khách hàng trả hàng");
                switch (index(scanner)) {
                    case 1:
                        saleReportService.createrBill(scanner, customers, customerManager);
                        break;
                    case 2:
                        saleReportService.removeBill(scanner, customers);
                        break;
                    default:
                        System.out.println("Lựa chọn không phù hợp");
                }
            default:
                System.out.printf("Lựa chọn không hợp lệ nhập lại!"); break;

             }
        }
}
