<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:if test="${offersResponse.status == 'ERROR'}">

    <p>An Error acquired please try later.</p>

</c:if>


<c:if test="${offersResponse.status == 'SUCCESS'}">

   <%-- <c:if test="${offersResponse.offerResponse.offers.hotel}">

    </c:if>--%>
    <ul>
        <c:forEach var="listValue" items="${offersResponse.offerResponse.offers.hotel}">
            <li>${listValue.hotelInfo.hotelName}</li>
        </c:forEach>
    </ul>

</c:if>
