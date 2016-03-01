/**
 * Created by ko-aoki on 2016/02/06.
 */
google.charts.load('current', {packages: ['corechart']});

var graphData = [];
// グラフ描画
var draw = function () {
    var data = new google.visualization.DataTable();
    data.addColumn('string', '時間');
    data.addColumn('number', '訪問者数');
    data.addRows(graphData);
    var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

    var options = {
        // 設定しないとX軸のラベル表示が消失。。
        chartArea: {
            top: 20,
            height: '50%'
        },
        hAxis: {
            title: '時間'
        },
        vAxis: {
            title: '訪問者数'
        }
    };
    chart.draw(data, options);
};
// データ取得
var getGraphData = function () {
    $.ajax("api/graph")
        .done(function (data) {
            for (var i = 0; i < data.length; i++) {
                var visitorsCnt =[];
                visitorsCnt[0] = data[i].checkedTime;
                visitorsCnt[1] = data[i].visitorsCnt;
                graphData[i] = visitorsCnt;
            }
            draw();
        })
        .fail(function () {
            console.log("error");
        });
};
setInterval(getGraphData, 1000);
