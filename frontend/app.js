function sendMessage() {
    var userMessage = document.getElementById("userInput").value;

    if (userMessage) {
        // Display user message in the chatbox
        var chatbox = document.getElementById("chatBox");
        chatbox.innerHTML += "<div>User: " + userMessage + "</div>";

        // Send the message to the backend
        fetch('http://localhost:8080/chatbot', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ userInput: userMessage })
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log("Backend Response:", data); // Debug log
            
            // Check for botResponse key in data
            if (data.botResponse) {
                chatbox.innerHTML += "<div>Bot: " + data.botResponse + "</div>";
            } else {
                chatbox.innerHTML += "<div>Bot: [Error: No botResponse key]</div>";
            }
        })
        .catch(error => {
            console.error("Error:", error);
            chatbox.innerHTML += "<div>Bot: [Error: Could not connect to backend]</div>";
        });

        // Clear the input box
        document.getElementById("userInput").value = '';
    }
}
