var position = document.getElementsByClassName("position");

var displayed = document.getElementsByClassName("displayed");

for (i = 0; i < position.length; i++) {

	position[i].style.display = "none";

}

var e = 0;
positionSlider();

function positionSlider() {

	if (displayed.length < 3) {
		if (displayed.length < 2) {
			displayed[0].style.display = "block";
		} else {
			displayed[0].style.display = "block";
			displayed[1].style.display = "block";
		}
	} else {

		if (displayed.length == 3) {
			if (e == 0) {
				displayed[displayed.length - 1].style.display = "none";
				displayed[e].style.display = "block";
				e++;
				displayed[e].style.display = "block";
				e++;
			} else {
				displayed[e].style.display = "block";
				displayed[0].style.display = "none";
				e = 0;

			}

		} else {
			if (e == 0) {
				displayed[displayed.length - 2].style.display = "none";
				displayed[e].style.display = "block";

				displayed[displayed.length - 1].style.display = "none";
				displayed[e + 1].style.display = "block";

				e += 2;
			} else {

				displayed[e].style.display = "block";
				displayed[e - 2].style.display = "none";
				e++;
				if (e >= displayed.length) {
					e = 0;
				} else {
					displayed[e].style.display = "block";
					displayed[e - 2].style.display = "none";
					e++;
				}
				// displayed[e+1].style.display = "block";
				// displayed[e - 1].style.display = "none";
				//			

			}
		}
		if (e >= displayed.length) {
			e = 0;
		}
	}
	setTimeout(positionSlider, 3000);
}
