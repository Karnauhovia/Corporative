package com.real.project.entity;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "transfers")
public class Transfers implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name = "cash_id")
    private Long cash_id;

    @Column(name = "pay_date")
    private String pay_date;

    @Column(name = "cash_pay")
    private float cash_pay;

    @Column(name = "cash_dinners")
    private float cash_dinners;

    @Column(name = "cash_taxes")
    private float cash_taxes;

    @Column(name = "cash_overtimes")
    private float cash_overtimes;

    @Column(name = "cash_bonus")
    private float cash_bonus;

    @Column(name = "cash_another")
    private float cash_another;

    @Column(name = "cash_salary")
    private float cash_salary;


    @Column(name = "cash_count")
    private float cash_count;

    @Column(name = "cash_balance")
    private float cash_balance;

    @Column(name = "cash_course")
    private float cash_course;


    public Transfers() {
    }

    public float getCash_course() {
        return cash_course;
    }

    public void setCash_course(float cash_course) {
        this.cash_course = cash_course;
    }

    public float getCash_balance() {
        return cash_balance;
    }

    public void setCash_balance(float cash_balance) {
        this.cash_balance = cash_balance;
    }

    public float getCash_count() {
        return cash_count;
    }

    public void setCash_count(float cash_count) {
        this.cash_count = cash_count;
    }

    public float getCash_salary() {
        return cash_salary;
    }

    public void setCash_salary(float cash_salary) {
        this.cash_salary = cash_salary;
    }

    public float getCash_dinners() {
        return cash_dinners;
    }

    public void setCash_dinners(float cash_dinners) {
        this.cash_dinners = cash_dinners;
    }

    public float getCash_taxes() {
        return cash_taxes;
    }

    public void setCash_taxes(float cash_taxes) {
        this.cash_taxes = cash_taxes;
    }

    public float getCash_overtimes() {
        return cash_overtimes;
    }

    public void setCash_overtimes(float cash_overtimes) {
        this.cash_overtimes = cash_overtimes;
    }

    public float getCash_bonus() {
        return cash_bonus;
    }

    public void setCash_bonus(float cash_bonus) {
        this.cash_bonus = cash_bonus;
    }

    public float getCash_another() {
        return cash_another;
    }

    public void setCash_another(float cash_another) {
        this.cash_another = cash_another;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCash_id() {
        return cash_id;
    }

    public void setCash_id(Long cash_id) {
        this.cash_id = cash_id;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public float getCash_pay() {
        return cash_pay;
    }

    public void setCash_pay(float cash_pay) {
        this.cash_pay = cash_pay;
    }


    @Override
    public String toString() {
        return "{" +
                "person=" + person +
                ", id=" + id +
                ", cash_id=" + cash_id +
                ", pay_date='" + pay_date + '\'' +
                ", cash_pay=" + cash_pay +
                ", cash_dinners=" + cash_dinners +
                ", cash_taxes=" + cash_taxes +
                ", cash_overtimes=" + cash_overtimes +
                ", cash_bonus=" + cash_bonus +
                ", cash_another=" + cash_another +
                ", cash_salary=" + cash_salary +
                ", cash_count=" + cash_count +
                ", cash_balance=" + cash_balance +
                ", cash_course=" + cash_course +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


}
