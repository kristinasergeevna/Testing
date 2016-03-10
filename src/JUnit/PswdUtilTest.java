package JUnit;

import JUnit.PswdUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Кристина on 9.03.2016.
 */
public class PswdUtilTest {

    @Test
    public void testPasswsCorrect(){
        boolean isCorrect= PswdUtil.validatePassword("Password1");
        Assert.assertEquals(true, isCorrect);
    }

    @Test
    public void testThreeSameSymbols() {
        boolean isCorrect= PswdUtil.validatePassword("Password111");
        Assert.assertEquals(false, isCorrect);
    }

    @Test
    public void testPasswordsLength(){
        boolean isCorrect=PswdUtil.validatePassword("Pass");
        Assert.assertEquals(false, isCorrect);
    }

    @Test
    public void testContentPassword(){
        boolean isCorrect=PswdUtil.validatePassword("password1");
        Assert.assertEquals(false, isCorrect);
    }

    @Test
    public void testPasswordsSigns(){
        boolean isCorrect=PswdUtil.validatePassword("Password1!");
        Assert.assertEquals(false, isCorrect);
    }

    @Test(expected = NullPointerException.class)
    public void testPasswordsNull(){
        PswdUtil.validatePassword(null);
    }
}
