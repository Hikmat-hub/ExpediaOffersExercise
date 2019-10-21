<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<section class="search-sec">
    <div class="container">
        <form:form action="/filter" modelAttribute="offersRequest" method="get" novalidate="novalidate">
            <div class="row">
                <div class="col-lg-12">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="destinationName" type="text" class="form-control search-slt" placeholder="Destination Name" id="destinationName"/>
                                <span>Destination Name</span>
                            </label>
                            <form:errors path="destinationName" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="minTripStartDate" id="datepicker-date1" readonly="true" class="datepicker-date form-control search-slt" placeholder="Min Trip Start Date" />
                                <span>Min Trip Start Date</span>
                            </label>
                            <form:errors path="minTripStartDate" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="maxTripStartDate" id="datepicker-date2" readonly="true" class="datepicker-date form-control search-slt" placeholder="Max Trip Start Date" />
                                <span>Max Trip Start Date</span>
                            </label>
                            <form:errors path="maxTripStartDate" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="lengthOfStay" type="number" class="form-control search-slt" placeholder="Length Of Stay" min="1" />
                                <span>Length Of Stay</span>
                            </label>
                            <form:errors path="lengthOfStay" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="maxStarRating" type="number" class="form-control search-slt" placeholder="Max Star Rating" min="0" max="5"/>
                                <span>Max Star Rating</span>
                            </label>
                            <form:errors path="maxStarRating" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="minStarRating" type="number" class="form-control search-slt" placeholder="Min Star Rating" min="0" max="5"/>
                                <span>Min Star Rating</span>
                            </label>
                            <form:errors path="minStarRating" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="maxTotalRate" type="number" class="form-control search-slt" placeholder="Max Total Rate" min="0" max="5"/>
                                <span>Max Total Rate</span>
                            </label>
                            <form:errors path="maxTotalRate" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="minTotalRate" type="number" class="form-control search-slt" placeholder="Min Total Rate" min="0" max="5"/>
                                <span>Min Total Rate</span>
                            </label>
                            <form:errors path="minTotalRate" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="maxGuestRating" type="number" class="form-control search-slt" placeholder="Max Guest Rating" min="0" max="5"/>
                                <span>Max Guest Rating</span>
                            </label>
                            <form:errors path="maxGuestRating" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <label class="form-group has-float-label">
                                <form:input path="minGuestRating" type="number" class="form-control search-slt" placeholder="Min Guest Rating" min="0" max="5"/>
                                <span>Min Guest Rating</span>
                            </label>
                            <form:errors path="minGuestRating" cssClass="error" />
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                            <button type="submit" class="btn btn-danger wrn-btn">Search</button>
                        </div>
                        <form:errors path="" cssClass="error" />
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</section>
