
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


function update_status_canvas() {
    $.ajax({
        url: "api/status",
        type: "GET",
        success: function(data) {
            var dataObj = JSON.parse(data);
            if(dataObj.status != "1")
                return;

            var myData = dataObj.requestCount.slice(1,1+10);
            var allData = dataObj.requestCount.slice(10,10+10);
            myChart.data.datasets[0].data = allData;
            myChart.data.datasets[1].data = myData;
            myChart.update();
        },
        error: function(data) {
            console.log(data);
        }
    });
}
update_status_canvas();
setInterval(update_status_canvas, 1000 * 5);
 
