package jp.co.ysk.pepper.api;

import org.springframework.web.bind.annotation.RestController;
import jp.co.ysk.pepper.dto.ExampleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ko-aoki on 2015/12/23.
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @RequestMapping(method = RequestMethod.GET)
    ExampleDto getMessage() {

        ExampleDto dto = new ExampleDto();
        dto.setMessage("Pepperです！");

        return dto;
    }

}
