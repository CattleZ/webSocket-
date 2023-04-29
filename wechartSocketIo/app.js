const express = require("express");
const { createServer } = require("http");
const { Server } = require("socket.io");

const app = express();
const httpServer = createServer(app);
const io = new Server(httpServer, {
    // 设置CORS问题
    cors: {
        origin: "http://localhost:63342"
    }
});
// express 能够处理静态资源,把public设置为静态资源目录
app.use(require('express').static('public'))
httpServer.listen(3000,()=>{
    console.log("服务器启动成功～～")
});
io.on("connection", (socket) => {
    // ...
    console.log("新的用户连接",socket.id)
});