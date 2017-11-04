<%@include file="/WEB-INF/pages/includedTags.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> 
            <tiles:getAsString name="title"/>    
        </title>
    </head>
   <body>
    <table width="100%">
        <thead>
            <tr>
                <td colspan="2">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
        </thead>

        <tbody>
            <tr height="300px">
                <td width="20%">
                    <tiles:insertAttribute name="sidebar"/>
                </td>
                <td width="80%">      
                        <tiles:insertAttribute name="content"/>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="2">
                    <tiles:insertAttribute name="footer"/>
                </td>
            </tr>
        </tfoot>
    </table>
</body>    
</html>