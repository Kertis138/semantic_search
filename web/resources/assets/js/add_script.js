$('.add_script').each(function() {

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


    var cs_button = $("#add_script_button");
    var cs_textarea = $("#add_script_textarea");
    var cs_name = $("#add_script_name");
    var modal = $("#add_script_modal");
    var modalBody = $("#add_script_modal_body");

    cs_button.click(function() {
        $.ajax({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
            url: "api/script_add",
            type: "POST",
            data: {"script":cs_textarea.val(), "name":cs_name.val()},
            success: function(data) {
                modalBody.html("<p>Драйвер успешно установлен</p>");
                modal.modal('toggle');
            },
            error: function(data) {
                modalBody.html("<p>Ошибка установки драйвера</p>");
                modal.modal('toggle');
                console.log(data);
            }
        });
    });

});