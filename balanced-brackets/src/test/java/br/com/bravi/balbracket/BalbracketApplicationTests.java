package br.com.bravi.balbracket;

import br.com.bravi.balbracket.controllers.BracketController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BalbracketApplicationTests {

    @Autowired
    private BracketController controller;


    @Test
    void contextLoads() throws Exception{
    }

}
