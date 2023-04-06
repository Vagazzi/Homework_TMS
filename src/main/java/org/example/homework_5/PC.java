package org.example.homework_5;

//todo solve this too
public class PC {

    private HDD hddStorage;
    private RAM ramStick;

    private String PCModel;
    private double price;

    public PC(String PCModel, double price) {
        this.PCModel = PCModel;
        this.price = price;
        hddStorage = new HDD();
        ramStick = new RAM();
    }

    public PC(HDD hddStorage, RAM ramStick, String PCModel, double price) {
        this.hddStorage = hddStorage;
        this.ramStick = ramStick;
        this.PCModel = PCModel;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PC{" +
                "hddStorage=" + hddStorage +
                ", ramStick=" + ramStick +
                ", PCModel='" + PCModel + '\'' +
                ", price=" + price +
                '}';
    }
}
