/**
 * Created by ko-aoki on 2016/02/29.
 */
var StompUtil = function(){};
/**
 * エンドポイントへの接続処理
 */
StompUtil.prototype.connect = function () {
    var socket = new WebSocket('ws://' + location.host + '/pepper/endpoint'); // エンドポイントのURL
    this.stompClient = Stomp.over(socket); // WebSocketを使ったStompクライアントを作成
    this.stompClient.connect({}, this.onConnected.bind(this)); // エンドポイントに接続し、接続した際のコールバックを登録
};

/**
 * エンドポイントへ接続したときの処理
 */
StompUtil.prototype.onConnected = function (frame) {
    console.log('Connected: ' + frame);
    // 宛先が'/topic/greetings'のメッセージを購読し、コールバック処理を登録
    this.stompClient.subscribe('/topic/stateChanged', this.onSubscribeStateChanged.bind(this));
};

/**
 * 宛先'/topic/stateChanged'なメッセージを受信したときの処理
 */
StompUtil.prototype.onSubscribeStateChanged = function (message) {
	// TODO リロード処理
	
//    var response = document.getElementById('response');
//    var p = document.createElement('p');
//    p.appendChild(document.createTextNode(message.body));
//    response.insertBefore(p, response.children[0]);
};

/**
 * 宛先'/app/changeState'へのメッセージ送信処理
 */
StompUtil.prototype.sendChangeState = function (param) {
    this.stompClient.send('/app/changeState', {}, param); // 宛先'/app/changeState'へメッセージを送信
};

/**
 * 接続切断処理
 */
StompUtil.prototype.disconnect = function () {
    if (this.stompClient) {
        this.stompClient.disconnect();
        this.stompClient = null;
    }
};
