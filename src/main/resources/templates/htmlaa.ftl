<form>
		H  I    ${name}  OK ?
		
		<input type="button" value="新增" onclick="addUser()">
		<table border="1" color="#ff9999">
		  
		  		<tr>
		  			<td>用户ID</td>
                    <td>用户姓名</td>
                    <td>用户性别</td>
                    <td>用户年龄</td>
                    <td>用户出生日期</td>
                    <td>操作</td>
		  		</tr>
		  		<#list list as emp>
                <tr>
                	<td>${emp.userId}</td>
                    <td>${emp.userName}</td>
                    <td>${emp.userSex}</td>
                    <td>${emp.userAge}</td>
                    <td>${emp.userDate}</td>
                    <td style="text-align:center;">
                    	[<a
                            href="${request.contextPath}/updatetoUser/${emp.userId}">修改
                        </a>] -
                        [<a 
                        	href="${request.contextPath}/deleteUser/${emp.userId}">删除
                        </a>]

                    </td>
                </tr>
                </#list>
		</table>
	</form>