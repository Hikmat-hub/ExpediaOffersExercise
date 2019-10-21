function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if ((charCode > 31 && charCode < 48) || charCode > 57) {
        return false;
    }
}

$(document).ready(function(){
    $('#datepicker-date1').datepicker({
        uiLibrary: 'bootstrap4'
    });

    $('#datepicker-date2').datepicker({
        uiLibrary: 'bootstrap4'
    });

    $(":input[type='number']").keypress(function(e){
        var keyCode = e.which;
        if ( !( (keyCode >= 48 && keyCode <= 57)
            ||(keyCode >= 65 && keyCode <= 90)
            || (keyCode >= 97 && keyCode <= 122) )
            && keyCode != 8 && keyCode != 32) {
            e.preventDefault();
        }
    });
});

