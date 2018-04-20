$('.dashboard').each(function() {
    var myChart = new Chart($("#server-status-canvas"), {
        type: 'line',
        data: {
            labels: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"],
            datasets: [{
                label: '# Общая загруженность сервера',
                data: [],
                backgroundColor: "rgba(255,0,0,0.7)",
                borderColor: "rgba(255,0,0,0.5)",
                fill: false,
                borderWidth: 2
            },
            {
                label: '# Пользовательская загруженность сервера',
                data: [],
                backgroundColor: "rgba(0,0,255,0.7)",
                borderColor: "rgba(0,0,255,0.5)",
                fill: false,
                borderWidth: 2
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            }
        }
    });


    var color = "rgba(50,255,0,0.8)";
    var server_status_span = $("#server-status-span");
    function server_error() {
        color = "rgba(255,0,0,0.8)";
    }
    function update_status_canvas() {
        $.ajax({
            url: "api/status/requestCount",
            type: "GET",
            success: function(data) {
                var dataObj = JSON.parse(data);
                if(dataObj.status != "1") {
                    server_error();
                    return;
                }

                var myData = dataObj.requestCount.slice(1,1+10);
                var allData = dataObj.requestCount.slice(10,10+10);
                myChart.data.datasets[0].data = allData;
                myChart.data.datasets[1].data = myData;
                myChart.update();
                color = "rgba(50,255,0,0.8)";
            },
            error: function(data) {
                //console.log(data);
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
    update_status_canvas();
    setInterval(update_status_canvas, 1000 * 5);
    setInterval(status_blink, 500);
 
});
