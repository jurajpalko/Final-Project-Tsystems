//Find all elements by paragraf	
				var emptyEl = document.querySelectorAll('p');
				
				//Arrow function 
				var cleaner = el => {
					 if (el.innerHTML == '&nbsp;' || el.innerHTML == '') {
				            el.parentNode.removeChild(el);
				        }
				}
				for (let el of emptyEl) {
			        cleaner(el);
			    }
				
var jobDes = $('.select-jobdescription');
var strongEl = $('p>strong');

var requirements = $('.select-requirements>p');
var requirementsUL = $('.select-requirements >ul');
$('span:empty:only-child').parent('p').remove();
$("li:nth-child(n+3)").hide();

strongEl.remove();
