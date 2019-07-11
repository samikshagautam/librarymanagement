<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Title</th>
        <th>Author</th>
        <th>ISBN</th>
        <th>Edition</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.get('bookList')}" var="book">

        <%--<a href="${requestScope.getContextPath}feed?tag=${tag.getTag()}">${tag.getTag()}</a>--%>
        <tr>
            <td>${book.getId()}</td>
            <td>${book.getTitle()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getIsbn()}</td>
            <td>${book.getEdition()}</td>
            <td>${book.getPrice()}</td>
            <td>${book.getStatus()}</td>
            <td>
                <a href="books/borrowing?id=${book.getId()}">Borrow</a>
                <a href="books/edit?id=${book.getId()}">Edit </a>
                <a class="delete-book" href="books/delete?id=${ book.getId()}">Delete</a>
            </td>
        </tr>

    </c:forEach>

    </tbody>

    <tfoot>
    <tr>
        <th><a href="books/add">Add a book </a></th>
    </tr>
    </tfoot>


</table>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('.delete-book').click(function (e) {
            var ans = confirm("Are you sure you want to delete this book?");
            if (ans === false) {
                e.preventDefault();
                return false;
            }
        });
    });
</script>

</body>
</html>
