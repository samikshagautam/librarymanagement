<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="book" scope="page" value='${requestScope.get("book")}'/>
<!DOCTYPE html>
<html>
<head>
    <title>${book.getTitle()} :: Borrowing</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="list.css">
</head>
<body>
<c:if test="${book.getStatus()==true}">
    <h2>Book is available for borrowing.</h2>
    <button type="button" class="borrow-book" data-book="${book.getId()}">Borrow Book</button>
</c:if>

<c:if test="${book.getStatus()==false}">

    Book is not available at this moment. Please come later. Thank you!
    <table>
        <tr>
            <td> Title</td>
            <td> ${book.getTitle()}</td>
        </tr>

        <tr>
            <td> Student name</td>
            <td> ${book.getStudentName()}</td>
        </tr>

        <tr>
            <td> Student email</td>
            <td> ${book.getStudentEmail()}</td>
        </tr>

        <tr>
            <td> Student phone</td>
            <td> ${book.getStudentPhone()}</td>
        </tr>

        <tr>
            <td> Borrow Date</td>
            <td> ${book.getBorrowDate()}</td>
        </tr>

        <tr>
            <td> Return Date</td>
            <td> ${book.getReturnDate()}</td>
        </tr>

        <tr>
            <td>
                <button type="button" class="return-book" data-book="${book.getId()}">Return Book</button>
            </td>
            <td>
                <button type="Notify Student" class="notify-student" data-book="${book.getId()}">Notify Student</button>
            </td>
        </tr>

    </table>
</c:if>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        $(".borrow-book").click(function (e) {
            e.preventDefault();
            const bookId = $(this).data().book;
            $.ajax({
                url: "borrow?id=" + bookId,
                type: "GET",
                success: function (resp) {
                    if (resp === "success") {
                        alert("Book was borrowed to student");
                        location.reload();
                        return true;
                    }
                    alert(resp);

                }
            });
        });
    });
</script>


<script type="text/javascript">
    $(function () {
        $(".return-book").click(function (e) {
            e.preventDefault();
            const bookId = $(this).data().book;
            $.ajax({
                url: "return?id=" + bookId,
                type: 'GET',
                success: function (resp) {
                    if (resp === "success") {
                        alert("Book was successfully returned!");
                        location.reload(); //to reload the page
                        return true;
                    }
                    alert(resp);


                }
            });

        })

    })
</script>

<script type="text/javascript">
    $(function () {
        $(".notify-student").click(function (e) {
            e.preventDefault();
            const bookId = $(this).data().book;
            $.ajax({
                url: "notify?id=" + bookId,
                type: 'GET',
                success: function (resp) {
                    if (resp === "success") {
                        alert("Notification was successfully sent!");
                        location.reload();
                        return true;
                    }
                    alert(resp);


                }
            });

        })

    })
</script>
</body>
</html>
