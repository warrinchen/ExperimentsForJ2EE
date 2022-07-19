<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <!-- <meta http-equiv="refresh" content="2;http://www.baidu.com;"> -->
    <title>j2ee-exp3</title>
    <script src="../../resources/jquery-3.6.0.js"></script>
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
    </style>
</head>
<body>
    <form id="book-info" >
            <table style="text-align: center">
                <thead>
                    <tr>
                        <th colspan="2">新增图书</th>
                    </tr>
                </thead>
                <tbody>
<#--                    <tr>-->
<#--                        <td>图书编号</td>-->
<#--                        <td><input type="number" readonly name="id" value="1"></td>-->
<#--                    </tr>-->
                    <tr>
                        <td>图书名称</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>作者</td>
                        <td><input type="text" name="author"></td>
                    </tr>
                    <tr>
                        <td>出版社</td>
                        <td><input type="text" name="publisher"></td>
                    </tr>
                    <tr>
                        <td>出版时间</td>
                        <td><input type="date" name="publishTime"></td>
                    </tr>
                    <tr>
                        <td>库存</td>
                        <td><input type="number" name="stock"></td>
                    </tr>
                    <tr>
                        <td>单价</td>
                        <td><input type="number" name="price"></td>
                    </tr>
<#--                    <tr>-->
<#--                        <td>登记时间</td>-->
<#--                        <td><input type="date" name="register_time"></td>-->
<#--                    </tr>-->
                    <tr>
                        <td>登记人</td>
                        <td><input type="text" readonly name="registerUser" value="${user.id}"></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2" ><input type="submit" value="添加" onclick="insertBook()"></td>
                    </tr>
                </tfoot>
            </table>
    </form>
</body>
<script>
    function insertBook(){
        console.log("data to insert: ");
        console.log($("#book-info").serialize());
        $.ajax({
            "url" : "/exp3/insert-book",
            "type" : "post",
            "data" : $("#book-info").serialize(),
            "dataType" : "json",
            "success" : function (json) {
                console.log("返回结果"+json);
                if(json.status == "ok"){
                    alert("添加成功!");
                    window.location.href = "/exp3/book-add";
                }else{
                    alert("添加失败!");
                }
            },
            "error" : function () {
                alert("服务器错误, 请联系管理员!");
            }
        })
    }
</script>
</html>