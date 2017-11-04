<%@include file="/WEB-INF/pages/includedTags.jsp" %>
<h3>Employees</h3>

<c:choose>
    <c:when test="${not empty emp}">

        <table>
            <thead>                    
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="number" value="0"/>
                <c:forEach var="e" items="${emp}">
                    <c:set var="number" value="${number+1}"/>
                    <tr>
                        <td><c:out value="${number}"/></td>
                        <td>${e.name}</td>
                        <td>${e.age}</td>
                    </tr>
                </c:forEach>
            </tbody>                                
        </table>
    </c:when>
    <c:otherwise>
        No data recorded
    </c:otherwise>
</c:choose>