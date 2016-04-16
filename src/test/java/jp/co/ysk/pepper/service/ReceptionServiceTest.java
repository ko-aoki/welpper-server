package jp.co.ysk.pepper.service;

import jp.co.ysk.pepper.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by ko-aoki on 2016/04/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// アプリケーションクラスを指定
@SpringApplicationConfiguration(DemoApplication.class)
@WebIntegrationTest
public class ReceptionServiceTest {
    @Autowired
    ReceptionService service;

    @Test
    public void testNumbering() throws Exception {
        int numbering = service.numbering();
        assertEquals(numbering + 1, service.numbering());
    }
}