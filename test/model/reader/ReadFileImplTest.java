package model.reader;

import by.epam.task01.model.exception.ReadDataException;
import by.epam.task01.model.reader.ReadFile;
import by.epam.task01.model.reader.impl.ReadFileImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ReadFileImplTest {
    private ReadFile reader;

    @BeforeClass
    public void init(){
        reader = ReadFileImpl.getInstance();
    }

    @Test(description = "read data from file")
    public void testReadDataTxtSuccessfully() throws ReadDataException {

        List<String> expected = Arrays.asList("0.77 6 1.34","0 -6 0","1.732 0 3","0 2 1",
                "1 2 -2","9 2 -2","5 8.93 -2","5 4.31 4.532",
                "1 2 -2","9 2 -2","5 d.93 -2","5 4.31 4.532",
                "0.577 0 1.634","0 -1 0","1.732 0 0","0 1 0",
                "0.577 0 df4","0 -1 0","1.732 0 0","0 1 0",
                "0 1.634","0 -1 0","1.732 0 0","0 1 0");

        List<String> actual = reader.readDataTxt("resource/data.txt");
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "file is not exist or empty", expectedExceptions = ReadDataException.class)
    public void testFileExistence() throws ReadDataException {
        List<String> actual = reader.readDataTxt("resource/another.txt");
    }


}
