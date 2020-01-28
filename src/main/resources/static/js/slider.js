
var slideIndex = 8;

//SHORT INFO OF POSITIONS FOR SCREEN 2, LIST OF POSITIONS
var slides = document.getElementsByClassName("positionRow");

//MORE DETAILED INFO OF POSTIONS FOR SCREENS 3 AND 4
var screens = document.getElementsByClassName("screens");

/*
 * ON START SETS ALL POSITION ROWS FROM POSITION LIST EXCEPT FOR FIRST 10 TO DISPLAY-NONE
 * */
for (i = 10; i < slides.length; i++) {
	slides[i].style.display = "none";
}

/*
 * ON START SETS ALL POSITIONS TO DISPLAY-NONE
 * */
for(i=0; i<screens.length;i++){

		screens[i].style.display = "none";		

}

var e =0;

var side = true;
showSlides();

/* ON THE SCREEN 2
 * ITERATES OVER A LIST OF POSITONS DISPLAYING 10 ROWS WITH SHORT INFO AT A TIME, MOVING BY ONE ROW
 * */
function showSlides() {

	slideIndex++;

	if (slides.length < 11) {
		for (var i = 1; i < slides.length; i++) {
			slides[i - 1].style.display = "table-row";
		}
	} else {

		if (slideIndex > slides.length) {

			slideIndex = 1;
		}
		slides[slideIndex - 1].style.display = "table-row";

		if (slideIndex < 11) {
			slides[slides.length - (11 - slideIndex)].style.display = "none";

		} else {
			slides[slideIndex - 11].style.display = "none";

		}
	}

	positionSlider();

	// TIME FOR ONE STEP AND SELF CALL
	setTimeout(showSlides, 500);
}

/*
 * ON THE SCREEN 3 AND 4 ITERATES OVER A LIST OF POSTIONS DISPLAYING 2
 * POSITIONS AT A TIME WITH MORE INFO, SWITCHING SCREEN 3 AND SCREEN 4 FOR
 * NEXT POSITION SETTING DISPLAY-BLOCK FOR 1 POSITON AND DISPALY-NONE FOR
 * PREVIOUS ONE BY ONE
 */

function positionSlider() {

	
	if (slides.length < 3) {
		screens[0].style.display = "block";
		screens[0].className = "col-6 screen-three screens";

		screens[1].style.display = "block";
		screens[1].className = "col-6 screen-four screens";

	} else {

		if (e == 0) {
			screens[e].style.display = "block";
			screens[screens.length - 2].style.display = "none";
			if (side == true) {
				screens[screens.length - 2].className = "screens"
				screens[e].className = "col-6 screen-three screens";
				side = false;
			} else {
				screens[screens.length - 2].className = "screens"
				screens[e].className = "col-6 screen-four screens";
				side = true;
			}
			e++;
		} else if (e == 1) {
			screens[e].style.display = "block";
			screens[screens.length - 1].style.display = "none";
			if (side == true) {
				screens[screens.length - 1].className = "screens"
				screens[e].className = "col-6 screen-three screens";
				side = false;
			} else {
				screens[screens.length - 1].className = "screens"
				screens[e].className = "col-6 screen-four screens";
				side = true;
			}
			e++;
		} else {
			screens[e].style.display = "block";
			screens[e - 2].style.display = "none";
			if (side == true) {
				screens[e - 2].className = "screens"
				screens[e].className = "col-6 screen-three screens";
				side = false;
			} else {
				screens[e - 2].className = "screens"
				screens[e].className = "col-6 screen-four screens";
				side = true;
			}
			e++;
		}
		if (e == screens.length) {
			e = 0;
		}

	}
}
