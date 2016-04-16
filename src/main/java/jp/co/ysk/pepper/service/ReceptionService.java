package jp.co.ysk.pepper.service;

import java.util.List;

import jp.co.ysk.pepper.entity.TrnNumbering;
import jp.co.ysk.pepper.entity.TrnReception;
import jp.co.ysk.pepper.repository.TrnNumberingRepository;
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

	@Autowired
	private TrnNumberingRepository trnNumberingRep;

	public List<TrnReception> findReceptionByWindowId(String windowId) {
		return trnRecptionRep.selectByWindowId(windowId);
	}

	public void changeState(String displayId, String statusCd) {
		TrnReception trnRecep = trnRecptionRep.selectByDisplayId(Integer.valueOf(displayId));
		trnRecep.setStatusCd(statusCd);
	}

	/**
	 * 採番します.
	 */
	public int numbering() {
		List<TrnNumbering> numberings = trnNumberingRep.findAll();
		if (numberings.isEmpty()) {
			throw new RuntimeException("採番テーブルにレコードなし");
		}
		if (numberings.size() > 1) {
			throw new RuntimeException("採番テーブルに複数レコード");
		}
		TrnNumbering numbering = numberings.get(0);
		// カウントアップ
		numbering.setDisplayId(numbering.getDisplayId() + 1);

		return numbering.getDisplayId();
	}
}
