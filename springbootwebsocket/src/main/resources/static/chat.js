var stomClient = null;

function connect() {

    var socket = new SockJS("/chat");
    stomClient = Stomp.over(socket);
    stomClient.connect({}, function (frame) {
        stomClient.subscribe("/user/queue/chat", function (chat) {
            showGreeting(JSON.parse(chat.body));
        })
    })
}


function sendMsg() {
    stomClient.send("/app/chat", {}, JSON.stringify({'to': $("#to").val(), 'content':$("#content").val()}))
}

var showGreeting = function (message) {
    $("#chatsContent")
        .append("<div>" + message.from + ":" + message.content + "</div>")
};

$(function () {
    connect();

    $("#send").click(function () {
        sendMsg();
    });
})