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
	return $(this).text() === "Education" || $(this).text() === "Education:" || 
	$(this).text() === "Experience"  || $(this).text() === "Experiences" || $(this).text() === "Language" ||  
	$(this).text() === "Languages"|| $(this).text() === "Others" || $(this).text() === "Soft Skills" || 
	$(this).text() === "Soft skills" || $(this).text() === "Certification" || $(this).text() === "IT Technical Skills" || $(this).text() === "Technical Skills"||
	$(this).text() === "We expect from you:"
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