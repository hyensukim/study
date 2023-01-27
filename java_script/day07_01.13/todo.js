window.addEventListener("DOMContentLoaded",function(){
    const textEl = document.getElementsByTagName("text");
    const registerEl = document.getElementById("register");
    const scheduleEl = document.getElementById("schedule");

    registerEl.addEventListener("click",function(){
        const text = textEl.value;

        const liEl = document.createElement("li");

        const textNode = document.createTextNode(text);

        liEl.appendChild(textNode);

        scheduleEl.appendChild(liEl);
    });

});