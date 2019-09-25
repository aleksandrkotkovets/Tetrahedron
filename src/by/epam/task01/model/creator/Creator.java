package by.epam.task01.model.creator;


import by.epam.task01.model.entity.Point;
import by.epam.task01.model.entity.Tetrahedron;
import by.epam.task01.model.entity.TetrahedronCharacteristic;
import by.epam.task01.model.exception.ReadDataException;
import by.epam.task01.model.reader.ReadFile;
import by.epam.task01.model.reader.impl.ReadFileImpl;
import by.epam.task01.model.repository.TetraRepository;
import by.epam.task01.model.repository.impl.TetraRepositoryImpl;
import by.epam.task01.model.validator.TetrahedronValidator;
import by.epam.task01.model.validator.impl.TetrahedronValidatorImpl;
import by.epam.task01.model.warehouse.Warehouse;
import by.epam.task01.model.warehouse.impl.WarehouseImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.epam.task01.model.parser.DataParser.parsPoints;

public class Creator {

    private static final Logger LOGGER = LogManager.getLogger(Creator.class);

    private static final Creator INSTANCE = new Creator();

    private Creator() {
    }

    public static Creator getInstance() {
        return INSTANCE;
    }

    private ReadFile read = ReadFileImpl.getInstance();
    private TetrahedronValidator validator = TetrahedronValidatorImpl.getInstance();
    private Warehouse warehouse = WarehouseImpl.getInstance();
    private TetraRepository repository = new TetraRepositoryImpl();

    public List<Tetrahedron> createListOfTetrahedronsFromFile(String path) {
        List<String> strings = this.getDataFromFile(path);
        List<Tetrahedron> tetrahedrons = this.createListOfTetrahedronsFromStrings(strings);
        return tetrahedrons;
    }


    public List<String> getDataFromFile(String path) {
        try {
            List<String> strings = read.readDataTxt(path);
            return strings;
        } catch (ReadDataException e) {
            LOGGER.fatal(e);
            throw new RuntimeException(e);
        }
    }

    public List<Tetrahedron> createListOfTetrahedronsFromStrings(List<String> allLines) {

        Tetrahedron tetrahedron;

        List<Tetrahedron> tetrahedronList = new ArrayList<>();
        List<String> resultLines = new ArrayList<>(validator.checkReadData(allLines));
        List<Point> pointList = parsPoints(resultLines);

        int count = resultLines.size() % 4;
        int size = pointList.size();

        while (size > count) {
            tetrahedron = Tetrahedron.createTetrahedron(pointList.get(0), pointList.get(1), pointList.get(2), pointList.get(3));
            tetrahedronList.add(tetrahedron);
            repository.addTetrahedron(tetrahedron);

            pointList.remove(0);
            pointList.remove(0);
            pointList.remove(0);
            pointList.remove(0);
            size -= 4;
        }

        LOGGER.info("Tetrahedrons was created.");
        return tetrahedronList;
    }

    void addRecordToTheWarehouse(Tetrahedron tetrahedron) {
        warehouse.addRecord(new TetrahedronCharacteristic(tetrahedron));
    }


}
