package a;

import com.sas.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: pete
 * Date: 4/13/14
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocalTest {
    @Autowired
    DivisionService divisionService;

    public static void main(String[] args){

        ResourceBundle props = ResourceBundle.getBundle("db");
    }
}
