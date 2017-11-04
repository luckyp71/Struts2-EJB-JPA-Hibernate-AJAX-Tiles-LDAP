//add employee
function addEmployee(){
    var name = $('#name').val();
    var age = $('#age').val();
    $('.loadingProcess').show();
    $.ajax({
       type:'POST',
       url:'addEmployee',
       data:'name='+name+'&age='+age,
       success:function(data){
           var ht = data;
           $('#respo').html(ht);
       },
       error:function(){
           alert('Some error occured');
       },
       complete :function(){
           $('.loadingProcess').hide();
           alert('Successfully added employee');
       }
    });
}

//update employee
function updateEmployee(){
    var id = $('#id').val();
    var name = $('#name').val();
    var age = $('#age').val();
    $('.loadingProcess').show();
    $.ajax({
       type:'POST',
       url:'updateEmployee',
       data:'id='+id+'&name='+name+'&age='+age,
       success:function(data){
           var ht = data;
           $('#respo').html(ht);
       },
       error:function(){
           alert('Some error occured');
       },
       complete: function(){
           $('.loadingProcess').hide();
           alert('Successfully updated employee');
       }
    });
}

//delete employee
function deleteEmployee(){
    var id = $('#id').val();
    $('.loadingProcess').show();
    $.ajax({
       type:'POST',
       url:'deleteEmployee',
       data:'id='+id,
       success:function(data){
           var ht = data;
           $('#resp').html(ht);
       },
       error:function(){
           alert('Some error occured');
       },
       complete:function(){
           $('.loadingProcess').hide();
           alert('Successfully deleted employee');
       }
    });
}