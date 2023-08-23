package service;

import entities.Customer;
import entities.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerManager {
    public List<Phone> phoneUser(Scanner scanner, Map<String, Phone> phones){
        String choose;
        do {
            System.out.println("Loại điện thoại khách hàng đã mua: ");
            String name = scanner.nextLine();
            List<Phone> phonesUser = new ArrayList<>();
            for (Phone phone : phones.values()) {
                if (name == phone.getName()) {
                    phonesUser.add(phone);
                }
            }
            System.out.println("bạn muốn tiếp tục ko Y/N");
            choose = scanner.nextLine();
            if(choose.equalsIgnoreCase("N")){
                break;
            }
        }while (choose.equalsIgnoreCase("y") );
            return phoneUser(scanner, phones);
    }
    public double billPhone(Scanner  scanner, List<Phone> phonesUser ){
        double money =0;
        System.out.println("Số tiền khách hàng đã thanh toán: ");
        for(Phone phone: phonesUser){
            money = money+ phone.getMoney();
        }
        return money;
    }
    public Customer createCustomer(Scanner scanner, Map<String, Phone> phones ){
        System.out.println("Nhập tên khách hàng: ");
        String nameCus = scanner.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();
        int numberPhone = 0;
        boolean check = true;

        while (check){
            try{
                System.out.println("Nhập số điện thoại:");
                numberPhone = Integer.parseInt(scanner.nextLine());
                check = false;
            }catch (Exception e ){
                System.out.println("Lỗi dữ liệu "+e.getMessage() +"Nhập lại!");
            }
        }
        System.out.println("NHẬP DANH SÁCH ĐIỆN THOẠI KHÁCH HÀNG ĐÃ DÙNG");
        phoneUser(scanner,phones );
        billPhone(scanner,phoneUser(scanner,phones));
        return  new Customer(nameCus,address, numberPhone, phones,billPhone(scanner, phoneUser(scanner,phones)) );
    }
    public void addCustomer(Scanner scanner, Map<String, Customer> customers,Map<String, Phone> phones ){
        Customer customer = createCustomer(scanner, phones);
        customers.put(customer.getNameCus(), customer);
    }
    public void remove (Scanner scanner, Map<String, Customer> customers   ){
        System.out.println("Nhập tên khách hàng cần xóa");
        String name = scanner.nextLine();
        for(Customer customer: customers.values()){
            if(name == customer.getNameCus()){
                customers.remove(name, customer);
            }else {
                System.out.println("Không tìm thấy tên khách hàng cần xóa");
            }

        }
    }
    public  void search(Scanner scanner, Map<String, Customer> customers){
        List<Customer> customersSearch = new ArrayList<>();
        System.out.println("Nhập tên người dùng cần tìm kiếm");
        String name = scanner.nextLine();
        int phoneNumber=0;
        try {
            System.out.println("Nhập số điện thoại khách hàng cần tìm kiếm");
            phoneNumber = Integer.parseInt(scanner.nextLine());

        }catch (Exception e){
            System.out.println("Lỗi dữ liệu "+e.getMessage());
        }
        for(Customer customer: customers.values()){
            if(name == customer.getNameCus() || phoneNumber ==customer.getNumberPhone()){
                customersSearch.add(customer);
            }
        }
        System.out.println("Danh sách khách hàng cần tìm" +customersSearch);
    }
}
