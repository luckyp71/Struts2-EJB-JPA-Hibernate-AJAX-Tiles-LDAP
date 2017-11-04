$('.loadingProcess').hide();

function employees() {
    $('.loadingProcess').show();
    $.ajax({
        type: 'GET',
        url: 'employees',
        success: function (data) {
            document.getElementById('resp').innerHTML = data;
        },
        error: function () {
            alert("Error");
        },
        complete: function () {
            $('.loadingProcess').hide();
        }
    });
}
function manageEmployee() {
    $('.loadingProcess').show();
    $.ajax({
        type: 'GET',
        url: 'manageEmployee',
        success: function (data) {
            document.getElementById('resp').innerHTML = data;
        },
        error: function(){
          alert('Some error occured');  
        },
        complete: function () {
            $('.loadingProcess').hide();
        }
    });
}
function getEmployeeById(){
    var id = $('#id').val();
    $('.loadingProcess').show();
    $.ajax({
       type:'GET',
       url:'getEmployeeById',
       data:'id='+id,
       success: function(data){
           var ht = data;
           document.getElementById('resp').innerHTML=ht;
       },
       error: function(){
           alert('Some error occured');
       },
       complete: function(){
           $('.loadingProcess').hide();
       }
    });
}








