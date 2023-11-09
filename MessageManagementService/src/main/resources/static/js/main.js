document.addEventListener("DOMContentLoaded", function () {
    const usernamePage = document.querySelector("#username-page");
    const chatPage = document.querySelector("#chat-page");
    const usernameForm = document.querySelector("#usernameForm");
    const messageForm = document.querySelector("#messageForm");
    const messageInput = document.querySelector("#message");
    const messageArea = document.querySelector("#messageArea");

    let stompClient = null;
    let username = null;

    function connect(event) {
        event.preventDefault();
        username = document.querySelector("#name").value.trim();

        if (username) {
            usernamePage.classList.add("hidden");
            chatPage.classList.remove("hidden");

            const socket = new SockJS("/chat");
            stompClient = Stomp.over(socket);

            stompClient.connect({}, onConnected, onError);
        }
    }

    function onConnected() {
        stompClient.subscribe("/topic/public", onMessageReceived);
        stompClient.send("/app/chat.addUser", {}, JSON.stringify({ sender: username, type: "JOIN" }));
    }

    function onError(error) {
        console.error("WebSocket error: " + error);
    }

    function sendMessage(event) {
        event.preventDefault();
        const messageContent = messageInput.value.trim();
        if (messageContent && stompClient) {
            const chatMessage = {
                sender: username,
                content: messageContent,
                type: "CHAT",
            };
            stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
            messageInput.value = "";
        }
    }

    function onMessageReceived(payload) {
        const message = JSON.parse(payload.body);

        const messageElement = document.createElement("li");
        if (message.type === "JOIN") {
            messageElement.classList.add("event-message");
            message.content = message.sender + " joined!";
        } else if (message.type === "LEAVE") {
            messageElement.classList.add("event-message");
            message.content = message.sender + " left!";
        } else {
            messageElement.classList.add("chat-message");
            const usernameElement = document.createElement("strong");
            usernameElement.textContent = message.sender;
            messageElement.appendChild(usernameElement);
        }

        const textElement = document.createElement("span");
        textElement.textContent = message.content;
        messageElement.appendChild(textElement);

        messageArea.appendChild(messageElement);
        messageArea.scrollTop = messageArea.scrollHeight;
    }

    usernameForm.addEventListener("submit", connect, true);
    messageForm.addEventListener("submit", sendMessage, true);
});
