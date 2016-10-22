$(function () {
    Highcharts.setOptions({
        global : {
            useUTC : false
        }
    });
    // Create the chart
    $('#datauser').highcharts('StockChart', {
        chart : {
            events : {
                load : function () {
                    // set up the updating of the chart each second
                    var series = this.series[0];
                    setInterval(function () {
                    	onlineUserNum();
                        var x = (new Date()).getTime(), // current time
                            y = num;
                        series.addPoint([x, y], true, true);
                    }, 1000);
                }
            }
        },
        rangeSelector: {
            buttons: [{
                count: 1,
                type: 'minute',
                text: '1M'
            }, {
                count: 5,
                type: 'minute',
                text: '5M'
            }, {
                type: 'all',
                text: 'All'
            }],
            inputEnabled: false,
            selected: 0
        },
        title : {
            text : '当前实时在线人数'
        },
        exporting: {
            enabled: false
        },
        series : [{
            name : '在线人数:',
            data : (function () {
                // generate an array of random data
                var data = [], time = (new Date()).getTime(), i;
                for (i = -999; i <= 0; i += 1) {
                    data.push([
                        time + i * 1000,
                        0
                    ]);
                }
                return data;
            }())
        }]
    });
    
    var num = 0;
    //获取在线人数
    function onlineUserNum() {
		$.ajax({
			url : 	path+"getonlinenum.do",
			type : "get",
			dataType : "json",
			success:function(result) {
				num = result;
			}
		});
		
		
		
		
	}
    
});
