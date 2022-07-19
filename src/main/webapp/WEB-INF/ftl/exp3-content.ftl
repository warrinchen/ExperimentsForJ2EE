<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>j2ee-exp3</title>
        <script src="../../resources/jquery-3.6.0.js"></script>
        <style>
            #menu-div {
                width: 15%;
                height: 800px;
                float: left;
                background-color: skyblue;
            }
            #content-div {
                width: 85%;
                height: 800px;
                float: right;
                background-color:antiquewhite;
            }
            .glossymenu{
                list-style-type: none;
                margin: 5px 0;
                padding: 0;
                border: 1px solid #9A9A9A;
                border-bottom-width: 0;
            }
            .glossymenu li a{
                background: white url(../../resources/picture/glossyback.gif) repeat-x bottom left;
                font: bold 12px "Lucida Grande", "Trebuchet MS",
                Verdana, Helvetica, sans-serif;
                color: white;
                display: block;
                width: auto;
                padding: 3px 0;
                padding-left: 10px;
                text-decoration: none;}
            * html .glossymenu li a{
                width: 160px;
            }
            .glossymenu li a:visited, .glossymenu li a:active{
                color: white;
            }
            .glossymenu li a:hover{
                background-image: url(../../resources/picture/glossyback2.gif);
            }
            a {
                text-align: center;
            }
            iframe {
                border: 0px;
                width: 100%;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <div id="menu-div">
            <div>
                welcome, ${user.username}!
            </div>
            <ul class="glossymenu">
                <li>
                    <a href="/exp3/book-detail" target="content-ifm">图书信息</a>
                </li>
                <li>
                    <a href="/exp3/book-add" target="content-ifm">新增图书</a>
                </li>
            </ul>
        </div>
        <div id="content-div">
            <iframe name="content-ifm" src="/exp3/book-detail"></iframe>
        </div>
    </body>
</html>