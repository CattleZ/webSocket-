// 教程： https://socket.io/zh-CN/docs/v4/server-installation/


const { createServer } = require("http");
const { Server } = require("socket.io");

const httpServer = createServer();
const io = new Server(httpServer, {
    // 设置CORS问题
    cors: {
        origin: "http://localhost:63342"
    }
});

io.on("connection", (socket) => {
    console.log("新用户连接了～～"+socket.id)
    socket.emit('send',{name:'zs'})
});

httpServer.listen(3000,()=>{
    console.log("服务器端启动成功～～")
});