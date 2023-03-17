package com.ubb.postuniv.domain;

public class Transaction extends Entity {
    private int idCake;
    private int clientCard;
    private String date;
    private String time;
    private int count;

    public Transaction(int id, int idCake, int clientCard, String date, String time, int count) {
        super(id);
        this.idCake = idCake;
        this.clientCard = clientCard;
        this.date = date;
        this.time = time;
        this.count = count;
    }

    public int getIdCake() {
        return idCake;
    }

    public void setIdCake(int idCake) {
        this.idCake = idCake;
    }

    public int getClientCard() {
        return clientCard;
    }

    public void setClientCard(int clientCard) {
        this.clientCard = clientCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + this.getId() +
                ", idCake=" + idCake +
                ", clientCard=" + clientCard +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", count=" + count +
                '}';
    }
}
