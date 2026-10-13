const form = document.querySelector("form");
const button = document.querySelector("button");
const textarea = document.querySelector("textarea");

form.addEventListener("submit", function () {

    if (textarea.value.trim() === "") {
        alert("Please enter some code.");
        return;
    }

    button.disabled = true;
    button.innerText = "Analyzing...";

});