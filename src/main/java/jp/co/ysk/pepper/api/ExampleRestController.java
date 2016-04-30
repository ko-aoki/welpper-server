package jp.co.ysk.pepper.api;

import jp.co.ysk.pepper.dto.ExampleDto;
import jp.co.ysk.pepper.dto.StatusChangeDto;
import jp.co.ysk.pepper.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ko-aoki on 2015/12/23.
 */
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    ReceptionService service;

    @RequestMapping(method = RequestMethod.GET)
    ExampleDto getMessage(StatusChangeDto dto) {

        System.out.println("received " + dto.getDisplayId());
        service.changeState(dto.getDisplayId(), dto.getStatusCd());

        template.convertAndSend("/topic/stateChanged", new StatusChangeDto());

        ExampleDto exDto = new ExampleDto();
        exDto.setMessage("Pepperです！");

        return exDto;
    }

}
