var jobDes = $('.select-jobdescription');
var strongEl = $('p>strong:contains(Requirements)')
var requirements = $('.select-requirements>p');
var requirementsUL = $('.select-requirements >ul');
var salary = $('p:contains(salary)');
var salaryInStrong = $('p>strong:contains(salary)');
var salaryInStrongUpp = $('p>strong:contains(Salary)');
var salary2 = $('p:contains(basic wage)'); 



$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Education"
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Education:"
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Experience";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Experiences";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Language";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Languages";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Languages:";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Others";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Soft Skills";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Soft skills";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "Certification";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "IT Technical Skills";
}).css({"color":"#E20074"});
$(".select-requirements p").filter(function() {
	// Matches exact string   
	return $(this).text() === "We expect from you:";
}).css({"color":"#E20074"});






//Find all elements by paragraf	
var emptyEl = document.querySelectorAll('p');
var brEl = $('br');
//Arrow function 
var cleaner = el => {
	if (el.innerHTML == '&nbsp;' || el.innerHTML == '') {
		el.parentNode.removeChild(el);
	}
}
for (let el of emptyEl) {
	cleaner(el);
}

$('span:empty:only-child').parent('p').remove();
$("li:nth-child(n+3)").hide();

strongEl.remove();
brEl.remove();
salary.remove();
salaryInStrong.hide();
salaryInStrongUpp.hide();
salary2.hide();

$('p').each(function(index, item) {
    if($.trim($(item).text()) === '') {
        $(item).remove();
    }
});	