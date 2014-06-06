/**
 * Created by gustavo on 01/4/14.
 */
function deviceReady() {
	$("#click1").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page2", "SLIDE_LEFT");
	});

	$("#click2").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page3", "SLIDE_LEFT");
	});
	
	$("#click3").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page8", "SLIDE_LEFT");
	});
	
	$("#click4").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page9", "SLIDE_LEFT");
	});
	
	
	$("#clickEdad").on("click", function(e) {
		param = "";
		getRegalosPorEdad(param);
	});
	
	$("#clickIntereses").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page5", "SLIDE_LEFT");
	});
	
	$("#clickPrecios").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page6", "SLIDE_LEFT");
	});
	
	$("#clickEventos").on("click", function(e) {
		mui.viewPort.showPage("mui-viewport-page7", "SLIDE_LEFT");
	});
	
	$("#clickMiCuenta").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		mui.viewPort.showPage("mui-viewport-page10", "SLIDE_LEFT");
	});
	
	$("#clickLocalesPreferidos").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		mui.viewPort.showPage("mui-viewport-page11", "SLIDE_LEFT");
	});
	
	$("#clickRegalosHechos").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		mui.viewPort.showPage("mui-viewport-page12", "SLIDE_LEFT");
	});
	
	$("#clickRegalosPendientes").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		mui.viewPort.showPage("mui-viewport-page13", "SLIDE_LEFT");
	});
	
	$("#clickAjustes").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		mui.viewPort.showPage("mui-viewport-page14", "SLIDE_LEFT");
	});
	
	$("#home-button").on("click", function(e) {
		e.stopPropagation(); e.preventDefault();
		mui.history.back();
	});
	
	$("#clickSettings").on("click", function(e) {
		mui.viewPort.showPanel("panelSettings", "SLIDE_RIGHT");
	});
	
	$("#clickAbrirRegalo").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		param = "";
		abrirRegalo(param);
	});
	
	
	$("#panel-button1").on("click", function(e) {
		if (mui.viewPort.panelIsOpen())
			mui.viewPort.closePanel();
		else
			mui.viewPort.showPanel('panel1', 'SLIDE_RIGHT');
	});
	
	$("#panel-button2").on("click", function(e) {
		mui.viewPort.closePanel();
	});
}

function putCover() {
	viewPort.putCoverShild('mui-cover-shild', function() {
		mui.viewPort.removeCoverShild();
	});
}

/**
 * Botones del menú capacidades
 */
function buttonCordova() {
	mui.alert("Cordova: " + mui.cordovaAvailable());
}
function buttonAlert() {
	mui.alert('VAMO ARRIBA', 'Mensaje', 'Dale');
}
function buttonBeep() {
	mui.beep();
}
function buttonVibrar() {
	mui.vibrate();
}
function discar() {
	mui.dialNumber('27093657');
}
function mensaje() {
	mui.sendSms('099693712','Hola');
}
function deviceInfo() {
	if (mui.cordovaAvailable()) {
		if (device) {
			if (device.platform) {
				mui.alert(device.name + "; " + device.platform + "; " + device.uuid + "; " + device.version);
			} else {
				mui.alert('no está definido d.name');
			}
		} else {
			mui.alert('no está definido window.device');
		}
	}
}
function esMovil() {
	if (navigator) {
		if (navigator.userAgent) {
			mui.alert(navigator.userAgent + ": " + mui.isMobileDevice.any());
		} else {
			mui.alert('navigator.userAgent no está definido.');
		}
	} else {
		alert('Navigator no definido');
	}
}
function buttonConfirm() {
	mui.confirm(
			"¿Ser o no ser?",
			function (buttonIndex) {
				mui.alert("Presionó: " + buttonIndex);
			},
			"Pregunta",
			"Soy,No soy"
		);
}
function buttonPrompt() {
	mui.prompt(
	        'Por favor ingrese algo',  // message
	        function(result) {
	        	mui.alert("Usted presioné: " + result.input1);
	        },
	        'EL TITULO OPCIONAL',            // title
	        ['Ok','Exit'],             // buttonLabels
	        'Pepe Trueno'                 // defaultText
	    );
}



function getRegalosPorEdad(param) {
	//METODO QUE SE USA PARA ARMAR LA LISTA DE REGALOS
	$.ajax({
        url:'http://localhost:8080/gifter/RegalosServlet',
        dataType: 'json',
        crossDomain: true,
        data:{
            ws: 2,
            dataType:"json"
            
        }
    })
        .done(function(data){
        	var obj = data;
        	//document.getElementById("ejemploEdad").style.backgroundImage="url('img_tree.png')";
        	var ret = "";
        	
            for(var i = 0 ; i < obj.length ; i++){
            	id = obj[i].id;
            	if (id == null){
            		id = "";
            	}
            	onclick = "onclick='abrirRegalo('"+id+"')";
            	ret = ret + "<li class='mui-clickable mui-list-disclosure mui-list-con-imagenes'"+ onclick + ";'> <span>";
            	//adentro va a tener un span con la imagen, no se como hacerlo todavia
            	ret = ret + obj[i].name+"<br>"+obj[i].description+"<br>"+obj[i].price+"</span>"+"<br>"+"</li>"+"<br>";
            }
            $("#list3").html(ret);
            mui.viewPort.iScrollRefresh();
            mui.viewPort.showPage("mui-viewport-page4", "SLIDE_LEFT");

        })
        .fail(function(jqXHR, textStatus, errorThrown){

        });
};

function abrirRegalo(idRegalo) {
	 
	//FALTA EL TEMA DEL ID REGALO QUE NO ESTA MANEJADO
	$.ajax({
        url:'http://localhost:8080/gifter/RegalosServlet',
        dataType: 'json',
        crossDomain: true,
        data:{
            ws: 13, //ws de getRegalosPorId del Servlet
            dataType:"json", 
            idRegalo: idRegalo
            
        }
    })
        .done(function(data){
        	var obj = data;
        	//document.getElementById("ejemploEdad").style.backgroundImage="url('img_tree.png')";
        	var ret = "";

        	ret = ret + "<li class='mui-clickable mui-list-disclosure mui-list-con-imagenes' > <span>"; 
            //adentro va a tener un span con la imagen, no se como hacerlo todavia
            ret = ret + obj[i].name+"<br>"+obj[i].description+"<br>"+obj[i].price+"</span>"+"<br>"+"</li>"+"<br>";
        
            $("#mostrarRegalos").html(ret);
            mui.viewPort.iScrollRefresh();
            mui.viewPort.showPage("mui-viewport-page15", "SLIDE_LEFT");

        })
        .fail(function(jqXHR, textStatus, errorThrown){

        });
};
