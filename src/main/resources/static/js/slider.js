
var slideIndex = 8;
/* var firstRow= slideIndex-4; */

var slides = document.getElementsByClassName("positionRow");

var screens = document.getElementsByClassName("screens");
var screen3 = document.getElementsByClassName("screen-three");
var screen4 = document.getElementsByClassName("screen-four");

for (i = 8; i < slides.length; i++) {
	slides[i].style.display = "none";
}

for(i=0; i<screens.length;i++){
	if (i==1||i==2) {
		screens[i].style.display = "block";
	}else{
		screens[i].style.display = "none";		
	}
}

//for (var a = 1; a < screen3.length; a++) {
//
//	screen3[a].style.display = "none";
//}
//for (var b = 1; b < screen4.length; b++) {
//
//	screen4[b].style.display = "none";
//}

var e =2;
//var count3 = 0;
//var count4 = 0;
showSlides();


function showSlides() {


	slideIndex++;

	if (slideIndex > slides.length) {

		slideIndex = 1;
	}

	slides[slideIndex - 1].style.display = "table-row";

	if (slideIndex < 9) {
		slides[slides.length - (9 - slideIndex)].style.display = "none";

	} else {
		slides[slideIndex - 9].style.display = "none";

	}
	
	
	if (e==0) {
		screens[e].style.display = "block";
		screens[screens.length-2].style.display = "none";
		e++;
	}
	else if (e==1) {
		screens[e].style.display = "block";
		screens[screens.length-1].style.display = "none";
		e++;
	}
	else{
		screens[e].style.display = "block";
		screens[e-2].style.display = "none";
		e++;
	}
	if (e==screens.length) {
		e=0;
	}
	

	setTimeout(showSlides, 10000);
}









//function showSlides() {
//
//	slideIndex++;
//
//	if (slideIndex > slides.length) {
//
//		slideIndex = 1;
//	}
//
//	slides[slideIndex - 1].style.display = "table-row";
//
//	if (slideIndex < 9) {
//		slides[slides.length - (9 - slideIndex)].style.display = "none";
//
//	} else {
//		slides[slideIndex - 9].style.display = "none";
//
//	}

	
	
	
//	if (true) {
//		if (count4==0) {
//			screen3[count3.length].style.display = "none";;
//		}
//		screen3[count3].style.display = "block";;
//		count3++;
//		side!=side;
//	}else{
//		screen4[count4].style.display = "block";;
//		count4++;
//		side!=side;
//	}
//	
//	
//	if(count3=screen3.length-1){
//		count3=0;
//	}
//	if(count4=screen4.length-1){
//		count4=0;
//	}
//	
//	
//	
//	
//	
//	
//	
//	if (e==0) {
//		
//		if ((screen3.length+screen4.length)%2==0) {
//			screen3[e].style.display = "block";
//			e++;
//		}
//	}
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	if (count3 == 0) {
//		screen3[screen3.length-1].style.display = "none";
//		screen3[count3].style.display = "block";
//		console.log("e= "+e);
//		console.log("screen3 count= "+count3);		
//		e++;
//		
//	}
//	if(count4==0){
//		screen4[screen4.length-1].style.display = "none";
//		screen4[count4].style.display = "block";
//		console.log("e= "+e);
//		console.log("screen4 count= "+count4);		
//		e++;
//	}
//	if(count3!=0){
//		screen3[count3-1].style.display = "none";
//		screen3[count3].style.display = "block";
//		console.log("e= "+e);
//		console.log("screen3 count= "+count3);		
//		e++;
//
//		
//	}
//	if(count4!=0){
//		screen4[count4-1].style.display = "none";
//		screen4[count4].style.display = "block";
//		console.log("e= "+e);
//		console.log("screen4 count= "+count4);		
//		e++;
//
//	}
//	count3++;
//	count4++;
//	
//
//
//	if (count3 == screen3.length-1) {
//		count3 =0;
//		if ((screen3.length+screen4.length)%2>0) {
//			e=0;
//		}
//
//		
//	}
//	if (count4 == screen4.length-1) {
//	screen3[count3].style.display = "block";
//		count4 =0;
//		if ((screen3.length+screen4.length)%2==0) {
//			e=0;
//		}
//	}
	
	

//	setTimeout(showSlides, 1000);
//}


	
	
	
	
	
	
	

//function showSlides() {
//
////	console.log("0i= "+e);
//	slideIndex++;
//
//	if (slideIndex > slides.length) {
//
//		slideIndex = 1;
//	}
//
//	slides[slideIndex - 1].style.display = "table-row";
//
//	if (slideIndex < 9) {
//		slides[slides.length - (9 - slideIndex)].style.display = "none";
//
//	} else {
//		slides[slideIndex - 9].style.display = "none";
//
//	}
//	
//	
//	
////console.log("1i= "+e);
////console.log("1count= "+count);
////								if (e == 0) {
////									screen3[e].style.display = "block";
////									count3++;
////									console.log("screen3 count= "+count3);
////									screen4[e].style.display = "block";
////									count4++;
////									console.log("screen4 count= "+count4);
////								}
////								else{
////									console.log(e - 1);
////									screen3[e - 1].style.display = "none";
////									screen3[e].style.display = "block";
////									count3++;
////									console.log("screen3 count= "+count3);
////							//		console.log("3count= "+count);
////									screen4[e - 1].style.display = "none";
////									screen4[e].style.display = "block";
////									count4++;	
////									console.log("screen4 count= "+count4);
////							//		console.log("4count= "+count);
////								}
////								
////							
////							e++;
////						console.log("e= "+e);
////						
////							if (count3 == screen3.length-1) {
////								count3 =0;
////								
////							}
////							if (count4 == screen4.length-1) {
////								count4 =0;
////								
////							}
////							if (e == count3+count4) {
////								e=0;
////							}
////	console.log("3i= "+e);
////	console.log("5count= "+count);
//	setTimeout(showSlides, 1000);
//}