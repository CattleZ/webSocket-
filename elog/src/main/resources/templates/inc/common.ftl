<#macro pageing PageData>
    <div style="text-align: center">
        <div id ="laypage-main">
        </div>
        <script src="../res/layui/layui.js"></script>
        <script>
            layui.use('laypage',function (){
                console.log("nihao")
                var laypage = layui.laypage;
                // 执行一个page实例
                laypage.render({
                    elem: 'laypage-main', // 这里是id，不用添加#号
                    count: ${pageData.total}, // 数据总数
                    curr: ${pageData.current},
                    limit: ${pageData.size}, //每一页显示的条数
                    // 切换分页后的回调
                    jump: function(obj, first){
                        //obj包含了当前分页的所有参数，比如：
                        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        console.log(obj.limit); //得到每页显示的条数
                        //首次不执行
                        if(!first){
                            location.href = "?pn="+obj.curr;
                        }
                    }
                })
            });
        </script>
    </div>
</#macro>