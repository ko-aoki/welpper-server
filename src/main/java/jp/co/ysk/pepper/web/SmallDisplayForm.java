package jp.co.ysk.pepper.web;

import java.util.List;

import jp.co.ysk.pepper.dto.ReceptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 掲示板(小)画面のフォームクラス.
 * @author ko-aoki
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallDisplayForm {

	/**
	 * 呼出番号
	 */
	private List<Integer> calledNoList;
	
	/**
	 * 待機番号
	 */
	private List<Integer> waitingNoList;
}
