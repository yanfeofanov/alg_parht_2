package sky.pro.alg.parth2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringListImplTest {

    private IntegerListImpl stringList = new IntegerListImpl(5);

    @BeforeEach
    public void list(){
        stringList.add(1);
        stringList.add(2);
        stringList.add(3);
        stringList.add(4);
        stringList.add(5);
    }

    @AfterEach
    public void cleanList(){
        stringList.clear();
    }

    @Test
    public void addPositive(){
        int size = stringList.size();
        Assertions.assertEquals(6,stringList.add(6));
        Assertions.assertEquals(size +1,stringList.size());
    }

    @Test
    public void addIndexPositive(){
        int index = 1;
        int size = stringList.size();
        Assertions.assertEquals(6,stringList.add(index,6));
        Assertions.assertEquals(index,stringList.indexOf(6));
        Assertions.assertEquals(size+1,stringList.size());
    }

    @Test
    public void removePositive(){
        int size = stringList.size();
        Assertions.assertEquals(2,stringList.remove(2));
        Assertions.assertEquals(size - 1,stringList.size());
    }

    @Test
    public void removeIndexPositive(){
        int size = stringList.size();
        Assertions.assertEquals("name3",stringList.remove(2));
        Assertions.assertEquals(size - 1, stringList.size());
    }

    @Test
    public void removeNegativeTest(){
        Assertions.assertThrows(NullItemException.class,()->stringList.remove(-1));
    }


    @Test
    public void setPositive(){
        Assertions.assertEquals(3,stringList.set(2,3));
    }

    @Test
    public void contPositive(){

    }

}
