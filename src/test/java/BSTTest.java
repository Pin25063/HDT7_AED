
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    BST<Association<String,String>> bst;

    @Before
    public void SetUp(){
        bst = new BST<>();
    }

    @Test
    public void doesItAddHello(){
        bst.insert(new Association<>("hello","hola"));
        assertNotNull(bst.getRoot());
    }

    @Test
    public void doesItFindHouse(){
        bst.insert(new Association<>("hello","hola"));
        bst.insert(new Association<>("adios","bye"));
        bst.insert(new Association<>("house","casa"));
        bst.insert(new Association<>("roof","techo"));
        Association<String, String> searchKey = new Association<>("house",null);
        Association<String, String> result = bst.contains(searchKey, bst.getRoot());
        assertEquals("casa", result.value);
    }
}