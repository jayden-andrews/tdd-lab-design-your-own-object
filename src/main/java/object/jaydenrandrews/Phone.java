package object.jaydenrandrews;

public class Phone {
    private String brand;
    private String model;
    private int storageGB;
    private boolean isOn;
    private int batteryLife;

    public Phone(String brand, String model, int storageGB, int batteryLife) {
        if (storageGB <= 0) {
            throw new IllegalArgumentException("Storage must be positive");
        }
        if (batteryLife < 0 || batteryLife > 100) {
            throw new IllegalArgumentException("Battery must be between 0 and 100");
        }

        this.brand = brand;
        this.model = model;
        this.storageGB = storageGB;
        this.isOn = false;
        this.batteryLife = batteryLife;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOn() {
        return isOn;
    }

    public void powerOn() {
        this.isOn = true;
    }

    public void powerOff() {
        this.isOn = false;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public void charge(int amount) {
        int newCharge = amount + this.getBatteryLife();
        this.batteryLife = Math.min(newCharge, 100);
    }

    public void useBattery(int amount) {
        int newCharge = this.getBatteryLife() - amount;
        this.batteryLife = Math.max(0, newCharge);
    }

    public int getBatteryLife() {
        return batteryLife;
    }
}
