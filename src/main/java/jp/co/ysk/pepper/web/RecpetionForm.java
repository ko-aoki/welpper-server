package jp.co.ysk.pepper.web;

import java.util.List;

import jp.co.ysk.pepper.dto.ReceptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 受付業務画面のフォームクラス.
 * @author ko-aoki
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecpetionForm {

	/**
	 * 対応中受付
	 */
	private ReceptionDto workingReception;
	
	/**
	 * 対応待ち受付
	 */
	private List<ReceptionDto> receptionList;
}
