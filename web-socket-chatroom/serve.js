var ws = require("nodejs-websocket")
var i =0;
/**
 * 优化：
 *    1. 消息不应该是简单的字符串
 *       这个消息应该是个对象：
 *          type: 消息的类型，0. 表示进来的消息 1. 用户离开聊天室的消息 2. 正常的聊天消息
 *          msg: 消息的内容
 *          time: 聊天的具体时间
 *
 */
// 每个连接上来的用户都用一个conn属性
const server = ws.createServer(function (conn) {
    i = i +1
    console.log("新的连接"+i)
    conn.username = `用户${i}`;

    // 1。 告诉所有用户，有人加入了聊天室
    brodcast({
        type: 0,
        msg : `${conn.username}进入了聊天室`,
        time : new Date().toLocaleTimeString()
    })
    // 2。 接收到了浏览器的数据，也要给所有用户发消息
    conn.on('text',function (data) {
        brodcast({
            type: 2,
            msg: `${conn.username}:${data}`,
            time: new Date().toLocaleTimeString()
        })
    })

    conn.on('close',function (data) {
        // 3.告诉所有的用户，xx离开了
        brodcast({
            type : 1,
            msg : `${conn.username}离开了聊天室`,
            time : new Date().toLocaleTimeString()
        })
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
        item.send(JSON.stringify(msg))
    })
}

server.listen(3000,function () {
    console.log("监听端口 3000")
})
