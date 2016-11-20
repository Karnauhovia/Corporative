package com.real.project.entity;


import javax.persistence.*;


@Entity
@Table(name = "person")
public class Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name2")
    private String name2;

    @Column(name = "name3")
    private String name3;

    @Column(name = "department")
    private String department;

    @Column(name = "position")
    private String position;

    @Column(name = "cash_date")
    private String cash_date;

    @Column(name = "date_recruit")
    private String date_recruit;

    @Column(name = "comments")
    private String comments;

    @Column(name = "dinners")
    private float dinners;

    @Column(name = "taxes")
    private float taxes;

    @Column(name = "overtimes")
    private float overtimes;

    @Column(name = "bonus")
    private float bonus;

    @Column(name = "another")
    private float another;

    @Column(name = "cash_back_uah")
    private float cash_back_uah;

    @Column(name = "cash_back_usd")
    private float cash_back_usd;


    @Column(name = "rate")
    private float rate;

    @Column(name = "count")
    private float count;

    @Column(name = "shows")
    private int shows;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCash_date() {
        return cash_date;
    }

    public void setCash_date(String cash_date) {
        this.cash_date = cash_date;
    }

    public String getDate_recruit() {
        return date_recruit;
    }

    public void setDate_recruit(String date_recruit) {
        this.date_recruit = date_recruit;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public float getCash_back_uah() {
        return cash_back_uah;
    }

    public void setCash_back_uah(float cash_back_uah) {
        this.cash_back_uah = cash_back_uah;
    }

    public float getCash_back_usd() {
        return cash_back_usd;
    }

    public void setCash_back_usd(float cash_back_usd) {
        this.cash_back_usd = cash_back_usd;
    }

    public float getDinners() {
        return dinners;
    }

    public void setDinners(float dinners) {
        this.dinners = dinners;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public float getOvertimes() {
        return overtimes;
    }

    public void setOvertimes(float overtimes) {
        this.overtimes = overtimes;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getAnother() {
        return another;
    }

    public void setAnother(float another) {
        this.another = another;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public int getShows() {
        return shows;
    }

    public void setShows(int shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", cash_date=" + cash_date +
                ", date_recruit='" + date_recruit + '\'' +
                ", comments='" + comments + '\'' +
                ", cash_back=" + cash_back_uah +
                ", cash_back=" + cash_back_usd +
                ", rate=" + rate +
                ", count=" + count +
                '}';
    }

}
