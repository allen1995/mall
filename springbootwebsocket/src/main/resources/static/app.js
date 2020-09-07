var stomClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if( connected ){
        $("#conversation").hide();
        $("chat").hide();
    }else {
        $("#conversation").hide();
        $("chat").hide();
    }

    $("#greetings").html("");
}

function connect() {
    if( !$("#name").val() ){
        return;
    }

    var socket = new SockJS("/chat");
    stomClient = Stomp.over(socket);
    stomClient.connect({}, function (frame) {
        setConnected(true);
        stomClient.subscribe("/topic/greetings", function (greeting) {

            showGreeting(JSON.parse(greeting.body));
        })
    })
}

function disconnect() {
    if( stomClient != null ){
        stomClient.disconnect();
    }

    setConnected(false);
}

function sendName() {
    stomClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(), 'content':$("#content").val()}))
}

var showGreeting = function (message) {
    $("#greetings")
        .append("<div>" + message.name + ":" + message.content + "</div>")
};

$(function () {
    $("#connect").click(function () {
        connect();
    });

    $("#disconnect").click(function () {
        disconnect();
    });

    $("#send").click(function () {
        sendName();
    });
})