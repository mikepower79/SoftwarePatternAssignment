var DD = DD || {};

DD.initialize = function()
{
	//set initial variables
	//dropTo = $('#dropTo');			//box dropping items too
	//numItems = $('.boxItem').size();	//number of draggable items
	
	   $('.boxItem').attr('draggable',true).bind('dragstart', function(e){
			//e.originalEvent.dataTransfer.effectAllowed = 'copy';
			e.originalEvent.dataTransfer.setData("Text", this.id);	
		});
	
	/*for(var i=0; i < numItems; i++)		//for each of these items you add an event handler
	{
		$('.boxItem')[i].addEventListener("dragstart", DD.startDrag, false);	//everytime you start to drag an item it calls the startDrag function
	};*/
	//dropTo.addEventListener("dragenter", DD.preventDragDefault, false);	
	//event handlers for DropTO
	$('#dropTo').bind('dragenter dragover ',false);
	$('#dropTo').bind('drop',function(e){
		e.stopPropagation();
		e.preventDefault(); 
		
		var data = e.originalEvent.dataTransfer.getData("Text");//get the id of the element that is being dropped into the box
        var cols = data.split('-');	//make a copy of this element
        $('#selectedServers tr:last').after('<tr><td>'+cols[0] +'</td><td>'+cols[1] +'</td><td>'+cols[2] +'</td><td>'+cols[3] +'</td></tr>');
		
	});
	//dropTo.addEventListener("dragover", DD.preventDragDefault, false);
	//dropTo.addEventListener("drop", DD.dropped, false);
//	populateTable(true);
};

DD.startDrag = function(e)
{
	e.dataTransfer.effectAllowed = 'copy';
	e.dataTransfer.setData("Text", this.id);			// every time you start dragging it stores the ID of the element into the Event so that we can use it
};

DD.preventDragDefault = function(e)
{
	e.preventDefault();
};

DD.dropped = function(e)				//called when element is dropped into the box
{
	//e.preventDefault();
	var data = e.dataTransfer.getData("text/plain");//get the id of the element that is being dropped into the box
	alert(data);
	var clone = $("#"+data).clone();				//make a copy of this element
		
	clone.click(function() {						//here we have an option to delete but it doesn't delete from database... you will have to do that part
		$(this).remove();
		$.ajax("/CloudProject/DatabaseServlet?id=" + $('#dcDropDown').val() + "&Floor=" + $('#floorDropDown').val() + "&Rack=" + $('#rackDropDown').val() +"&Server=" + $('n').val(),{
		method: "GET",
		async: false,
		data: {
			"dragId" : $(this).attr("data-id"),
			"dragName" : name
		}
	});
	populateTable();
	});
	$("#dropTo").append(clone);					//put into the box
	
	var name = $("#"+data).find(".left").html().trim();		//get the name of the element that was dropped in... also trim the white space
	$.ajax("storeDrag.php", {			//takes the name and sends it to a DB
		method: "GET",
		async: false,
		data: {
			"dragName" : name
			},
		success: function(oId) {			//stores the ID of the dragged item so that we can delete that one in particular if needed
			clone.attr("data-id", oId.id);
		}
	});
	populateTable();
};

function deleteDb() {				//delete everything
	$.ajax("deleteDb.php", {
		async: false				//this makes it wait for the call to be finished so that we can use PopulateTable
	});
	populateTable();
	$("#dropTo").empty();
}

