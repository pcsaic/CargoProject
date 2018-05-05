$(document).ready(
    function() {
        $.get('/truck',
            function (data){
                $.each(data, function(i, truck) {
                    $('#table_truck')
                        .append(
                            '<tr id="'+truck.id+'">' +
                            '<td>'+truck.number+'</td>' +
                            '<td>'+truck.status+'</td>' +
                            '<td>'+truck.point+'</td>' +
                            '<td> <input type="button" onclick="remove(' + truck.id + ')" value="Delete"></td>' +
                            '</tr>'
                        );
                });
            },
            'JSON');

        $.get('/driver',
            function (data){
                $.each(data, function(i, driver) {
                    $('#table_driver')
                        .append(
                            '<tr id="'+driver.id+'">' +
                            '<td>'+driver.name+'</td>' +
                            '<td>'+driver.surname+'</td>' +
                            '</tr>'
                        );
                });
            },
            'JSON');


        $( "#button" ).click(function() {
            var j = {
                number:  $('[id = number]').val(),
                tonnage: $('[id = tonnage]').val(),
                status:  $('[id = status]').val(),
                point:   $('[id = point]').val()
            };

            // внимателльно смотри !!! не в виде json тк далее идет stringify!!!

            var jsonTruck = JSON.stringify(j);

            $.post('/truck',
                jsonTruck,
                function (){
                    location.reload();
                }
            );

        });

        $( "#button2" ).click(function() {
            var x = {
                name:  $('[id = name]').val(),
                surname:   $('[id = surname]').val()
            };

            // внимателльно смотри !!! не в виде json тк далее идет stringify!!!

            var jsonDriver = JSON.stringify(x);

            $.post('/driver',
                jsonDriver,
                function (){
                    location.reload();
                }
            );

        });
    });

function remove(id) {
    $.ajax({
        url: '/truck/' + id,
        type: 'DELETE',
        success: function() {
            location.reload();
        }
    });

}
