<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>J2EE Experiment_1</title>
    <style>
        table {
            margin: auto;
        }
        table, tr, th, td {
            border: 1px solid black
        }

    </style>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>政治面貌</th>
            <th>籍贯</th>
            <th>所在公寓</th>
            <th>入学成绩</th>
            <th>平均成绩</th>
            <th>名次</th>
            <th>备注</th>
        </tr>
    </thead>
    <tbody>
        <#list list as line>
            <tr>
<#--                <td>${line_index + 1}</td>-->
                <td>${line.id}</td>
                <#if line.name??>
                    <td>${line.name}</td>
                </#if>
                <td>${line.gender}</td>
                <td>${line.birthDay?string("yyyy-MM-dd")}</td>
                <td>${line.politicalStatus}</td>
                <td>${line.birthplace}</td>
                <td>${line.flatId}</td>
                <td>${line.admissionScore}</td>
                <td>${line.averageScore?string("0.0")}</td>
                <td>${line.ranking}</td>
                <td>${line.note}</td>
            </tr>
        </#list>
    </tbody>
</table>
</body>
</html>