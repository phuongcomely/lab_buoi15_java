package entities;

public class Phone {
    private String name;
    private String Company;
    private String comment;
    private double money;
    private int quantity;

    public Phone(String name, String company, String comment, double money, int quantity) {
        this.name = name;
        Company = company;
        this.comment = comment;
        this.money = money;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", Company='" + Company + '\'' +
                ", comment='" + comment + '\'' +
                ", money=" + money +
                ", quantity=" + quantity +
                '}';
    }
}
