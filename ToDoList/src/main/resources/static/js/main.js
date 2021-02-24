$(function(){

    const appendDeal = function(data){
        var bookCode = '<a href="#" class="list-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#deal-list')
            .append('<div>' + listCode + '</div>');
    };

//    Loading books on load page
//    $.get('/lists/', function(response)
//    {
//        for(i in response) {
//            appendDeal(response[i]);
//        }
//    });

    //Show adding book form
    $('#show-add-deal-form').click(function(){
        $('#deal-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#deal-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting book
    $(document).on('click', '.list-link', function(){
        var link = $(this);
        var listId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/lists/' + listId,
            success: function(response)
            {
                var code = '<span>День недели:' + response.day + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Дело не найдено!');
                }
            }
        });
        return false;
    });

    //Adding book
    $('#save-deal').click(function()
    {
        var data = $('#deal-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/lists/',
            data: data,
            success: function(response)
            {
                $('#deal-form').css('display', 'none');
                var book = {};
                book.id = response;
                var dataArray = $('#deal-form form').serializeArray();
                for(i in dataArray) {
                    book[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendDeal(book);
            }
        });
        return false;
    });

});