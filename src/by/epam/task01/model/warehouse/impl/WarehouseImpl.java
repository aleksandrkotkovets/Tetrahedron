package by.epam.task01.model.warehouse.impl;

import by.epam.task01.model.entity.TetrahedronCharacteristic;
import by.epam.task01.model.warehouse.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class WarehouseImpl implements Warehouse {
    private static final WarehouseImpl INSTANCE = new WarehouseImpl();

    private  WarehouseImpl() {}

    public static WarehouseImpl getInstance() {
        return INSTANCE;
    }


    List<TetrahedronCharacteristic> records = new ArrayList<>();

    @Override
    public void addRecord(TetrahedronCharacteristic record) {
        records.add(record);
    }

    @Override
    public void removeRecord(TetrahedronCharacteristic record) {
        records.remove(record);
    }

    @Override
    public void updateRecord(TetrahedronCharacteristic record) {
        for (TetrahedronCharacteristic recordPrev : records){
            if(recordPrev.getId() == record.getId()) {
                removeRecord(recordPrev);
                break;
            }
        }
        addRecord(record);
    }

    @Override
    public List<TetrahedronCharacteristic> getAllRecords() {
        return records;
    }
}
