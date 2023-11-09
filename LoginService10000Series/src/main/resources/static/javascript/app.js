fetch('/SnapTalk/Login', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        // Your request data here
    })
})
.then(response => response.json())
.then(data => {
    // Handle the response data here
})
.catch(error => {
    console.error('Error:', error);
});
