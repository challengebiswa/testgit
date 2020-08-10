

import static org.junit.Assert.assertEquals;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.Defaults;

/**
 * Junit Test automate for setter and getter methods.
 *
 */

public class GetterSetterTest<T> {

    private Class<T> clsType;

    private GetterSetterTest( final Class<T> clsType) {
        this.clsType = clsType;
    }


    /**
     * Verify setters and getters
     */
    public void verifySetterGetter() {
        try {
            final BeanInfo beanInfo = Introspector.getBeanInfo(clsType);
            final PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();

            for (final PropertyDescriptor property : properties) {
                if (checkProperty(property)) {
                    testProperty(property);
                }
            }
        } catch (final Exception e) {
        	//e.printStackTrace();
            throw new AssertionError(e.getMessage());
        }
    }

    private boolean checkProperty(final PropertyDescriptor property) {
        if (property.getWriteMethod() == null || property.getReadMethod() == null) {
            return false;
        } else
        	return true;
    }

    /**
     * Test an individual property by getting the read method and write method
     * and passing the default value for the type to the setter and asserting
     * that the same value was returned.
     *
     * @param property The property that we are testing.
     *
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    private void testProperty( final PropertyDescriptor property) throws IllegalAccessException,
                                                                                 InstantiationException,
                                                                                 InvocationTargetException {
    	final Object target =  clsType.newInstance();
        final Object setValue = Defaults.defaultValue(property.getPropertyType());

        final Method getter = property.getReadMethod();
        final Method setter = property.getWriteMethod();

        setter.invoke(target, setValue);
        final Object getValue = getter.invoke(target);

        assertEquals(
            property.getDisplayName() + " getter / setter mismatch.",
            setValue, getValue
        );
    }

    /**
     * Factory method for easily creating a test for the getters and setters.
     *
     * @param type The class that we are testing the getters and setters for.
     * @return An object that can be used for testing the getters and setters
     * of a class.
     */
    public static <T> GetterSetterTest<T> loadClass(final Class<T> type) {
        return new GetterSetterTest<T>(type);
    }
}

