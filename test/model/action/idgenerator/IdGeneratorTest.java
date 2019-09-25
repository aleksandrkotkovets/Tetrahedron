package model.action.idgenerator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static by.epam.task01.idgenerator.IdGenerator.nextId;

public class IdGeneratorTest {

    @Test
    public void testIdGenerator(){
        long expected = 432;
        long actual = nextId();
        Assert.assertEquals(expected,actual);
    }

}
