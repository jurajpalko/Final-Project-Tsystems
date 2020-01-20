

var slideIndex = 9;
/*var firstRow= slideIndex-4;*/

var slides = document.getElementsByClassName("positionRow");


for (i = 9; i < slides.length; i++) {
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


	if (slideIndex < 10) {
		slides[slides.length - (10 - slideIndex)].style.display = "none";
		
	} else {
		slides[slideIndex - 10].style.display = "none";
	
	}

	setTimeout(showSlides, 1000);
}


	



