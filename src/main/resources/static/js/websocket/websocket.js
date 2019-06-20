
var socket = {};
var stompClient = null;

var onmessagefn = function (data) {

};
//初始化webSocket
var initWebSocket = function(userId,onmessage){
    socket = new SockJS('/portfolio-stomp');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        // 订阅公共频道
        stompClient.subscribe('/topic/greetings', function (greeting) {
            if (!onmessage) {
                onmessage = onmessagefn
            }
            onmessage(JSON.parse(greeting).body);
            console.log("广播频道:" +JSON.stringify(greeting));
        });

        // 订阅个人接收频道
        stompClient.subscribe('/user/' + userId + '/topic/greetings', function (greeting) {
            if (!onmessage) {
                onmessage = onmessagefn
            }
            onmessage(JSON.parse(greeting.body));
            console.log("个人频道:" +JSON.stringify(greeting));
        });
    });
};

var wsOpen = function () {
    console.log('open');
};
var wsOnmessage = function (e) {
    console.log('message', e.data);
};
var wsOnclose = function () {
    disconnect();
};
/**
 * 建立成功的回调函数
 */
socket.onopen = wsOpen;

/**
 * 服务器有消息返回的回调函数
 */
socket.onmessage = wsOnmessage;

/**
 * websocket链接关闭的回调函数
 */
socket.onclose = wsOnclose;

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    if (stompClient.connected) {
        stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
    } else {
        console.error("服务掉线了。");
    }
}

function sendToUser(id, content) {
    if (stompClient.connected) {
        stompClient.send("/app/message", {}, JSON.stringify({'user': id, 'content': content}));
    } else {
        console.error("服务掉线了。");
    }
}