setTimeout(mato, 10000);


var slideIndex = 7;

var slides = document.getElementsByClassName("positionRow");

for (i = 7; i < slides.length; i++) {
	slides[i].style.display = "none";
}

showSlides();

function showSlides() {

	var delayInMilliseconds = 10000;
	
	slideIndex++;

	if (slideIndex > slides.length) {
		/*
		 * for (i = 10; i < slides.length; i++) { slides[i].style.display =
		 * "none";}
		 */
		slideIndex = slides.length - 34

		/*
		 * for (i = 1; i < 10; i++) { slides[i].style.display = "table-row";}
		 */
	}

	slides[slideIndex - 1].style.display = "table-row";

	if (slideIndex < 8) {
		slides[slides.length - (8 - slideIndex)].style.display = "none";
	} else {
		slides[slideIndex - 8].style.display = "none";
	}

	setTimeout(showSlides, delayInMilliseconds);
}


function mato(){
	
}



