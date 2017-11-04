
<div id="resp">
<h3>Manage Employee</h3>
<form action="addEmployee" method="post">
    <input type="text" id="id" name="id" placeholder="id" value="${emp.id}"/> <input type="button" value="Search" onclick="getEmployeeById();"/>
    <br/>
    <br/>
    <br/>
    <input type="text" id="name" name="name" placeholder="username" value="${emp.name}"/> 
    <br/>
    <input type="text" id="age" name="age" placeholder="age" value="${emp.age}"/>
    <br/>
    <br/>
    <input type="button" value="Add" onclick="addEmployee();"/>
    <input type="button" value="Update" onclick="updateEmployee();"/>
    <input type="button" value="Delete" onclick="deleteEmployee();"/>
</form>
</div>