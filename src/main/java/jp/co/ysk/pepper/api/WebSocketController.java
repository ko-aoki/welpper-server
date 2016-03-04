package jp.co.ysk.pepper.api;

import jp.co.ysk.pepper.dto.StatusChangeDto;
import jp.co.ysk.pepper.service.ReceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ko-aoki on 2016/02/14.
 */
@RestController
public class WebSocketController {
	
	@Autowired
	ReceptionService service;

    @MessageMapping(value = "/changeState" /* 宛先名 */) // Controller内の@MessageMappingアノテーションをつけたメソッドが、メッセージを受け付ける
    @SendTo(value = "/topic/stateChanged") // 処理結果の送り先
    StatusChangeDto changeState(StatusChangeDto dto) {
    	
        System.out.println("received " + dto.getDisplayId());
        service.changeState(dto.getDisplayId(), dto.getStatusCd());
        return dto;
    }
}
