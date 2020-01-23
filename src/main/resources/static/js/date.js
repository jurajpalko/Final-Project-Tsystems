var x = document.getElementsByClassName("format-date");
var temp = Array();
for (var i = 0; i < x.length; i++) {
	  temp[i] = x[i].innerText;
	  x[i].innerHTML = formatDate (new Date(Date.parse(temp[i])));
}
function formatDate(date) {
	

	  var monthNames = [ "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" ];

	  var day = date.getDate();
	  
	  if(day<10) day = "0"+day;
	  var monthIndex = date.getMonth();
	  var year = date.getFullYear();

	  return day + '. ' + monthNames[monthIndex] + '. ' + year;
	}