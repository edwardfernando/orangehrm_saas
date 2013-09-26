function popup(url) {
	window.open(url, 'popUpWindow', 'height=500,width=500,left=50,top=50,resizable=no,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no,status=yes');
}

function setPopUpValue(target, entityId, entityName){
	var object = window.opener.document.getElementById(target);
	object.value = entityId;
	
	var name = window.opener.document.getElementById(target + "-span");
	name.innerHTML = entityName;
	
	window.close();
}

function setFormElementValue(target, val){
	target.value = val;
}

function submit(form, action){
	document.getElementById(form).action = action;
	document.getElementById(form).submit();
}

function submitWithAdditionalFields(form, action){
	var inputs = document.forms['additionalForm'].getElementsByTagName("input");
	var elems = new Array();
	
	for(var i = 0; i <= inputs.length; i++){
		if(inputs[i] != undefined && inputs[i].type != 'hidden'){
			var x = inputs[i].name + "," + inputs[i].value; 
			elems[i] = x;
		}
	}

	var module_name = document.getElementById("module_name").value;
	var model_id = document.getElementById("model_id").value;
	
	additionalFieldsDWR.saveAdditionalFields(elems, module_name, model_id,{
		callback : function(){
			submit(form, action);
		}
	});
}

$(document).ready(function(){
	
	var defaultDateFormat = document.getElementById('default_date_format').value;
	
    $('.datepicker').datepicker({
	      changeMonth: true,
	      changeYear: true,
	      //dateFormat : 'dd/mm/yy',
	      dateFormat : defaultDateFormat,
	      showOn : 'button'
      });
    
    $(".draggable").draggable({
    	scroll: true,
        grid: [10, 10],
        drag: function(){
        	var $this = $(this);
            var divElement = $this.attr('id').split("-");
            document.getElementById(divElement[0] + "-position").value = $(this).css('left') + "," + $(this).css('top');
        }
    });
    
});