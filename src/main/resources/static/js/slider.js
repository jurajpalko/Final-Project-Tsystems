setTimeout(mato, 10000);


var slideIndex = 5;

var slides = document.getElementsByClassName("positionRow");

for (i = 5; i < slides.length; i++) {
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

	if (slideIndex < 6) {
		slides[slides.length - (6 - slideIndex)].style.display = "none";
	} else {
		slides[slideIndex - 6].style.display = "none";
	}

	setTimeout(showSlides, delayInMilliseconds);
}


function mato(){
	
}



