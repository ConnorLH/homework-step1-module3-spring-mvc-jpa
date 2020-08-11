<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: connor.h.liu
  Date: 2020/8/10
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表页</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script>
      $(function () {

        $(".delete").bind("click", function (e) {
          var id = $(e.target).data("id");
          // 发送ajax请求
          $.ajax({
            url: '/resume/delete?id=' + id,
            type: 'DELETE',
            success: function (data) {
              if (data === "success") {
                alert("删除成功");
                location.reload();
              } else {
                alert("删除失败");
              }
            }
          })

        });

        $("#add").bind("click", function (e) {
          $("#edit-dialog").show();
          var editInput = $("#edit-dialog").children("input");
          editInput.eq(0).val("");
          editInput.eq(1).val("");
          editInput.eq(2).val("");
          editInput.eq(3).val("");
        });

        $(".edit").bind("click", function (e) {
          console.log(e.target);
          $("#edit-dialog").show();
          var id = $(e.target).data("id");
          var resumeStr = $("#" + id).children("td");
          id = resumeStr.eq(0).text();
          var address = resumeStr.eq(2).text();
          var name = resumeStr.eq(3).text();
          var phone = resumeStr.eq(4).text();
          var editInput = $("#edit-dialog").children("input");
          console.log(editInput);
          editInput.eq(0).val(id);
          editInput.eq(1).val(address);
          editInput.eq(2).val(name);
          editInput.eq(3).val(phone);
        });

        $("#submit").bind("click", function (e) {
          var editInput = $("#edit-dialog").children("input");
          var id = editInput.eq(0).val();
          var address = editInput.eq(1).val();
          var name = editInput.eq(2).val();
          var phone = editInput.eq(3).val();

          var param = {
            "address": address,
            "name": name,
            "phone": phone
          }
          if (id) {
            param.id = id;
          }

          $.ajax({
            url: '/resume/save',
            type: 'POST',
            data: JSON.stringify(param),
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
              if (data === "success") {
                alert("保存成功");
                location.reload();
              } else {
                alert("保存失败");
              }
            }
          })
        })

      })
    </script>
</head>
<body>
<div>
    <table>
        <tr>
            <th>序号</th>
            <th>地址</th>
            <th>姓名</th>
            <th>电话</th>
            <th><input type="button" value="新增" id="add"></th>
        </tr>
        <%--@elvariable id="list" type="java.util.List"--%>
        <c:forEach var="resume" items="${list}" varStatus="status">
            <tr id="${resume.id}">
                <td style="display: none">${resume.id}</td>
                <td>${status.count}</td>
                <td>${resume.address}</td>
                <td>${resume.name}</td>
                <td>${resume.phone}</td>
                <td><input data-id="${resume.id}" class="edit" type="button" value="编辑"></td>
                <td><input data-id="${resume.id}" class="delete" type="button" value="删除"></td>
            </tr>
        </c:forEach>
    </table>
    <div style="display: none" id="edit-dialog">
        <input type="hidden" name="id">
        地址：<input type="text" name="address"><br/>
        姓名：<input type="text" name="name"><br/>
        电话：<input type="text" name="phone"><br/>
        <input type="button" value="确定" id="submit">
    </div>
</div>
</body>
</html>
