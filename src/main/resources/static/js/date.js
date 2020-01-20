var x = document.getElementsByClassName("format-date");
var temp = Array();
for (var i = 0; i < x.length; i++) {
	  temp[i] = x[i].innerText;
	  x[i].innerHTML = formatDate (new Date(Date.parse(temp[i])));
}
function formatDate(date) {
	  var monthNames = [
	    "1", "2", "3",
	    "4", "5", "6", "7",
	    "8", "9", "10",
	    "11", "12"
	  ];

	  var day = date.getDate();
	  var monthIndex = date.getMonth();
	  var year = date.getFullYear();

	  return day + '. ' + monthNames[monthIndex] + '. ' + year;
	}