// nodejs websocket地址 https://github.com/sitegui/nodejs-websocket


// 导入nodejs-websocket包
var ws = require("nodejs-websocket")

// Scream server example: "hi" -> "HI!!!"
var server = ws.createServer(function (conn) {
    console.log("New connection,有用户连接上来了")
    conn.on("text", function (str) {
        console.log("Received "+str)
        conn.sendText(str.toUpperCase()+"!!!")
    })
    // 连接断开会触发
    conn.on("close", function (code, reason) {
        console.log("Connection closed")
    })
    // 连接断开后会抛出异常，因此就需要注册一个error事件
    conn.on("error",function () {
        console.log("连接断开了 error")
    })
    
}).listen(8001)