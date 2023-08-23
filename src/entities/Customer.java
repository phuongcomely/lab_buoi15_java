package entities;

import java.util.Map;

public class Customer {
    private  String nameCus;
    private String address;
    private int numberPhone;
    private Map<String, Phone> phones;
    private double money;

    public Customer(String nameCus, String address, int numberPhone, Map<String, Phone> phones, double money) {
        this.nameCus = nameCus;
        this.address = address;
        this.numberPhone = numberPhone;
        this.phones = phones;
        this.money = money;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nameCus='" + nameCus + '\'' +
                ", address='" + address + '\'' +
                ", numberPhone=" + numberPhone +
                ", phones=" + phones +
                ", money=" + money +
                '}';
    }
}
