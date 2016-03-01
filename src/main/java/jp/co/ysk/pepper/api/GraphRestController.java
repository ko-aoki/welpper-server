package jp.co.ysk.pepper.api;

import jp.co.ysk.pepper.dto.GoogleChartDto;
import jp.co.ysk.pepper.dto.ReceptionDto;
import jp.co.ysk.pepper.service.ReceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ko-aoki on 2015/12/23.
 */
@RestController
@RequestMapping("/api/graph")
public class GraphRestController {

    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("KK:mm:ss");
    private LocalTime startTime;
    private ArrayList<GoogleChartDto> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.startTime = LocalTime.now();
        for(int i=0; i<20; i++) {
            // 0-99の乱数を生成
            ArrayList<GoogleChartDto> xy = new ArrayList<>();
            GoogleChartDto dto = new GoogleChartDto();
            dto.setCheckedTime(
                    this.startTime.plusMinutes(5 * i).format(DTF));
            dto.setVisitorsCnt((int)(Math.random() * 100));
            this.list.add(dto);
        }
    }

    /**
     * 訪問者数グラフ描画データを返却します.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<GoogleChartDto> getGraph() {

        GoogleChartDto dto = new GoogleChartDto();
        dto.setCheckedTime(LocalTime.now().format(DTF));
        dto.setVisitorsCnt((int)(Math.random() * 100));

        this.list.add(dto);
        return this.list.subList(this.list.size() - 20, this.list.size());
    }

}
