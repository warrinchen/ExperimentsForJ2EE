<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>jsTree test</title>
  <link rel="stylesheet" href="/resources/dist/themes/default/style.min.css" />
<#--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />-->
<#--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>-->
<#--  <script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>-->
</head>
<body>
<div id="using_json">
</div>
<script src="/resources/jquery-3.6.0.js"></script>
<script src="/resources/dist/jstree.min.js"></script>
<script>
  $(function () {
    $.ajax({
      url:"/exp2json",
      data: "",
      type:"get",
      dataType:"json",
      success:function (json){
        $('#jstree').jstree();
        // bind to events triggered on the tree
        $('#jstree').on("changed.jstree", function (e, data) {
          console.log(data.selected);
        });

        $('#using_json').jstree({ 'core' : {
            'data' : json
          } });
      },
      error: function (data) {
        console.log("error occurred in server, details:");
        console.log(data)
      }
    });
  });
</script>
</body>
</html>