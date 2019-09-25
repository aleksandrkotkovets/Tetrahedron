package by.epam.task01.model.warehouse;

import by.epam.task01.model.entity.TetrahedronCharacteristic;

import java.util.List;

public interface Warehouse {

    void addRecord(TetrahedronCharacteristic record);

    void removeRecord(TetrahedronCharacteristic record);

    void updateRecord(TetrahedronCharacteristic record);

    List<TetrahedronCharacteristic> getAllRecords();


}