function populateTable(bPopulateDrags) {
	$.ajax("getItems.php", {		
		success: function(oData) {		//this function is executed when we get the data back
			var tbl = $("#resultTbl");	//get the table
			tbl.empty();				//we empty the table ... stop the table building on top of itself
			for(var ind in oData) {		//for every item in the data we get, we append a row into the table
				tbl.append($("<tr><td>"+oData[ind]['id']+"</td><td>"+oData[ind]['name']+"</td><td>"+oData[ind]['added']+"</td></tr>"));		
				
				if(bPopulateDrags) {	//if there are already elements in the table, they will be shown in the dragged box
					var elem = $('<div id="item'+ind+'" class="boxItem" draggable="true" data-id="'+oData[ind]['id']+'"> <div class="left"> '+oData[ind]['name']+'</div></div>');
					elem.click(function() {						
						$(this).remove();
						$.ajax("removeDrag.php", {			//takes the name and sends it to a DB
							method: "GET",
							async: false,
							data: {
								"dragId" : $(this).attr("data-id"),
								"dragName" : name
							}
						});
						populateTable();
					});
					$("#dropTo").append(elem);

				}
			}
		}
	});

}

 var oModel = {
	dcs: {}
 };
 
 function handleDcSelect(ev) {
	var selected = $(ev).find(":selected").text();
	populateFloorSelect(selected);
 }

 function handleFloorSelect(ev) {
	var selected = $(ev).find(":selected");
	var dc = $(selected).attr("data-dc");
	var sFloor = $(selected).text();
	populateRackSelect(dc, sFloor);
 }

 function handleRackSelect(ev) {
	var selected = $(ev).find(":selected");
	var dc = $(selected).attr("data-dc");
	var sFloor = $(selected).attr("data-floor");
	var rack = $(selected).attr("data-rack");
	
	console.log(dc + " " + sFloor + " " + rack);
	populateServersList(dc, sFloor, rack);
 }
 
 function populateDcSelect() {
	var sel = $("#dcSelect");
	
	sel.append($("<option>Please select dc</option>"));
	
	for(var idx in oModel.dcs) {
		sel.append($("<option>" + idx + "</option>"));
	}
 }
 
 function populateFloorSelect(dc) {
	var sel = $("#floorSelect");
	sel.empty();
	
	if(oModel.dcs[dc]) {
		sel.append($("<option>Please select floor</option>"));

		for(var i = 0; i < oModel.dcs[dc].floors.length; i++) {
			sel.append($("<option data-dc='"+dc+"'> "+i+"</option>"));

		}	
	}
 }

 function populateRackSelect(dc, sFloor) {
	var sel = $("#rackSelect");
	sel.empty();

	if(oModel.dcs[dc].floors[parseInt(sFloor)]) {
		sel.append($("<option>Please select rack</option>"));

		for(var i = 0; i < oModel.dcs[dc].floors[parseInt(sFloor)].racks.length; i++) {
			sel.append($("<option data-dc='"+dc+"' data-floor='"+sFloor+"' data-rack='"+i+"'> "+oModel.dcs[dc].floors[parseInt(sFloor)].racks[i].rack+"</option>"));

		}	
	}
	

 }

 function populateServersList(dc, sFloor, rack) {
	var sel = $("#dragFrom");
	sel.empty();

	if(oModel.dcs[dc].floors[parseInt(sFloor)].racks[parseInt(rack)].servers) {

		for(var i = 0; i < oModel.dcs[dc].floors[parseInt(sFloor)].racks[parseInt(rack)].servers.length; i++) {
			sel.append($('<div id="item'+i+'" class="boxItem" draggable="true"> <div class="left"> '+oModel.dcs[dc].floors[parseInt(sFloor)].racks[parseInt(rack)].servers[i].ip+'</div></div>'));

		}	
		DD.initialize();

	}
			

 }
 
 	/*	$(document).ready(function(){  //when document is finished loading, we initialise drag and drop
			DD.initialize();
			$jQuery.get("PopulatingField.jsp", {
				success: function(data) {
					oModel.dcs = data;
					populateDcSelect();

				}
			});
		}); */
 
 
 
 
	$(document).ready(function(){
		$("#dcDropDown").val('select a data center');
		$("#floorDropDown").val('please select a datacenter');
		$("#rackDropDown").val('please select a floor');
		$("#serverDropDown").val('please select a rack');
		$("#dcDropDown").change(function(){
		
			 $.get("/papillonjsp/FillFields?Datacenter=" + $('#dcDropDown').val() + "&Type=Floor" )
			.done(function( data ) {
				$("#floorDropDown").html(data);
				
				});
		});
		
		$("#floorDropDown").change(function(){
			
			 $.get("/papillonjsp/FillFields?Datacenter=" + $('#dcDropDown').val() + "&Floor=" + $('#floorDropDown').val() + "&Type=Rack" )
			.done(function( data ) {
				$("#rackDropDown").html(data);
				});
		});
		$("#rackDropDown").change(function(){
			 $.get("/papillonjsp/FillFields?Datacenter=" + $('#dcDropDown').val() + "&Floor=" + $('#floorDropDown').val() + "&Rack=" + $('#rackDropDown').val() +"&Type=Server" )
			.done(function( data ) {
				$("#servers").html(data);
				DD.initialize();
				});
		});

		
	});
	
