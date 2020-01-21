var jobDes = $('.select-jobdescription');
var strongEl = $('p>strong');

var requirements = $('.select-requirements>p');
var requirementsUL = $('.select-requirements >ul');
$('span:empty:only-child').parent('p').remove();
$("li:nth-child(n+3)").hide();

strongEl.remove();
