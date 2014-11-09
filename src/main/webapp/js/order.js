$(function() {
    //监听保存数据事件
    $("#saveOrder").on('click', function(){
        $('#saveOrder').attr('disabled',true);
        $('.form-horizontal').ajaxSubmit({
            url: '/orders/create',
            type: 'post',
            success: function(responseText){
                var res = $.parseJSON(responseText);
                if(res.success){
                    var form = $("#orderForm");
                    form.empty();
                    form.append(res.msg);
                }else{
                    cleanErrorCss();
                    $("input[name='"+ res.field +"']").parent().parent().addClass('has-error');
                    $('#saveOrder').attr('disabled',false);
                }
            }
        });
    });
});

function cleanErrorCss(){
    var fields = $('.has-error');
    $.each(fields, function(index, field) {
        $(field).removeClass('has-error');
    });
}