
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/CSS/details.css"%>
    </style>
    <title>Document</title>
</head>
<body>


<header>
    <div class="logo"><img src="https://i.ibb.co/4pCSmsM/LOGO.png" width="100%"></div>

    <ul>
        <li><a href="#" id="a1">HOME</a></li>
        <li><a href="#">MOVIE</a></li>
        <li><a href="#">ABOUT</a></li>
        <li><a href="#">CONTACT</a></li>
    </ul>

</header>
<c:forEach var="fl" items="${list_film}">

<section class="details">
    <div class="wrapper">
        <div class="img-film">
<<<<<<< HEAD
            <img src="${fl.getFilm_pic()}" width="90%">
=======
            <img src="${img}" width="90%">
>>>>>>> f1862385d0a6d56c28bf67483399cd4b5fb3036d
        </div>
        <div class="content-film">
            <div class="titles">
                <h2>New Episodes</h2>
<<<<<<< HEAD
                <h1>${fl.getTitle()}</h1>
=======
                <h1>${title}</h1>
>>>>>>> f1862385d0a6d56c28bf67483399cd4b5fb3036d
            </div>
            <br>
            <div class="titles-content">

                <div class="quality">
                    <div>
                        <h2>8K+</h2>
                        <button id="book">Book</button>
                    </div>
                </div>

                <div class="proprty">
<<<<<<< HEAD
                    <h3>${fl.getCategory()}</h3>
                </div>

                <div class="delay">
                    <h3>${fl.getShow_time()}</h3>
                    <h3>${fl.getFilm_duration()} min</h3>
=======
                    <h3>${cat}</h3>
                </div>

                <div class="delay">
                    <h3>${date}</h3>
                    <h3>${duration} min</h3>
>>>>>>> f1862385d0a6d56c28bf67483399cd4b5fb3036d
                </div>
            </div>
            <br>
            <div class="desc">
<<<<<<< HEAD
                <p>${fl.getDescription()}</p>
            </div>
            <div class="film-res">
                <h2>Share</h2>
                <h3>Ticket : <input type="number" name="ticket" /></h3>
                <button class="reservation"><a href="#">Reservation</a></button>
=======
                <p>${desc}</p>
            </div>
            <div class="film-res">
                <h2>Share</h2>
                <h3>Prime Film</h3>
                <form action="Reservation_film" method="POST">

                    <button class="reservation"><a href="#">Reservation</a></button>
                </form>
>>>>>>> f1862385d0a6d56c28bf67483399cd4b5fb3036d
            </div>

        </div>

    </div>
</section>
</c:forEach>



</body>
</html>