package object.jaydenandrews;

import object.jaydenrandrews.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {
    @Test
    public void constructor_HappyPath_ShouldInitializeFieldsCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act
        Phone phone = new Phone(brand, model, storageGB, batteryLife);

        // Assert
        assertEquals(brand, phone.getBrand());
        assertEquals(model, phone.getModel());
        assertEquals(storageGB, phone.getStorageGB());
        assertEquals(batteryLife, phone.getBatteryLife());
    }

    @Test
    public void assertInvalidStorage() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> { new Phone("Samsung", "Galaxy S21", -1, 100);
        });
    }

    @Test
    public void assertInvalidBatteryLifeLessThan() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = -1;
        int batteryLife = 75;
        boolean isOn = false;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> { new Phone("Samsung", "Galaxy S21", 128, -1);
        });
    }

    @Test
    public void assertInvalidBatteryGreaterThan() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = -1;
        int batteryLife = 75;
        boolean isOn = false;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> { new Phone("Samsung", "Galaxy S21", 128, 101);
        });
    }

    @Test
    public void assertSettersWorkCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act
        Phone phone = new Phone(brand, model, storageGB, batteryLife);
        phone.setBrand("Samsung");
        phone.setStorageGB(256);
        phone.setModel("Galaxy S20");

        // Assert
        assertEquals("Samsung", phone.getBrand());
        assertEquals("Galaxy S20", phone.getModel());
        assertEquals(256, phone.getStorageGB());
    }

    @Test
    public void assertPowerOnWorksCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act
        Phone phone = new Phone(brand, model, storageGB, batteryLife);
        phone.powerOn();

        // Assert
        assertTrue(phone.isOn());
    }

    @Test
    public void assertPowerOffWorksCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act
        Phone phone = new Phone(brand, model, storageGB, batteryLife);
        phone.powerOn();
        phone.powerOff();

        // Assert
        assertFalse(phone.isOn());
    }

    @Test
    public void assertChargeWorksCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act & Assert
        Phone phone = new Phone(brand, model, storageGB, batteryLife);
        phone.charge(24);

        assertEquals(99, phone.getBatteryLife());
        phone.charge(24);
        assertEquals(100, phone.getBatteryLife());
    }

    @Test
    public void assertUseBatteryLifeWorksCorrectly() {
        // Arrange
        String brand = "Apple";
        String model = "iPhone 14";
        int storageGB = 128;
        int batteryLife = 75;

        // Act & Assert
        Phone phone = new Phone(brand, model, storageGB, batteryLife);
        phone.useBattery(25);

        assertEquals(50, phone.getBatteryLife());
        phone.useBattery(100);
        assertEquals(0, phone.getBatteryLife());
    }
}
