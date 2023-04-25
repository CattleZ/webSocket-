var ws = require("nodejs-websocket")
var i =0;
// 每个连接上来的用户都用一个conn属性
const server = ws.createServer(function (conn) {
    i = i +1
    console.log("新的连接"+i)
    conn.username = `用户${i}`;

    // 1。 告诉所有用户，有人加入了聊天室
    brodcast(`${conn.username}进入了聊天室`)
    // 2。 接收到了浏览器的数据，也要给所有用户发消息
    conn.on('text',function (data) {
        brodcast(`${conn.username}:${data}`)
    })

    conn.on('close',function (data) {
        // 3.告诉所有的用户，xx离开了
        brodcast(`${conn.username}离开了聊天室`)
        console.log("关闭连接")
        i--;
    })

    conn.on('error',function (data) {
        console.log("关闭连接，发生异常")
    })
})

// 广播，给所有的用户发送消息
function brodcast(msg){
    // server.connections 用来获取所有的连接
    server.connections.forEach(item => {
        item.send(msg)
    })
}

server.listen(3000,function () {
    console.log("监听端口 3000")
})
