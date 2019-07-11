<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="book" scope="page" value='${requestScope.get("book")}'/>
<!DOCTYPE html>
<html>
<head>
    <title>${book.getTitle()} :: Borrowing</title>
</head>
<body>
<c:if test="${book.status==true}">
    <h2>Book is available for borrowing.</h2>
    <button type="button" class="borrow-book" data-book="${book.getId()}">Borrow Book</button>
</c:if>

<c:if test="${book.status==false}">
    Book is not available at this moment. Please come later. Thank you!
</c:if>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".borrow-book").click(function (e) {
            e.preventDefault();
            const bookId = $(this).data().book;
            $.ajax({
                url: "/project-final/books/borrow?id=" + bookId,
                type: "GET",
                success: function (resp) {
                    if (resp === "success") {
                        alert("Book was borrowed to student");
                        location.reload();
                        return true;
                    }
                    alert("Unable to borrow book");

                }
            });
        });
    });
</script>
</body>
</html>
