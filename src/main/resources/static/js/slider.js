

var slideIndex = 6;
/*var firstRow= slideIndex-4;*/

var slides = document.getElementsByClassName("positionRow");


for (i = 6; i < slides.length; i++) {
	slides[i].style.display = "none";
}

showSlides();

function showSlides() {

	var delayInMilliseconds = 10000;
	
	slideIndex++;

	if (slideIndex > slides.length) {
		
		slideIndex = 1;
	}

	slides[slideIndex - 1].style.display = "table-row";
slides[slideIndex - 4].style.color = "white !important";


	if (slideIndex < 7) {
		slides[slides.length - (7 - slideIndex)].style.display = "none";
		
	} else {
		slides[slideIndex - 7].style.display = "none";
	
	}

	setTimeout(showSlides, 10000);
}


	



