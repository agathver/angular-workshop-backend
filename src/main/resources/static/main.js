const debug = document.getElementById("debug");
const socket = new SockJS('/realtime');
stompClient = Stomp.over(socket);
stompClient.connect({}, onConnected, onError);

function onConnected() {
    console.log("Connected");
    debug.innerHtml += "Connected\n";
    stompClient.subscribe('/topic/public', onMessageReceived);

    setInterval(() => {
        stompClient.send("/app/channels/test/send_message", {}, JSON.stringify({
            type: 'MESSAGE',
            username: "debug",
            content: "Debug"
        }));
    }, 3000);
}


function onError(error) {
    console.error('Could not connect to WebSocket server. Please refresh this page to try again!');
}


function onMessageReceived(payload) {
    console.log(payload)
    debug.innerHtml += payload.body + "\n";
    var message = JSON.parse(payload.body);
    console.log(message)
}
