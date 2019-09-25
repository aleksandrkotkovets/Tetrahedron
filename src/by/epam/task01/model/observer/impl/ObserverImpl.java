package by.epam.task01.model.observer.impl;

import by.epam.task01.model.action.TetrahedronAction;
import by.epam.task01.model.entity.Tetrahedron;
import by.epam.task01.model.entity.TetrahedronCharacteristic;
import by.epam.task01.model.observer.Observer;
import by.epam.task01.model.warehouse.Warehouse;
import by.epam.task01.model.warehouse.impl.WarehouseImpl;
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
