package jp.co.ysk.pepper.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.ysk.pepper.dto.ReceptionDto;
import jp.co.ysk.pepper.entity.TrnReception;
import jp.co.ysk.pepper.service.ReceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ko-aoki on 2015/12/23.
 */
@Controller
@RequestMapping("/reception")
public class ReceptionController {

	@Autowired
	ReceptionService service;
	
    @RequestMapping(method = RequestMethod.GET)
    String displayHandling(Model model) {
    	
    	List<TrnReception> recs = service.findReceptionByWindowId("1");
    	
       	// TODO : マッピングをdozerとか
    	RecpetionForm frm = new RecpetionForm();
    	List<ReceptionDto> receptionList = new ArrayList<>();
    	ReceptionDto work = new ReceptionDto();
    	for (TrnReception rec :recs) {
    		if (Arrays.asList("1","2","3").contains(rec.getStatusCd())) {
    			work.setDisplayId(rec.getDisplayId());
    			work.setStatusCd(rec.getStatusCd());
    		} else {
    	    	ReceptionDto dto = new ReceptionDto();
    			dto.setDisplayId(rec.getDisplayId());
    			dto.setStatusCd(rec.getStatusCd());
    			receptionList.add(dto);
    		}
    		
    	}
    	
    	frm.setWorkingReception(work);
    	frm.setReceptionList(receptionList);
    	
    	model.addAttribute("reception", frm);
    	return "/reception/receive";
    }

    @RequestMapping(value = "smalldisplay", method = RequestMethod.GET)
    String displaySmall(Model model) {
    	
    	List<TrnReception> recs = service.findReceptionByWindowId("1");
    	
       	// TODO : マッピングをdozerとか
    	SmallDisplayForm frm = new SmallDisplayForm();
    	List calledList = new ArrayList<>();
    	List waitingList = new ArrayList<>();
    	for (TrnReception rec :recs) {
    		if ("1".equals(rec.getStatusCd())) {
    			calledList.add(rec.getDisplayId());
    		} else if ("4".equals(rec.getStatusCd())){
    			waitingList.add(rec.getDisplayId());
    		}
    	}
    	
    	frm.setCalledNoList(calledList);
    	frm.setWaitingNoList(waitingList);
    	
    	model.addAttribute("smalldisplay", frm);
    	return "/reception/smalldisplay";
    }

	@RequestMapping(value = "smalldisplayFragment", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	String displaySmallFragment(Model model) {

		List<TrnReception> recs = service.findReceptionByWindowId("1");

		// TODO : マッピングをdozerとか
		SmallDisplayForm frm = new SmallDisplayForm();
		List calledList = new ArrayList<>();
		List waitingList = new ArrayList<>();
		for (TrnReception rec :recs) {
			if ("1".equals(rec.getStatusCd())) {
				calledList.add(rec.getDisplayId());
			} else if ("4".equals(rec.getStatusCd())){
				waitingList.add(rec.getDisplayId());
			}
		}

		frm.setCalledNoList(calledList);
		frm.setWaitingNoList(waitingList);

		model.addAttribute("smalldisplay", frm);
		return "reception/smalldisplay_fragment :: display_content";
	}
}
