var x = document.getElementsByClassName("format-date");
var temp = Array();
for (var i = 0; i < x.length; i++) {
	  temp[i] = x[i].innerText;
	  x[i].innerHTML = formatDate (new Date(Date.parse(temp[i])));
}
function formatDate(date) {
	  var monthNames = [
	    "Jan", "Feb", "Mar,
	    "Apr", "May", "Jun", "Jul",
	    "Aug", "Sep", "Oct",
	    "Nov", "Dec"
	  ];

	  var day = date.getDate();
	  var monthIndex = date.getMonth();
	  var year = date.getFullYear();

	  return day + '. ' + monthNames[monthIndex] + '. ' + year;
	}