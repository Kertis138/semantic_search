$('.datamining').each(function() {

    var color = "rgba(50,255,0,0.8)";
    var server_status_span = $("#server-status-span");
    function server_error() {
        color = "rgba(255,0,0,0.8)";
    }

    function update_status_status() {
        $.ajax({
            url: "api/status",
            type: "GET",
            success: function(data) {
                var dataObj = JSON.parse(data);
                if(dataObj.status != "1") {
                    server_error();
                    return;
                }
                color = "rgba(50,255,0,0.8)";
            },
            error: function(data) {
                server_error();
            }
        });
    }

    var state = false;
    function status_blink() {
      if ( state ) {
        server_status_span.css({
          "background": "#f3f3f3",
        });
      } else {
        server_status_span.css({
          "background": color,
        });
      }
      state = !state;
    }
    update_status_status();
    setInterval(update_status_status, 1000 * 5);
    setInterval(status_blink, 500);


    var modal = $("#datamining_modal");
    var modalBody = $("#datamining_modal_body");

    var datamining_start = $("#datamining_start");
    datamining_start.click(function() {
        var driver_id = $("#datamining_select option:selected").attr("data");
        $.ajax({
            url: "api/driver_run/"+driver_id,
            type: "GET",
            success: function(data) {
                if(data != 1) {
                    modalBody.html("<p>Ошибка запуска</p>");
                }
                else {
                    modalBody.html("<p>Драйвер успешно запущен</p>");
                }
                modal.modal('toggle');
            },
            error: function(data) {
                modalBody.html("<p>Ошибка запуска</p>");
                modal.modal('toggle');
                console.log(data);
            }
        });        
    });
});