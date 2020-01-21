
var slideIndex = 8;
/* var firstRow= slideIndex-4; */

var slides = document.getElementsByClassName("positionRow");

var screens = document.getElementsByClassName("screens");
var screen3 = document.getElementsByClassName("screen-three");
var screen4 = document.getElementsByClassName("screen-four");

for (i = 10; i < slides.length; i++) {
	slides[i].style.display = "none";
}

for(i=0; i<screens.length;i++){
//	if (i==1) {
//		screens[i].style.display = "block";
//		screens[i].className = "col-6 screen-three screens";
//	}else if(i==2){		
//		screens[i].style.display = "block";
//		screens[i].className = "col-6 screen-four screens";
//	}
//	else{
		screens[i].style.display = "none";		
//	}
}

var e =0;

var side = true;
showSlides();


function showSlides() {


	slideIndex++;

	if (slideIndex > slides.length) {

		slideIndex = 1;
	}

	slides[slideIndex - 1].style.display = "table-row";

	if (slideIndex < 11) {
		slides[slides.length - (11 - slideIndex)].style.display = "none";

	} else {
		slides[slideIndex - 11].style.display = "none";

	}
	
	
	if (e==0) {
		screens[e].style.display = "block";
		screens[screens.length-2].style.display = "none";
		if (side==true) {
			screens[screens.length-2].className = "screens"
			screens[e].className = "col-6 screen-three screens";
			side=false;
		}else{
			screens[screens.length-2].className = "screens"
			screens[e].className = "col-6 screen-four screens";
			side=true;
		}
		e++;
	}
	else if (e==1) {
		screens[e].style.display = "block";
		screens[screens.length-1].style.display = "none";
		if (side==true) {
			screens[screens.length-1].className = "screens"
			screens[e].className = "col-6 screen-three screens";
			side=false;
		}else{
			screens[screens.length-1].className = "screens"
			screens[e].className = "col-6 screen-four screens";
			side=true;
		}
		e++;
	}
	else{
		screens[e].style.display = "block";
		screens[e-2].style.display = "none";
		if (side==true) {
			screens[e-2].className = "screens"
			screens[e].className = "col-6 screen-three screens";
			side=false;
		}else{
			screens[e-2].className = "screens"
			screens[e].className = "col-6 screen-four screens";
			side=true;
		}
		e++;
	}
	if (e==screens.length) {
		e=0;
	}

	setTimeout(showSlides, 3000);
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