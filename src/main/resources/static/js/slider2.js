var slideIndex = 8;

// SHORT INFO OF POSITIONS FOR SCREEN 2, LIST OF POSITIONS
var slides = document.getElementsByClassName("positionRow");

// MORE DETAILED INFO OF POSTIONS FOR SCREENS 3 AND 4
var screens = document.getElementsByClassName("screens");

/*
 * ON START SETS ALL POSITION ROWS FROM POSITION LIST EXCEPT FOR FIRST 10 TO
 * DISPLAY-NONE
 */
for (i = 18; i < slides.length; i++) {
	slides[i].style.display = "none";
}

/*
 * ON START SETS ALL POSITIONS TO DISPLAY-NONE
 */
for (i = 0; i < screens.length; i++) {

	screens[i].style.display = "none";

}

var e = 0;

var side = true;
showSlides();

/*
 * ON THE SCREEN 2 ITERATES OVER A LIST OF POSITONS DISPLAYING 10 ROWS WITH
 * SHORT INFO AT A TIME, MOVING BY ONE ROW
 */
function showSlides() {
	var first = slides[0];

	if (slides.length < 19) {
		for (var i = 1; i < slides.length; i++) {
			slides[i - 1].style.display = "table-row";
		}
	} else {

		first.style.display = "none";
		slides[0].parentNode.removeChild(slides[0]);
		document.getElementById("positionsTable").appendChild(first);
		slides[18 - 1].style.display = "table-row";
		setTimeout(showSlides, 2000);
	}

}