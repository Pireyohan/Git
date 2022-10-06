const express = require('express');

const app = express();

app.get('/', (req, res) => {
    res.send("Bonjour depuis mon serv nodeJs")
})

app.listen(80, () => {
    console.log("App is running")
})