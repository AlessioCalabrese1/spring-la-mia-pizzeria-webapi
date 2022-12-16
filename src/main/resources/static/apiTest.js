console.log("Hello World!");

fetch('http://localhost:8080/api/1/pizza')
  .then((response) => response.json())
  .then((data) => console.log(data));