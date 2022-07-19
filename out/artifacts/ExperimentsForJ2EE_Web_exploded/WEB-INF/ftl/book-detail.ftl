<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- <meta http-equiv="refresh" content="2;http://www.baidu.com;"> -->
        <title>j2ee-exp3</title>
        <script type="text/javascript" src="../../resources/jquery-3.6.0.js"></script>
        <script src="../../resources/sweetalert2.all-11.4.10.js"></script>
        <link type="text/css" rel="stylesheet" href="../../resources/sweetalert2-11.4.10.css">
        <style>
            table, th, td {
                border: 1px solid black;
            }
            table {
                width: 80%;
                margin: auto;
            }
            th {
                background-color: aqua;
            }
            td {
                background-color: aquamarine;
            }
            body {
                background-color: beige;
            }
            /* input[type="button"] {
                background-color: aquamarine;
                border: 0px;
            } */
        </style>
    </head>
    <body>
        <table id="tb">
            <thead>
                <tr>
                    <th>图书编号</th>
                    <th>图书名称</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>出版时间</th>
                    <th>库存</th>
                    <th>单价</th>
                    <th>登记时间</th>
                    <th>登记人编号</th>
                    <th colspan="2">操作</th>
                </tr>
            </thead>
            <tbody>
                <#list books as b>
                    <tr>
                        <td>${b.id}</td>
                        <td>${b.name}</td>
                        <td>${b.author}</td>
                        <td>${b.publisher}</td>
                        <td>${b.publishTime?string("yyyy-MM-dd")}</td>
                        <td>${b.stock}</td>
                        <td>${b.price?string("0.00")}</td>
                        <td>${b.registerTime?string("yyyy-MM-dd")}</td>
                        <td>${b.registerUser}</td>
                        <td>
                            <img src="../../resources/picture/pencil.gif">
                            <button onclick="mdfBook(this)">修改</button>
                        </td>
                        <td>
                            <img src="../../resources/picture/bin_closed.gif">
                            <input type="button" onclick="delBook(this)" value="删除">
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </body>
    <script>
        async function mdfBook(obj) {
            let items = $(obj).parent().parent().children("td");
            console.log(items);
            let id;
            let name;
            let author;
            let publisher;
            let publishTime;
            let stock;
            let price;
            let registerTime;
            let registerUser;
            console.log("待修改值:")
            for(let i = 0; i < 9; ++i) {
                console.log(items[i].innerHTML);
                switch (i) {
                    case 0 :id = items[i].innerHTML;break;
                    case 1 :name = items[i].innerHTML;break;
                    case 2 :author = items[i].innerHTML;break;
                    case 3 :publisher = items[i].innerHTML;break;
                    case 4 :publishTime = items[i].innerHTML;break;
                    case 5 :stock = items[i].innerHTML;break;
                    case 6 :price = items[i].innerHTML;break;
                    case 7 :registerTime = items[i].innerHTML;break;
                    case 8 :registerUser = items[i].innerHTML;break;
                }
            }
            const {value: isModified} = await Swal.fire({
                title: '修改图书信息',
                html: '<table id="book-mdf-tb">\n' +
        '                    <tr>\n' +
        '                        <td>图书编号</td>\n' +
        '                        <td><input type="number" disabled name="id" value="'+id+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>图书名称</td>\n' +
        '                        <td><input type="text" name="name" value="'+name+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>作者</td>\n' +
        '                        <td><input type="text" name="author" value="'+author+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>出版社</td>\n' +
        '                        <td><input type="text" name="publisher" value="'+publisher+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>出版时间</td>\n' +
        '                        <td><input type="date" name="publish_time" value="'+publishTime+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>库存</td>\n' +
        '                        <td><input type="number" name="stock" value="'+stock+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>单价</td>\n' +
        '                        <td><input type="number" name="price" value="'+price+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>登记时间</td>\n' +
        '                        <td><input type="date" name="register_time" value="'+registerTime+'"></td>\n' +
        '                    </tr>\n' +
        '                    <tr>\n' +
        '                        <td>登记人</td>\n' +
        '                        <td><input type="text" disabled name="register_user" value="'+registerUser+'"></td>\n' +
        '                    </tr>\n' +
            '            </table>',
                confirmButtonText: '提交',
                showCancelButton: true,
                cancelButtonText: '取消',
                preConfirm: async () => {
                    var result;
                    let items = $("#book-mdf-tb").find("input");
                    console.log("tb-input items:")
                    console.log(items);
                    // let id;
                    // let name;
                    // let author;
                    // let publisher;
                    // let publishTime;
                    // let stock;
                    // let price;
                    // let registerTime;
                    // let registerUser;
                    console.log("修改后的值:")
                    for(let i = 0; i < 9; ++i) {
                        console.log(items[i].value);
                        switch (i) {
                            case 0 :id = items[i].value;break;
                            case 1 :name = items[i].value;break;
                            case 2 :author = items[i].value;break;
                            case 3 :publisher = items[i].value;break;
                            case 4 :publishTime = items[i].value;break;
                            case 5 :stock = items[i].value;break;
                            case 6 :price = items[i].value;break;
                            case 7 :registerTime = items[i].value;break;
                            case 8 :registerUser = items[i].value;break;
                        }
                    };
                    await $.ajax({
                        "url" : "/exp3/modify-book",
                        "type" : "post",
                        "data" : {"id":id, "name":name,"author":author,"publisher":publisher,"publishTime":publishTime,
                                "stock":stock,"price":price,"registerTime":registerTime,"registerUser":registerUser},
                        dataType : "json",
                        "success" : function(json){
                                console.log(json);
                                if(json.status == "ok"){
                                    console.log("json.status is "+json.status);
                                    result = "ok";
                                }else{
                                    result = "error in modify book info."
                                }
                                console.log("request success, result: "+result);
                            },
                        "error" : function(xmlhttp, errorText){
                            console.log(xmlhttp);
                            console.log(errorText); //xmlhttp中的statusText
                            if(xmlhttp.status == 405){
                                alert("无效请求方式");
                            }else if(xmlhttp.status == 404){
                                alert("未找到URL资源");
                            }else if(xmlhttp.status == 500){
                                alert("服务器内部错误, 请联系管理员");
                            }else{
                                alert("产生异常, 请联系管理员");
                            }
                        }
                    });
                    console.log("result: "+result);
                    return result;
                }
            });
            console.log("isModified:");
            console.log(isModified);
            if (isModified){
                if(isModified == "ok") {
                    Swal.fire('修改成功!', '', 'success');
                    window.location.href = "/exp3/book-detail";
                }else{
                    Swal.fire({
                        title: '修改失败',
                        text: '系统错误, 请联系管理员!',
                        icon: 'error'
                    })
                }
            }

        }
        async function delBook(obj) {
            let items = $(obj).parent().parent().children("td");
            console.log(items)
            let id = items[0].innerHTML;
            console.log("id to delete: "+id)
            const {value: isDel} = await Swal.fire({
                title: '删除图书信息',
                text: '请慎重考虑是否删除图书信息',
                icon: 'warning',
                focusConfirm: false,
                showCancelButton: true,
                confirmButtonColor: '#d33',
                cancelButtonColor: '#33dd85',
                confirmButtonText: '删除',
                cancelButtonText: '取消',
                preConfirm: async () => {
                    var result;
                    await $.ajax({
                        "url" : "/exp3/delete-book",
                        "type" : "post",
                        "data" : {"id":id},
                        dataType : "json",
                        "success" : function(json){
                            console.log(json);
                            if(json.status == "ok"){
                                console.log("json.status is "+json.status);
                                result = "ok";
                            }else{
                                result = "error in delete e book info."
                            }
                            console.log("request success, result: "+result);
                        },
                        "error" : function(xmlhttp, errorText){
                            console.log(xmlhttp);
                            console.log(errorText); //xmlhttp中的statusText
                            if(xmlhttp.status == 405){
                                alert("无效请求方式");
                            }else if(xmlhttp.status == 404){
                                alert("未找到URL资源");
                            }else if(xmlhttp.status == 500){
                                alert("服务器内部错误, 请联系管理员");
                            }else{
                                alert("产生异常, 请联系管理员");
                            }
                        }
                    });
                    return result;
                }
            })
            if (isDel){
                if(isDel == "ok") {
                    Swal.fire(
                        '删除成功!',
                        'ID为 '+id+' 的图书信息已经删除!',
                        'success'
                    )
                    window.location.href = "/exp3/book-detail";
                } else{
                    Swal.fire(
                        '删除失败!',
                        '系统错误,请联系管理人员!',
                        'error'
                    )
                }
            }
        }
    </script>
</html>