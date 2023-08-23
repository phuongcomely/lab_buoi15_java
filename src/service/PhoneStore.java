package service;

import entities.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneStore {

    public void addPhone(Scanner scanner, Map<String, Phone> phones) {
        System.out.println("Nhập tên điện thoại");
        String newName = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất ");
        String newCompany = scanner.nextLine();
        System.out.println("Nhập mô tả cho điện thoại");
        String newComment = scanner.nextLine();
        double newMoney = 0;
        int newQuantity = 0;
        boolean check = true;


        while (check) {
            try {
                System.out.println("Nhập giá tiền ");
                newMoney = Double.parseDouble(scanner.nextLine());
                check = false;

            } catch (Exception e) {
                System.out.println("Lỗi dữ liệu: " + e.getMessage());
                System.out.println("Nhập lại");
            }
        }
        check = true;
        while (check) {
            try {
                System.out.println("Nhập số lượng cho loại điện thoại này");
                newQuantity = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Lỗi dữ liệu! Nhập lại");
            }
        }


        Phone phone = new Phone(newName, newCompany, newComment, newMoney, newQuantity);
        phones.put(newName, phone);
    }


    public void removePhone(Scanner scanner, Map<String, Phone> phones) {
        System.out.println("Nhập tên điện thoại cần xóa: ");
        String name = scanner.nextLine();
        phones.remove(name);
    }

    public void SearchPhone(Scanner scanner, Map<String, Phone> phones) {
        System.out.println("Nhập tên điện thoại cần tìm");
        String nameSearch = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất cần tìm kiếm: ");
        String company = scanner.nextLine();

        List<Phone> list = new ArrayList<>();
        for (Phone phone : phones.values()) {
            if (nameSearch == phone.getName() || company == phone.getCompany()) {
               list.add(phone);
                System.out.println(list);
            }
        }
    }
}

