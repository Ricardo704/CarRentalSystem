package org.example.utils;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import static org.junit.Assert.*;

/**
 * Test methods in InputUtil class.
 */
public class InputUtilTest {

    @Test
    public void testGetRentDay() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(InputUtil.getRentDay(new Date[]{simpleDateFormat.parse("01/08/2022"),
                simpleDateFormat.parse("05/08/2022")}), 5);
    }

    @Test
    public void checkEmail() {
        assertTrue(InputUtil.checkEmail("ricardo704@hotmail.com"));
        assertFalse(InputUtil.checkEmail("cardosdf.com"));
    }
}

