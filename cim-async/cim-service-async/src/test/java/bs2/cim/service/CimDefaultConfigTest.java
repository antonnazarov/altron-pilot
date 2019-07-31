package bs2.cim.service;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * The tests for CimDefaultConfig.
 * 
 * @author Anton Nazarov
 * @since 31/07/2019
 */
public class CimDefaultConfigTest {

    CimDefaultConfig cfg = null;

    @Before
    public void setUp() {
        cfg = new CimDefaultConfig();
        DataSource ds = Mockito.mock(DataSource.class);
        cfg.dataSource = ds;
    }

    @Test
    public void testJdbcOperations() {
        JdbcOperations op = cfg.jdbcOperations();
        assertNotNull(op);
    }
}
