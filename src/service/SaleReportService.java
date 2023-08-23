package service;

import entities.Customer;
import entities.Phone;
import entities.SalesReport;

import java.util.*;

public class SaleReportService {

    public void createrBill(Scanner scanner, Map<String, Customer> customers, CustomerManager customerManager){
        Map<String, Double> saleByCustomer = new HashMap<>();
        Map<String, Phone> phones = new HashMap<>();
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        int numberPhone = 0;
        try{
            System.out.println("Nhập số điện thoại khách hàng: ");
            numberPhone = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Lỗi");
        }
        System.out.println("Mặt hàng điện thoại đã mua: ");
        String namePhone = scanner.nextLine();

        System.out.println("Nhập số lượng điện thoại mua: ");
        int quantitySale = Integer.parseInt(scanner.nextLine());
        System.out.println("Số tiền bạn cần thanh toán: ");
        double price =0;
        for(Phone phone: phones.values()){
            if(namePhone ==phone.getName()){
                price = phone.getMoney()*quantitySale;
            }
        }

        for(Customer customer: customers.values()){
            if(numberPhone == customer.getNumberPhone()){
                customerManager.phoneUser(scanner, phones); //Nhập số điện thoại đã mua
                System.out.println(customer);
            }else {
                customerManager.addCustomer(scanner, customers,phones);
            }
        }
        saleByCustomer.put(name, price);
    }
    public  void removeBill(Scanner scanner, Map<String, Customer> customers){
        List<Phone> phoneUser = new ArrayList<>();
        int numberPhone = 0;
        try{
            System.out.println("Nhập số điện thoại khách hàng muốn trả hàng: ");
            numberPhone = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.println("Lỗi");
        }
        int count = 0;
        for(Customer customer1: customers.values()) {
            if (numberPhone == customer1.getNumberPhone()) {
                System.out.println("Nhập loại điện thoại muốn trả: ");
                String namePhone = scanner.nextLine();
                for (Phone phone1 : phoneUser) {
                    if (namePhone == phone1.getName()) {
                        count = count + 1;
                        phoneUser.remove(phone1);
                        double salesPrice = customer1.getMoney() - (phone1.getMoney()*count);
                        int quantity = phone1.getQuantity()-count;
                        phone1.setQuantity(quantity);
                        customer1.setMoney(salesPrice);
                        System.out.println("Cập nhật thông tin khách hàng "+customer1);

                    }

                }
            }else {
                System.out.println("Số điện thoại chưa tổn tại trong hệ thống!");
            }
        }
    }
}
