package jp.co.ysk.pepper.service;

import java.util.List;

import jp.co.ysk.pepper.entity.TrnReception;
import jp.co.ysk.pepper.repository.TrnReceptionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author ko-aoki
 *
 */
@Service
@Transactional
public class ReceptionService {

    @Autowired 
    private TrnReceptionRepository trnRecptionRep;

	public List<TrnReception> findReceptionByWindowId(String windowId) {
		return trnRecptionRep.selectByWindowId(windowId);
	}

	public void changeState(String displayId, String statusCd) {
		TrnReception trnRecep = trnRecptionRep.selectByDisplayId(Integer.valueOf(displayId));
		trnRecep.setStatusCd(statusCd);
	}

}
