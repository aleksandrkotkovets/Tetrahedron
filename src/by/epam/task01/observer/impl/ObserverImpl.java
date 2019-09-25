package by.epam.task01.observer.impl;

import by.epam.task01.entity.TetrahedronCharacteristic;
import by.epam.task01.action.TetrahedronAction;
import by.epam.task01.entity.Tetrahedron;
import by.epam.task01.observer.Observer;
import by.epam.task01.warehouse.Warehouse;
import by.epam.task01.warehouse.impl.WarehouseImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class ObserverImpl implements Observer {

    private static final Logger LOGGER = LogManager.getLogger(Observer.class);


    @Override
    public void update(Tetrahedron tetrahedron) {
        LOGGER.info("\n**********************************\n"
                + ", we have some changes: " + tetrahedron
                + "\n**************************************");

        TetrahedronAction action = new TetrahedronAction();
        long id = tetrahedron.getId();
        double square = action.calcSquare(tetrahedron);
        double volume = action.calcVolume(tetrahedron);
        double perimeter = action.calcPerimeter(tetrahedron);

        Warehouse warehouse = WarehouseImpl.getInstance();
        warehouse.updateRecord(new TetrahedronCharacteristic(id, square, volume, perimeter));

    }
}
