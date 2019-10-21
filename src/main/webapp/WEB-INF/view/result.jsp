<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<section>
    <div class="container">
        <c:if test="${offersResponse.status == 'ERROR'}">

            <div class="result-info"><p>An Error acquired please try later.</p></div>

        </c:if>
        <c:if test="${offersResponse.status == 'SUCCESS'}">

            <c:if test="${fn:length(offersResponse.offerResponse.offers.hotel) == 0 }">
                <div><p class="result-info">No Data Found.</p></div>
            </c:if>

            <c:forEach var="listValue" items="${offersResponse.offerResponse.offers.hotel}">
                <div class="card mb-3" style="max-width: 900px;">
                    <div class="row no-gutters">
                        <div class="col-md-4">
                            <img src="${listValue.hotelInfo.hotelImageUrl}" class="card-img" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${listValue.hotelInfo.hotelName}</h5>
                                <p class="card-text"><span class="label">Destination:</span> ${listValue.destination.longName}</p>
                                <p class="card-text"><span class="label">Hotel Star Rating:</span> ${listValue.hotelInfo.hotelStarRating}</p>
                                <p class="card-text"><span class="label">Hotel Guest Review Rating:</span> ${listValue.hotelInfo.hotelGuestReviewRating}</p>
                                <p class="card-text"><span class="label">${listValue.offerDateRange.travelStartDate[1]}/${listValue.offerDateRange.travelStartDate[2]} - ${listValue.offerDateRange.travelEndDate[1]}/${listValue.offerDateRange.travelEndDate[2]}</p>
                                <p class="card-text"><span class="label">Price:</span> ${listValue.hotelPricingInfo.displayPriceValue} ${listValue.hotelPricingInfo.currency}</p>
                                <p class="card-text"><span class="label">Save:</span> ${listValue.hotelPricingInfo.percentSavings}%</p>
                                <a href="${listValue.hotelUrls.hotelInfositeUrl}%" class="btn btn-primary">Check on Expedia Site</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </c:if>
    </div>
</section>
